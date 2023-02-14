package com.dreamtree.api.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.dreamtree.api.**.mapper")
public class RootConfig {
}
