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
@JsonPropertyOrder({"aircraftId", "messageTime", "satelliteGuidanceTime", "localTime", "messageSequenceNumber",
        "weaponId", "pylonId", "weaponType", "targetId", "longitude", "latitude", "altitude",
        "missileTargetDistance", "missileSpeed", "interceptionStatus", "nonInterceptionReason",
        "seekerAzimuth", "seekerElevation", "targetTspiStatus", "commandMachineStatus",
        "groundAngleSatisfactionFlag", "zeroCrossingFlag"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class AgTraj {

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
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 高度
     */
    private String altitude;

    /**
     * 航向
     */
    private String heading;

    /**
     * 俯仰
     */
    private String pitch;

    /**
     * 北速
     */
    private String northSpeed;

    /**
     * 天速
     */
    private String skySpeed;

    /**
     * 东速
     */
    private String eastSpeed;

    /**
     * 导引头号
     */
    private String seekerId;

    /**
     * 截获标志
     */
    private String interceptionFlag;

    /**
     * 终止标志
     */
    private String terminationFlag;

    /**
     * 截获成员ID
     */
    private String interceptingMemberId;

    /**
     * 截获装备ID
     */
    private String interceptingEquipmentId;

    /**
     * 截获装备类型
     */
    private String interceptingEquipmentType;

    /**
     * 发射方ID
     */
    private String launcherId;

    /**
     * 导引头方位中心
     */
    private String seekerAzimuthCenter;

    /**
     * 导引头俯仰中心
     */
    private String seekerPitchCenter;

    /**
     * 目标ID
     */
    private String targetId;

    /**
     * 弹目距离
     */
    private String missileTargetDistance;
}
