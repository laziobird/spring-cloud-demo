package com.mingxinbeijing.search.dto.trip;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceListElement {
    /**
     * 乘客类型，0 成人/1 儿童/2 婴儿
     */
    int passengerType;
    /**
     * 公布运价，不含税（Ctrip用，Qunar不用）<br>
     * 不清楚请赋值0
     */
    BigDecimal publishPrice;
    /**
     * 底价，不含税
     */
    BigDecimal price;

    /**
     * 税费<br>
     * 1）不能是0；2）若存在为0的情况，请与我们联系
     */
    BigDecimal taxFeeAmount;
}
