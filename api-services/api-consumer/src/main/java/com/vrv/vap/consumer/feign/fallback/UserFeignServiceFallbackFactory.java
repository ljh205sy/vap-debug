package com.vrv.vap.consumer.feign.fallback;

import com.vrv.vap.consumer.feign.UserFeignService;
import com.vrv.vap.core.model.SysUser;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wh1107066
 * userService降级工场
 */
@Slf4j
public class UserFeignServiceFallbackFactory implements FallbackFactory<UserFeignService> {
    @Override
    public UserFeignService create(Throwable throwable) {
        return new UserFeignService() {
            @Override
            public SysUser selectByUsername(String username) {
                log.error("通过用户名查询用户异常:{}", username, throwable);
                return new SysUser();
            }
        };
    }
}
