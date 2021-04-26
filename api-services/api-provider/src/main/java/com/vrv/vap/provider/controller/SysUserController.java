package com.vrv.vap.provider.controller;

import com.vrv.vap.core.annotation.LoginUser;
import com.vrv.vap.core.model.SysUser;
import com.vrv.vap.provider.model.SysUserModel;
import com.vrv.vap.provider.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysUser)表控制层
 *
 * @author makejava
 * @since 2021-04-24 09:54:07
 */
@RestController
@RequestMapping("user")
@Api(tags = "用户管理")
public class SysUserController {
    private Logger logger = LoggerFactory.getLogger(getClass());
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
    @ApiOperation(value = "根据ID查询")
    @GetMapping("/{id}")
    public SysUserModel selectOne(@PathVariable Integer id) {
        return sysUserService.findByPrimaryKey(id);
    }


    /**
     * 主要测试该方法： http://localhost:18443/api-provider/user
     * @param sysUser 通过注解方式进行获取
     * @return 返回用户对象
     */
    @ApiOperation(value = "zuul传递过来的数据获取当前用户，LoginUser被Request拦截")
    @GetMapping
    public SysUser user(@LoginUser(isFull = true) SysUser sysUser) {
        logger.info("----------------------进入到方法体中----------------------");
        logger.info(sysUser == null ? "空" : "---->" + sysUser.toString());
        return  sysUser;
    }


    @GetMapping(value = "/name/{username:admin}")
    public SysUser selectByUsername(@PathVariable("username") String username){
        logger.info("++++++++++++++feign接口调用++++++++++++++");
        SysUserModel sysUserModel = new SysUserModel();
        sysUserModel.setUsername(username);
        SysUserModel source = sysUserService.selectOne(sysUserModel);

        SysUser target = new SysUser();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    @ApiOperation(value = "查询所有数据")
    @GetMapping("/all")
    public List<SysUserModel> selectAll(){
        return  sysUserService.findAll();
    }

}