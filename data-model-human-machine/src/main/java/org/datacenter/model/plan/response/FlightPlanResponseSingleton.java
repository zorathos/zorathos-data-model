package org.datacenter.model.plan.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author : [wangminan]
 * @description : 飞行计划响应
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightPlanResponseSingleton {

    /**
     * 飞行计划编号
     * 不确定是否一定有 默认required=false
     */
    @JsonAlias(value = "JHBH")
    private String planRootId;

    /**
     * 飞行计划日期 HH:mm:ss默认是00:00:00
     */
    @JsonAlias("RQ")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime flightDateTime;

    /**
     * 飞行计划标准XML
     */
    @JsonAlias("XML")
    private String xml;
}
