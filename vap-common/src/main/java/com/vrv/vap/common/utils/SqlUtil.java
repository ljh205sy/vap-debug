package com.vrv.vap.common.utils;

/**
 * @author liujinhui
 * date 2021/4/10 9:46
 */

import org.springframework.util.StringUtils;

/**
 * sql操作工具类
 *
 * @author liujinhui
 */
public class SqlUtil {
    /**
     * 仅支持字母、数字、下划线、空格、逗号、小数点（支持多个字段排序）
     */
    public static String SQL_PATTERN = "[a-zA-Z0-9_\\ \\,\\.]+";

    /**
     * 检查字符，防止注入绕过
     */
    public static String escapeOrderBySql(String value) {
        if (!StringUtils.isEmpty(value) && !isValidOrderBySql(value)) {
            throw new RuntimeException("参数不符合规范，不能进行查询");
        }
        return value;
    }

    /**
     * 验证 order by 语法是否符合规范
     */
    public static boolean isValidOrderBySql(String value) {
        return value.matches(SQL_PATTERN);
    }
}