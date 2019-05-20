package cn.edu.gzmu.controller;

import cn.edu.gzmu.model.entity.Teacher;
import cn.edu.gzmu.service.TeacherService;
import cn.edu.gzmu.controller.BaseController;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Teacher Controller
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-20 9:18:57
 */
@RepositoryRestController
@RequestMapping("/teachers/search")
public class TeacherController extends BaseController<Teacher, TeacherService, Long> {

}
