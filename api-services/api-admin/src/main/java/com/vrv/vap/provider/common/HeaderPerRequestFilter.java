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
        String header = request.getHeader(SecurityConstants.USER_ID_HEADER);
        String uri = request.getRequestURI();
        logger.info(String.format("接收到的header参数,uri:%s  header:%s" , uri,  header));
        chain.doFilter(request,response);
    }
}
