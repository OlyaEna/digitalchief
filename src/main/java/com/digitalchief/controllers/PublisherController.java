package com.digitalchief.controllers;

import com.digitalchief.model.dto.GenreDto;
import com.digitalchief.model.dto.PublisherDto;
import com.digitalchief.service.PublisherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/publisher")
public class PublisherController {
    private final PublisherService publisherService;

    @GetMapping(path = "/all")
    public List<PublisherDto> getAll() {
        return publisherService.findAll();
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<PublisherDto> findByName(@PathVariable String name) {
        PublisherDto publisher = publisherService.findByName(name);
        return new ResponseEntity<>(publisher, HttpStatus.OK);
    }


    @PostMapping(path = "/create")
    public ResponseEntity<PublisherDto> create(@RequestBody PublisherDto publisherDto) {
        PublisherDto publisher = publisherService.create(publisherDto);
        return new ResponseEntity<>(publisher, HttpStatus.CREATED);
    }


    @DeleteMapping(path = "/delete")
    public ResponseEntity<String> delete(@RequestBody PublisherDto publisherDto) {
        publisherService.deleteByName(publisherDto.getName());
        return new ResponseEntity<>("Publisher " + "\"" + publisherDto.getName() + "\"" + " has been deleted", HttpStatus.OK);

    }

    @PutMapping(path = "/update/{name}")
    public ResponseEntity<PublisherDto> update(@PathVariable("name") String name,
                                               @RequestBody PublisherDto publisherDto) {
        PublisherDto publisher = publisherService.update(publisherDto, name);
        return new ResponseEntity<>(publisher, HttpStatus.OK);
    }
}
