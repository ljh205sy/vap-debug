package com.vrv.vap.consumer.feign;

import com.vrv.vap.core.config.FeignConfiguration;
import com.vrv.vap.core.constant.ServiceNameConstants;
import com.vrv.vap.core.feign.fallback.SysUserServiceFallbackFactory;
import com.vrv.vap.core.model.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author liujinhui
 * date 2021/4/26 20:29
 */
@FeignClient(value = ServiceNameConstants.USER_SERVICE, contextId = "consumer",
             configuration = FeignConfiguration.class, fallbackFactory = SysUserServiceFallbackFactory.class,
             decode404 = true)
public interface UserFeignService {
    @GetMapping(value = "/user/name/{username}")
    SysUser selectByUsername(@PathVariable("username") String username);
}

