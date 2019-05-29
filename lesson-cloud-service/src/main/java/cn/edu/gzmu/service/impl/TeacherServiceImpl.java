package cn.edu.gzmu.service.impl;

import cn.edu.gzmu.model.entity.Teacher;
import cn.edu.gzmu.repository.entity.TeacherRepository;
import cn.edu.gzmu.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * Teacher Service Impl
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-7 11:33:57
 */
@Service
@RequiredArgsConstructor
public class TeacherServiceImpl extends BaseServiceImpl<TeacherRepository, Teacher, Long>
        implements TeacherService {

    @Override
    public Teacher completeEntity(Teacher entity) {
        return entity;
    }
}
