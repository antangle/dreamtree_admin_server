package com.dreamtree.api.domain.program.mapper;

import com.dreamtree.api.domain.program.dto.FileFormDTO;
import com.dreamtree.api.domain.program.dto.ProgramFormDTO;

import java.util.List;

public interface FileMapper {

    int postFileForm(ProgramFormDTO programFormDTO);
}
