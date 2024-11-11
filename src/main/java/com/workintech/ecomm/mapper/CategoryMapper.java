package com.workintech.ecomm.mapper;

import com.workintech.ecomm.dto.CategoryDTO;

import com.workintech.ecomm.entity.Category;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel ="spring")
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(Category category);

    List<CategoryDTO> categoryListToCategoryDTOList(List<Category> categoryList);

    Category categoryDTOToCategory(CategoryDTO categoryDTO);

    List<Category> categoryDTOListToCategoryList(List<CategoryDTO> categoryDTOList);
}
