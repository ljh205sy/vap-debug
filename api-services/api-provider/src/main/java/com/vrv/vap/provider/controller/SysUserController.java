package com.vrv.vap.provider.controller;

import com.vrv.vap.provider.model.SysUser;
import com.vrv.vap.provider.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
    public SysUser selectOne(@PathVariable Integer id) {
        return sysUserService.findByPrimaryKey(id);
    }

    @ApiOperation(value = "查询所有数据")
    @GetMapping("/all")
    public List<SysUser> selectAll(){
        return  sysUserService.findAll();
    }

}