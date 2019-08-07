package cn.edu.gzmu.repository.entity;

import cn.edu.gzmu.model.entity.Knowledge;
import cn.edu.gzmu.repository.base.BaseRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Knowledge Repository
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-23 17:38:13
 */
@RepositoryRestResource(path = "/knowledge")
public interface KnowledgeRepository extends BaseRepository<Knowledge, Long> {

}