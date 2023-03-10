package com.dreamtree.api.config;

import com.dreamtree.api.common.auth.kakaologin.service.KakaoLoginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@Log4j2
@EnableWebSecurity
public class CustomSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {

        log.info("-----------------------");
        http.authorizeRequests().antMatchers("api/parent/*").permitAll();
        http.authorizeRequests().antMatchers("api/request/*").permitAll();
        http.authorizeRequests().antMatchers("api/lesson/*").permitAll();
        http.authorizeRequests().antMatchers("api/program/*").permitAll();
        http.authorizeRequests().antMatchers("api/minio/*").permitAll();
        http.authorizeRequests().antMatchers("api/attendance/*").permitAll();
        http.authorizeRequests().antMatchers("api/kakaoLogin/*").permitAll();
        http.authorizeRequests().antMatchers("api/payment/*").permitAll();

        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.cors(httpSecurityCorsConfigurer -> {
            httpSecurityCorsConfigurer.configurationSource(corsConfigurationSource());
        });

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        log.info("---------------------------------------");
        log.info(configuration);
        log.info("---------------------------------------");
        log.info("---------------------------------------");

        return source;
    }
}
