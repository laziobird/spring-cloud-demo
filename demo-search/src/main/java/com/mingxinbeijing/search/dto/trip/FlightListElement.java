package com.mingxinbeijing.search.dto.trip;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

/**
 * 航班信息通过索引号对应flightRefList，可复用。即同一航班可用于不同的报价组合
 */
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightListElement {
    /**
     * 索引号，与flightRefList中的索引号对应，从1开始
     */
    int flightRefNum;

    /**
     * 票面航司 IATA 二字码，必须与 flightNumber 航司相同
     */
    String marketingCarrier;

    /**
     * 航班号，如：CA123<br>
     * 航班号数字前若有多余的数字 0，必须去掉；如 CZ006 需返回 CZ6 。
     */
    String flightNumber;

    /**
     * 实际承运航司<br>
     * 若codeShare=true， operatingCarrier不能为空。
     */
    String operatingCarrier;

    /**
     * 实际承运航班号
     */
    String operatingFlightNo;

    /**
     * 出发机场；IATA 三字码
     */
    String depAirport;

    /**
     * 到达机场 IATA 三字码
     */
    String arrAirport;

    /**
     * 出发航站楼；使用简写，例如T1（Qunar不用）
     */
    String depTerminal;

    /**
     * 抵达航站楼，使用简写，例如T1（Qunar不用）
     */
    String arrTerminal;

    /**
     * 起飞日期时间（当地时间），格式：YYYYMMDDHHMM 例：201203100300 表示 2012 年 3 月 10 日 3 时 0 分
     */
    String depTime;

    /**
     * 到达日期时间（当地时间），格式：YYYYMMDDHHMM 例：201203101305 表示 2012 年 3 月 10 日 13 时 5 分
     */
    String arrTime;

    /**
     * 代码共享标识（true 代码共享/false 非代码共享）
     */
    Boolean codeShare;

    /**
     * 机型 ，IATA标准3字码，并过滤下列机型运价信息BUS|ICE|LCH|LMO|MTL|RFS|TGV|THS|THT|TRN|TSL|<br>
     * IATA标准3字码，非标运价会被过滤。不确定机型可以不传
     */
    String aircraftCode;

    /**
     * 经停信息，没有经停信息改节点可不传
     */
    List<StopsElement> stops;
}
