package com.mingxinbeijing.search.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mingxinbeijing.search.component.SessionInterceptor;

/**
 *
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Bean
	public SessionInterceptor getMyInterceptor() {
		return new SessionInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//order 值越小，优先级越高
		registry.addInterceptor(getMyInterceptor()).addPathPatterns("/trip/**").order(100);
	}
}
