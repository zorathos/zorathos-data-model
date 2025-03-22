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
@JsonPropertyOrder({"aircraftId", "messageTime", "satelliteGuidanceTime", "localTime", "messageSequenceNumber", "weaponId", "pylonId", "weaponType", "targetId", "longitude", "latitude", "altitude", "missileTargetDistance", "missileSpeed", "interceptionStatus", "nonInterceptionReason", "seekerAzimuth", "seekerElevation", "targetTspiStatus", "commandMachineStatus", "groundAngleSatisfactionFlag", "zeroCrossingFlag", "distanceInterceptionFlag", "speedInterceptionFlag", "angleInterceptionFlag"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class PL17Traj {

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
     * 挂架ID
     */
    private String pylonId;

    /**
     * 武器类型
     */
    private String weaponType;

    /**
     * 目标ID
     */
    private String targetId;

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
     * 弹目距离
     */
    private String missileTargetDistance;

    /**
     * 弹速度(m/s)
     */
    private String missileSpeed;

    /**
     * 截获状态
     */
    private String interceptionStatus;

    /**
     * 未截获原因
     */
    private String nonInterceptionReason;

    /**
     * 导引头视线方位角
     */
    private String seekerAzimuth;

    /**
     * 导引头视线俯仰角
     */
    private String seekerElevation;

    /**
     * 目标TSPI状态
     */
    private String targetTspiStatus;

    /**
     * 指令机状态
     */
    private String commandMachineStatus;

    /**
     * 擦地角满足标志
     */
    private String groundAngleSatisfactionFlag;

    /**
     * 过零标志
     */
    private String zeroCrossingFlag;

    /**
     * 距离截获标志
     */
    private String distanceInterceptionFlag;

    /**
     * 速度截获标志
     */
    private String speedInterceptionFlag;

    /**
     * 角度截获标志
     */
    private String angleInterceptionFlag;
}
