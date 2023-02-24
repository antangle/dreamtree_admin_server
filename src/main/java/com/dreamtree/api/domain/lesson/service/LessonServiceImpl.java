package com.dreamtree.api.domain.lesson.service;

import com.dreamtree.api.common.enums.ErrorEnum;
import com.dreamtree.api.domain.lesson.dto.LessonAddDTO;
import com.dreamtree.api.domain.lesson.dto.LessonApplyInfoDTO;
import com.dreamtree.api.domain.lesson.dto.LessonApplyReqDTO;
import com.dreamtree.api.domain.program.dto.LessonProgressDTO;
import com.dreamtree.api.domain.lesson.mapper.LessonMapper;
import com.dreamtree.api.exception.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//이승윤 ver0.1
@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class LessonServiceImpl implements LessonService{

    private final LessonMapper lessonMapper;

    @Override
    public boolean addLesson(LessonAddDTO lessonAddDTO) {
        int lessonAddCount = lessonMapper.addLesson(lessonAddDTO);
        if(lessonAddCount == 0) throw new CustomException(ErrorEnum.POST_LESSON_FORM_FAIL);

        return true;
    }

    @Override
    public LessonApplyInfoDTO getLessonApplyInfo(Long id) {
        LessonApplyInfoDTO info = lessonMapper.getLessonApplyInfo(id);
        return info;
    }

    @Override
    public List<LessonProgressDTO> getLessonList(Long id) {

        return lessonMapper.getLessonList(id);
    }
}
