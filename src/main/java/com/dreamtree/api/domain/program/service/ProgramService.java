package com.dreamtree.api.domain.program.service;

import com.dreamtree.api.domain.program.dto.ProgramDetailsDTO;
import com.dreamtree.api.domain.program.dto.ProgramListDTO;
import com.dreamtree.api.domain.program.dto.ProgramSearchDTO;

import java.util.List;

public interface ProgramService {
    public List<ProgramListDTO> getProgramLists(ProgramSearchDTO programSearchDTO);

    public ProgramDetailsDTO getProgramDetailsById(Long id);
}
