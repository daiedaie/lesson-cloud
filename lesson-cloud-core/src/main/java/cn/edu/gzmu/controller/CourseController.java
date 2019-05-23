package cn.edu.gzmu.controller;

import cn.edu.gzmu.model.entity.Course;
import cn.edu.gzmu.service.CourseService;
import cn.edu.gzmu.controller.BaseController;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Course Controller
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-23 17:38:14
 */
@RepositoryRestController
@RequestMapping("/course/search")
public class CourseController extends BaseController<Course, CourseService, Long> {

}
