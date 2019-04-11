package cn.edu.gzmu.repository.entity;

import cn.edu.gzmu.model.entity.SelOptions;
import cn.edu.gzmu.repository.BaseRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * SelOptions Repository
 *
 * @author echo
 * @version 1.0
 * @date 2019-4-11 17:24:41
 */
@RepositoryRestResource
public interface SelOptionsRepository extends BaseRepository<SelOptions, Long> {

}