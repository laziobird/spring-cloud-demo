package com.mingxinbeijing.search.dto.trip;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.List;

@Getter
@Validated
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchRS implements Serializable {
    /**
     *  0，接口响应成功;
     *  3，其他失败原因;
     *  4，ctrip请求参数错误;
     *  5，程序异常;
     *  -1，网络异常(ctrip使用)
     *  -2，response 数据异常(ctrip 使用)
     * 【注】无航线政策数据时请返回 status = 0，routings 空即 可;status 不为 0 都将计入查询接口响应失败
     */
    int status;

    /**
     * 提示信息，长度小于 64
     */
    String msg;

    /**
     * 航班信息通过索引号对应flightRefList，可复用。即同一航班可用于不同的报价组合
     */
    List<FlightListElement> flightList;

    /**
     * 报价信息，参考下面的 Routing Element
     */
    List<ShoppingResultListElement> shoppingResultList;

    /**
     * 自定义运价缓存时长，单位：秒<br>
     * 自定义缓存时长上限为3600秒，下限为10秒，不赋值时使用默认缓存时长
     */
    Integer cacheTime;

}
