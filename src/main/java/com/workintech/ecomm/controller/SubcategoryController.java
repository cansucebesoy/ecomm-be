package com.workintech.ecomm.controller;

import com.workintech.ecomm.dto.CategoryDTO;
import com.workintech.ecomm.service.SubcategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
@RequestMapping("/subcategory")
@RequiredArgsConstructor
public class SubcategoryController {

    private final SubcategoryService subcategoryService;

    @GetMapping("/{subcategoryId}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getParentCategory(@PathVariable long subcategoryId){
        return subcategoryService.getParentCategory(subcategoryId);
    }

    @GetMapping("/{parentCategoryId}")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryDTO> getSubcategories(long parentCategoryId){
        return subcategoryService.getSubcategories(parentCategoryId);
    }
}
