package com.mingxinbeijing.search.dto.trip;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChangesInfoListElement {
    /**
     * 乘客类型，0 成人/1 儿童/2 婴儿 （Qunar不区分乘客类型，全部传0）<br>
     * 1）对于对乘客类型的查询、验价，必须按乘客类型返回；如成人+儿童的查询，成人和儿童的退改签都要有。
     */
    int passengerType;

    /**
     * 改期类型 0：客票全部未使用； 1：客票部分已使用【即去程已使用，在往返行程中使用，代表回程的改期信息】<br>
     * 单程时赋值为0；往返时0、1都要有（指一张票里面有往返）
     */
    int changesType;

    /**
     * 改期标识 T：不可改期 H：有条件改期 F：免费改期 E：按航司客规
     */
    String changesStatus;

    /**
     * 改期费 （退改币种与运价币种一致）<br>
     * 1）当changesStatus =H，必须赋值； 2）若changesStatus =T/F，此字段可不赋值。
     */
    BigDecimal changesFee;

    /**
     * 是否允许NoShow改期 T：不可改期； H：有条件改期； F：免费改期； E：按航司客规为准
     */
    String revNoshow;

    /**
     * 改期时航班起飞前多久算NoShow，单位：小时（Qunar用的是分钟）<br>
     * 1）若无法确认此时间，请默认赋0。
     */
    int revNoShowCondition;

    /**
     * NoShow改期费用<br>
     * 1）当revNoshow = H，必须赋值； 2）当changesStatus = H 且 revNoshow = H 时，展示给客人的noshow改期费= changesFee+ revNoshowFee 3）当changesStatus = T 且 revNoshow = H 时，展示给客人的noshow改期费 = 0+ revNoshowFee
     */
    BigDecimal revNoshowFee;

    /**
     * 多段退改新节点<br>
     * 多段noshow退改可使用此节点，三段以下退改使用上述老节点，此节点不需要传值
     */
    List<ConditionListElement> conditionList;

}
