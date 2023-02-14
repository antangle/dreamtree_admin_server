package com.dreamtree.api.domain.program.mapper;

import com.dreamtree.api.domain.program.dto.FileFormDTO;
import com.dreamtree.api.domain.program.dto.ProgramFormDTO;

import java.util.List;

//이승윤 ver0.1
public interface FileMapper {

    int postFileForm(ProgramFormDTO programFormDTO);
}
