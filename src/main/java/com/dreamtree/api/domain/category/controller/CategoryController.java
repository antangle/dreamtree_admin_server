package com.dreamtree.api.domain.category.controller;

import com.dreamtree.api.domain.category.dto.CategoryListDTO;
import com.dreamtree.api.domain.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//이승윤 ver0.1
@RestController
@Log4j2
@RequestMapping("api/category/")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("layout")
    public List<CategoryListDTO> getCategoryLists(){
        return categoryService.getCategoryList();
    }
}