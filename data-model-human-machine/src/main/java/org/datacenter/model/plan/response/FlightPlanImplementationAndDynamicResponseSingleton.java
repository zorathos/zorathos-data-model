package org.datacenter.model.plan.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author : [wangminan]
 * @description : 飞行计划实施响应
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightPlanImplementationAndDynamicResponseSingleton {

    /**
     * 飞行计划编号
     * 不确定是否一定有 默认required=false
     */
    @JsonAlias(value = "JHBH")
    private String planRootId;

    /**
     * 飞行计划具体时间点
     */
    @JsonAlias("KFSK")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime flightDateTime;

    /**
     * 飞行计划标准XML
     */
    @JsonAlias("XML")
    private String xml;
}
