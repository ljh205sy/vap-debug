package com.vrv.vap.common.utils;

import lombok.Data;

/**
 * 统一规范的异步请求返回结果结构
 * 所有异步请求均返回该结构
 * 当正常的时候，返回的code为ResultCodeEnum.SUCCESS,将业务数据放到data中。其他异常情况的code和msg给前端提示信息
 *
 * @param <T>
 * @author find
 */
@Data
public class Result<T> implements IResult {
    private Integer code;
    private String message;
    private T data;
}
