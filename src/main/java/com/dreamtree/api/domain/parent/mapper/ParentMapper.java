package com.dreamtree.api.domain.parent.mapper;

import com.dreamtree.api.common.auth.kakaologin.dto.KakaoResDTO;
import com.dreamtree.api.common.auth.kakaologin.dto.KakaoTokenResDTO;
import com.dreamtree.api.domain.parent.dto.*;
import com.dreamtree.api.domain.student.dto.StudentKakaoAddDTO;

import java.util.List;

/** 최서연 ver.0.2 **/
public interface ParentMapper {

    int getCount(ParentInfoReqDTO reqDTO);

    List<ParentInfoResDTO> getParentList(ParentInfoReqDTO reqDTO);

    ParentInfoResDTO getOneParentInfo(Long id);

    ParentInfoResDTO getOneParentInfoWithEmail(String email);

    int updateParentInfo(ParentModDTO modDTO);

    int softDeleteOneParent(Long id);



    /** kakao login **/ /*** 최서연 ver.0.1 ***/
    // 학부모 회원 카카오 토큰 정보 조회
    KakaoTokenResDTO getParentKakaoTokenInfo(String email);

    // 학부모 회원 카카오 토큰 정보 업데이트
    int updateParentKakaoTokenInfo(KakaoTokenResDTO resDTO);

    // 이메일로 회원 ID 조회
    KakaoResDTO getParentInfoWithEmail(String email);

    // 카카오 로그인 정보로 회원가입
    int addParentWithKakao(ParentKakaoAddDTO addDTO);

    // 이메일로 학부모 조회
    EmailParentDTO getEmailParent(String email);

}
