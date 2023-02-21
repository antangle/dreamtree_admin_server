package com.dreamtree.api.domain.attendance.controller;

import com.dreamtree.api.domain.attendance.dto.AttendModReqDTO;
import com.dreamtree.api.domain.attendance.dto.AttendParentResDTO;
import com.dreamtree.api.domain.attendance.dto.AttendStudentResDTO;
import com.dreamtree.api.domain.attendance.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequestMapping("api/attendance")
@RequiredArgsConstructor
public class AttendanceController {
    private final AttendanceService attendanceService;
    @GetMapping("/student")
    public List<AttendStudentResDTO> getStudentReqAttendanceInfo(@RequestParam Long id){
        return attendanceService.getAttendanceListForStudent(id);
    }

    @GetMapping("/parent")
    public List<AttendParentResDTO> getParentReqAttendanceInfo(@RequestParam Long id){
        return attendanceService.getAttendanceListForParent(id);
    }

    @PutMapping("")
    public void putAttendanceStatus(@RequestBody List<AttendModReqDTO> dtoList){
        log.info(dtoList);
        attendanceService.putAttendanceStatus(dtoList);
    }
}
