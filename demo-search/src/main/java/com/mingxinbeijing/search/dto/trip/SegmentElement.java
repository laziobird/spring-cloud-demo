package com.mingxinbeijing.search.dto.trip;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

@Data
public class SegmentElement implements Serializable {
    /**
     * 销售航司 IATA 二字码，必须与 flightNumber 航司相同
     */
    String marketingCarrier;

    @JsonIgnore
    String carrier;

    void setMarketingCarrier(String marketingCarrier) {
        this.marketingCarrier = marketingCarrier;
        this.carrier = marketingCarrier;
    }

    /**
     * 出发机场;IATA 三字码
     */
    String depAirport;

    /**
     * 起飞日期时间(当地时间)，格式:YYYYMMDDHHMM 例: 201203100300 表示 2012 年 3 月 10 日 3 时 0 分
     */
    String depTime;

    /**
     * 到达机场 IATA 三字码
     */
    String arrAirport;

    /**
     * 到达日期时间(当地时间)，格式:YYYYMMDDHHMM 例: 201203101305 表示 2012 年 3 月 10 日 13 时 5 分
     */
    String arrTime;

    /**
     * 【公布运价强校验】/【携程退改签强校验】
     * 子舱位，1-2 个字符
     */
    String seatClass;

    @JsonIgnore
    String cabin;

    void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
        this.cabin = seatClass;
    }

    /**
     * 航班号，如:CA123。
     * 航班号数字前若有多余的数字 0，必须去掉;如 CZ006 需返 回 CZ6
     */
    String flightNumber;

    /**
     * 代码共享标识(true 代码共享/false 非代码共享)
     */
    Boolean codeShare;

    /**
     * 机型 ，IATA 标准 3 字码，并过滤下列机型运价信息
     * BUS|ICE|LCH|LMO|MTL|RFS|TGV|THS|THT|TRN|TSL|
     */
    String aircraftCode;

    /**
     * 实际承运航司
     * 若 codeShare=true`， operatingCarrier 不能为空。
     */
    String operatingCarrier;
    /**
     * 属于第几个用户段，同group（Ctrip不用，Qunar用）
     */
    Integer segmentNo;

    /**
     * 经停城市; IATA 三字码
     */
    String stopCities;

}
