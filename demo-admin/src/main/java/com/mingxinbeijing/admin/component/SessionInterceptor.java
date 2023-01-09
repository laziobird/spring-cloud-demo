package com.mingxinbeijing.admin.component;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 拦截器 调用用户中心，封装数据
 * 
 * @author jiangzhiwei
 * @date 2022/12/22
 */
public class SessionInterceptor implements HandlerInterceptor {
	private static final Logger LOGGER = LoggerFactory.getLogger(SessionInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if (attributes != null) {

			Enumeration<String> headerNames = request.getHeaderNames();
			if (headerNames != null) {
//				while (headerNames.hasMoreElements()) {
//					String name = headerNames.nextElement();
//					String values = request.getHeader(name);
//					// 请求头的值为JSON格式时有截断问题
//					if ("userId".equals(name) && StrUtil.isNotEmpty(values)) {
//						LOGGER.info(" SessionInterceptor | header 的 userId :" + values);
//						userId = Long.parseLong(values);
//					}
//					if ("companyId".equals(name) && StrUtil.isNotEmpty(values)) {
//						LOGGER.info(" SessionInterceptor | header 的 companyId :" + values);
//						companyId = Long.parseLong(values);
//					}
//				}

			}
		}
		LOGGER.info(" SessionInterceptor Enter ");
		return true;
	}

}
