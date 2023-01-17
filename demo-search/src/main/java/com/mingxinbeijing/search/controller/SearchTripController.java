package com.mingxinbeijing.search.controller;

import com.mingxinbeijing.search.dto.SearchRQ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mingxinbeijing.search.dto.PageParam;
import com.mingxinbeijing.search.service.SupplyService;
import com.mingxinbeijing.common.api.CommonPage;
import com.mingxinbeijing.common.api.CommonResult;

/**
 * 分类API
 * 
 * @author jiangzhiwei
 * @date 2022/11/30
 */

@Controller
@RequestMapping("/trip")
public class SearchTripController {
	@Autowired
	private SupplyService categoryService;

	private static final Logger LOGGER = LoggerFactory.getLogger(SearchTripController.class);

	@Autowired
	private RedisTemplate<String,Object> redisTemplate;

	@RequestMapping(value = "/v1/search", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public CommonResult<CommonPage<Integer>> search(@RequestBody SearchRQ req) {
		//TODO 1、走缓存
		//TODO 2、看是否短时间类  10s 重复搜索
		//TODO 3 都不是，实时请求，异步合并结果
		return CommonResult.success(null);
	}

}
