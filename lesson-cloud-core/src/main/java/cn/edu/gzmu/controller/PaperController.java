package cn.edu.gzmu.controller;

import cn.edu.gzmu.model.constant.LessonResource;
import cn.edu.gzmu.model.entity.Paper;
import cn.edu.gzmu.service.PaperService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Paper Controller
 *
 * @author echo
 * @author YMS
 * @version 1.0
 * @date 2019-5-28 17:24:38
 * @date 2019-8-8
 */
@RequiredArgsConstructor
@RepositoryRestController
@RequestMapping(LessonResource.PAPER_SEARCH)
public class PaperController extends BaseController<Paper, PaperService, Long> {

    private final @NonNull PaperService paperService;

    @GetMapping("/exam/{id}")
    public HttpEntity<?> examById(@PathVariable Long id) {
        return ResponseEntity.ok(paperService.searchByExamId(id));
    }


    @GetMapping("/exam/{id}/generate/")
    public HttpEntity<?> generateByExamId(@PathVariable Long id) {
        return null;
    }
}
