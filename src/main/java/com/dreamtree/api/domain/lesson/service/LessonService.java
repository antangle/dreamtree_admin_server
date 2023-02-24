package com.dreamtree.api.domain.lesson.service;

import com.dreamtree.api.domain.lesson.dto.LessonAddDTO;
import com.dreamtree.api.domain.lesson.dto.LessonApplyInfoDTO;
import com.dreamtree.api.domain.lesson.dto.LessonApplyReqDTO;
import com.dreamtree.api.domain.program.dto.LessonProgressDTO;

import java.util.List;

//이승윤 ver0.1
public interface LessonService {
    public boolean addLesson(LessonAddDTO lessonAddDTO);

    // 레슨 리스트
    List<LessonProgressDTO> getLessonList(Long id);

    LessonApplyInfoDTO getLessonApplyInfo(Long id);

}
