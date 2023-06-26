package com.digitalchief.service.impl;

import com.digitalchief.model.repository.GenreRepository;
import com.digitalchief.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;
}
