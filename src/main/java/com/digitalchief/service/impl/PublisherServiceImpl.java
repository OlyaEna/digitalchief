package com.digitalchief.service.impl;

import com.digitalchief.model.repository.PublisherRepository;
import com.digitalchief.service.PublisherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;
}
