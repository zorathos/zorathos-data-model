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
@JsonPropertyOrder({"飞机ID", "消息时间", "卫导时间", "本地时间", "消息序列号", "X波段干扰俯仰", "C波段干扰俯仰", "C波段干扰方位", "S波段干扰俯仰", "S波段干扰方位", "L波段干扰俯仰", "L波段干扰方位", "U波段干扰方位", "干扰状态", "X波段干扰方位角"})
public class ews_Y8G {

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

    @JsonProperty(value = "X波段干扰俯仰")
    private double xBandJammingElevation;

    @JsonProperty(value = "C波段干扰俯仰")
    private double cBandJammingElevation;

    @JsonProperty(value = "C波段干扰方位")
    private double cBandJammingAzimuth;

    @JsonProperty(value = "S波段干扰俯仰")
    private double sBandJammingElevation;

    @JsonProperty(value = "S波段干扰方位")
    private double sBandJammingAzimuth;

    @JsonProperty(value = "L波段干扰俯仰")
    private double lBandJammingElevation;

    @JsonProperty(value = "L波段干扰方位")
    private double lBandJammingAzimuth;

    @JsonProperty(value = "U波段干扰方位")
    private double uBandJammingAzimuth;

    @JsonProperty(value = "干扰状态")
    private String jammingStatus; // Or boolean jammingActive;  Or an enum

    @JsonProperty(value = "X波段干扰方位角")
    private double xBandJammingAzimuthAngle;
}