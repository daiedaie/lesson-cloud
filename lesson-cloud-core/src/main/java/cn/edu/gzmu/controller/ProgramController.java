package cn.edu.gzmu.controller;

import cn.edu.gzmu.model.entity.Program;
import cn.edu.gzmu.service.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Program Controller
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-28 10:48:37
 */
@RequiredArgsConstructor
@RepositoryRestController
@RequestMapping("/program/search")
public class ProgramController extends BaseController<Program, ProgramService, Long> {
    private final static String RESOURCE = "/program/search";

}
