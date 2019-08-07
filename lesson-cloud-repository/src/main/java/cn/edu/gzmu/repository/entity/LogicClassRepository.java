package cn.edu.gzmu.repository.entity;

import cn.edu.gzmu.model.entity.LogicClass;
import cn.edu.gzmu.repository.base.BaseRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Set;


/**
 * LogicClass Repository
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-23 17:38:13
 */
@RepositoryRestResource(path = "/logicClass")
public interface LogicClassRepository extends BaseRepository<LogicClass, Long> {

    /**
     * 根据 classes id 查询所有符合条件的逻辑班级
     *
     * @param id student id
     * @return 结果
     */
    Set<LogicClass> findDistinctByClassesId(Long id);

    /**
     * 根据 student id 查询所有符合条件的逻辑班级
     *
     * @param id student id
     * @return 结果
     */
    Set<LogicClass> findDistinctByStudentId(Long id);


    /**
     * 根据 teacher id 查询所有符合条件的逻辑班级
     *
     * @param id teacher id
     * @return 结果
     */
    Set<LogicClass> findDistinctByTeacherId(Long id);

}