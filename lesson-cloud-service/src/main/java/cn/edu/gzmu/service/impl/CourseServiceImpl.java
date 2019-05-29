package cn.edu.gzmu.service.impl;

import cn.edu.gzmu.model.entity.Course;
import cn.edu.gzmu.repository.entity.CourseRepository;
import cn.edu.gzmu.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * Course Service Impl
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-7 11:33:57
 */
@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends BaseServiceImpl<CourseRepository, Course, Long>
        implements CourseService {

    @Override
    public Course completeEntity(Course entity) {
        return entity;
    }
}
