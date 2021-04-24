package com.vrv.vap.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: liujinhui
 * @Date: 2019/11/9 13:21
 * 进行web结果的包装方法
 * 主要提供成功时的方法success和错误时的error方法
 */

public class ResultUtil {

    private static Logger logger = LoggerFactory.getLogger(ResultUtil.class);

    private ResultUtil() {

    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMessage(ResultEnum.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    public static <T> Result<T> error(IResult result) {

        return error(result.getCode(), result.getMessage());
    }

    public static <T> Result<T> error(Integer code, String msg) {
        Result<T> res = new Result<>();
        res.setCode(code);
        res.setMessage(msg);
        return res;
    }

    public static <T> Result<T> error(Integer code, String msg, T data) {
        Result<T> res = new Result<>();
        res.setCode(code);
        res.setMessage(msg);
        res.setData(data);
        return res;
    }
}
