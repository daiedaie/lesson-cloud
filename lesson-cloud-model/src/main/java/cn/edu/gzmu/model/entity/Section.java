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
import java.io.Serializable;

/**
 * section
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-7 11:33:56
 */
@Data
@Cacheable
@Table(name = "section")
@Entity(name = "section")
@Where(clause = "is_enable = 1")
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Cache(region = "section", usage = CacheConcurrencyStrategy.READ_WRITE)
public class Section extends BaseEntity implements Serializable {

    /**
     * 内容简介
     */
    private java.lang.String intro;

    /**
     * 课程编号
     */
    private java.lang.Long courseId;

    /**
     * 0，代表无上级，即：课程的第一个章节
     */
    private java.lang.Long parentId;

    /**
     * 类型，0：章，1：节
     */
    private java.lang.Byte type;
}