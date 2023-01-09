package com.mingxinbeijing.schedule;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mingxinbeijing.dao.mapper.CategoryMapper;
import com.mingxinbeijing.dao.model.Category;
import com.mingxinbeijing.dao.model.CategoryExample;

@Component
@EnableScheduling // 开启定时任务

/**
 * 定时汇总 视频播放数据
 * 
 * @author jiangzhiwei
 * @date 2022/12/05
 */
public class DemoTask {
	final long INTERVAL = 1000 * 60 * 10;

	@Autowired
	private CategoryMapper categoryMapper;



	private static final Logger LOGGER = LoggerFactory.getLogger(DemoTask.class);

	// 容器启动后,延迟10秒后再执行一次定时器,一分钟执行一次该定时器。
	@Scheduled(initialDelay = 10000, fixedRate = INTERVAL)
	public void summary() {
		CategoryExample example = new CategoryExample();
		List<Category> list = categoryMapper.selectByExample(example);
		LOGGER.info(" 记录数 "+list.size());
	}





}
