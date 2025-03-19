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
@JsonPropertyOrder({"飞机ID", "消息时间", "卫导时间", "本地时间", "消息序列号", "武器ID", "武器挂架ID", "武器类型", "投放弹数", "载机地速", "载机经度", "载机纬度", "载机高度", "载机航向", "载机俯仰", "载机横滚", "载机攻角", "载机北速", "载机天速", "载机东速", "北向风速", "天向风速", "东向风速", "目标经度", "目标纬度", "目标高度", "目标距离", "导引头号", "目标经纬高有效标识", "目标方位俯仰有效标识", "目标俯仰角(惯性侧滑角)", "目标方位角(真空速)", "落角有效性", "进入角", "落角", "方向有效性"})
public class AgRtsn {
    /**
     * 主键 auto-incrementing ID
     */
    private Long id;

    @JsonProperty(value = "飞机ID")
    private String aircraftId;

    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    @JsonProperty(value = "消息时间")
    private LocalTime messageTime;

    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    @JsonProperty(value = "卫导时间")
    private LocalTime guidanceTime;

    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    @JsonProperty(value = "本地时间")
    private LocalTime localTime;

    @JsonProperty(value = "消息序列号")
    private Long messageSequenceNumber;

    @JsonProperty(value = "武器ID")
    private String weaponId;

    @JsonProperty(value = "武器挂架ID")
    private String weaponPylonId;

    @JsonProperty(value = "武器类型")
    private String weaponType;

    @JsonProperty(value = "投放弹数")
    private Integer numberOfMissilesReleased;

    @JsonProperty(value = "载机地速")
    private Double aircraftGroundSpeed;

    @JsonProperty(value = "载机经度")
    private Double aircraftLongitude;

    @JsonProperty(value = "载机纬度")
    private Double aircraftLatitude;

    @JsonProperty(value = "载机高度")
    private Double aircraftAltitude;

    @JsonProperty(value = "载机航向")
    private Double aircraftHeading;

    @JsonProperty(value = "载机俯仰")
    private Double aircraftPitch;

    @JsonProperty(value = "载机横滚")
    private Double aircraftRoll;

    @JsonProperty(value = "载机攻角")
    private Double aircraftAngleOfAttack;

    @JsonProperty(value = "载机北速")
    private Double aircraftNorthSpeed;

    @JsonProperty(value = "载机天速")
    private Double aircraftVerticalSpeed;

    @JsonProperty(value = "载机东速")
    private Double aircraftEastSpeed;

    @JsonProperty(value = "北向风速")
    private Double northWindSpeed;

    @JsonProperty(value = "天向风速")
    private Double verticalWindSpeed;

    @JsonProperty(value = "东向风速")
    private Double eastWindSpeed;

    @JsonProperty(value = "目标经度")
    private Double targetLongitude;

    @JsonProperty(value = "目标纬度")
    private Double targetLatitude;

    @JsonProperty(value = "目标高度")
    private Double targetAltitude;

    @JsonProperty(value = "目标距离")
    private Double targetDistance;

    @JsonProperty(value = "导引头号")
    private Integer seekerHeadNumber;

    @JsonProperty(value = "目标经纬高有效标识")
    private String targetCoordinateValidity;

    @JsonProperty(value = "目标方位俯仰有效标识")
    private String targetAzimuthElevationValidity;

    @JsonProperty(value = "目标俯仰角(惯性侧滑角)")
    private Double targetElevationAngle;

    @JsonProperty(value = "目标方位角(真空速)")
    private Double targetAzimuthAngle;

    @JsonProperty(value = "落角有效性")
    private String impactAngleValidity;

    @JsonProperty(value = "进入角")
    private Double entryAngle;

    @JsonProperty(value = "落角")
    private Double impactAngle;

    @JsonProperty(value = "方向有效性")
    private String directionValidity;
}
