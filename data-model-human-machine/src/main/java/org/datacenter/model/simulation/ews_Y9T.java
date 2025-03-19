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
@JsonPropertyOrder({"飞机ID", "消息时间", "卫导时间", "本地时间", "消息序列号", "干扰方位角", "干扰频点数量", "干扰类型", "干扰波段", "干扰方向", "干扰状态", "干扰俯仰角", "干扰开始频率", "干扰终止频率"})
public class ews_Y9T {

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

    @JsonProperty(value = "干扰方位角")
    private double jammingAzimuth;

    @JsonProperty(value = "干扰频点数量")
    private int jammingFrequencyCount;

    @JsonProperty(value = "干扰类型")
    private String jammingType; // Strong candidate for an enum

    @JsonProperty(value = "干扰波段")
    private String jammingBand; // Strong candidate for an enum

    @JsonProperty(value = "干扰方向")
    private String jammingDirection; // Could be an enum (e.g., Forward, Aft, Left, Right)

    @JsonProperty(value = "干扰状态")
    private String jammingStatus; // Or boolean jammingActive, or an enum

    @JsonProperty(value = "干扰俯仰角")
    private double jammingElevation;

    @JsonProperty(value = "干扰开始频率")
    private double jammingStartFrequency; // Consider units (MHz, GHz, etc.)

    @JsonProperty(value = "干扰终止频率")
    private double jammingEndFrequency;   // Consider units (MHz, GHz, etc.)
}