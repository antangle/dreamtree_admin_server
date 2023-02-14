package com.dreamtree.api.domain.program.service;

import com.dreamtree.api.common.dto.PageResponseDTO;
import com.dreamtree.api.common.enums.ErrorEnum;
import com.dreamtree.api.domain.program.dto.ProgramDetailsDTO;
import com.dreamtree.api.domain.program.dto.ProgramFormDTO;
import com.dreamtree.api.domain.program.dto.ProgramListDTO;
import com.dreamtree.api.domain.program.dto.ProgramSearchDTO;
import com.dreamtree.api.domain.program.mapper.FileMapper;
import com.dreamtree.api.domain.program.mapper.ProgramMapper;
import com.dreamtree.api.exception.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class ProgramServiceImpl implements ProgramService{
    private final ProgramMapper programMapper;
    private final FileMapper fileMapper;

    @Override
    public ProgramDetailsDTO getProgramDetailsById(Long id) {

        ProgramDetailsDTO programDetailsDTO = programMapper.getProgramDetails(id);
        if(programDetailsDTO.getTitle() == null) throw new CustomException(ErrorEnum.NO_PROGRAM_DETAIL);

        return programDetailsDTO;
    }

    @Override
    public boolean postProgramForm(ProgramFormDTO programFormDTO) {
        int postProgramCount = programMapper.postProgramForm(programFormDTO);

        if(programFormDTO.getProgramId() == 0 || postProgramCount != 1) throw new CustomException(ErrorEnum.POST_PROGRAM_FORM_FAIL);

        if(programFormDTO.getFileForms().size() > 0){
            int postFileCount = fileMapper.postFileForm(programFormDTO);
            if(postFileCount == 0) throw new CustomException(ErrorEnum.NO_CATEGORY);
        }

        return true;
    }

    @Override
    public PageResponseDTO<ProgramListDTO> getProgramLists(ProgramSearchDTO programSearchDTO) {
        List<ProgramListDTO> list = programMapper.getProgramLists(programSearchDTO);
        int count = programMapper.getProgramListsCount(programSearchDTO);

        PageResponseDTO<ProgramListDTO> pagedProgramListDTO = PageResponseDTO.<ProgramListDTO>withAll()
                .pageRequestDTO(programSearchDTO)
                .dtoList(list)
                .total(count)
                .build();

        return pagedProgramListDTO;
    }
}
