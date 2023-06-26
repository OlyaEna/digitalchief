package com.digitalchief.service.impl;

import com.digitalchief.model.repository.AuthorRepository;
import com.digitalchief.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
}
