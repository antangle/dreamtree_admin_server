package com.dreamtree.api.domain.program.mapper;

import com.dreamtree.api.domain.program.dto.*;

import java.util.List;

//이승윤 ver0.1
public interface ProgramMapper {
    List<ProgramListDTO> getProgramLists(ProgramSearchDTO programSearchDTO);

    int getProgramListsCount(ProgramSearchDTO programSearchDTO);

    List<WordCloudDTO> getWordCloudInfo();

    ProgramDetailsDTO getProgramDetails(Long id);

    int postProgramForm(ProgramFormDTO programFormDTO);


}
