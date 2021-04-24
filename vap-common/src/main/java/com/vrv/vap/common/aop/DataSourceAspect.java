package com.vrv.vap.common.aop;

import com.vrv.vap.common.annotation.DataSource;
import com.vrv.vap.common.config.DynamicDataSourceHelper;
import com.vrv.vap.common.service.DataSourceNames;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 多数据源，切面处理类
 * @author wh1107066
 */
@Aspect
@Component
public class DataSourceAspect implements Ordered {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("@annotation(com.vrv.vap.common.annotation.DataSource)")
    public void dataSourcePointCut() {
    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        DataSource ds = method.getAnnotation(DataSource.class);
        if(ds == null){
            //如果不存在是直接走的master主库
            DynamicDataSourceHelper.setDataSourceType(DataSourceNames.FIRST);
            logger.info("设置数据源set datasource is " + DataSourceNames.FIRST);
        }else {
            // 如果不为空，从注解中获取是走主库还是从库
            DynamicDataSourceHelper.setDataSourceType(ds.name());
            logger.info("设置数据源set datasource is " + ds.name());
        }

        try {
            return point.proceed();
        } finally {
            DynamicDataSourceHelper.clearDataSourceType();
            logger.info("clean datasource");
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}