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
@JsonPropertyOrder({"飞机ID", "消息时间", "卫导时间", "本地时间", "消息序列号", "真攻角", "马赫数", "法向过载", "表速(km/h)", "场高", "无线电高度", "余油量", "手动复活", "参数设置状态"})
public class cdDronePlaneState{ // Choose a descriptive class name

    private long id; // Optional: If you have an auto-incrementing ID

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

    @JsonProperty(value = "真攻角")
    private double trueAngleOfAttack;

    @JsonProperty(value = "马赫数")
    private double machNumber;

    @JsonProperty(value = "法向过载")
    private double normalLoadFactor; // Or 'gForce' might be a suitable name

    @JsonProperty(value = "表速(km/h)")
    private double indicatedAirspeed; // km/h

    @JsonProperty(value = "场高")
    private double fieldElevation;

    @JsonProperty(value = "无线电高度")
    private double radioAltitude;

    @JsonProperty(value = "余油量")
    private double remainingFuel; // Consider units (kg, lbs, etc.)

    @JsonProperty(value = "手动复活")
    private String manualRespawn; // Or boolean manualRespawnEnabled;

    @JsonProperty(value = "参数设置状态")
    private String parameterSettingStatus; // Or boolean parametersSet;
}