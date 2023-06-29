package com.digitalchief.controllers;

import com.digitalchief.model.dto.*;
import com.digitalchief.service.AuthorService;
import com.digitalchief.service.GenreService;
import com.digitalchief.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final AuthorService authorService;
    private final GenreService genreService;

    @GetMapping(path = "/all")
    public List<ProductDto> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<ProductDto> findByName(@PathVariable String name) {
        ProductDto productDto = productService.findByName(name);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }


    @PostMapping(path = "/create")
    public ResponseEntity<ProductDto> create(@Valid  @RequestBody ProductDto productDto) {
        ProductDto product = productService.create(productDto);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }


    @DeleteMapping(path = "/delete")
    public ResponseEntity<String> delete(@RequestBody ProductDto productDto) {
        productService.deleteByName(productDto.getTitle());
        return new ResponseEntity<>("Product " + "\"" + productDto.getTitle() + "\"" + " has been deleted", HttpStatus.OK);

    }


    @PutMapping(path = "/update/{name}")
    public ResponseEntity<ProductDto> update(@PathVariable("name") String name,
                                             @Valid @RequestBody ProductDto productDto) {
        ProductDto product = productService.update(productDto, name);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }


    @PostMapping(path = "/set/author")
    public ResponseEntity<String> setAuthor(@RequestBody ParamProductDto paramProductDto) {
        authorService.insertIntoAuthorProduct(paramProductDto);
        return new ResponseEntity<>(paramProductDto.getProductName() + " "+ paramProductDto.getParamName(), HttpStatus.OK);
    }

    @PostMapping(path = "/set/genre")
    public ResponseEntity<String> setGenre(@RequestBody ParamProductDto paramProductDto) {
        genreService.insertIntoGenreProduct(paramProductDto);
        return new ResponseEntity<>(paramProductDto.getProductName() + paramProductDto.getParamName(), HttpStatus.OK);
    }

    @GetMapping(path = "/find/{genre}")
    public ResponseEntity<List<ProductDto>> findByGenre(@PathVariable("genre") String genre) {
        List<ProductDto> productDtoList = genreService.findProductsByGenre(genre);
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }


}
