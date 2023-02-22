package com.dreamtree.api.common.auth.kakaologin.service;

import com.dreamtree.api.common.auth.kakaologin.dto.*;
import com.dreamtree.api.domain.parent.dto.ParentInfoResDTO;
import com.dreamtree.api.domain.parent.dto.ParentKakaoAddDTO;
import com.dreamtree.api.domain.parent.mapper.ParentMapper;
import com.dreamtree.api.domain.student.dto.StudentDetailDTO;
import com.dreamtree.api.domain.student.dto.StudentKakaoAddDTO;
import com.dreamtree.api.domain.student.mapper.StudentMapper;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.xerial.snappy.pool.BufferPool;

import java.util.Collections;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class KakaoLoginServiceImpl implements KakaoLoginService {

    // Kakao URI
//    @Value("${kakao.auth-token-uri}")
    private String kokaoAuthTokenUri;

//    @Value("${kakao.rest-api-key}")
    private String kakaoRestApiKey;

//    @Value("${kakao.redirect-uri}")
    private String kakaoRedirectUri;

//    @Value("${kakao.user-me-uri}")
    private String kakaoUserMeUri;

//    @Value("${kakao.access-token-info-uri}")
    private String kakaoAccessTokenInfoUri;


    private final RestTemplate restTemplate;
    private final ParentMapper parentMapper;
    private final StudentMapper studentMapper;

    @Override
    public KakaoResDTO StudentSignIn(KakaoReqDTO reqDTO) {

        String email = reqDTO.getUserInfoDTO().getAccount_email();
        KakaoTokenResDTO tokenResDTO = studentMapper.getStudentKakaoTokenInfo(email);
        KakaoResDTO resDTO = studentMapper.getStudentIdAndRole(email);

        // 확인된 유저
        if (tokenResDTO != null) {

            String access = tokenResDTO.getAccessToken();
            String refresh = tokenResDTO.getRefreshToken();

            try {
                KakaoReqTokenDTO kakaoToken = getKakaoTokenInfo(access);
                // kakaoToken 만료되면 refreshToken 재발행
                if (kakaoToken.getCode() != 200) {

                    kakaoToken = refreshToken(refresh);
                    // 재발행한 토큰값 update
                    if (kakaoToken.getCode() == 200) {
                        tokenResDTO.setAccessToken(kakaoToken.getAccessToken());
                        tokenResDTO.setRefreshToken(kakaoToken.getRefreshToken());
                        studentMapper.updateStudentKakaoTokenInfo(tokenResDTO);
                    }
                }

                return resDTO;

            } catch (HttpClientErrorException e) {

            }
        }
        return resDTO;
    }

    @Override
    public KakaoResDTO ParentSignIn(KakaoReqDTO reqDTO) {

        String email = reqDTO.getUserInfoDTO().getAccount_email();
        KakaoTokenResDTO tokenResDTO = parentMapper.getParentKakaoTokenInfo(email);
        KakaoResDTO resDTO = new KakaoResDTO("parents", parentMapper.getParentIdWithEmail(email));

        if (tokenResDTO != null) {

            String access = tokenResDTO.getAccessToken();
            String refresh = tokenResDTO.getRefreshToken();

            try {
                KakaoReqTokenDTO kakaoToken = getKakaoTokenInfo(access);
                // kakaoToken 만료되면 refreshToken 재발행
                if (kakaoToken.getCode() != 200) {

                    kakaoToken = refreshToken(refresh);
                    // 재발행한 토큰값 update
                    if (kakaoToken.getCode() == 200) {
                        tokenResDTO.setAccessToken(kakaoToken.getAccessToken());
                        tokenResDTO.setRefreshToken(kakaoToken.getRefreshToken());
                        parentMapper.updateParentKakaoTokenInfo(tokenResDTO);
                    }
                }

                return resDTO;
//                return parentMapper.getOneParentInfoWithEmail(email);

            } catch (HttpClientErrorException e) {

            }
        }
        return resDTO;
    }

    @Override
    public int signUp(KakaoReqDTO reqDTO) {

        String role = reqDTO.getPathValue();
        KakaoUserInfoDTO infoDTO = reqDTO.getUserInfoDTO();

        // 학생 가입
        if (role.equals("students")) {

            StudentKakaoAddDTO addDTO =  StudentKakaoAddDTO.builder()
                    .email(infoDTO.getAccount_email())
                    .nickname(infoDTO.getProfile_nickname())
                    .profileImgUrl(infoDTO.getProfile_nickname())
                    .thumbnailImgUrl(infoDTO.getThumbnail_image())
                    .birthday(infoDTO.getBirthday())
                    .build();


            studentMapper.addStudentWithKakao(addDTO);
            return 1;
        }
        // 학부모 가입
        if (role.equals("parents")) {

            ParentKakaoAddDTO addDTO = ParentKakaoAddDTO.builder()
                    .email(infoDTO.getAccount_email())
                    .nickname(infoDTO.getProfile_nickname())
                    .profileImgUrl(infoDTO.getProfile_nickname())
                    .thumbnailImgUrl(infoDTO.getThumbnail_image())
                    .birthday(infoDTO.getBirthday())
                    .build();

            parentMapper.addParentWithKakao(addDTO);
            return 2;

        }
        return 0;
    }

    @Override
    public KakaoUserInfoDTO getKakaoUserInfo(String accessToken) throws HttpClientErrorException {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer " + accessToken);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity(map, headers);

        try {
            ResponseEntity<KakaoUserInfoDTO> response = restTemplate.exchange(kakaoUserMeUri,
                    HttpMethod.GET, request, KakaoUserInfoDTO.class);

            log.info("===========GET K-USER INFO....GET BODY=============");
            log.info(response.getBody());
            return response.getBody();

        } catch (HttpClientErrorException e) {
            log.error(e.getMessage());
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public KakaoReqTokenDTO generateToken(String code) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("grant_type", "authorization_code");
        map.add("client_id", kakaoRestApiKey);
        map.add("redirect_uri", kakaoRedirectUri);
        map.add("code", code);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity(map, headers);
        try {
            KakaoReqTokenDTO response = restTemplate
                    .postForObject(kokaoAuthTokenUri, request, KakaoReqTokenDTO.class,
                            request);

            log.info("===========GET GENERATE TOKEN....GET RESPONSE=============");
            log.info(response);
            return response;

        } catch (HttpClientErrorException e) {
            log.error(e.getMessage());
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public KakaoReqTokenDTO refreshToken(String refreshToken) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("grant_type", "refresh_token");
        map.add("client_id", kakaoRestApiKey);
        map.add("refresh_token", refreshToken);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity(map, headers);

        try {

            KakaoReqTokenDTO response = restTemplate
                    .postForObject(kokaoAuthTokenUri, request, KakaoReqTokenDTO.class,
                            request);
            response.setCode(200);

            log.info("===========GET REFRESH TOKEN....GET RESPONSE=============");
            log.info(response);
            return response;

        } catch (HttpClientErrorException e) {

            log.error(e.getMessage());
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);

        }

    }

    @Override
    public KakaoReqTokenDTO getKakaoTokenInfo(String accessToken) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer " + accessToken);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity(map, headers);

        try {

            ResponseEntity<KakaoReqTokenDTO> response = restTemplate.exchange(kakaoAccessTokenInfoUri,
                    HttpMethod.GET, request, KakaoReqTokenDTO.class);

            if(response.getStatusCode() == HttpStatus.OK) {
                response.getBody().setCode(200);
            }

            log.info("===========GET TOKEN INFO....GET RESPONSE=============");
            log.info(response);
            return response.getBody();

        } catch (HttpClientErrorException e) {

            log.error(e.getMessage());
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);

        }

    }

}
