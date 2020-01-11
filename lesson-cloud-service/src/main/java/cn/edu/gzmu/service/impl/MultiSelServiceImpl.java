package cn.edu.gzmu.service.impl;

import cn.edu.gzmu.model.entity.MultiSel;
import cn.edu.gzmu.repository.entity.CourseRepository;
import cn.edu.gzmu.repository.entity.KnowledgeRepository;
import cn.edu.gzmu.repository.entity.MultiSelRepository;
import cn.edu.gzmu.repository.entity.SectionRepository;
import cn.edu.gzmu.service.MultiSelService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * MultiSel Service Impl
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-7 11:33:57
 */
@Service
@RequiredArgsConstructor
public class MultiSelServiceImpl extends BaseServiceImpl<MultiSelRepository, MultiSel, Long>
        implements MultiSelService {

    private @NonNull MultiSelRepository multiSelRepository;
    private @NonNull SectionRepository sectionRepository;
    private @NonNull CourseRepository courseRepository;
    private @NonNull KnowledgeRepository knowledgeRepository;

    @Override
    protected MultiSel completeEntity(MultiSel entity) {
        return entity.setSection(sectionRepository.findById(entity.getSectionId()).orElse(null))
                .setCourse(courseRepository.findById(entity.getCourseId()).orElse(null))
                .setKnowledge(knowledgeRepository.findById(entity.getKnowledgeId()).orElse(null));
    }

    @Override
    public Page<MultiSel> findAllByCourseId(Long courseId, Pageable pageable) {
        // 先根据 courseId 查出当前课程所有多选题
        Page<MultiSel> multiSelList = multiSelRepository.findAllByCourseId(courseId, pageable);
        // 获取到分页信息中的数据
        List<MultiSel> content = multiSelList.getContent();
        // 对数据进行遍历
        for (MultiSel multiSel : content) {
            // 对每个数据进行完整性填充
            completeEntity(multiSel);
        }
        return multiSelList;
    }

    @Override
    public Page<MultiSel> findAllByCourseIdAndSectionId(Long courseId, Long sectionId, Pageable pageable) {
        // 先根据 courseId 和 sectionId 查出当前课程所有多选题
        Page<MultiSel> multiSelList = multiSelRepository.findAllByCourseIdAndSectionId(courseId, sectionId, pageable);
        // 获取到分页信息中的数据
        List<MultiSel> content = multiSelList.getContent();
        // 对数据进行遍历
        for (MultiSel multiSel : content) {
            // 对每个数据进行完整性填充
            completeEntity(multiSel);
        }
        return multiSelList;
    }

    @Override
    public Page<MultiSel> findAllByCourseIdAndSectionIdAndKnowledgeId(Long courseId, Long sectionId, Long knowledgeId, Pageable pageable) {
        // 先根据 courseId 和 sectionId 和 knowledgeId 查出当前课程所有多选题
        Page<MultiSel> multiSelList = multiSelRepository.findAllByCourseIdAndSectionIdAndKnowledgeId(courseId, sectionId, knowledgeId, pageable);
        // 获取到分页信息中的数据
        List<MultiSel> content = multiSelList.getContent();
        // 对数据进行遍历
        for (MultiSel multiSel : content) {
            // 对每个数据进行完整性填充
            completeEntity(multiSel);
        }
        return multiSelList;
    }

    @Override
    public Page<MultiSel> findByNameContaining(String name, Pageable pageable) {
        // 先根据 name 查出当前课程所有多选题
        Page<MultiSel> multiSelList = multiSelRepository.findByNameContaining(name, pageable);
        // 获取到分页信息中的数据
        List<MultiSel> content = multiSelList.getContent();
        // 对数据进行遍历
        for (MultiSel multiSel : content) {
            // 对每个数据进行完整性填充
            completeEntity(multiSel);
        }
        return multiSelList;
    }
}
