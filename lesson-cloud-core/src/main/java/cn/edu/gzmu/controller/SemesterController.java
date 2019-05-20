package cn.edu.gzmu.controller;

import cn.edu.gzmu.model.entity.Semester;
import cn.edu.gzmu.service.SemesterService;
import cn.edu.gzmu.controller.BaseController;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Semester Controller
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-20 9:18:57
 */
@RepositoryRestController
@RequestMapping("/semesters/search")
public class SemesterController extends BaseController<Semester, SemesterService, Long> {

}
