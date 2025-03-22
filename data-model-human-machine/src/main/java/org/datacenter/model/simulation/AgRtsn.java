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
public class AgRtsn {

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
     * 武器挂架ID
     */
    private String weaponPylonId;

    /**
     * 武器类型
     */
    private String weaponType;

    /**
     * 投放弹数
     */
    private String numberOfMissilesReleased;

    /**
     * 载机地速
     */
    private String aircraftGroundSpeed;

    /**
     * 载机经度
     */
    private String aircraftLongitude;

    /**
     * 载机纬度
     */
    private String aircraftLatitude;

    /**
     * 载机高度
     */
    private String aircraftAltitude;

    /**
     * 载机航向
     */
    private String aircraftHeading;

    /**
     * 载机俯仰
     */
    private String aircraftPitch;

    /**
     * 载机横滚
     */
    private String aircraftRoll;

    /**
     * 载机攻角
     */
    private String aircraftAngleOfAttack;

    /**
     * 载机北速
     */
    private String aircraftNorthSpeed;

    /**
     * 载机天速
     */
    private String aircraftVerticalSpeed;

    /**
     * 载机东速
     */
    private String aircraftEastSpeed;

    /**
     * 北向风速
     */
    private String northWindSpeed;

    /**
     * 天向风速
     */
    private String verticalWindSpeed;

    /**
     * 东向风速
     */
    private String eastWindSpeed;

    /**
     * 目标经度
     */
    private String targetLongitude;

    /**
     * 目标纬度
     */
    private String targetLatitude;

    /**
     * 目标高度
     */
    private String targetAltitude;

    /**
     * 目标距离
     */
    private String targetDistance;

    /**
     * 导引头号
     */
    private String seekerHeadNumber;

    /**
     * 目标经纬高有效标识
     */
    private String targetCoordinateValidity;

    /**
     * 目标方位俯仰有效标识
     */
    private String targetAzimuthElevationValidity;

    /**
     * 目标俯仰角(惯性侧滑角)
     */
    private String targetElevationAngle;

    /**
     * 目标方位角(真空速)
     */
    private String targetAzimuthAngle;

    /**
     * 落角有效性
     */
    private String impactAngleValidity;

    /**
     * 进入角
     */
    private String entryAngle;

    /**
     * 落角
     */
    private String impactAngle;

    /**
     * 方向有效性
     */
    private String directionValidity;
}
