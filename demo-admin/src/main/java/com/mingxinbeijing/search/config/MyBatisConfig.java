package com.mingxinbeijing.search.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author jiangzhiwei
 * @date 2022/11/29
 */
@Configuration
@MapperScan("com.mingxinbeijing.dao.mapper")
public class MyBatisConfig {
}
