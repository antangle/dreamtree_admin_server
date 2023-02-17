package com.dreamtree.api.domain.program.service;

import com.dreamtree.api.common.dto.PageResponseDTO;
import com.dreamtree.api.domain.program.dto.*;

import java.util.List;

//이승윤 ver0.1
public interface ProgramService {
    public PageResponseDTO<ProgramListDTO> getProgramLists(ProgramSearchDTO programSearchDTO);

    public List<WordCloudDTO> getWordCloudInfo();

    public ProgramDetailsDTO getProgramDetailsById(Long id);

    public long postProgramForm(ProgramFormDTO programFormDTO);

}
