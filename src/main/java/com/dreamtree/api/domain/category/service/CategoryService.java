package com.dreamtree.api.domain.category.service;

import com.dreamtree.api.domain.category.dto.CategoryListDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryListDTO> getCategoryList();
}
