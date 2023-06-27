package com.digitalchief.service.impl;

import com.digitalchief.exceptions.ConstraintException;
import com.digitalchief.exceptions.NonUniqueException;
import com.digitalchief.exceptions.NotFoundException;
import com.digitalchief.model.dto.AuthorDto;
import com.digitalchief.model.dto.ProductDto;
import com.digitalchief.model.repository.AuthorRepository;
import com.digitalchief.service.AuthorService;
import com.digitalchief.service.ProductService;
import com.digitalchief.service.mapper.AuthorMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;
    private final ProductService productService;

    @Override
    public AuthorDto save(AuthorDto authorDto) {
        return authorMapper.toDto(authorRepository.save(authorMapper.toEntity(authorDto)));
    }

    @Override
    public AuthorDto create(AuthorDto authorDto) {
        AuthorDto author = authorMapper.toDto(authorRepository.findByName(authorDto.getName()));
        if (author == null) {
            return save(authorDto);
        } else {
            throw new NonUniqueException("Author is incorrect or already exists. Try again.");
        }
    }

    @Override
    public List<AuthorDto> findAll() {
        return authorMapper.listToDto(authorRepository.findAll());
    }

    @Transactional
    @Override
    public void deleteByName(String name) {
        AuthorDto author = findByName(name);
        var products = productService.findAll();
        for (ProductDto product : products) {
            if (product.getAuthors().contains(name)) {
                throw new ConstraintException("Could not execute statement. " + "'" + name + "'" + "  cannot be deleted.");
            } else {
                authorRepository.delete(authorMapper.toEntity(author));
            }
        }
    }

    @Override
    public AuthorDto findByName(String name) {
        AuthorDto author = authorMapper.toDto(authorRepository.findByName(name));
        if (author == null) {
            throw new NotFoundException("Author " + "'" + name + "'" + " does not exist. Try again.");
        }
        return author;
    }

    @Override
    public AuthorDto update(AuthorDto authorDto, String name) {
        AuthorDto author = findByName(name);
        if (author != null) {
            author.setName(authorDto.getName());
            author.setBirthDate(authorDto.getBirthDate());
            save(author);
        }
        return author;
    }
}
