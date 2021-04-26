package com.vrv.vap.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.vrv.vap.core.constant.SecurityConstants;
import com.vrv.vap.zuul.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.FORM_BODY_WRAPPER_FILTER_ORDER;

/**
 * @author liujinhui
 * date 2021/4/26 9:50
 */
@Component
public class PermissionsZuulFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private SecurityProperties securityProperties;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FORM_BODY_WRAPPER_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        //非登录用户发送令牌或者是登录时不进行拦截请求
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String requestURI = request.getRequestURL().toString();
        logger.info("send  {} request to {} ", request.getMethod(), requestURI);
        String[] httpUrls = securityProperties.getIgnore().getHttpUrls();
        //判断不进行url权限认证的api，所有已登录用户都能访问的url
        for (String path : httpUrls) {
            if (antPathMatcher.match(path, requestURI)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        // 跳过不需要验证的路径
        ctx.addZuulRequestHeader(SecurityConstants.USER_ID_HEADER, "1");
        ctx.addZuulRequestHeader(SecurityConstants.USER_HEADER, "admin");
        ctx.addZuulRequestHeader("from", "zuul");
        return null;
    }
}
