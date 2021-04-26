package com.vrv.vap.core.config;


import com.vrv.vap.core.feign.UserService;
import com.vrv.vap.core.resolver.ClientArgumentResolver;
import com.vrv.vap.core.resolver.LoginTokenArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 默认SpringMVC拦截器
 *
 * @author zlt
 * @date 2019/8/5
 * <p>
 * Blog: https://zlt2000.gitee.io
 * Github: https://github.com/zlt2000
 */
public class DefaultWebMvcConfig  implements WebMvcConfigurer {

	@Lazy
	@Autowired
	private UserService userService;
	/**
	 * Token参数解析
	 *
	 * @param argumentResolvers 解析类
	 */
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		//注入用户信息
		argumentResolvers.add(new LoginTokenArgumentResolver(userService));
		//注入应用信息
		argumentResolvers.add(new ClientArgumentResolver());
	}
}
