package cn.edu.gzmu.repository.entity;

import cn.edu.gzmu.model.entity.Exam;
import cn.edu.gzmu.repository.BaseRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Exam Repository
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-7 11:05:30
 */
@RepositoryRestResource(path = "/exams")
public interface ExamRepository extends BaseRepository<Exam, Long> {

}