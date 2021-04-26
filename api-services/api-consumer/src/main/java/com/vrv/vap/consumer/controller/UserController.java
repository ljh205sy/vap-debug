package com.vrv.vap.consumer.controller;

import com.vrv.vap.consumer.feign.UserFeignService;
import com.vrv.vap.core.model.Result;
import com.vrv.vap.core.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liujinhui
 * date 2021/4/26 20:35
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserFeignService userFeignService;
    
    @GetMapping
    public Result<SysUser> user(){
        SysUser admin = userFeignService.selectByUsername("admin");
        return Result.succeed(admin);
    }
}
