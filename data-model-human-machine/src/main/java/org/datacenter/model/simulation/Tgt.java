package org.datacenter.model.simulation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@JsonPropertyOrder({"飞机ID", "消息时间", "卫导时间", "本地时间", "消息序列号", "目标数量", "targets"})  // Simplified order
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tgt {

    /**
     * 主键 auto-incrementing ID
     */
    private Long id;

    /**
     * 架次号 分区键
     */
    private String sortieNumber;

    @JsonProperty(value = "飞机ID")
    private String aircraftId;

    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    @JsonProperty(value = "消息时间")
    private LocalTime messageTime;

    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    @JsonProperty(value = "卫导时间")
    private LocalTime satelliteGuidanceTime;

    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    @JsonProperty(value = "本地时间")
    private LocalTime localTime;

    @JsonProperty(value = "消息序列号")
    private Long messageSequenceNumber;

    @JsonProperty(value = "目标数量")
    private Integer targetCount;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class TargetData {
        @JsonProperty(value = "标识")
        private String identifier;

        @JsonProperty(value = "传感器")
        private String sensor;

        @JsonProperty(value = "俯仰")
        private Double pitch;

        @JsonProperty(value = "方位")
        private Double azimuth;

        @JsonProperty(value = "斜距")
        private Double slantRange;
    }


    @JsonProperty(value = "targets")
    @Singular
    private List<TargetData> targets;
}
