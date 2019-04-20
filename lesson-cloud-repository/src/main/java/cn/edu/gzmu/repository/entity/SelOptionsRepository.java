package cn.edu.gzmu.repository.entity;

import cn.edu.gzmu.model.entity.SelOptions;
import cn.edu.gzmu.repository.BaseRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * SelOptions Repository
 *
 * @author echo
 * @version 1.0
 * @date 2019-4-20 0:08:37
 */
@RepositoryRestResource
public interface SelOptionsRepository extends BaseRepository<SelOptions, Long> {

}