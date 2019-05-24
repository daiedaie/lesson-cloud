package cn.edu.gzmu.controller;

import cn.edu.gzmu.model.entity.Exam;
import cn.edu.gzmu.service.ExamService;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Exam Controller
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-24 14:18:22
 */
@RepositoryRestController
@RequestMapping("/exam/search")
public class ExamController extends BaseController<Exam, ExamService, Long> {

}
