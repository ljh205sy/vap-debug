package com.vrv.vap.admin.feign;

import com.vrv.vap.core.model.SysUser;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * userService降级工场
 *
 * @author zlt
 * @date 2019/1/18
 */
@Slf4j
public class SysUserServiceFallbackFactory implements FallbackFactory<SysUserService> {
    @Override
    public SysUserService create(Throwable throwable) {
        return new SysUserService() {
            @Override
            public SysUser selectByUsername(String username) {
                log.error("通过用户名查询用户异常:{}", username, throwable);
                return new SysUser();
            }
        };
    }
}
