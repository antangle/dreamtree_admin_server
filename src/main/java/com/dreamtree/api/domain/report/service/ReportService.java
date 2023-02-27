package com.dreamtree.api.domain.report.service;

import com.dreamtree.api.common.dto.PageRequestDTO;
import com.dreamtree.api.common.dto.PageResponseDTO;
import com.dreamtree.api.domain.report.dto.*;

import java.util.List;

public interface ReportService {

    // 신고 조회
    ReportDTO getReport(Long id);

    ReportDTO memberGetReport(Long id);

    // 내가 한 신고 리스트
    PageResponseDTO<ReportListDTO> getMyReportList(ReportRequestDTO reportRequestDTO);

    // 신고 리스트 전체
    PageResponseDTO<ReportListDTO> getReportList(ReportAdminRequestDTO reportRequestDTO);

    // 신고 상태 업데이트
    void updateStatus(ReportStatusDTO reportStatusDTO);

    // 신고하기
    void writeReport(AddReportDTO addReportDTO);

    // 신고 삭제
    void removeReport(List<Long> id);

}
