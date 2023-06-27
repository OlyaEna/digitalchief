package com.digitalchief.controllers;

import com.digitalchief.model.dto.AuthorDto;
import com.digitalchief.model.dto.ProductDeleteDto;
import com.digitalchief.model.dto.ProductDto;
import com.digitalchief.service.ProductService;
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
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto productDto) {
        ProductDto product = productService.create(productDto);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }


    @DeleteMapping(path = "/delete")
    public ResponseEntity<String> delete(@RequestBody ProductDeleteDto productDto) {
        productService.deleteByName(productDto.getTitle());
        return new ResponseEntity<>("Product " + "\"" + productDto.getTitle() + "\"" + " has been deleted", HttpStatus.OK);

    }

    @PutMapping(path = "/update/{name}")
    public ResponseEntity<ProductDto> update(@PathVariable("name") String name,
                                            @RequestBody ProductDto productDto) {
        ProductDto product = productService.update(productDto, name);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

}
