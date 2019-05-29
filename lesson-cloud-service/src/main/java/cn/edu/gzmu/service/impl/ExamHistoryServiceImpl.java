package cn.edu.gzmu.service.impl;

import cn.edu.gzmu.model.entity.ExamHistory;
import cn.edu.gzmu.repository.entity.ExamHistoryRepository;
import cn.edu.gzmu.service.ExamHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * ExamHistory Service Impl
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-7 11:33:57
 */
@Service
@RequiredArgsConstructor
public class ExamHistoryServiceImpl extends BaseServiceImpl<ExamHistoryRepository, ExamHistory, Long>
        implements ExamHistoryService {

    @Override
    public ExamHistory completeEntity(ExamHistory entity) {
        return entity;
    }
}
