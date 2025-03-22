package org.datacenter.model.simulation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonPropertyOrder({"aircraftId", "messageTime", "satelliteGuidanceTime", "localTime", "messageSequenceNumber", "weaponId", "weaponType", "targetId", "interceptedWeaponId", "hitResult", "missReason", "missDistance", "matchingFailureReason", "groundDefenseEquipmentType", "groundDefenseEquipmentId", "groundDefenseEquipmentType1", "groundDefenseEquipmentId1", "groundDefenseEquipmentType2", "groundDefenseEquipmentId2", "groundDefenseEquipmentType3", "groundDefenseEquipmentId3", "jammingEffective", "jamming", "afterburner", "headOn", "heading", "pitch"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rtkn {

    /**
     * 架次号
     */
    private String sortieNumber;

    /**
     * 飞机ID
     */
    private String aircraftId;

    /**
     * 消息时间
     */
    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    private LocalTime messageTime;

    /**
     * 卫导时间
     */
    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    private LocalTime satelliteGuidanceTime;

    /**
     * 本地时间
     */
    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    private LocalTime localTime;

    /**
     * 消息序列号
     */
    private Long messageSequenceNumber;

    /**
     * 武器ID
     */
    private String weaponId;

    /**
     * 武器类型
     */
    private String weaponType;

    /**
     * 目标ID
     */
    private String targetId;

    /**
     * 被拦截武器ID
     */
    private String interceptedWeaponId;

    /**
     * 命中结果
     */
    private String hitResult;

    /**
     * 未命中原因
     */
    private String missReason;

    /**
     * 脱靶量
     */
    private String missDistance;

    /**
     * 匹配失败原因
     */
    private String matchingFailureReason;

    /**
     * 地导装备类型
     */
    private String groundDefenseEquipmentType;

    /**
     * 地导装备ID
     */
    private String groundDefenseEquipmentId;

    /**
     * 地导装备类型.1
     */
    private String groundDefenseEquipmentType1;

    /**
     * 地导装备ID.1
     */
    private String groundDefenseEquipmentId1;

    /**
     * 地导装备类型.2
     */
    private String groundDefenseEquipmentType2;

    /**
     * 地导装备ID.2
     */
    private String groundDefenseEquipmentId2;

    /**
     * 地导装备类型.3
     */
    private String groundDefenseEquipmentType3;

    /**
     * 地导装备ID.3
     */
    private String groundDefenseEquipmentId3;

    /**
     * 干扰是否有效
     */
    private String jammingEffective;

    /**
     * 干扰
     */
    private String jamming;

    /**
     * 加力
     */
    private String afterburner;

    /**
     * 迎头
     */
    private String headOn;

    /**
     * 航向
     */
    private String heading;

    /**
     * 俯仰
     */
    private String pitch;
}
