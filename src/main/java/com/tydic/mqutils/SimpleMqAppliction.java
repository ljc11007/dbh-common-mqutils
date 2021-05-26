package com.tydic.mqutils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(basePackages = "com.tydic.mqutils.dao")
public class SimpleMqAppliction {
    public static void main(String[] args) {
        SpringApplication.run(SimpleMqAppliction.class, args);
    }
}
