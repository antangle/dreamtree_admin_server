package com.dreamtree.api.domain.report.service;

import com.dreamtree.api.common.dto.PageRequestDTO;
import com.dreamtree.api.common.dto.PageResponseDTO;
import com.dreamtree.api.domain.report.dto.*;
import com.dreamtree.api.domain.report.mapper.ReportMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*** 임성현 ver.0.1 ***/

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class ReportServiceImpl implements ReportService {

    private final ReportMapper reportMapper;

    @Override
    public ReportDTO getReport(Long id) {

        ReportStatusDTO reportStatusDTO = ReportStatusDTO.builder()
                .reportId(id)
                .status("accepted")
                .build();

        reportMapper.updateStatus(reportStatusDTO);

        return reportMapper.getReport(id);
    }

    @Override
    public ReportDTO memberGetReport(Long id) {

        return reportMapper.getReport(id);
    }

    @Override
    public PageResponseDTO<ReportListDTO> getMyReportList(ReportRequestDTO reportRequestDTO) {

        List<ReportListDTO> list = reportMapper.getMyReportList(reportRequestDTO);

        log.info("list: " + list);

        int count = reportMapper.getMyReportCount(reportRequestDTO.getReporterEmail());

        PageResponseDTO<ReportListDTO> pageResponseDTO = PageResponseDTO.<ReportListDTO>withAll()
                .pageRequestDTO(reportRequestDTO)
                .dtoList(list)
                .total(count)
                .build();

        return pageResponseDTO;
    }

    @Override
    public PageResponseDTO<ReportListDTO> getReportList(PageRequestDTO pageRequestDTO) {

        List<ReportListDTO> list = reportMapper.getReportList(pageRequestDTO);

        log.info("list: " + list);

        int count = reportMapper.getReportCount();

        PageResponseDTO<ReportListDTO> pageResponseDTO = PageResponseDTO.<ReportListDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(list)
                .total(count)
                .build();

        return pageResponseDTO;
    }

    @Override
    public void updateStatus(ReportStatusDTO reportStatusDTO) {

        reportMapper.updateStatus(reportStatusDTO);
    }

    @Override
    public void writeReport(AddReportDTO addReportDTO) {

        reportMapper.writeReport(addReportDTO);
    }

    @Override
    public void removeReport(List<Long> id) {

        reportMapper.removeReport(id);
    }

}
