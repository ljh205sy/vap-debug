package com.vrv.vap.admin.controller;

import com.vrv.vap.admin.feign.SysUserService;
import com.vrv.vap.core.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liujinhui
 * date 2021/4/26 10:41
 */
@RestController("feign")
public class UserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping
    public void getUser(){
        SysUser admin = sysUserService.selectByUsername("admin");
        System.out.println(admin);
    }

}
