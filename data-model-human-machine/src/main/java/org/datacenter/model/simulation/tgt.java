package org.datacenter.model.simulation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonPropertyOrder({"飞机ID", "消息时间", "卫导时间", "本地时间", "消息序列号", "目标数量", "targets"})  // Simplified order
public class tgt {

    private long id; // Optional: auto-incrementing ID

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
    private long messageSequenceNumber;

    @JsonProperty(value = "目标数量")
    private int targetCount;

    // Nested class to represent a single target
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class TargetData {
        @JsonProperty(value = "标识")
        private String identifier;

        @JsonProperty(value = "传感器")
        private String sensor; // Consider an enum

        @JsonProperty(value = "俯仰")
        private double pitch;

        @JsonProperty(value = "方位")
        private double azimuth;

        @JsonProperty(value = "斜距")
        private double slantRange;
    }

    // Use a list to store the target data
    @JsonProperty(value = "targets") // Give this a clear name in the JSON
    private List<TargetData> targets = new ArrayList<>();


    //Helper method to add target data
    public void addTargetData(String identifier, String sensor, double pitch, double azimuth, double slantRange){
        TargetData targetData = TargetData.builder()
                .identifier(identifier)
                .sensor(sensor)
                .pitch(pitch)
                .azimuth(azimuth)
                .slantRange(slantRange)
                .build();
        targets.add(targetData);
    }


}