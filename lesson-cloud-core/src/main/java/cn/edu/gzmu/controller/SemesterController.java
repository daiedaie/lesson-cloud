package cn.edu.gzmu.controller;

import cn.edu.gzmu.model.entity.Semester;
import cn.edu.gzmu.service.SemesterService;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Semester Controller
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-24 14:18:22
 */
@RepositoryRestController
@RequestMapping("/semester/search")
public class SemesterController extends BaseController<Semester, SemesterService, Long> {

}
