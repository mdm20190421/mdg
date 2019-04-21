package com.hk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = {"com.hk"})
@MapperScan(basePackages = {"com.hk.dao"})
public class AppRunner {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(AppRunner.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
