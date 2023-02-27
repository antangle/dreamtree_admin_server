package com.dreamtree.api.domain.report.controller;

import com.dreamtree.api.common.dto.PageRequestDTO;
import com.dreamtree.api.common.dto.PageResponseDTO;
import com.dreamtree.api.domain.report.dto.*;
import com.dreamtree.api.domain.report.service.ReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*** 임성현 ver.0.1 ***/

@RestController
@Log4j2
@RequestMapping("api/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/admin/{id}")
    public ReportDTO adminGetReport(@PathVariable("id") Long id) {

        return reportService.getReport(id);
    }

    @GetMapping("/member/{id}")
    public ReportDTO memberGetReport(@PathVariable("id") Long id) {

        return reportService.memberGetReport(id);
    }

    @GetMapping("/myReport")
    public PageResponseDTO<ReportListDTO> getMyReportList(ReportRequestDTO reportRequestDTO) {

        log.info("myReport: " + reportRequestDTO);
        log.info("sort: " + reportRequestDTO.getSort());

        return reportService.getMyReportList(reportRequestDTO);
    }

    @GetMapping("/list")
    public PageResponseDTO<ReportListDTO> getReportList(ReportAdminRequestDTO reportRequestDTO) {

        return reportService.getReportList(reportRequestDTO);
    }

    @PutMapping("/update")
    public void updateStatus(@RequestBody ReportStatusDTO reportStatusDTO) {

        log.info("update: " + reportStatusDTO);

        reportService.updateStatus(reportStatusDTO);
    }

    @PostMapping("/write")
    public void writeReport(@RequestBody AddReportDTO addReportDTO) {

        reportService.writeReport(addReportDTO);
    }

    @PutMapping("/remove")
    public void removeReport(@RequestBody List<Long> id) {

        reportService.removeReport(id);
    }

}
