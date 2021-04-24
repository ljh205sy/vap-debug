package com.vrv.vap.provider.service.impl;

import com.vrv.vap.mybatis.service.impl.BaseServiceImpl;
import com.vrv.vap.provider.model.SysUser;
import com.vrv.vap.provider.mapper.SysUserMapper;
import com.vrv.vap.provider.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (SysUser)表服务实现类
 *
 * @author makejava
 * @since 2021-04-24 09:54:06
 */
@Service("sysUserService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUser,Integer> implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;


}