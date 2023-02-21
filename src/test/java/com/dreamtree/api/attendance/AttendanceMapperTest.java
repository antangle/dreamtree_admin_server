package com.dreamtree.api.attendance;

import com.dreamtree.api.domain.attendance.dto.AttendAddDTO;
import com.dreamtree.api.domain.attendance.dto.AttendModReqDTO;
import com.dreamtree.api.domain.attendance.dto.AttendParentResDTO;
import com.dreamtree.api.domain.attendance.mapper.AttendanceMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;


/** 최서연 ver.0.1 **/
@SpringBootTest
@Log4j2
public class AttendanceMapperTest {

    @Autowired(required = false)
    AttendanceMapper attendanceMapper;

    String setStatus(int cnt) {
        String status = "";
        char s = '0';

        while (cnt-- > 0) {
            status += s;
        }

        return status;
    }

    @Test
    public void testAddAttendance() {
        attendanceMapper.addAttendance(111L);
    }

    @Test
    public void testGetAttendanceListForParent() {

        log.info("==============TEST GET ATTENDANCE LIST FOR PARENT==================");

        Long id = 17L;
        List<AttendParentResDTO> list = attendanceMapper.getAttendanceListForParent(id);

        log.info(list);

    }

    @Test
    public void testGetAttendanceListForStudent() {
        log.info(attendanceMapper.getAttendanceListForStudent(1L));
    }

    @Test
    public void testUpdateAttendance() {

        log.info("==============TEST GET ATTENDANCE LIST FOR PARENT==================");

        AttendModReqDTO reqDTO = new AttendModReqDTO(2L, "100");
        attendanceMapper.updateAttendance(reqDTO);

    }

    @Test
    public void testSoftDeleteAttendance() {

        log.info("==============TEST SOFT DELETE ATTENDANCES==================");

        attendanceMapper.softDeleteAttendances(2L);
    }

}
