package com.dreamtree.api.domain.category.mapper;

import com.dreamtree.api.domain.category.dto.CategoryListDTO;

import java.util.List;

public interface CategoryMapper {
    public List<CategoryListDTO> getCategories();
}
