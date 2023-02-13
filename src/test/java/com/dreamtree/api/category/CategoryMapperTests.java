package com.dreamtree.api.category;

import com.dreamtree.api.domain.category.mapper.CategoryMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class CategoryMapperTests {
    @Autowired(required = false)
    CategoryMapper categoryMapper;

    @Test
    public void getCategoryTest(){
        log.info(categoryMapper.getCategories());
    }
}
