package com.dreamtree.api.domain.program.mapper;

import com.dreamtree.api.domain.program.dto.ProgramDetailsDTO;
import com.dreamtree.api.domain.program.dto.ProgramListDTO;
import com.dreamtree.api.domain.program.dto.ProgramSearchDTO;

import java.util.List;

public interface ProgramMapper {
    List<ProgramListDTO> getProgramLists(ProgramSearchDTO programSearchDTO);

    ProgramDetailsDTO getProgramDetails(Long id);
}
