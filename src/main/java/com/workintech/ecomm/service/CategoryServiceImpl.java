package com.workintech.ecomm.service;

import com.workintech.ecomm.dto.CategoryDTO;
import com.workintech.ecomm.dto.ProductDTO;
import com.workintech.ecomm.entity.Category;
import com.workintech.ecomm.entity.Product;
import com.workintech.ecomm.exceptions.EcommException;
import com.workintech.ecomm.mapper.CategoryMapper;
import com.workintech.ecomm.repository.CategoryRepository;
import com.workintech.ecomm.util.GenericUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final ProductService productService;

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        return GenericUtil.saveEntity(categoryDTO, categoryMapper::categoryDTOToCategory, categoryMapper::categoryToCategoryDTO, categoryRepository);
    }

    @Override
    public CategoryDTO getById(long id) {
        Category category = this.getEntityById(id);
        return categoryMapper.categoryToCategoryDTO(category);
    }

    @Override
    public CategoryDTO delete(long id) {
        Category category = getEntityById(id);
        categoryRepository.delete(category);
        return categoryMapper.categoryToCategoryDTO(category);
    }

    @Override
    public CategoryDTO update(CategoryDTO categoryDTO) {
        return GenericUtil.saveEntity(categoryDTO, categoryMapper::categoryDTOToCategory, categoryMapper::categoryToCategoryDTO, categoryRepository);
    }

    @Override
    public Category getEntityById(long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new EcommException("Category with given id does not exist: " + id, HttpStatus.NOT_FOUND));
    }

    @Override
    public List<ProductDTO> getCategoryProducts(long id) {
        return productService.getByCategoryId(id);
    }
}
