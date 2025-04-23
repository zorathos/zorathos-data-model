package org.datacenter.model.plan.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author : [wangminan]
 * @description : 飞行计划响应
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightPlanResponse {

    /**
     * 飞行计划编号
     * 不确定是否一定有 默认required=false
     */
    @JsonProperty(value = "JHBH")
    private String planRootId;

    /**
     * 飞行计划日期
     */
    @JsonProperty("FXRQ")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate flightDate;

    /**
     * 飞行计划标准XML
     */
    @JsonProperty("XML")
    private String xml;
}
