package com.digitalchief.service.mapper;

import com.digitalchief.model.dto.PublisherDto;
import com.digitalchief.model.entity.Publisher;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
public class PublisherMapper {
    private ModelMapper modelMapper;

    public Publisher toEntity(PublisherDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Publisher.class);
    }

    public PublisherDto toDto(Publisher entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, PublisherDto.class);
    }

    public List<PublisherDto> listToDto(List<Publisher> entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, new TypeToken<List<PublisherDto>>() {
        }.getType());
    }
}
