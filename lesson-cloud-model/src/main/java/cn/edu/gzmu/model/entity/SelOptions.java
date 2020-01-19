package cn.edu.gzmu.model.entity;

import cn.edu.gzmu.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * sel_options
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-27 10:59:08
 */
@Data
@ToString(callSuper = true)
@Table(name = "sel_options")
@Entity(name = "sel_options")
@Where(clause = "is_enable = 1")
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SelOptions extends BaseEntity implements Serializable {

    /**
     * 题目编号
     */
    @javax.validation.constraints.NotNull(message = "questionId 题目编号 为必填项")
    private java.lang.Long questionId;

    /**
     * 题目类型，0：单项选择题，1：多项选择题，2：填空题
     */
    @javax.validation.constraints.NotNull(message = "type 题目类型，0：单项选择题，1：多项选择题，2：填空题 为必填项")
    private java.lang.Integer type;

}