package com.digitalchief.controllers;

import com.digitalchief.model.dto.GenreDto;
import com.digitalchief.service.GenreService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/genre")
public class GenreController {
    private final GenreService genreService;

    @GetMapping(path = "/all")
    public List<GenreDto> getAllGenres() {
        return genreService.findAll();
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<String> findGenre(@PathVariable String name) {
        GenreDto genre = genreService.findByName(name);
        return new ResponseEntity<>(genre.getId() + ". " + genre.getName(), HttpStatus.OK);
    }


    @PostMapping(path = "/create")
    public ResponseEntity<String> createGenre(@Valid  @RequestBody GenreDto genreDto) {
        GenreDto genre = genreService.createGenre(genreDto);
        return new ResponseEntity<>("Genre " + "\"" + genre.getName() + "\"" + " has been created", HttpStatus.CREATED);
    }


    @DeleteMapping(path = "/delete")
    public ResponseEntity<String> deleteGenre(@RequestBody GenreDto genreDto) {
        genreService.deleteGenreByName(genreDto.getName());
        return new ResponseEntity<>("Genre " + "\"" + genreDto.getName() + "\"" + " has been deleted", HttpStatus.OK);

    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<String> deleteGenre(@PathVariable String name) {
        genreService.deleteGenreByName(name);
        return new ResponseEntity<>("Genre " + "\"" + name + "\"" + " has been deleted", HttpStatus.OK);
    }

    @PutMapping(path = "/update/{name}")
    public ResponseEntity<GenreDto> update(@PathVariable("name") String name,
                                           @Valid @RequestBody GenreDto genreDto) {
        GenreDto genre = genreService.updateGenre(genreDto, name);
        return new ResponseEntity<>(genre, HttpStatus.OK);
    }
}
