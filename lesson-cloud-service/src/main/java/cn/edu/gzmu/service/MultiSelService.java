package cn.edu.gzmu.service;

import cn.edu.gzmu.model.entity.MultiSel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 * MultiSel Service
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-7 11:33:57
 */
public interface MultiSelService extends BaseService<MultiSel, Long> {
    /**
     * 分页查询公开与不公开的题目
     *
     * @param isPublic 是否公开
     * @param pageable 分页
     * @return java.util.List<cn.edu.gzmu.model.entity.MultiSel>
     */
    Page<MultiSel> findAllByIsPublic(boolean isPublic, Pageable pageable);

    /**
     * 根据课程 Id 分页查询
     *
     * @param courseId 课程id
     * @param isPublic 是否公开
     * @param pageable 分页
     * @return java.util.List<cn.edu.gzmu.model.entity.MultiSel>
     * @author Soul
     * @date 2020/1/10 13:16
     */
    Page<MultiSel> findAllByCourseIdAndIsPublic(Long courseId, boolean isPublic, Pageable pageable);

    /**
     * 根据课程 Id 和章节 Id 分页查询
     *
     * @param courseId  课程id
     * @param sectionId 章节id
     * @param isPublic  是否公开
     * @param pageable  分页
     * @return java.util.List<cn.edu.gzmu.model.entity.MultiSel>
     * @author Soul
     * @date 2020/1/10 13:17
     */
    Page<MultiSel> findAllByCourseIdAndSectionIdAndIsPublic(Long courseId, Long sectionId, boolean isPublic, Pageable pageable);

    /**
     * 根据课程 Id 和章节 Id 和知识点 Id 分页查询
     *
     * @param courseId    课程id
     * @param sectionId   章节id
     * @param knowledgeId 知识点id
     * @param isPublic    是否公开
     * @param pageable    分页
     * @return java.util.List<cn.edu.gzmu.model.entity.MultiSel>
     * @author Soul
     * @date 2020/1/10 13:18
     */
    Page<MultiSel> findAllByCourseIdAndSectionIdAndKnowledgeIdAndIsPublic(Long courseId, Long sectionId, Long knowledgeId, boolean isPublic, Pageable pageable);

    /**
     * 根据题目部分内容模糊分页查询
     *
     * @param name     名称
     * @param isPublic 是否公开
     * @param pageable 分页
     * @return cn.edu.gzmu.model.entity.MultiSel
     * @author Soul
     * @date 2020/1/10 13:23
     */
    Page<MultiSel> findByNameContainingAndIsPublic(String name, boolean isPublic, Pageable pageable);
}
