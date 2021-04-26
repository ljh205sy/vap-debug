package com.vrv.vap.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author liujinhui
 * date 2021/4/24 17:29
 */
@MapperScan("com.vrv.vap.common.dao")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
}