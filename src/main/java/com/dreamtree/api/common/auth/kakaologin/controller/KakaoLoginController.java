package com.dreamtree.api.common.auth.kakaologin.controller;

import com.dreamtree.api.common.auth.kakaologin.dto.KakaoReqDTO;
import com.dreamtree.api.common.auth.kakaologin.dto.KakaoResDTO;
import com.dreamtree.api.common.auth.kakaologin.service.KakaoLoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequestMapping("api/kakaoLogin/")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class KakaoLoginController {

    private final KakaoLoginService kakaoLoginService;

    @PostMapping("")
    public KakaoResDTO kakaoLogin(@RequestBody KakaoReqDTO reqDTO) {

        log.info("==================GET KAKAO USER INFO=================");
        log.info(reqDTO);
        KakaoResDTO result = new KakaoResDTO();
        // students 로그인 >> 학생 DB 조회...
        if (reqDTO.getPathValue().equals("students")) {

            result = kakaoLoginService.StudentSignIn(reqDTO);

        }
        // parents 로그인 >> 학부모 DB 조회...
        if (reqDTO.getPathValue().equals("parents")) {

            result = kakaoLoginService.ParentSignIn(reqDTO);

        }
        return result;
    }

    @PostMapping("signUp")
    public int signUpWithKakaoLoginInfo(@RequestBody KakaoReqDTO reqDTO) {

        log.info("==================GET KAKAO USER SIGN UP=================");
        log.info(reqDTO);

        int res = kakaoLoginService.signUp(reqDTO);

        return res;

    }


}
