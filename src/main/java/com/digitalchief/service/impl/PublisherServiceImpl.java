package com.digitalchief.service.impl;

import com.digitalchief.exceptions.ConstraintException;
import com.digitalchief.exceptions.NonUniqueException;
import com.digitalchief.exceptions.NotFoundException;
import com.digitalchief.model.dto.ProductDto;
import com.digitalchief.model.dto.PublisherDto;
import com.digitalchief.model.repository.PublisherRepository;
import com.digitalchief.service.ProductService;
import com.digitalchief.service.PublisherService;
import com.digitalchief.service.mapper.PublisherMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;
    private final ProductService productService;

    @Override
    public PublisherDto save(PublisherDto publisherDto) {
        return publisherMapper.toDto(publisherRepository.save(publisherMapper.toEntity(publisherDto)));
    }
    @Override
    public PublisherDto update(PublisherDto publisherDto, String name) {
        PublisherDto publisher = findByName(name);
        if (publisher != null) {
            publisher.setName(publisherDto.getName());
            publisher.setAddress(publisherDto.getAddress());
            save(publisher);
        }
        return publisher;
    }

    @Override
    public PublisherDto create(PublisherDto publisherDto) {
        PublisherDto publisher = publisherMapper.toDto(publisherRepository.findByName(publisherDto.getName()));
        if (publisher == null) {
            return save(publisherDto);
        } else {
            throw new NonUniqueException("Genre is incorrect or already exists. Try again.");
        }
    }

    @Override
    public List<PublisherDto> findAll() {
        return publisherMapper.listToDto(publisherRepository.findAll());
    }

    @Override
    public void deleteByName(String name) {
        PublisherDto publisher = findByName(name);
        List<ProductDto> products = productService.findAll();
        for (ProductDto product : products) {
            if (product.getPublisher().equals(publisher)) {
                throw new ConstraintException("Could not execute statement. " + "'" + name + "'" + "  cannot be deleted.");
            } else {
                publisherRepository.delete(publisherMapper.toEntity(publisher));
            }
        }
    }

    @Override
    public PublisherDto findByName(String name) {
        PublisherDto publisher = publisherMapper.toDto(publisherRepository.findByName(name));
        if (publisher == null) {
            throw new NotFoundException("Publisher " + "'" + name + "'" + " does not exist. Try again.");
        }
        return publisher;
    }


}
