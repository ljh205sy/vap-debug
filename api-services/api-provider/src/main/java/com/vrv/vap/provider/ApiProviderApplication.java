package com.vrv.vap.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wh1107066
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApiProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiProviderApplication.class, args);
    }

}
