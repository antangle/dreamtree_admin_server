package com.dreamtree.api.domain.attendance.service;

import com.dreamtree.api.domain.attendance.dto.AttendAddDTO;
import com.dreamtree.api.domain.attendance.dto.AttendParentResDTO;
import com.dreamtree.api.domain.attendance.mapper.AttendanceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/** 최서연 ver.0.1 **/
@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceMapper attendanceMapper;

    @Override
    public int addAttendance(AttendAddDTO addDTO) {

        return attendanceMapper.addAttendance(addDTO);

    }

    @Override
    public List<AttendParentResDTO> getAttendanceListForParent(Long parent_id) {

        return attendanceMapper.getAttendanceListForParent(parent_id);

    }
}
