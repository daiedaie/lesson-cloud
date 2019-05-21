package cn.edu.gzmu.controller;

import cn.edu.gzmu.model.entity.SysLog;
import cn.edu.gzmu.service.SysLogService;
import cn.edu.gzmu.controller.BaseController;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * SysLog Controller
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-20 9:18:57
 */
@RepositoryRestController
@RequestMapping("/sysLogs/search")
public class SysLogController extends BaseController<SysLog, SysLogService, Long> {

}
