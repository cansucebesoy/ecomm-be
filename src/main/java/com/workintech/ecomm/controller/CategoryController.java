package com.workintech.ecomm.controller;

import com.workintech.ecomm.dto.CategoryDTO;
import com.workintech.ecomm.dto.ProductDTO;
import com.workintech.ecomm.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201 CREATED
    public CategoryDTO save(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.save(categoryDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) // 200 OK
    public CategoryDTO getById(@PathVariable long id) {
        return categoryService.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) // 200 OK
    public CategoryDTO delete(@PathVariable long id) {
        return categoryService.delete(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK) // 200 OK
    public CategoryDTO update(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.update(categoryDTO);
    }

    @GetMapping("/{id}/product")
    @ResponseStatus(HttpStatus.OK) // 200 OK
    public List<ProductDTO> getCategoryProducts(@PathVariable long id) {
        return categoryService.getCategoryProducts(id);
    }
}
