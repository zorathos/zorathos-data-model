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
@JsonPropertyOrder({"飞机ID", "消息时间", "卫导时间", "本地时间", "消息序列号", "武器ID", "武器类型", "目标ID", "被拦截武器ID", "命中结果", "未命中原因", "脱靶量", "匹配失败原因", "地导装备类型", "地导装备ID", "地导装备类型.1", "地导装备ID.1", "地导装备类型.2", "地导装备ID.2", "地导装备类型.3", "地导装备ID.3", "干扰是否有效", "干扰", "加力", "迎头", "航向", "俯仰"})
public class rtkn {

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

    @JsonProperty(value = "武器ID")
    private String weaponId;

    @JsonProperty(value = "武器类型")
    private String weaponType;

    @JsonProperty(value = "目标ID")
    private String targetId;

    @JsonProperty(value = "被拦截武器ID")
    private String interceptedWeaponId;

    @JsonProperty(value = "命中结果")
    private String hitResult; // Or boolean hit;

    @JsonProperty(value = "未命中原因")
    private String missReason; // Consider an enum

    @JsonProperty(value = "脱靶量")
    private double missDistance;

    @JsonProperty(value = "匹配失败原因")
    private String matchingFailureReason; // Consider an enum

    @JsonProperty(value = "地导装备类型")
    private String groundDefenseEquipmentType;

    @JsonProperty(value = "地导装备ID")
    private String groundDefenseEquipmentId;

    @JsonProperty(value = "地导装备类型.1")
    private String groundDefenseEquipmentType1;

    @JsonProperty(value = "地导装备ID.1")
    private String groundDefenseEquipmentId1;

    @JsonProperty(value = "地导装备类型.2")
    private String groundDefenseEquipmentType2;

    @JsonProperty(value = "地导装备ID.2")
    private String groundDefenseEquipmentId2;

    @JsonProperty(value = "地导装备类型.3")
    private String groundDefenseEquipmentType3;

    @JsonProperty(value = "地导装备ID.3")
    private String groundDefenseEquipmentId3;

    @JsonProperty(value = "干扰是否有效")
    private Boolean jammingEffective; // Or boolean jammingEffective;

    @JsonProperty(value = "干扰")
    private String jamming; // Or boolean jammingActive;

    @JsonProperty(value = "加力")
    private String afterburner; // Or boolean afterburnerEngaged;

    @JsonProperty(value = "迎头")
    private String headOn; // Or boolean headOnEngagement;

    @JsonProperty(value = "航向")
    private double heading;

    @JsonProperty(value = "俯仰")
    private double pitch;


}