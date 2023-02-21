package com.dreamtree.api.domain.attendance.service;

import com.dreamtree.api.domain.attendance.dto.AttendAddDTO;
import com.dreamtree.api.domain.attendance.dto.AttendModReqDTO;
import com.dreamtree.api.domain.attendance.dto.AttendParentResDTO;
import com.dreamtree.api.domain.attendance.dto.AttendStudentResDTO;

import java.util.List;

/** 최서연 ver.0.1 **/
public interface AttendanceService {

    /* 수강시 출석 기록 생성 */
//    int addAttendance(AttendAddDTO addDTO);

    /* 학부모 출석 현황 조회 */
    List<AttendParentResDTO> getAttendanceListForParent(Long parent_id);

    List<AttendStudentResDTO> getAttendanceListForStudent(Long parent_id);

    void putAttendanceStatus(List<AttendModReqDTO> dtoList);

}
