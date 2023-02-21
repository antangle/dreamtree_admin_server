package com.dreamtree.api.common.auth.kakaologin.service;

import com.dreamtree.api.common.auth.kakaologin.dto.KakaoUserInfoDTO;
import com.dreamtree.api.domain.parent.mapper.ParentMapper;
import com.dreamtree.api.domain.student.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.Role;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class KakaoLoginServiceImpl implements KakaoLoginService {

    private final ParentMapper parentMapper;
    private final StudentMapper studentMapper;
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public int signIn(Long kakaoId) {
        return 0;
    }

    @Override
    public int signUp(String code) {
        return 0;
    }

    @Override
    public KakaoUserInfoDTO getKakaoUserInfo(String accessToken) {
        return null;
    }

}
