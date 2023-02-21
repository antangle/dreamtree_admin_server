package com.dreamtree.api.domain.attendance.service;

import com.dreamtree.api.common.enums.ErrorEnum;
import com.dreamtree.api.domain.attendance.dto.AttendAddDTO;
import com.dreamtree.api.domain.attendance.dto.AttendModReqDTO;
import com.dreamtree.api.domain.attendance.dto.AttendParentResDTO;
import com.dreamtree.api.domain.attendance.dto.AttendStudentResDTO;
import com.dreamtree.api.domain.attendance.mapper.AttendanceMapper;
import com.dreamtree.api.exception.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/** 최서연 ver.0.1 **/
/** 이승윤 ver.0.1 **/
@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceMapper attendanceMapper;

/*
    @Override
    public int addAttendance(AttendAddDTO addDTO) {

        return attendanceMapper.addAttendance(addDTO);

    }
*/

    @Override
    public List<AttendParentResDTO> getAttendanceListForParent(Long parentId) {

        List<AttendParentResDTO> list = attendanceMapper.getAttendanceListForParent(parentId);

        return list;
    }

    @Override
    public List<AttendStudentResDTO> getAttendanceListForStudent(Long studentId) {

        List<AttendStudentResDTO> list = attendanceMapper.getAttendanceListForStudent(studentId);

        return list;
    }

    @Override
    public void putAttendanceStatus(List<AttendModReqDTO> dtoList) {

        for(AttendModReqDTO reqDTO: dtoList){
            int count = attendanceMapper.updateAttendance(reqDTO);
            if(count != 1) {
                throw new CustomException(ErrorEnum.NO_PROGRAM);
            }
        }

    }

}
