package cn.edu.gzmu.service.impl;

import cn.edu.gzmu.model.BaseEntity;
import cn.edu.gzmu.model.entity.*;
import cn.edu.gzmu.repository.base.BaseRepository;
import cn.edu.gzmu.repository.entity.*;
import cn.edu.gzmu.service.PaperService;
import com.google.common.base.Splitter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Paper Service Impl
 *
 * @author echo
 * @author YMS
 * @version 1.0
 * @date 2019-5-7 11:33:57
 * @date 2019-8-8
 */
@Service
@RequiredArgsConstructor
public class PaperServiceImpl extends BaseServiceImpl<PaperRepository, Paper, Long>
        implements PaperService {
    private final @NonNull PaperRepository paperRepository;

    @Override
    protected Paper completeEntity(Paper paper) {
        // TODO: paper 完整性填充
        return paper;
    }

    private <T extends BaseEntity> List<T> listEntity(
            String ids, BaseRepository<T, Long> baseRepository) {
        if (Objects.isNull(ids)) {
            return null;
        }
        ArrayList<T> entity = new ArrayList<>();
        Splitter.on(",").trimResults().split(ids)
                .forEach(id -> entity.add(
                        baseRepository.findById(Long.valueOf(id)).orElse(null)
                ));
        return entity;
    }

    @Override
    public List<Paper> searchByExamId(Long id) {
        return paperRepository.findAllByExamId(id)
                .stream().map(this::completeEntity)
                .collect(Collectors.toList());
    }
}
