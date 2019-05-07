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
 * essay
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-7 11:05:30
 */
@Data
@Cacheable
@Table(name = "essay")
@Entity(name = "essay")
@Where(clause = "is_enable = 1")
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Cache(region = "essay", usage = CacheConcurrencyStrategy.READ_WRITE )
public class Essay extends BaseEntity implements Serializable {

    /**
     * 难度系数，介于0~1之间
     */
    private java.lang.Float difficultRate;

    /**
     * 参考答案（可能包含图片）
     */
    private java.lang.String answer;

    /**
     * 答案解析
     */
    private java.lang.String explanation;

    /**
     * 课程编号
     */
    private java.lang.Long courseId;

    /**
     * 章节编号
     */
    private java.lang.Long sectionId;

    /**
     * 知识点编号
     */
    private java.lang.Long knowledgeId;
}