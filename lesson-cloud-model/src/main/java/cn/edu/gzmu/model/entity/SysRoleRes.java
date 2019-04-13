package cn.edu.gzmu.model.entity;

import cn.edu.gzmu.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Where;


import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * sys_role_res
 *
 * @author echo
 * @version 1.0
 * @date 2019-4-12 20:32:45
 */
@Data
@Cacheable
@Table(name = "sys_role_res")
@Entity(name = "sys_role_res")
@Where(clause = "is_enable = 1")
@EqualsAndHashCode(callSuper = true)
@Cache(region = "sys_role_res", usage = CacheConcurrencyStrategy.READ_WRITE )
public class SysRoleRes extends BaseEntity {

    /**
     * 角色编号
     */
    private java.lang.Long roleId;

    /**
     * 权限资源编号
     */
    private java.lang.Long resId;
}