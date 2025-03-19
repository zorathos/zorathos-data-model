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
@JsonPropertyOrder({"地防ID", "消息时间", "卫导时间", "本地时间", "消息序列号", "营地类型", "装备类型", "装备编号", "是否开机", "辐射源频段", "诱饵闪烁周期", "天线指向"})
public class srdState {

    private long id; // Optional: auto-incrementing ID

    @JsonProperty(value = "地防ID")
    private String groundDefenseId;

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

    @JsonProperty(value = "营地类型")
    private String campType; // Consider an enum

    @JsonProperty(value = "装备类型")
    private String equipmentType; // Consider an enum

    @JsonProperty(value = "装备编号")
    private String equipmentNumber; // Or int

    @JsonProperty(value = "是否开机")
    private Boolean powerOn;

    @JsonProperty(value = "辐射源频段")
    private String emitterFrequencyBand; // Consider an enum

    @JsonProperty(value = "诱饵闪烁周期")
    private String decoyBlinkPeriod;  // Consider units (seconds, milliseconds, etc.) and double/int

    @JsonProperty(value = "天线指向")
    private String antennaPointing; // Or separate azimuth and elevation (doubles)
}