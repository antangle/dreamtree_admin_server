package com.dreamtree.api.domain.attendance.mapper;

import com.dreamtree.api.domain.attendance.dto.AttendAddDTO;
import com.dreamtree.api.domain.attendance.dto.AttendModReqDTO;
import com.dreamtree.api.domain.attendance.dto.AttendParentResDTO;
import com.dreamtree.api.domain.attendance.dto.AttendStudentResDTO;

import java.util.List;

/** 최서연 ver.0.1 **/
public interface AttendanceMapper {

    int addAttendance(Long lessonId);

    List<AttendParentResDTO> getAttendanceListForParent(Long parent_id);

    List<AttendStudentResDTO> getAttendanceListForStudent(Long student_id);

    int updateAttendance(AttendModReqDTO reqDTO);

    int softDeleteAttendances(Long lesson_id);
}
