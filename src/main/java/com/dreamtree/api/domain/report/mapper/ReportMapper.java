package com.dreamtree.api.domain.report.mapper;

import com.dreamtree.api.common.dto.PageRequestDTO;
import com.dreamtree.api.common.dto.PageResponseDTO;
import com.dreamtree.api.domain.report.dto.*;

import java.util.List;

public interface ReportMapper {

    // 신고 조회
    ReportDTO getReport(Long id);

    // 내가 한 신고 리스트
    List<ReportListDTO> getMyReportList(ReportRequestDTO reportRequestDTO);

    // 신고 리스트 전체
    List<ReportListDTO> getReportList(PageRequestDTO pageRequestDTO);

    // 신고 상태 업데이트
    int updateStatus(ReportStatusDTO reportStatusDTO);

    // 신고하기
    int writeReport(AddReportDTO addReportDTO);

    // 신고 삭제
    int removeReport(List<Long> id);

    // 내가 한 신고 카운트
    int getMyReportCount(String email);

    // 전체 신고 카운트
    int getReportCount();

}
