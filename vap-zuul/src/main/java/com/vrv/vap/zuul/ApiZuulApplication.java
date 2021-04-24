package com.vrv.vap.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author wh1107066
 */
@EnableZuulProxy
@SpringBootApplication(scanBasePackages = {"com.vrv.vap"})
public class ApiZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiZuulApplication.class, args);
    }

}
