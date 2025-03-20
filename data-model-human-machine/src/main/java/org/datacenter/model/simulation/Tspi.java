package org.datacenter.model.simulation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonPropertyOrder({"飞机ID", "飞机类型", "消息时间", "卫导时间", "本地时间", "消息序列号", "经度", "纬度", "气压高度", "横滚", "俯仰", "航向", "卫星高度", "训练状态", "干扰弹", "加力", "北向速度", "天向速度", "东向速度"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tspi {

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

    @JsonProperty(value = "飞机类型")
    private String aircraftType;

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

    @JsonProperty(value = "经度")
    private Double Longitude;

    @JsonProperty(value = "纬度")
    private Double latitude;

    @JsonProperty(value = "气压高度")
    private Double pressureAltitude;

    @JsonProperty(value = "横滚")
    private Double roll;

    @JsonProperty(value = "俯仰")
    private Double pitch;

    @JsonProperty(value = "航向")
    private Double heading;

    @JsonProperty(value = "卫星高度")
    private Double satelliteAltitude;

    @JsonProperty(value = "训练状态")
    private Double trainingStatus;

    @JsonProperty(value = "干扰弹")
    private Double chaff;

    @JsonProperty(value = "加力")
    private Double afterburner;

    @JsonProperty(value = "北向速度")
    private Double northVelocity;

    @JsonProperty(value = "天向速度")
    private Double verticalVelocity;

    @JsonProperty(value = "东向速度")
    private Double eastVelocity;
}
