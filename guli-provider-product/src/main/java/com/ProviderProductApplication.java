package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.guli.mapper")
@EnableEurekaClient //注册到服务中
public class ProviderProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderProductApplication.class, args);
    }
}
