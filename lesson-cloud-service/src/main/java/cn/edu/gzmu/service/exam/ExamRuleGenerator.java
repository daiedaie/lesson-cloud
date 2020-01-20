package cn.edu.gzmu.service.exam;

import cn.edu.gzmu.model.entity.ExamRule;
import cn.edu.gzmu.model.entity.Question;

import java.util.List;

/**
 * @author BugRui
 * @date 2020/1/19 下午11:15
 **/

public interface ExamRuleGenerator {
    /**
     * 根据规则生成试题
     *
     * @param examRule 考试规则
     * @return Question
     */
    List<Question> generateQuestion(ExamRule examRule);
}
