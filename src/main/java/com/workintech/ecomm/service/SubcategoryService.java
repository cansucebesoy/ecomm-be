package com.workintech.ecomm.service;

import com.workintech.ecomm.dto.CategoryDTO;

import java.util.List;

public interface SubcategoryService {
    CategoryDTO getParentCategory(long subcategoryId);
    List<CategoryDTO> getSubcategories(long parentCategoryId);

}
