package cn.edu.gzmu.repository.entity;

import cn.edu.gzmu.model.entity.SysRoleRes;
import cn.edu.gzmu.repository.base.BaseRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


/**
 * SysRoleRes Repository
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-7 11:05:31
 */
@RepositoryRestResource(path = "sysRoleRes")
public interface SysRoleResRepository extends BaseRepository<SysRoleRes, Long> {

    List<SysRoleRes> findAllByResId(Long resId);

}