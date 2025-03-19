package org.datacenter.model.simulation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@JsonPropertyOrder({"发射方ID", "目标ID", "武器类型", "武器ID", "发射时间", "结束时间", "命中结果"})
public class HitResult {

    /**
     * 主键 auto-incrementing ID
     */
    private Long id;

    @JsonProperty(value = "发射方ID")
    private String launcherId;

    @JsonProperty(value = "目标ID")
    private String targetId;

    @JsonProperty(value = "武器类型")
    private String weaponType;

    @JsonProperty(value = "武器ID")
    private String weaponId;

    @JsonProperty(value = "发射时间")
    private String launchTime; // See notes below about String vs LocalTime

    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    @JsonProperty(value = "结束时间")
    private LocalTime endTime;

    @JsonProperty(value = "命中结果")
    private String hitResult;
}
