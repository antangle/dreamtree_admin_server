package com.dreamtree.api.domain.category.mapper;

import com.dreamtree.api.domain.category.dto.CategoryListDTO;

import java.util.List;

//이승윤 ver0.1
public interface CategoryMapper {
    public List<CategoryListDTO> getCategories();
}
