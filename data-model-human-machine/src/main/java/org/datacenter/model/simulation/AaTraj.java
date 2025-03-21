package org.datacenter.model.simulation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonPropertyOrder({"飞机ID", "消息时间", "卫导时间", "本地时间", "消息序列号", "武器ID", "挂架ID", "武器类型", "目标ID", "经度", "纬度", "高度", "弹目距离", "弹速度", "截获状态", "未截获原因", "导引头视线方位角", "导引头视线俯仰角", "目标TSPI状态", "指令机状态", "擦地角满足标志", "过零标志"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class AaTraj {


    /**
     * 架次号
     */
    private String sortieNumber;

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

    @JsonProperty(value = "挂架ID")
    private String pylonId;

    @JsonProperty(value = "武器类型")
    private String weaponType;

    @JsonProperty(value = "目标ID")
    private String targetId;

    @JsonProperty(value = "经度")
    private String longitude;

    @JsonProperty(value = "纬度")
    private String latitude;

    @JsonProperty(value = "高度")
    private String altitude;

    @JsonProperty(value = "弹目距离")
    private String missileTargetDistance;

    @JsonProperty(value = "弹速度")
    private String missileSpeed;

    @JsonProperty(value = "截获状态")
    private String interceptionStatus;

    @JsonProperty(value = "未截获原因")
    private String nonInterceptionReason;

    @JsonProperty(value = "导引头视线方位角")
    private String seekerAzimuth;

    @JsonProperty(value = "导引头视线俯仰角")
    private String seekerElevation;

    @JsonProperty(value = "目标TSPI状态")
    private String targetTspiStatus;

    @JsonProperty(value = "指令机状态")
    private String commandMachineStatus;

    @JsonProperty(value = "擦地角满足标志")
    private String groundAngleSatisfactionFlag;

    @JsonProperty(value = "过零标志")
    private String zeroCrossingFlag;
}
