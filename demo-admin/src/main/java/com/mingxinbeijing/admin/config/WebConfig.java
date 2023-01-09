package com.mingxinbeijing.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mingxinbeijing.admin.component.SessionInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	/**
	 * 拦截器如何注入bean https://segmentfault.com/a/1190000040963436
	 * 
	 * @return
	 */
	@Bean
	public SessionInterceptor getMyInterceptor() {
		return new SessionInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//order 值越小，优先级越高
		registry.addInterceptor(getMyInterceptor()).addPathPatterns("/category/**").addPathPatterns("/lesson/**")
				.addPathPatterns("/video/**").addPathPatterns("/api/**").order(100);
	}
}
