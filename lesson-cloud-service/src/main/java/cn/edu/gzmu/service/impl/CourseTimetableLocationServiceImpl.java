package cn.edu.gzmu.service.impl;

import cn.edu.gzmu.model.entity.CourseTimetableLocation;
import cn.edu.gzmu.repository.entity.CourseTimetableLocationRepository;
import cn.edu.gzmu.service.CourseTimetableLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * CourseTimetableLocation Service Impl
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-20 9:18:57
 */
@Service
@RequiredArgsConstructor
public class CourseTimetableLocationServiceImpl extends BaseServiceImpl<CourseTimetableLocationRepository, CourseTimetableLocation, Long>
        implements CourseTimetableLocationService {

    @Override
    public CourseTimetableLocation completeEntity(CourseTimetableLocation entity) {
        return entity;
    }
}
