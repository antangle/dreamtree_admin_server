package com.dreamtree.api.lesson;

import com.dreamtree.api.domain.category.mapper.CategoryMapper;
import com.dreamtree.api.domain.lesson.dto.LessonAddDTO;
import com.dreamtree.api.domain.lesson.mapper.LessonMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
@Log4j2
public class LessonMapperTests {
    @Autowired(required = false)
    LessonMapper lessonMapper;

    @Test
    public void addLesson(){
        LessonAddDTO lessonAddDTO = LessonAddDTO.builder()
                .programId(1)
                .subCategoryId(1)
                .startDate(LocalDate.now().minusDays(1))
                .endDate(LocalDate.now())
                .day(1)
                .fee(10000)
                .lessonLength(2)
                .lessonTime(20)
                .personnel(4)
                .place("place")
                .expireStartDate(LocalDate.now().plusDays(1))
                .expireEndDate(LocalDate.now().plusDays(2))
                .build();
        lessonMapper.addLesson(lessonAddDTO);

    }

    @Test
    public void getLessonListDTO() {

        log.info(lessonMapper.getLessonList(21L));
    }
}
