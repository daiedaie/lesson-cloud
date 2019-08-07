package cn.edu.gzmu.repository.entity;

import cn.edu.gzmu.model.entity.Program;
import cn.edu.gzmu.repository.base.BaseRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Program Repository
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-23 17:38:13
 */
@RepositoryRestResource(path = "/program")
public interface ProgramRepository extends BaseRepository<Program, Long> {

}