package com.mingxinbeijing.search.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.mingxinbeijing.search.dto.CategoryParam;
import com.mingxinbeijing.search.service.SupplyService;

/**
 * 课程分类
 * @author jiangzhiwei
 * @date 2022/11/30
 */
@Service
public class SupplyServiceImpl implements SupplyService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SupplyServiceImpl.class);

    @Override
    public int insertCagegory(CategoryParam categoryDto) {
        return 1;
    }

    
    
}
