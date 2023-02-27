package com.dreamtree.api.domain.lesson.controller;

import com.dreamtree.api.domain.attendance.service.AttendanceService;
import com.dreamtree.api.domain.lesson.dto.LessonAddDTO;
import com.dreamtree.api.domain.lesson.dto.LessonApplyInfoDTO;
import com.dreamtree.api.domain.lesson.dto.LessonApplyReqDTO;
import com.dreamtree.api.domain.mail.service.MailService;
import com.dreamtree.api.domain.program.dto.LessonProgressDTO;
import com.dreamtree.api.domain.lesson.service.LessonService;
import com.dreamtree.api.domain.progress.service.ProgressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//이승윤 ver0.1
@RestController
@Log4j2
@RequestMapping("api/lesson")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;

    private final MailService mailService;

    private final ProgressService progressService;

    @PostMapping("/form")
    public void addLesson(@RequestBody LessonAddDTO lessonAddDTO){
        lessonService.addLesson(lessonAddDTO);
    }

//    @GetMapping("/list/{id}")
//    public List<LessonProgressDTO> getLessonList(@PathVariable("id") Long id) {
//
//        return lessonService.getLessonList(id);
//    }

    @GetMapping("/apply")
    public LessonApplyInfoDTO getLessonApplyInfo(@RequestParam("lessonId") Long lessonId){
        return lessonService.getLessonApplyInfo(lessonId);
    }

    @PostMapping("/apply")
    @Transactional
    public void postLessonApply(@RequestBody LessonApplyReqDTO lessonApplyReqDTO){
        log.info(lessonApplyReqDTO);
        mailService.writeMail(lessonApplyReqDTO.getMail());
        progressService.postProgress(lessonApplyReqDTO.getProgress());

    }
}
