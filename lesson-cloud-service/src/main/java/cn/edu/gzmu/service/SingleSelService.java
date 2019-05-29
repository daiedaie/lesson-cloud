package cn.edu.gzmu.service;

import cn.edu.gzmu.model.entity.SingleSel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 * SingleSel Service
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-7 11:33:57
 */
public interface SingleSelService extends BaseService<SingleSel, Long> {

    /**
     * 查询所有单项选择题分页信息
     *
     * @param pageable 分页
     * @return 分页结果
     */
    Page<SingleSel> searchAll(Pageable pageable);
}
