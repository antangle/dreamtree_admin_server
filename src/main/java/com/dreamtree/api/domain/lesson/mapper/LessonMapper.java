package com.dreamtree.api.domain.lesson.mapper;

import com.dreamtree.api.domain.lesson.dto.LessonAddDTO;
import com.dreamtree.api.domain.program.dto.LessonProgressDTO;

import java.util.List;

public interface LessonMapper {
    public int addLesson(LessonAddDTO lessonAddDTO);

    // 레슨 리스트
    List<LessonProgressDTO> getLessonList(Long id);
}
