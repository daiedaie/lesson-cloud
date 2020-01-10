package cn.edu.gzmu.repository.entity;

import cn.edu.gzmu.model.entity.Essay;
import cn.edu.gzmu.repository.base.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Essay Repository
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-23 17:38:13
 */
@RepositoryRestResource(path = "essay")
public interface EssayRepository extends BaseRepository<Essay, Long> {
    /**
     * 根据课课程 Id 分页查询
     *
     * @param courseId 课程id
     * @param pageable 分页
     * @return java.util.List<cn.edu.gzmu.model.entity.Essay>
     * @author Soul
     * @date 2020/1/10 13:16
     */
    Page<Essay> findAllByCourseId(Long courseId, Pageable pageable);

    /**
     * 根据课章节 Id 分页查询
     *
     * @param sectionId 章节id
     * @param pageable  分页
     * @return java.util.List<cn.edu.gzmu.model.entity.Essay>
     * @author Soul
     * @date 2020/1/10 13:17
     */
    Page<Essay> findAllBySectionId(Long sectionId, Pageable pageable);

    /**
     * 根据知识点 Id 分页查询
     *
     * @param knowledgeId 知识点id
     * @param pageable    分页
     * @return java.util.List<cn.edu.gzmu.model.entity.Essay>
     * @author Soul
     * @date 2020/1/10 13:18
     */
    Page<Essay> findAllByKnowledgeId(Long knowledgeId, Pageable pageable);

    /**
     * 根据题目部分内容模糊分页查询
     *
     * @param name     名称
     * @param pageable 分页
     * @return cn.edu.gzmu.model.entity.Essay
     * @author Soul
     * @date 2020/1/10 13:23
     */
    Page<Essay> findByNameContaining(String name, Pageable pageable);
}