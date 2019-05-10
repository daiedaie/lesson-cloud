package cn.edu.gzmu.model.entity;

import cn.edu.gzmu.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Where;


import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * sys_log
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-8 16:03:14
 */
@Data
@Cacheable
@Table(name = "sys_log")
@Entity(name = "sys_log")
@Where(clause = "is_enable = 1")
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Cache(region = "sys_log", usage = CacheConcurrencyStrategy.READ_WRITE)
public class SysLog extends BaseEntity implements Serializable {

    /**
     * 浏览器
     */
    @Size(max = 255, message = "browser 不能大于 255 位")
    private java.lang.String browser;

    /**
     * 操作方式：GET/POST
     */
    @Size(max = 20, message = "operation 不能大于 20 位")
    private java.lang.String operation;

    /**
     * 访问的实际url地址
     */
    @Size(max = 1000, message = "fromUrl 不能大于 1000 位")
    private java.lang.String fromUrl;

    /**
     * 来源ip地址
     */
    @javax.validation.constraints.NotNull(message = "ip 为必填项")
    @Size(max = 200, message = "ip 不能大于 200 位")
    private java.lang.String ip;

    /**
     * 访问url相对地址
     */
    @Size(max = 255, message = "url 不能大于 255 位")
    private java.lang.String url;

    /**
     * 1-记录
     */
    @Size(max = 2, message = "status 不能大于 2 位")
    private java.lang.String status;
}