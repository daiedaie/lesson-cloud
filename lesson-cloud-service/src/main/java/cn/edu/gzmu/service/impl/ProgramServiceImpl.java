package cn.edu.gzmu.service.impl;

import cn.edu.gzmu.model.entity.Program;
import cn.edu.gzmu.repository.entity.ProgramRepository;
import cn.edu.gzmu.service.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * Program Service Impl
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-7 11:33:57
 */
@Service
@RequiredArgsConstructor
public class ProgramServiceImpl extends BaseServiceImpl<ProgramRepository, Program, Long>
        implements ProgramService {

}
