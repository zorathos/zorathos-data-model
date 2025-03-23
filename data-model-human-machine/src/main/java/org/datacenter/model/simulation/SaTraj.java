package org.datacenter.model.simulation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class SaTraj {

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
     * 被拦截武器ID
     */
    private String interceptedWeaponId;

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
}
