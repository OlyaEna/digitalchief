package com.digitalchief.service;

import com.digitalchief.model.dto.PublisherDto;

import java.util.List;

public interface PublisherService {
    PublisherDto save(PublisherDto publisherDto);

    PublisherDto create(PublisherDto publisherDto);

    List<PublisherDto> findAll();

    void deleteByName(String name);

    PublisherDto findByName(String name);

    PublisherDto update(PublisherDto publisherDto, String name);
}
