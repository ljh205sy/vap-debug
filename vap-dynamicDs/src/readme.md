# 访问
http://localhost:18089/sysUser/selectOne?id=1

1. 修改com.vrv.vap.common.service.impl.SysUserServiceImpl中的注解，使用
DataSourceType.SLAVE 与 DataSourceType.MASTER返回的数据不一致查看
例如：
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public SysUser queryById(Integer id) {
        return this.sysUserDao.queryById(id);
    }
    
>如果是master，返回master数据库中的数据
如果是slave，返回slave数据库中的数据