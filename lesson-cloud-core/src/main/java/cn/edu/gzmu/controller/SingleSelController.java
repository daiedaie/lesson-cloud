package cn.edu.gzmu.controller;

import cn.edu.gzmu.model.entity.SingleSel;
import cn.edu.gzmu.service.SingleSelService;
import cn.edu.gzmu.controller.BaseController;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * SingleSel Controller
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-20 9:18:57
 */
@RepositoryRestController
@RequestMapping("/singleSels/search")
public class SingleSelController extends BaseController<SingleSel, SingleSelService, Long> {

}
