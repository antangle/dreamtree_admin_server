package com.dreamtree.api.domain.category.service;

import com.dreamtree.api.domain.category.dto.CategoryListDTO;

import java.util.List;

//이승윤 ver0.1
public interface CategoryService {
    List<CategoryListDTO> getCategoryList();
}
