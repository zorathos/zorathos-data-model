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
@JsonPropertyOrder({"地防ID", "消息时间", "卫导时间", "本地时间", "消息序列号", "可用导弹数量", "可用目标通道数量", "训练模式", "允许重置导弹", "自主复活"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class CmbPower {


    /**
     * 架次号
     */
    private String sortieNumber;

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
    private Long messageSequenceNumber;

    @JsonProperty(value = "可用导弹数量")
    private String availableMissileCount;

    @JsonProperty(value = "可用目标通道数量")
    private String availableTargetChannelCount;

    @JsonProperty(value = "训练模式")
    private String trainingMode;

    @JsonProperty(value = "允许重置导弹")
    private String allowMissileReset;

    @JsonProperty(value = "自主复活")
    private String autoRespawn;
}
