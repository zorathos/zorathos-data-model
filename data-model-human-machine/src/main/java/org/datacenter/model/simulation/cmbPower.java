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
@JsonPropertyOrder({"地防ID", "消息时间", "卫导时间", "本地时间", "消息序列号", "可用导弹数量", "可用目标通道数量", "训练模式", "允许重置导弹", "自主复活"})
public class cmbPower {

    private long id; // Optional: If you have an auto-incrementing ID

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

    @JsonProperty(value = "可用导弹数量")
    private int availableMissileCount;

    @JsonProperty(value = "可用目标通道数量")
    private int availableTargetChannelCount;

    @JsonProperty(value = "训练模式")
    private String trainingMode; // Or boolean inTrainingMode;

    @JsonProperty(value = "允许重置导弹")
    private String allowMissileReset; // Or boolean missileResetAllowed;

    @JsonProperty(value = "自主复活")
    private String autoRespawn; // Or boolean autoRespawnEnabled;
}