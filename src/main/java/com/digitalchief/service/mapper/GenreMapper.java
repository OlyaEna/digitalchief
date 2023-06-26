package com.digitalchief.service.mapper;

import com.digitalchief.model.dto.GenreDto;
import com.digitalchief.model.entity.Genre;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
public class GenreMapper {
    private ModelMapper modelMapper;

    public Genre toEntity(GenreDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Genre.class);
    }

    public GenreDto toDto(Genre entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, GenreDto.class);
    }

    public List<GenreDto> listToDto(List<Genre> entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, new TypeToken<List<GenreDto>>() {
        }.getType());
    }

}
