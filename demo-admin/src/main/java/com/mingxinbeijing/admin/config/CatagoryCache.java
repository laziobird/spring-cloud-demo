package com.mingxinbeijing.admin.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mingxinbeijing.dao.mapper.CategoryMapper;
import com.mingxinbeijing.dao.model.Category;
import com.mingxinbeijing.dao.model.CategoryExample;

/**
 * 缓存获取下lesson数据
 * @author jiangzhiwei
 * @date 2022/12/23
 */

@Component
public class CatagoryCache {

	@Autowired
	private CategoryMapper categoryMapper;
	
	public static Map<Long, String> map = new HashMap<Long, String>();

	@PostConstruct
	public void init() {
		System.out.println("系统运行开始初始化内存  ");
		CategoryExample query = new CategoryExample();	
		
		List<Category> list = categoryMapper.selectByExample(query);
		for (Category c : list) {
			map.put(c.getCategoryId(), c.getCategoryName());
		}
		System.out.println("初始化内存结束 课程数据大小  "+map.size());
	}

}
