package org.datacenter.model.simulation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonPropertyOrder({"hitId", "hitTime", "hitLocation", "hitSeverity", "hitStatus"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class HitResult {

    /**
     * 命中ID
     */
    private String hitId;

    /**
     * 命中时间
     */
    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    private LocalTime hitTime;

    /**
     * 命中位置
     */
    private String hitLocation;

    /**
     * 命中严重程度
     */
    private String hitSeverity;

    /**
     * 命中状态
     */
    private String hitStatus;
}
