package cn.edu.gzmu.controller;

import cn.edu.gzmu.model.constant.LessonResource;
import cn.edu.gzmu.model.entity.SingleSel;
import cn.edu.gzmu.service.SingleSelService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * SingleSel Controller
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-28 17:24:38
 */
@RequiredArgsConstructor
@RepositoryRestController
@RequestMapping(LessonResource.SINGLE_SEL)
public class SingleSelController extends BaseController<SingleSel, SingleSelService, Long> {

    private final @NonNull SingleSelService singleSelService;

    /**
     * 接受前端请求，路径为 /singleSel/search/complete
     *
     * @param pageable 接收分页参数
     * @return http 实体
     */
    @GetMapping(COMPLETE)
    public HttpEntity<?> resources(@PageableDefault(sort = {"sort","id"}) Pageable pageable){
        return ResponseEntity.ok(pagedResources(singleSelService.searchAll(pageable)));
    }


}
