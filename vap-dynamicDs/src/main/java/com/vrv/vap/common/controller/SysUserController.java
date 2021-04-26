package com.vrv.vap.common.controller;

import com.vrv.vap.common.entity.SysUser;
import com.vrv.vap.common.service.SysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SysUser)表控制层
 *
 * @author makejava
 * @since 2021-04-24 17:41:13
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysUser selectOne(Integer id) {
        return this.sysUserService.queryById(id);
    }


//    /* 方法注解 */
//    @ApiOperation(value = "方法名:打招呼", notes = "打招呼方法的测试")
//    @GetMapping("/hello")
//    public String sayHello(/* 参数注解 */ @ApiParam(value = "参数:名字" , required=true ) @RequestParam String name){
//        return "hi"+name+",I can say hello";
//    }

}