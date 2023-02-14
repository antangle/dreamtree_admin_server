package com.dreamtree.api.domain.program.service;

import com.dreamtree.api.common.dto.PageResponseDTO;
import com.dreamtree.api.domain.program.dto.ProgramDetailsDTO;
import com.dreamtree.api.domain.program.dto.ProgramFormDTO;
import com.dreamtree.api.domain.program.dto.ProgramListDTO;
import com.dreamtree.api.domain.program.dto.ProgramSearchDTO;

import java.util.List;

//이승윤 ver0.1
public interface ProgramService {
    public PageResponseDTO<ProgramListDTO> getProgramLists(ProgramSearchDTO programSearchDTO);

    public ProgramDetailsDTO getProgramDetailsById(Long id);

    public boolean postProgramForm(ProgramFormDTO programFormDTO);

}
