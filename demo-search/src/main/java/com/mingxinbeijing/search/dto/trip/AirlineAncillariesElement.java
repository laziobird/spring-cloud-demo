package com.mingxinbeijing.search.dto.trip;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AirlineAncillariesElement implements Serializable {
    /**
     * 行李增值服务，true:包含 / false:不包含
     * 1)默认 false
     */
    Boolean baggageService;

    /**
     * 有无免费行李额，true:无免费行李额 /false:全部有免费行 李额或部分有免费行李额
     * 1)默认 false
     */
    Boolean unFreeBaggage;
}
