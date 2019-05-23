package cn.edu.gzmu.controller;

import cn.edu.gzmu.model.entity.Student;
import cn.edu.gzmu.service.StudentService;
import cn.edu.gzmu.controller.BaseController;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Student Controller
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-23 17:38:14
 */
@RepositoryRestController
@RequestMapping("/student/search")
public class StudentController extends BaseController<Student, StudentService, Long> {

}
