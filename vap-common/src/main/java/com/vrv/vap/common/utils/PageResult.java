package com.vrv.vap.common.utils;

import java.io.Serializable;
import java.util.List;

/**
 * @author liujinhui
 * date 2021/3/31 14:36
 */
public class PageResult<T> implements Serializable {

    private int code;

    private String message;

    private long total;

    private List<T> list;

    /**
     * 默认构造
     */
    public PageResult() {
    }

    public PageResult SUCCESS(List<T> rows, long total) {
        this.list = rows;
        this.total = total;
        this.code = ResultEnum.SUCCESS.getCode();
        this.message = ResultEnum.SUCCESS.getMessage();
        return this;
    }

    public PageResult SUCCESS(int code, List<T> rows, long total) {
        this.list = rows;
        this.total = total;
        this.code = code;
        this.message = ResultEnum.SUCCESS.getMessage();
        return this;
    }

    public PageResult SUCCESS(List<T> rows, long total, Integer pageNum, Integer pageSize) {
        this.list = rows;
        this.total = rows.size();
        this.code = ResultEnum.SUCCESS.getCode();
        this.message = ResultEnum.SUCCESS.getMessage();
        return this;
    }

//    public static <T> PageResult<T> success(PageInfo<T> pageInfo) {
//        PageResult<T> result = new PageResult<>();
//        result.setCode(ResultEnum.SUCCESS.getCode());
//        result.setMessage(ResultEnum.SUCCESS.getMessage());
//        if (pageInfo != null && pageInfo.getTotal() > 0) {
//            result.setTotal(pageInfo.getTotal());
//            result.setList(pageInfo.getList());
//        }
//        if (logger.isDebugEnabled()) {
//            //将封装好的数据返回到前台页面， 返回ResponseBody
//            logger.debug("总数量：" + pageInfo.getTotal());
//            logger.debug("总页数：" + pageInfo.getPages());
//            logger.debug("每页显示条数：" + pageInfo.getPageSize());
//            logger.debug("当前是第几页：" + pageInfo.getPageNum());
//            logger.debug("当前页数据数量：" + pageInfo.getSize());
//        }
//        return result;
//    }

    public PageResult SUCCESS(List<T> rows) {
        this.list = rows;
        this.total = rows.size();
        this.code = ResultEnum.SUCCESS.getCode();
        this.message = ResultEnum.SUCCESS.getMessage();

        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public void setData(List<T> data) {
        this.list = data;
        this.total = data.size();
    }

    public PageResult error(int code, String message) {
        this.list = null;
        this.total = 0;
        this.code = code;
        this.message = message;
        return this;
    }
}