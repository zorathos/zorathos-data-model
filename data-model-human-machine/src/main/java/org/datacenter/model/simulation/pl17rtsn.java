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
@JsonPropertyOrder({"飞机ID", "消息时间", "卫导时间", "本地时间", "消息序列号", "目标ID", "被拦截武器ID", "目标实虚属性", "武器ID", "挂架ID", "武器类型", "弹道类型", "导弹攻击模式"})
public class pl17rtsn {

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

    @JsonProperty(value = "目标ID")
    private String targetId;

    @JsonProperty(value = "被拦截武器ID")
    private String interceptedWeaponId;

    @JsonProperty(value = "目标实虚属性")
    private String targetRealOrVirtual; // Consider an enum

    @JsonProperty(value = "武器ID")
    private String weaponId;

    @JsonProperty(value = "挂架ID")
    private String pylonId;

    @JsonProperty(value = "武器类型")
    private String weaponType;

    @JsonProperty(value = "弹道类型")
    private String trajectoryType; // Consider an enum

    @JsonProperty(value = "导弹攻击模式")
    private String missileAttackMode;  // Strong candidate for an enum
}