package com.dreamtree.api.attendance;

import com.dreamtree.api.domain.attendance.dto.AttendAddDTO;
import com.dreamtree.api.domain.attendance.dto.AttendParentResDTO;
import com.dreamtree.api.domain.attendance.mapper.AttendanceMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
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


        IntStream.rangeClosed(1, 100).forEach((i) -> {
            AttendAddDTO addDTO = AttendAddDTO.builder()
                    .progressId(Long.valueOf(i))
                    .status(setStatus(i%20 + 1))
                    .times(i%20 + 1)
                    .build();

            attendanceMapper.addAttendance(addDTO);
        });

    }

    @Test
    public void testGetAttendanceListForParent() {

        log.info("==============TEST GET ATTENDANCE LIST FOR PARENT==================");

        Long id = 17L;
        List<AttendParentResDTO> list = attendanceMapper.getAttendanceListForParent(id);

        log.info(list);

    }

}
