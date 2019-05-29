package cn.edu.gzmu.service.impl;

import cn.edu.gzmu.model.entity.SysUserRole;
import cn.edu.gzmu.repository.entity.SysUserRoleRepository;
import cn.edu.gzmu.service.SysUserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * SysUserRole Service Impl
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-7 11:33:57
 */
@Service
@RequiredArgsConstructor
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRoleRepository, SysUserRole, Long>
        implements SysUserRoleService {

    @Override
    public SysUserRole completeEntity(SysUserRole entity) {
        return entity;
    }
}
