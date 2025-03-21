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
@JsonPropertyOrder({"飞机ID", "消息时间", "卫导时间", "本地时间", "消息序列号", "真攻角", "马赫数", "法向过载", "表速(km/h)", "场高", "无线电高度", "余油量", "场景", "手动复活", "参数设置状态", "加密状态"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaneState {

    /**
     * 主键 auto-incrementing ID
     */
    private Long id;

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

    @JsonProperty(value = "真攻角")
    private String trueAngleOfAttack;

    @JsonProperty(value = "马赫数")
    private String machNumber;

    @JsonProperty(value = "法向过载")
    private String normalLoadFactor;

    @JsonProperty(value = "表速(km/h)")
    private String indicatedAirspeed; // km/h

    @JsonProperty(value = "场高")
    private String fieldElevation;

    @JsonProperty(value = "无线电高度")
    private String radioAltitude;

    @JsonProperty(value = "余油量")
    private String remainingFuel;

    @JsonProperty(value = "场景")
    private String scenario;

    @JsonProperty(value = "手动复活")
    private String manualRespawn;

    @JsonProperty(value = "参数设置状态")
    private String parameterSettingStatus;

    @JsonProperty(value = "加密状态")
    private String encryptionStatus;
}
