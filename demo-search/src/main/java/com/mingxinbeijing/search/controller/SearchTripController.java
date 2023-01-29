package com.mingxinbeijing.search.controller;

import com.mingxinbeijing.common.api.CommonPage;
import com.mingxinbeijing.common.api.CommonResult;
import com.mingxinbeijing.search.config.SearchCache;
import com.mingxinbeijing.search.dto.trip.SearchRQ;
import com.mingxinbeijing.search.dto.trip.SearchRS;
import com.mingxinbeijing.search.service.SupplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;

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
    private SupplyService supplyService;

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchTripController.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @RequestMapping(value = "/v1/search", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public CommonResult<CommonPage<Integer>> search(@RequestBody SearchRQ req) throws InterruptedException, ExecutionException {

        ConcurrentHashMap<String, Optional<SearchRS>> searchMap = new ConcurrentHashMap();
        //TODO 1、走缓存
        //TODO 2、看是否短时间类  10s 重复搜索

        //TODO 3 都不是，实时请求，异步合并结果

        //TODO 获取票代商列表，我们平台DB 存票代商数据
        List<String> supplyListIds = new ArrayList<>();
        supplyListIds.add("供应商1");
        supplyListIds.add("供应商2");

        //Java CompletionService https://www.cnblogs.com/shijiaqi1066/p/10454237.html
        CompletionService<Optional<SearchRS>> completionService = new ExecutorCompletionService<>(SearchCache.searchPool);
        //并发异步请求
        for (String id : supplyListIds) {
            completionService.submit(
                    (Callable<Optional<SearchRS>>) () -> supplyService.search(req)
            );
        }

        //轮询，最终合并请求
        for (String id : supplyListIds) {
            Future<Optional<SearchRS>> f = completionService.take();
            Optional<SearchRS> s = f.get();
            searchMap.putIfAbsent(id, s);
        }

        return CommonResult.success(null);
    }

}
