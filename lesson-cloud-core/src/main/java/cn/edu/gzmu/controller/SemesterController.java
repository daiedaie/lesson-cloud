package cn.edu.gzmu.controller;

import cn.edu.gzmu.model.entity.Semester;
import cn.edu.gzmu.repository.entity.SemesterRepository;
import cn.edu.gzmu.controller.BaseController;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* Semester Controller
*
* @author echo
* @version 1.0
* @date 19-3-25 14:51
*/
@RepositoryRestController
@RequestMapping("/semesters")
public class SemesterController extends BaseController<Semester, SemesterRepository, Long> {

}
