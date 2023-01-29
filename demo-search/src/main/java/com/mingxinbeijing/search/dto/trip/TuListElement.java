package com.mingxinbeijing.search.dto.trip;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;
import java.util.Map;

@Builder
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TuListElement {
    /**
     * 属于第几张票<br>
     * 非供应商自组多票产品赋值只有1
     */
    int tuSequence;

    /**
     * 运价信息
     */
    List<PriceListElement> priceList;

    /**
     * 旅客资质，标准三字码： NOR：普通成人 STU：学生 YOU：青年<br>
     * 如果投放非NOR/STU/YOU的政策，请提前告知我们。去哪儿普通价传NOR，留学生价传STU
     */
    String eligibility;

    /**
     * 出票航司（Qunar可不传）<br>
     * 1）一个行程只能赋一个出票航司； 2）如不赋值会取行程第一航段的carrier作为出票航司； 3）此字段非常重要，请务必准确赋值
     */
    String validatingCarrier;

    /**
     * 产品类型 （注意Ctrip和Qunar不一样）<br>
     * Ctrip: 公布运价产品：PUB 控位产品：KWP 私有运价产品：PRV【注】PUB产品需要申请才能投放，KWP为控位票台专用。 Qunar: 公布运价产品：PUB 控位(含包机、切位、K位)产品：KWP 私有运价产品：PRV 积分票产品：JFP 官网（含官网B2B本票）产品：GWP 【注】使用控位产品、积分票产品类型，请提前联系客户经理；不传默认私有运价
     */
    String productType;

    /**
     * 票价等级<br>
     * 1）fareBasis数量必须和航段数一致 2）同一旅行方向的farebasis可以不一致（多段） 3）不同旅行方向farebasis可以不一致 4）每航段1个，使用“ ; ”分割
     */
    String fareBasis;

    /**
     * 是否要与携程退改签匹配，true ：需要匹配 / false：不匹配 （Qunar可不传）<br>
     * 1）默认false；2）匹配成功将展示携程退改；3）匹配失败则展示航司客规。为true时需要赋值公布运价相关参数
     */
    Boolean isUseCtripRule;

    /**
     * 公布运价相关参数，地理区间见运价集群编码 （Qunar可不传）<br>
     * 【注】因供应商无法确定准确的tariffNo，此节点传运价类型，公布运价PUB，私有运价PRI，强校验情况下，不传会过滤运价
     */
    String tariffNo;

    /**
     * 运价规则编码，公布运价相关参数（Qunar可不传）
     */
    String ruleNo;

    /**
     * 订位Office号，可为空（Qunar可不传）
     */
    String bookingOfficeNo;

    /**
     * 出票Office号，可为空（Qunar可不传）
     */
    String ticketingOfficeNo;

    /**
     * 政策来源<br>
     * 1）非公布运价此字段必须按要求返回； 2）公布运价此字段必须按要求返回，否则产品将按照未知订座系统，输出到旅行套餐； 3）使用IATA标准2字代码 1E：TravelSky 1A：Amadeus 1B：Abacus 1S：Sabre 1P：WorldSpan 1G：Galileo Website：航司官网 OT：未知订座系统来源
     */
    String reservationType;

    /**
     * 出票地国家2字码，多个出票地用‘|’隔开
     */
    String posCode;

    /**
     * 特殊产品复合类型（Qunar可不传）<br>
     * 1）需要使用该节点请提前告知；2）多票组合报价目前不支持特殊产品投放。<br>
     * 复合格式：2表示类型2；3表示类型1+类型2；
     *
     * 0：无
     *
     * 1：退改限制，（例如小团价需要同退同改，具体限制内容请提前告知）
     *
     * 2：签证要求，（例如需要朝拜签证，具体签证类型请提前告知）
     *
     * 4：行李尺寸，（例如手提行李特殊尺寸，具体尺寸请提前告知）
     *
     * 8：免费行李额，（例如留学生可申请额外行李或无手提行李，具体要求、限制和额度请提前告知）
     *
     * 16：额外证件要求，（例如需要青年卡或学生证，具体证件类型请提前告知）
     *
     * 32：国籍要求，（例如日本籍乘客，具体国籍要求请提前告知）
     *
     * 64：24小时小额退
     *
     * 128：中转点多票（已废弃）
     *
     * 256：23点前免费退
     *
     * 512：急速出票
     *
     * 1024：往返自组多票产品（之前的伪多票产品，即多张票拼成一张票进行售卖，含多个运价组合的真多票产品不用赋值1024）
     *
     * 2048：廉航超经舱
     */
    Integer complexTerm;

    /**
     * 最小年龄，置空表示无限制<br>
     * 如要使用此字段请提前通知我们，盲目使用会影响价格展示
     */
    Integer minAge;

    /**
     * 最大年龄，置空表示无限制<br>
     * 如要使用此字段请提前通知我们，盲目使用会影响价格展示
     */
    Integer maxAge;

    /**
     * 乘客允许国籍类型，0全部，1适用部分国籍，2不适用部分国籍，与nationality配合使用<br>
     * 限制国籍会造成价格属性劣势
     */
    int nationalityType;

    /**
     * 乘客国籍，可为空<br>
     * 限制国籍会造成价格属性劣势
     */
    String nationality;

    /**
     * 套餐类型（注意Ctrip和Qunar不一样）<br>
     * Ctrip:0：旅行套餐 / 1：商务优选 / 2：特惠推荐 Qunar:0：特惠产品 / 1：标准产品 / 2：特殊产品
     */
    Integer planCategory;

    /**
     * 报销凭证，T：行程单 / F：发票 / E：电子发票 （Qunar只支持T和E）<br>
     * 1）默认F发票； 2）廉航票台可赋值为E电子发票； 3）非Eterm出票则无法打印行程单，不可赋值T行程单；否则出票后系统无法打印，将自动转为F发票开票； 4）赋值T行程单或者E电子发票，请提前通知我们调整配置
     */
    String invoiceType;

    /**
     * 最小出行人数（Qunar可不传）<br>
     * 如果没有返回，默认为1
     */
    Integer minPassengerCount;

    /**
     * 最大出行人数（Qunar可不传）<br>
     * 如果没有返回，默认为9
     */
    Integer maxPassengerCount;

    /**
     * 备注信息，最大 300 个字符<br>
     * 目前此节点不展示
     */
    String note;

    AirlineAncillariesElement airlineAncillaries;

    /**
     * 行李额信息
     */
    List<FormatBaggageDetailListElement> formatBaggageDetailList;

    /**
     * 退票信息
     */
    List<RefundInfoListElement> refundInfoList;

    /**
     * 改签信息
     */
    List<ChangesInfoListElement> changesInfoList;

    /**
     * 套餐信息（Ctrip暂未启用，Qunar可以传）
     */
    PackageInfoElement packageInfo;

    /**
     * 币种<br>
     * 默认为CNY，Ctrip要求与结算币种一致。若要投放外币请与我们联系
     */
    String currency;

    /**
     * 报价类型（Ctrip不用传，Qunar需要传）<br>
     * 0预定价； 1 申请价
     */
    Integer applyType;

    /**
     * 出票速度，单位分钟（Ctrip不用传，Qunar可以传）
     */
    Integer ticketTimeUnit;

    /**
     * 小团报价，0普通价/1小团报价（Ctrip不用传，Qunar可以传）
     */
    Integer tuanType;

    List<Integer> combineIndexs;

    /**
     * 是否支持签转，0表示不支持，1表示支持（Ctrip不用传，Qunar必须传）<br>
     * 默认为0
     */
    Integer endorsement;

    /**
     * 扩展字段（Qunar可以传）Ctrip用于本地证件本地语言下单。如需投放先联系携程相关人员<br>
     * 本地证件本地语言下单： {"languageOfGovernmentIssuedPhotoId": "KO|EN|ZH"}key固定的，value的话采用ISO 639-1标准，多个语言用“|”隔开，示例：KO|EN|ZH
     */
    Map<String, String> extraInfo;

}
