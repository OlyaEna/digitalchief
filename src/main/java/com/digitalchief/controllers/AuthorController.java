package com.digitalchief.controllers;

import com.digitalchief.model.dto.AuthorDto;
import com.digitalchief.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping(path = "/all")
    public List<AuthorDto> getAll() {
        return authorService.findAll();
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<AuthorDto> findByName(@PathVariable String name) {
        AuthorDto author = authorService.findByName(name);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }


    @PostMapping(path = "/create")
    public ResponseEntity<AuthorDto> create(@RequestBody AuthorDto authorDto) {
        AuthorDto author = authorService.create(authorDto);
        return new ResponseEntity<>(author, HttpStatus.CREATED);
    }


    @DeleteMapping(path = "/delete")
    public ResponseEntity<String> delete(@RequestBody AuthorDto authorDto) {
        authorService.deleteByName(authorDto.getName());
        return new ResponseEntity<>("Author " + "\"" + authorDto.getName() + "\"" + " has been deleted", HttpStatus.OK);

    }

    @PutMapping(path = "/update/{name}")
    public ResponseEntity<AuthorDto> update(@PathVariable("name") String name,
                                               @RequestBody AuthorDto authorDto) {
        AuthorDto author = authorService.update(authorDto, name);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }
}
