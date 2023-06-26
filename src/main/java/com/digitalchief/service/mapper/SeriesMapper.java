package com.digitalchief.service.mapper;

import com.digitalchief.model.dto.PublisherDto;
import com.digitalchief.model.dto.SeriesDto;
import com.digitalchief.model.entity.Publisher;
import com.digitalchief.model.entity.Series;
import com.digitalchief.model.repository.SeriesRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
public class SeriesMapper {
    private ModelMapper modelMapper;

    public Series toEntity(SeriesDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Series.class);
    }

    public SeriesDto toDto(Series entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, SeriesDto.class);
    }

    public List<SeriesDto> listToDto(List<Series> entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, new TypeToken<List<SeriesDto>>() {
        }.getType());
    }
}
