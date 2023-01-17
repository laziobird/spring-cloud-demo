package com.mingxinbeijing.redis;

import com.google.gson.Gson;
import com.mingxinbeijing.AdminApplication;
import com.mingxinbeijing.admin.dto.PageParam;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * jiangzhiwei
 * 11:04 AM
 */
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;



    @Test
    public void query() {
        PageParam param = new PageParam();
        param.setPageNum(5);
        param.setPageSize(5);
        Gson gson = new Gson();
        redisTemplate.opsForValue().set("test:jsonParam", param);
        redisTemplate.opsForSet().add("test:set2", "asdf");
        redisTemplate.opsForHash().put("hash1", "name1", "lms1");
        redisTemplate.opsForHash().put("hash1", "name2", "lms2");
        redisTemplate.opsForHash().put("hash1", "name3", "lms3");
        PageParam p = (PageParam)redisTemplate.opsForValue().get("test:jsonParam");
        System.out.println(p.toString());
        System.out.println(redisTemplate.opsForHash().get("hash1", "name1"));
    }
}