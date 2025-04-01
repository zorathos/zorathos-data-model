package org.datacenter.model.plan.response;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class FlightPlanResponse {
    /**
     * 日期
     */
    @JsonProperty("RQ")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate date;

    /**
     * 飞行计划标准XML
     */
    private String xml;
}
