package com.mingxinbeijing.search.dto.trip;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RefundInfoListElement {
    /**
     * 乘客类型，0：成人 / 1：儿童 / 2：婴儿（Qunar不区分乘客类型，全部传0<br>
     * 对于多乘客类型的查询、验价，必须按乘客类型返回；如成人+儿童的查询，成人和儿童的退改签都要有
     */
    int passengerType;

    /**
     * 退票类型 0：客票全部未使用； 1：客票部分使用【即去程已使用，在往返行程中使用，代表回程的退票信息】<br>
     * 单程时0；往返时0、1都要有（指一张票里面有往返）
     */
    int refundType;

    /**
     * 退票标识 T：不可退 H：有条件退 F：免费退 E：按航司客规
     */
    String refundStatus;

    /**
     * 退票费 （退改币种与运价币种一致）<br>
     * 1）若refundStatus =H，必须赋值； 2）若refundStatus =T/F，此字段可不赋值
     */
    BigDecimal refundFee;

    /**
     * 是否允许NoShow退票  T：不可退；  H：有条件退； F：免费退； E：按航司客规为准
     */
    String refNoshow;

    /**
     * 退票时航班起飞前多久算NoShow，单位：小时（Qunar用的是分钟）<br>
     * 1）若无法确认此时间，请默认赋0。
     */
    int refNoShowCondition;

    /**
     * 1）当refNoshow =H，必须赋值； 2）当refundStatus = H 且 refNoshow = H 时，展示给客人的noshow退票费= refundFee+ refNoshowFee 3）当refundStatus = T 且 refNoshow = H时，展示给客人的noshow退票费 = 0+refNoshowFee
     */
    BigDecimal refNoshowFee;

    /**
     * 多段退改新节点<br>
     * 多段noshow退改可使用此节点，三段以下退改使用上述老节点，此节点不需要传值
     */
    ConditionListElement conditionList;
}
