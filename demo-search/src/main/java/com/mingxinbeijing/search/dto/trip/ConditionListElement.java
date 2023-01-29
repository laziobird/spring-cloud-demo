package com.mingxinbeijing.search.dto.trip;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConditionListElement {
    /**
     * 退票/改期标识 T：不可退票/改期 H：有条件退票/改期 F：免费退票/改期 E：按航司客规
     */
    String status;
    /**
     * 起飞前时间,以分钟为单位，与amount配合使用。如填入60，表示起飞前60分钟改期费。<br>
     * 最后一段的endminute必须以-1结尾。
     */
    int endMinute;
    /**
     * 退票/改期费 1）当Status =H，必须赋值； 2）若Status =T/F，此字段可不赋值。
     */
    BigDecimal amount;
}
