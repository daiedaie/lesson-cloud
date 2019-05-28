package cn.edu.gzmu.controller;

import cn.edu.gzmu.model.entity.ExamRule;
import cn.edu.gzmu.service.ExamRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ExamRule Controller
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-28 10:48:37
 */
@RequiredArgsConstructor
@RepositoryRestController
@RequestMapping("/examRule/search")
public class ExamRuleController extends BaseController<ExamRule, ExamRuleService, Long> {
    private final static String RESOURCE = "/examRule/search";

}
