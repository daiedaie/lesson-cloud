package cn.edu.gzmu.model.entity;

import cn.edu.gzmu.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
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
 * sys_data
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-27 10:59:09
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysData extends BaseEntity implements Serializable {

    /**
     * 0，代表无上级，即：学校
     */
    private java.lang.Long parentId;

    /**
     * 简介
     */
    @Size(max = 2048, message = "brief 不能大于 2048 位")
    private java.lang.String brief;

    /**
     * 0：学校，1：学院，2：系部，3：专业，4：班级，5：性别，6：学历，7：学位，8：教师毕业专业，9：民族，10：研究方向，11：职称
     */
    private java.lang.Integer type;
}