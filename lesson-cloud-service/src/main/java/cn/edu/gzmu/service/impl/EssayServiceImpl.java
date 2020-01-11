package cn.edu.gzmu.service.impl;

import cn.edu.gzmu.model.entity.Essay;
import cn.edu.gzmu.repository.entity.CourseRepository;
import cn.edu.gzmu.repository.entity.EssayRepository;
import cn.edu.gzmu.repository.entity.KnowledgeRepository;
import cn.edu.gzmu.repository.entity.SectionRepository;
import cn.edu.gzmu.service.EssayService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Essay Service Impl
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-7 11:33:57
 */
@Service
@RequiredArgsConstructor
public class EssayServiceImpl extends BaseServiceImpl<EssayRepository, Essay, Long>
        implements EssayService {
    private final @NonNull EssayRepository essayRepository;
    private final @NonNull CourseRepository courseRepository;
    private final @NonNull SectionRepository sectionRepository;
    private final @NonNull KnowledgeRepository knowledgeRepository;

    @Override
    protected Essay completeEntity(Essay entity) {
        return entity
                .setCourse(courseRepository.findById(entity.getCourseId()).orElse(null))
                .setKnowledge(knowledgeRepository.findById(entity.getKnowledgeId()).orElse(null))
                .setSection(sectionRepository.findById(entity.getSectionId()).orElse(null));

    }

    @Override
    public Page<Essay> findAllByCourseId(Long courseId, Pageable pageable) {
        // 先根据 courseId 查出当前课程所有问答题
        Page<Essay> essays = essayRepository.findAllByCourseId(courseId, pageable);
        // 获取到分页信息中的数据
        List<Essay> content = essays.getContent();
        // 对数据进行遍历
        for (Essay essay : content) {
            // 对每个数据进行完整性填充
            completeEntity(essay);
        }
        return essays;
    }

    @Override
    public Page<Essay> findAllByCourseIdAndSectionId(Long courseId, Long sectionId, Pageable pageable) {
        // 先根据 courseId 和 sectionId 查出当前章节所有问答题
        Page<Essay> essays = essayRepository.findAllByCourseIdAndSectionId(courseId, sectionId, pageable);
        // 获取到分页信息中的数据
        List<Essay> content = essays.getContent();
        // 对数据进行遍历
        for (Essay essay : content) {
            // 对每个数据进行完整性填充
            completeEntity(essay);
        }
        return essays;
    }

    @Override
    public Page<Essay> findAllByCourseIdAndSectionIdAndKnowledgeId(Long courseId, Long sectionId, Long knowledgeId, Pageable pageable) {
        // 先根据  courseId 和 sectionId 和 knowledgeId 查出当前知识点所有问答题
        Page<Essay> essays = essayRepository.findAllByCourseIdAndSectionIdAndKnowledgeId(courseId, sectionId, knowledgeId, pageable);
        // 获取到分页信息中的数据
        List<Essay> content = essays.getContent();
        // 对数据进行遍历
        for (Essay essay : content) {
            // 对每个数据进行完整性填充
            completeEntity(essay);
        }
        return essays;
    }

    @Override
    public Page<Essay> findByNameContaining(String name, Pageable pageable) {
        // 先根据 name 查出与之匹配的问答题
        Page<Essay> essays = essayRepository.findByNameContaining(name, pageable);
        // 获取到分页信息中的数据
        List<Essay> content = essays.getContent();
        // 对数据进行遍历
        for (Essay essay : content) {
            // 对每个数据进行完整性填充
            completeEntity(essay);
        }
        return essays;
    }
}