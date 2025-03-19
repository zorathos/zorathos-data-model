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
@JsonPropertyOrder({"飞机ID", "消息时间", "卫导时间", "本地时间", "消息序列号", "武器ID", "挂架ID", "武器类型", "目标ID", "经度", "纬度", "高度", "弹目距离", "弹速度(m/s)", "截获状态", "未截获原因", "导引头视线方位角", "导引头视线俯仰角", "目标TSPI状态", "指令机状态", "擦地角满足标志", "过零标志", "距离截获标志", "速度截获标志", "角度截获标志"})
public class pl17traj {

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

    @JsonProperty(value = "挂架ID")
    private String pylonId;

    @JsonProperty(value = "武器类型")
    private String weaponType;

    @JsonProperty(value = "目标ID")
    private String targetId;

    @JsonProperty(value = "经度")
    private double longitude;

    @JsonProperty(value = "纬度")
    private double latitude;

    @JsonProperty(value = "高度")
    private double altitude;

    @JsonProperty(value = "弹目距离")
    private double missileTargetDistance;

    @JsonProperty(value = "弹速度(m/s)")
    private double missileSpeed;

    @JsonProperty(value = "截获状态")
    private String interceptionStatus; // Or boolean intercepted;

    @JsonProperty(value = "未截获原因")
    private String nonInterceptionReason; // Consider an enum

    @JsonProperty(value = "导引头视线方位角")
    private double seekerAzimuth;

    @JsonProperty(value = "导引头视线俯仰角")
    private double seekerElevation;

    @JsonProperty(value = "目标TSPI状态")
    private String targetTspiStatus;  // Consider an enum

    @JsonProperty(value = "指令机状态")
    private String commandMachineStatus; // Consider an enum

    @JsonProperty(value = "擦地角满足标志")
    private Boolean groundAngleSatisfactionFlag;

    @JsonProperty(value = "过零标志")
    private Boolean zeroCrossingFlag;

    @JsonProperty(value = "距离截获标志")
    private Boolean distanceInterceptionFlag;

    @JsonProperty(value = "速度截获标志")
    private Boolean speedInterceptionFlag;

    @JsonProperty(value = "角度截获标志")
    private Boolean angleInterceptionFlag;
}