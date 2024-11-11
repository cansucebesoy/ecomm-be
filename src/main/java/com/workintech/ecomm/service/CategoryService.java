package com.workintech.ecomm.service;

import com.workintech.ecomm.dto.CategoryDTO;
import com.workintech.ecomm.dto.ProductDTO;
import com.workintech.ecomm.entity.Category;

import java.util.List;

public interface CategoryService {
    CategoryDTO getById(long id);
    CategoryDTO save(CategoryDTO categoryDTO);
    CategoryDTO delete(long id);
    CategoryDTO update(CategoryDTO categoryDTO);

    Category getEntityById(long id);
    List<ProductDTO> getCategoryProducts(long id);
}
