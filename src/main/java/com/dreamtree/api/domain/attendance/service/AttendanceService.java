package com.dreamtree.api.domain.attendance.service;

import com.dreamtree.api.domain.attendance.dto.AttendAddDTO;
import com.dreamtree.api.domain.attendance.dto.AttendParentResDTO;

import java.util.List;

public interface AttendanceService {

    int addAttendance(AttendAddDTO addDTO);

    List<AttendParentResDTO> getAttendanceListForParent(Long parent_id);

}
