package com.digitalchief.service.impl;

import com.digitalchief.model.dto.SeriesDto;
import com.digitalchief.model.repository.SeriesRepository;
import com.digitalchief.service.SeriesService;
import com.digitalchief.service.mapper.SeriesMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SeriesServiceImpl  implements SeriesService {
    private final SeriesRepository seriesRepository;
    private final SeriesMapper seriesMapper;

    @Override
    public SeriesDto findById(Long id) {
        return seriesMapper.toDto(seriesRepository.getReferenceById(id));
    }
}
