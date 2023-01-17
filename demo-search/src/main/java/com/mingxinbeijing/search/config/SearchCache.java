package com.mingxinbeijing.search.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;


/**
 * 缓存获取下lesson数据
 * @author jiangzhiwei
 * @date 2022/12/23
 */

@Component
public class SearchCache {

	@Autowired
	private RedisTemplate<String,Object> redisTemplate;
	
	public static Map<Long, String> map = new HashMap<Long, String>();

	@PostConstruct
	public void init() {
		System.out.println("系统运行开始初始化内存  ");

		System.out.println("初始化内存结束 课程数据大小  "+map.size());
	}

}
