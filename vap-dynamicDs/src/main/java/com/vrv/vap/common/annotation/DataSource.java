package com.vrv.vap.common.annotation;

import com.vrv.vap.common.service.DataSourceType;

import java.lang.annotation.*;

/**
 * 多数据源注解
 *
 * @author wh1107066
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    DataSourceType value() default DataSourceType.MASTER;
}