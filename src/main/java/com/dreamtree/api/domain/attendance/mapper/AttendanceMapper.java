package com.dreamtree.api.domain.attendance.mapper;

import com.dreamtree.api.domain.attendance.dto.AttendAddDTO;
import com.dreamtree.api.domain.attendance.dto.AttendParentResDTO;

import java.util.List;

/** 최서연 ver.0.1 **/
public interface AttendanceMapper {

    int addAttendance(AttendAddDTO addDTO);

    List<AttendParentResDTO> getAttendanceListForParent(Long parent_id);

    List<AttendParentResDTO> getAttendanceListForStudent(Long student_id);

}
