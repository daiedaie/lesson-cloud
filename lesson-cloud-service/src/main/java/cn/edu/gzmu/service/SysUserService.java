package cn.edu.gzmu.service;

import cn.edu.gzmu.model.entity.SysUser;


/**
 * SysUser Service
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-7 11:33:57
 */
public interface SysUserService extends BaseService<SysUser, Long> {
    /**
     * 通过用户名/手机号/邮箱查询用户
     *
     * @param user 用户名/手机号/邮箱
     * @return 用户
     */
    SysUser searchByAll(String user);

    /**
     * 通过手机号查询用户
     *
     * @param phone 手机号
     * @return 用户
     */
    SysUser searchByPhone(String phone);
}
