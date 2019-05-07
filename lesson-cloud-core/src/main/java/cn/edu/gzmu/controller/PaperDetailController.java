package cn.edu.gzmu.controller;

import cn.edu.gzmu.model.entity.PaperDetail;
import cn.edu.gzmu.service.PaperDetailService;
import cn.edu.gzmu.controller.BaseController;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* PaperDetail Controller
*
* @author echo
* @version 1.0
* @date 2019-5-7 11:05:31
*/
@RepositoryRestController
@RequestMapping("/paperDetails")
public class PaperDetailController extends BaseController<PaperDetail, PaperDetailService, Long> {

}
