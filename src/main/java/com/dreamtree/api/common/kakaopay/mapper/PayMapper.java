package com.dreamtree.api.common.kakaopay.mapper;

import com.dreamtree.api.common.kakaopay.dto.AfterKakaoPayReadyDTO;
import com.dreamtree.api.common.kakaopay.dto.KakaoReadyResponseDTO;
import com.dreamtree.api.common.kakaopay.dto.PayDTO;

/** 이승윤 ver.0.1 **/
public interface PayMapper {

    int insertPay(AfterKakaoPayReadyDTO afterKakaoPayReadyDTO);
    int updateTid(String tid);

    PayDTO getPaymentInfo(Long payId);
}
