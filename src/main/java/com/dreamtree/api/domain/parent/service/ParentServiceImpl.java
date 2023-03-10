package com.dreamtree.api.domain.parent.service;

import com.dreamtree.api.common.dto.PageResponseDTO;
import com.dreamtree.api.domain.parent.dto.EmailParentDTO;
import com.dreamtree.api.domain.parent.dto.ParentInfoReqDTO;
import com.dreamtree.api.domain.parent.dto.ParentInfoResDTO;
import com.dreamtree.api.domain.parent.dto.ParentModDTO;
import com.dreamtree.api.domain.parent.mapper.ParentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/** 최서연 ver.0.2 **/
@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class ParentServiceImpl implements ParentService{

    private final ParentMapper parentMapper;
    @Override
    public PageResponseDTO<ParentInfoResDTO> getAllParentsList(ParentInfoReqDTO reqDTO) {

        List<ParentInfoResDTO> list = parentMapper.getParentList(reqDTO);

        int count = parentMapper.getCount(reqDTO);

        PageResponseDTO<ParentInfoResDTO> result = PageResponseDTO.<ParentInfoResDTO>withAll()
                .pageRequestDTO(reqDTO)
                .dtoList(list)
                .total(count)
                .build();

        return result;
    }

    @Override
    public ParentInfoResDTO getOneParentInfo(Long id) {

        ParentInfoResDTO res = parentMapper.getOneParentInfo(id);

        return res;
    }

    @Override
    public int updateParentInfo(ParentModDTO modDTO) {

        return parentMapper.updateParentInfo(modDTO);

    }

    @Override
    public int softDeleteOneParent(Long id) {

        return parentMapper.softDeleteOneParent(id);

    }

    @Override
    public EmailParentDTO getEmailParent(String email) {

        return parentMapper.getEmailParent(email);
    }
}
