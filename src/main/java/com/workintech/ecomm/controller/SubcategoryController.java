package com.workintech.ecomm.controller;

import com.workintech.ecomm.dto.CategoryDTO;
import com.workintech.ecomm.service.SubcategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/subcategory")
@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class SubcategoryController {

    private final SubcategoryService subcategoryService;

    @GetMapping("/parentCategory/{parentCategoryId}")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryDTO> getSubcategories(@PathVariable long parentCategoryId){
        return subcategoryService.getSubcategories(parentCategoryId);
    }

    @GetMapping("/{subcategoryId}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getParentCategory(@PathVariable long subcategoryId){
        return subcategoryService.getParentCategory(subcategoryId);
    }

}
