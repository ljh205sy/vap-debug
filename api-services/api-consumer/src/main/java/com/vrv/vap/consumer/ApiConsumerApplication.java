package com.vrv.vap.consumer;

import com.vrv.vap.vapservice.EnableRyFeignClients;
import com.vrv.vap.vapservice.VapCloudApplication;
import org.springframework.boot.SpringApplication;

/**
 * @author wh1107066
 */
@VapCloudApplication
@EnableRyFeignClients
public class ApiConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiConsumerApplication.class, args);
    }

}
