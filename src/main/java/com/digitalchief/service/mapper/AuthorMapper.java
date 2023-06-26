package com.digitalchief.service.mapper;

import com.digitalchief.model.dto.AuthorDto;
import com.digitalchief.model.entity.Author;
import com.digitalchief.model.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
public class AuthorMapper {
    private ModelMapper modelMapper;

    public Author toEntity(AuthorDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Author.class);
    }

    public AuthorDto toDto(Author entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, AuthorDto.class);
    }

    public List<AuthorDto> listToDto(List<Author> entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, new TypeToken<List<AuthorDto>>() {
        }.getType());
    }
}
