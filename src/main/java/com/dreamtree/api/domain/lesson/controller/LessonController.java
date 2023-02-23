package com.dreamtree.api.domain.lesson.controller;

import com.dreamtree.api.domain.attendance.service.AttendanceService;
import com.dreamtree.api.domain.lesson.dto.LessonAddDTO;
import com.dreamtree.api.domain.program.dto.LessonProgressDTO;
import com.dreamtree.api.domain.lesson.service.LessonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//이승윤 ver0.1
@RestController
@Log4j2
@RequestMapping("api/lesson")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;

    @GetMapping("/form")
    public void addLesson(@RequestBody LessonAddDTO lessonAddDTO){
        lessonService.addLesson(lessonAddDTO);
    }

//    @GetMapping("/list/{id}")
//    public List<LessonProgressDTO> getLessonList(@PathVariable("id") Long id) {
//
//        return lessonService.getLessonList(id);
//    }
}
