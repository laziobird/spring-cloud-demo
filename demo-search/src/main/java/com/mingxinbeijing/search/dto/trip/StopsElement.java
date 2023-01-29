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
public class StopsElement {
    /**
     * 经停机场； IATA 三字码（Qunar不用）
     */
    String stopAirport;

    /**
     * 经停时长，拿不到请置空，单位分钟（Qunar不用）
     */
    Integer stopDuration;

    /**
     * 经停城市； IATA 三字码
     */
    String stopCity;
}
