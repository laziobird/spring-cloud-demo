package com.mingxinbeijing.search.dto.trip;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Builder
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FormatBaggageDetailListElement {
    /**
     * 航程标识，1标识去程，2标识回程（与flightRefList中的segmentNo对应）
     */
    int segmentNo;

    /**
     * 航程中的航段顺序，往返分别从1开始（与flightRefList中的flightSeq对应）
     */
    int flightSeq;

    /**
     * 乘客类型，0：成人 / 1：儿童 / 2：婴儿 （Qunar不区分乘客类型，全部传0）<br>
     * 1）对于多乘客类型的查询、验价，必须按乘客类型返回；如成人+儿童的查询，成人和儿童的行李额都要有
     */
    int passengerType;

    /**
     * 行李额件数，单位PC，枚举值见备注<br>
     * 0：表示无免费托运行李，baggageWeight需赋值-1； -1：表示计重制，baggageWeight表示每人可携带的总重量baggageWeight必须赋正值 n（n>0）：表示计件制，每人可携带n件行李，对应的对应的baggageWeight表示每件行李重量（若计件制时不知每件行李额的重量，baggageWeight必须赋值为-1）
     */
    int baggagePiece;

    /**
     * 行李额重量，单位KG，跟BaggagePiece配合使用
     */
    int baggageWeight;
}
