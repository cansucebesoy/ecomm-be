package com.workintech.ecomm.controller;

import com.workintech.ecomm.dto.ProductDTO;
import com.workintech.ecomm.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Validated
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201 CREATED
    public ProductDTO save(@RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) // 200 OK
    public ProductDTO getById(@PathVariable long id) {
        return productService.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) // 200 OK
    public ProductDTO delete(@PathVariable long id) {
        return productService.delete(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK) // 200 OK
    public ProductDTO update(@RequestBody ProductDTO productDTO) {
        return productService.update(productDTO);
    }
}