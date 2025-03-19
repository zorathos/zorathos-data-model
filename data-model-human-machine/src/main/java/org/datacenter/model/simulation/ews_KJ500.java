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
@JsonPropertyOrder({"飞机ID", "消息时间", "卫导时间", "本地时间", "消息序列号", "方位起始角", "扇区相对基准", "扇区类型", "扇区号", "动作代码", "范围终止角"})
public class ews_KJ500 {

    private long id;  // Optional: auto-incrementing ID

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

    @JsonProperty(value = "方位起始角")
    private double azimuthStartAngle;

    @JsonProperty(value = "扇区相对基准")
    private String sectorReference; //  Could be an enum

    @JsonProperty(value = "扇区类型")
    private String sectorType; // Could be an enum

    @JsonProperty(value = "扇区号")
    private String sectorNumber; // Or int, depending on the format

    @JsonProperty(value = "动作代码")
    private String actionCode;  // Could be an enum

    @JsonProperty(value = "范围终止角")
    private double azimuthEndAngle;
}