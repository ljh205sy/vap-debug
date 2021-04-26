package com.vrv.vap.provider.common;

import com.vrv.vap.core.constant.SecurityConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liujinhui
 * date 2021/4/26 12:13
 */
@Component
public class HeaderPerRequestFilter extends OncePerRequestFilter {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
       logger.info("---------进入到过滤器中获取header头部信息------");
        String header = request.getHeader(SecurityConstants.USER_ID_HEADER);
        String from = request.getHeader("from");
        String uri = request.getRequestURI();
        logger.info(String.format("接收到的header参数信息完成, 源来自from: %s, uri:%s  header:%s" , from,  uri,  header));
        chain.doFilter(request,response);
    }
}
