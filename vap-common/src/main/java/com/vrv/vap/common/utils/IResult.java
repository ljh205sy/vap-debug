package com.vrv.vap.common.utils;

/**
 * 结果编码接口
 * 在各个模块中可以自定义自己的ResultCodeEnum
 *
 * @author find
 */
public interface IResult {
    Integer getCode();

    String getMessage();
}
