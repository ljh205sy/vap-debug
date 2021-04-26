package com.vrv.vap.admin.feign;

import com.vrv.vap.core.constant.ServiceNameConstants;
import com.vrv.vap.core.model.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zlt
 */
@FeignClient(name = ServiceNameConstants.USER_SERVICE, fallbackFactory = SysUserServiceFallbackFactory.class, decode404 = true)
public interface SysUserService {
    /**
     * feign rpc访问远程/users/{username}接口
     * 查询用户实体对象SysUser
     *
     * @param username
     * @return
     */
    @GetMapping(value = "/user/name/{username}")
    SysUser selectByUsername(@PathVariable("username") String username);
}
