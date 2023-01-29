package com.mingxinbeijing.search.dto.trip;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightRefListElement {
    /**
     * 航班索引号
     */
    int flightRefNum;

    /**
     * 航程标识，1标识去程，2标识回程
     */
    int segmentNo;

    /**
     * 航程中的航段顺序，往返分别从1开始
     */
    int flightSeq;

    /**
     * 属于第几张票，从1开始赋值，第一张票赋值为1。供应商自组多票产品才存在多个值。<br>
     * Qunar目前不支持多张票，默认赋值为1
     */
    int tuSequence;

    /**
     * 舱等； 头等：F；商务：C；超经：S（非廉航和廉航均已支持，需联系我方配置）；经济：
     */
    String seatGrade;

    /**
     * 子舱位<br>
     * 携程会根据子舱位调用携程舱等接口去获取舱等，携程会校验子舱位是否规范（默认为两位字符，特殊舱位与我们联系）
     */
    String seatClass;

    /**
     * 子舱位数量，如果舱位数量超过9 ，请返回9。如果没有返回，默认为 9<br>
     * 该字段的准确赋值可有效拦截用户在乘机人页填写人数大于剩余舱位数的情况
     */
    int seatCount;

    /**
     * 航司原始子舱位，如果航司无原始子舱位名，则赋值为Y<br>
     * 供携程匹配退改签，赋值比价属性用
     */
    String originSeatClass;

    /**
     * 品牌运价名<br>
     * 供携程匹配退改签，赋值比价属性用
     */
    String brandName;
}
