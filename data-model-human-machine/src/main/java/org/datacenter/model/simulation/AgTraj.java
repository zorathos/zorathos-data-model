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
@JsonPropertyOrder({"飞机ID", "消息时间", "卫导时间", "本地时间", "消息序列号", "武器ID", "武器类型", "经度", "纬度", "高度", "航向", "俯仰", "北速", "天速", "东速", "导引头号", "截获标志", "终止标志", "截获成员ID", "截获装备ID", "截获装备类型", "发射方ID", "导引头方位中心", "导引头俯仰中心", "目标ID", "弹目距离"})
public class AgTraj {

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
    private LocalTime satelliteGuidanceTime;

    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    @JsonProperty(value = "本地时间")
    private LocalTime localTime;

    @JsonProperty(value = "消息序列号")
    private Long messageSequenceNumber;

    @JsonProperty(value = "武器ID")
    private String weaponId;

    @JsonProperty(value = "武器类型")
    private String weaponType;

    @JsonProperty(value = "经度")
    private Double Longitude;

    @JsonProperty(value = "纬度")
    private Double latitude;

    @JsonProperty(value = "高度")
    private Double altitude;

    @JsonProperty(value = "航向")
    private Double heading;

    @JsonProperty(value = "俯仰")
    private Double pitch;

    @JsonProperty(value = "北速")
    private Double northSpeed;

    @JsonProperty(value = "天速")
    private Double skySpeed;

    @JsonProperty(value = "东速")
    private Double eastSpeed;

    @JsonProperty(value = "导引头号")
    private String seekerId;

    @JsonProperty(value = "截获标志")
    private String interceptionFlag;

    @JsonProperty(value = "终止标志")
    private String terminationFlag;

    @JsonProperty(value = "截获成员ID")
    private String interceptingMemberId;

    @JsonProperty(value = "截获装备ID")
    private String interceptingEquipmentId;

    @JsonProperty(value = "截获装备类型")
    private String interceptingEquipmentType;

    @JsonProperty(value = "发射方ID")
    private String launcherId;

    @JsonProperty(value = "导引头方位中心")
    private Double seekerAzimuthCenter;

    @JsonProperty(value = "导引头俯仰中心")
    private Double seekerPitchCenter;

    @JsonProperty(value = "目标ID")
    private String targetId;

    @JsonProperty(value = "弹目距离")
    private Double missileTargetDistance;

}
