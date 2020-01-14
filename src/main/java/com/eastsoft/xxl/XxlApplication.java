package com.eastsoft.xxl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class XxlApplication {

    public static void main(String[] args) {
        SpringApplication.run(XxlApplication.class, args);
    }

}
