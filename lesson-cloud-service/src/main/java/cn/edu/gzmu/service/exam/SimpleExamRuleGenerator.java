package cn.edu.gzmu.service.exam;

import cn.edu.gzmu.model.constant.QuestionType;
import cn.edu.gzmu.model.dto.QuestionInfo;
import cn.edu.gzmu.model.dto.ExamRuleDetailInfo;
import cn.edu.gzmu.model.entity.ExamRule;
import cn.edu.gzmu.model.entity.Knowledge;
import cn.edu.gzmu.model.entity.KnowledgeQuestion;
import cn.edu.gzmu.model.entity.Question;
import cn.edu.gzmu.model.entity.Section;
import cn.edu.gzmu.repository.entity.KnowledgeQuestionRepository;
import cn.edu.gzmu.repository.entity.KnowledgeRepository;
import cn.edu.gzmu.repository.entity.QuestionRepository;
import cn.edu.gzmu.repository.entity.SectionRepository;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author BugRui
 * @date 2020/1/19 下午11:15
 **/
@Component
@RequiredArgsConstructor
public class SimpleExamRuleGenerator implements ExamRuleGenerator {

    @Data
    @EqualsAndHashCode(callSuper = true)
    private static class ExamRuleDetail extends ExamRuleDetailInfo {
        private ExamRuleDetail() {
        }

        public boolean isEmpty() {
            return CollectionUtils.isEmpty(requireQuestionIds)
                    && CollectionUtils.isEmpty(sectionIds)
                    && CollectionUtils.isEmpty(passageIds)
                    && CollectionUtils.isEmpty(knowledgeIds);
        }

        public static ExamRuleDetail convert(JSONObject jsonObject) {
            return (ExamRuleDetail) ExamRuleDetailInfo.convert(jsonObject);
        }
    }

    private final @NonNull QuestionRepository questionRepository;

    private final @NonNull KnowledgeQuestionRepository knowledgeQuestionRepository;

    private final @NonNull SectionRepository sectionRepository;

    private final @NonNull KnowledgeRepository knowledgeRepository;

    @Override
    public List<QuestionInfo> generateQuestion(ExamRule examRule) {
        ExamRuleDetail ruleDetail = ExamRuleDetail.convert(examRule.getRuleDetail());
        List<Long> selectQuestionIds = null;
        if (BooleanUtils.isFalse(ruleDetail.isEmpty())) {
            //查询出符合条件的待选择的selectQuestionIds
            List<Section> sectionList = sectionRepository.findAllByParentIdIn(ruleDetail.getPassageIds());
            Set<Long> sectionIds = sectionList.stream().map(Section::getId).collect(Collectors.toSet());
            sectionIds.addAll(ruleDetail.getSectionIds());
            List<Knowledge> knowledgeList = knowledgeRepository.findAllBySectionIdIn(new ArrayList<>(sectionIds));
            Set<Long> knowledgeIds = knowledgeList.stream().map(Knowledge::getId).collect(Collectors.toSet());
            knowledgeIds.addAll(ruleDetail.getKnowledgeIds());
            List<KnowledgeQuestion> knowledgeQuestionList = knowledgeQuestionRepository.findAllByKnowledgeIdIn(new ArrayList<>(knowledgeIds));
            selectQuestionIds = knowledgeQuestionList.stream().map(KnowledgeQuestion::getQuestionId).collect(Collectors.toList());
        }
        List<Question> questionList = questionRepository.findAll(specificationQuestionProvide(examRule, ruleDetail.getRequireQuestionIds(), selectQuestionIds));
        //增加必选题
        questionList.addAll(questionRepository.findAllByIdIn(ruleDetail.getRequireQuestionIds()));
        //TODO 这里可以增加一下判断 必选题题量超出总题量
        return questionList.stream().map(question -> modelMapper(question, examRule)).collect(Collectors.toList());
    }


    private QuestionInfo modelMapper(Question question, ExamRule examRule) {
        QuestionInfo questionInfo = new QuestionInfo();
        return questionInfo
                .setId(question.getId())
                .setName(question.getName())
                .setSpell(question.getSpell())
                .setDifficultRate(question.getDifficultRate())
                .setValue(examRule.getEachValue())
                .setQuestionType(question.getType());
    }

    private <T> Specification<T> specificationQuestionProvide(ExamRule examRule, List<Long> requireIds, List<Long> selectIds) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            Predicate conjunction = criteriaBuilder.equal(root.get("isEnable").as(Boolean.class), true);
            if (CollectionUtils.isNotEmpty(selectIds)) {
                CriteriaBuilder.In<Long> inIds = criteriaBuilder.in(root.get("id").as(Long.class));
                selectIds.forEach(inIds::value);
                conjunction = criteriaBuilder.and(conjunction, inIds);
            }
            if (CollectionUtils.isNotEmpty(requireIds)) {
                CriteriaBuilder.In<Long> notInIds = criteriaBuilder.in(root.get("id").as(Long.class));
                requireIds.forEach(notInIds::value);
                conjunction = criteriaBuilder.and(conjunction, notInIds.not());
            }
            conjunction = criteriaBuilder.and(conjunction,
                    criteriaBuilder.equal(root.get("questionType").as(QuestionType.class), examRule.getQuestionType()));
            conjunction = criteriaBuilder.and(conjunction,
                    criteriaBuilder.between(root.get("difficultRate").as(Integer.class),
                            examRule.getStartDifficultRate(), examRule.getEndDifficultRate()));
            return criteriaQuery.where(conjunction).
                    orderBy(criteriaBuilder.asc(criteriaBuilder.currentDate())).
                    getRestriction();
        };
    }


}
