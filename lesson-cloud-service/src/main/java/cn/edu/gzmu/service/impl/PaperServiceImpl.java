package cn.edu.gzmu.service.impl;

import cn.edu.gzmu.model.entity.Paper;
import cn.edu.gzmu.repository.entity.PaperRepository;
import cn.edu.gzmu.service.PaperService;
import org.springframework.stereotype.Service;


/**
* Paper Service Impl
*
* @author echo
* @version 1.0
* @date 2019-5-7 11:05:31
*/
@Service
public class PaperServiceImpl extends BaseServiceImpl<PaperRepository, Paper, Long>
        implements PaperService {

}
