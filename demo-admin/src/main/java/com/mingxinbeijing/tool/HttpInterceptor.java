package com.mingxinbeijing.tool;

import java.io.IOException;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
/**
 * 做一个通用拦截器
 * @author jiangzhiwei
 * @date 2023/01/01
 */
public class HttpInterceptor implements Interceptor {
	private static final Logger LOGGER = LoggerFactory.getLogger(HttpInterceptor.class);

	/**
	 * 统计登录接口完成时间
	 */
	@NotNull
	@Override
	public Response intercept(@NotNull Chain chain) throws IOException {

		Request request = chain.request();
		long begin = System.currentTimeMillis();
		Response response = chain.proceed(request);
		long end = System.currentTimeMillis();

		// 请求统计花费时间

		LOGGER.info("接口请求URL: " + request.url().toString() + " | 接口处理总用时: { "+ (end - begin) + " ms } ");

		return response;
	}
}