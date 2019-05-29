package cn.edu.gzmu.controller;

import cn.edu.gzmu.model.constant.LessonResource;
import cn.edu.gzmu.model.entity.Judgement;
import cn.edu.gzmu.service.JudgementService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Judgement Controller
 *
 * @author yxf
 * @version 1.0
 * @date 2019-5-28 17:48:37
 */
@RequiredArgsConstructor
@RepositoryRestController
@RequestMapping(LessonResource.JUDGEMENT)
public class JudgementController extends BaseController<Judgement, JudgementService, Long> {

}
