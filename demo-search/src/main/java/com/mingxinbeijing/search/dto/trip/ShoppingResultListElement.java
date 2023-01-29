package com.mingxinbeijing.search.dto.trip;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShoppingResultListElement {
    /**
     * 航段信息
     */
    List<FlightRefListElement> flightRefList;
    /**
     * 可保存必要信息，验价时会放在请求报文中传给供应商
     */
    String data;
    /**
     * 票信息
     */
    List<TuListElement> tuList;
}
