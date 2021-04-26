package com.vrv.vap.provider;

import com.vrv.vap.vapservice.EnableRyFeignClients;
import com.vrv.vap.vapservice.VapCloudApplication;
import org.springframework.boot.SpringApplication;

/**
 * @author wh1107066
 */

@VapCloudApplication
@EnableRyFeignClients
public class ApiProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiProviderApplication.class, args);
    }

}
