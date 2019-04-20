package cn.edu.gzmu.controller;

import cn.edu.gzmu.model.entity.SysLog;
import cn.edu.gzmu.repository.entity.SysLogRepository;
import cn.edu.gzmu.controller.BaseController;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* SysLog Controller
*
* @author echo
* @version 1.0
* @date 2019-4-20 0:08:37
*/
@RepositoryRestController
@RequestMapping("/sysLogs")
public class SysLogController extends BaseController<SysLog, SysLogRepository, Long> {

}
