package com.workintech.ecomm.service;

import com.workintech.ecomm.dto.CategoryDTO;
import com.workintech.ecomm.entity.Category;
import com.workintech.ecomm.entity.Subcategory;
import com.workintech.ecomm.exceptions.EcommException;
import com.workintech.ecomm.mapper.CategoryMapper;
import com.workintech.ecomm.repository.SubcategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubcategoryServiceImpl implements SubcategoryService{
    private final SubcategoryRepository subcategoryRepository;
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;
    @Override
    public CategoryDTO getParentCategory(long subcategoryId) {
        Subcategory subcategory = subcategoryRepository.findBySubcategoryId(subcategoryId)
                .orElseThrow(() -> new EcommException("subcategory not found with id: " + subcategoryId, HttpStatus.NOT_FOUND));
        return categoryMapper.categoryToCategoryDTO(subcategory.getParentCategory());
    }

    @Override
    public List<CategoryDTO> getSubcategories(long parentCategoryId) {
        List<Subcategory> subcategoryList = subcategoryRepository.findByParentCategoryId(parentCategoryId);
        List<Category> categoryList = subcategoryList.stream().map((Subcategory::getSubcategory)).toList();
        return categoryMapper.categoryListToCategoryDTOList(categoryList);
    }
}
