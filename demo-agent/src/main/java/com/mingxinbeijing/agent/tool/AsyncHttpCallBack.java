package com.mingxinbeijing.agent.tool;

import java.io.IOException;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mingxinbeijing.agent.action.bo.DemoBO;
import com.mingxinbeijing.agent.action.impl.DemoAction;
import com.mingxinbeijing.agent.config.AgentConstant;

import cn.hutool.core.util.StrUtil;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class AsyncHttpCallBack implements Callback {
	private static final Logger LOGGER = LoggerFactory.getLogger(AsyncHttpCallBack.class);
	

	
	@Override
	public void onFailure(@NotNull Call call, @NotNull IOException e) {
		LOGGER.info("异步请求失败,URL {} |  异常信息为: {} ",call.request().url().toString(), e.getMessage());
	}

	@Override
	public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
		LOGGER.info("异步请求成功! URL = {}",response.request().url().toString());
		//LOGGER.debug("异步请求返回的内容: "+response.body().string());
		
		
		//根据返回的URl 请求响应的Action
		if(StrUtil.contains(response.request().url().toString(), AgentConstant.DEMO_URL)) {
			String testStr = "{\n"
					+ "    \"lessonId\": \"111\",\n"
					+ "    \"lessonName\": \"17777788888\" \n"
					+ "}";
			DemoAction<DemoBO> demoAction = new DemoAction<DemoBO>();
			demoAction.jsonToObject(testStr,DemoBO.class);
		}
	}

}
