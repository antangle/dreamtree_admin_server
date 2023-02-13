package com.dreamtree.api.domain.program.service;

import com.dreamtree.api.common.enums.ErrorEnum;
import com.dreamtree.api.domain.program.dto.ProgramDetailsDTO;
import com.dreamtree.api.domain.program.dto.ProgramListDTO;
import com.dreamtree.api.domain.program.dto.ProgramSearchDTO;
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

    @Override
    public ProgramDetailsDTO getProgramDetailsById(Long id) {

        try{
            ProgramDetailsDTO programDetailsDTO = programMapper.getProgramDetails(id);
            if(programDetailsDTO.getTitle() == null) throw new CustomException(ErrorEnum.NO_PROGRAM_DETAIL);

            return programDetailsDTO;
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<ProgramListDTO> getProgramLists(ProgramSearchDTO programSearchDTO) {
        try {
            List<ProgramListDTO> list = programMapper.getProgramLists(programSearchDTO);
            return list;
        } catch (Exception e){
            throw e;
        }
    }
}
