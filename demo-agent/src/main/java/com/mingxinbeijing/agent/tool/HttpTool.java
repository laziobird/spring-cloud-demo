package com.mingxinbeijing.agent.tool;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpTool {
	private static final Logger LOGGER = LoggerFactory.getLogger(HttpTool.class);

	static final int maxIdleConnections = 5;
	static final int maxConnections = 100;
	static final long keepAliveDuration = 10;
	static final int maxRequests = 100;
	static final int maxRequestsPerHost = 10;

	private static ConnectionPool one = new ConnectionPool(maxIdleConnections, keepAliveDuration, TimeUnit.MINUTES);

	// Host 访问并发量限制
	private static Dispatcher dispacher;
	static {
		dispacher = new Dispatcher();
		dispacher.setMaxRequests(maxRequests);
		dispacher.setMaxRequestsPerHost(maxRequestsPerHost);
	}

	// 创建OkHttpClient对象, 并设置超时时间 添加拦截器LoginInterceptor
	private static final OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS)
			.connectionPool(one).addInterceptor(new HttpInterceptor()).dispatcher(dispacher).build();

	/**
	 * 同步GET请求
	 *
	 * @param url 请求地址
	 */
	public static String get(String url) {
		try {
			// 1 创建OkHttpClient对象
			// 2 构建Request对象
			Request request = new Request.Builder().get()// 不写默认为GET请求
					.url(url).build();
			// 3 发起请求获取响应值
			Response response = okHttpClient.newCall(request).execute();
			// 4 根据响应结果判断
			if (response.isSuccessful()) {
				String re = response.body().string();
				// LOGGER.debug(" 请求返回结果: \n "+re);
				return re;
			} else {
				throw new RuntimeException("请求异常,错误码为: " + response.code());
			}
		} catch (Exception e) {
			LOGGER.info("请求失败,对于的URL = {} | 错误信息为= {} ",url, e.getMessage());
		}
		return null;
	}

	/**
	 * 同步POST请求
	 *
	 * @param url    请求地址
	 * @param params 请求参数
	 */
	public static String post(String url, Map<String, String> params) {

		try {
			// 1 创建OkHttpClient对象
			// 2 构建请求体
			MultipartBody body = new MultipartBody.Builder().setType(MediaType.parse("multipart/form-data"))
					// .addFormDataPart("username", params.get("username"))
					// .addFormDataPart("password", params.get("password"))
					.build();
			// 3 构建Request对象
			Request request = new Request.Builder().post(body).url(url).build();
			// 4 发起请求获取响应值
			Response response = okHttpClient.newCall(request).execute();

			// 5 根据响应结果判断
			if (response.isSuccessful()) {
				String re = response.body().string();
				LOGGER.debug(" 请求返回结果: \n " + re);
				return re;
			} else {
				throw new RuntimeException("请求异常,错误码为: " + response.code());
			}
		} catch (Exception e) {
			LOGGER.info("请求失败,错误信息为= {} ", e.getMessage());
		}
		return null;
	}

	/**
	 * 异步Get请求
	 */
	public static void getAsync(String url) {
		// 1 创建OkHttpClient对象
		// 2 构建Request对象
		Request request = new Request.Builder().get()// 不写默认为GET请求
				.url(url).build();
		// 3 发起请求获取响应值
		okHttpClient.newCall(request).enqueue(new AsyncHttpCallBack());
	}

	/**
	 * 异步POST请求
	 *
	 * @param url    请求地址
	 * @param params 请求参数
	 */
	public static String postAsync(String url, Map<String, String> params) {

		try {
			// 1 创建OkHttpClient对象
			// 2 构建请求体
			MultipartBody body = new MultipartBody.Builder().setType(MediaType.parse("multipart/form-data"))
					// .addFormDataPart("username", params.get("username"))
					// .addFormDataPart("password", params.get("password"))
					.build();
			// 3 构建Request对象
			Request request = new Request.Builder().post(body).url(url).build();
			// 4 发起请求获取响应值
			okHttpClient.newCall(request).enqueue(new AsyncHttpCallBack());
		} catch (Exception e) {
			LOGGER.info("请求失败,错误信息为= {} ", e.getMessage());
		}
		return null;
	}



}
