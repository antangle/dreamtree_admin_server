package com.dreamtree.api.domain.category.service;

import com.dreamtree.api.common.enums.ErrorEnum;
import com.dreamtree.api.domain.category.dto.CategoryListDTO;
import com.dreamtree.api.domain.category.mapper.CategoryMapper;
import com.dreamtree.api.exception.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//이승윤 ver0.1
@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class CategoryServiceImpl implements CategoryService{
    private final CategoryMapper categoryMapper;
    @Override
    public List<CategoryListDTO> getCategoryList() {
        List<CategoryListDTO> list = categoryMapper.getCategories();

        if(list.size() == 0) throw new CustomException(ErrorEnum.NO_CATEGORY);

        return list;
    }
}
