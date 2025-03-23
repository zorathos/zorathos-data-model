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
public class CdDronePlaneState {

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
     * 真攻角
     */
    private String trueAngleOfAttack;

    /**
     * 马赫数
     */
    private String machNumber;

    /**
     * 法向过载
     */
    private String normalLoadFactor;

    /**
     * 表速(km/h)
     */
    private String indicatedAirspeed;

    /**
     * 场高
     */
    private String fieldElevation;

    /**
     * 无线电高度
     */
    private String radioAltitude;

    /**
     * 余油量
     */
    private String remainingFuel;

    /**
     * 手动复活
     */
    private String manualRespawn;

    /**
     * 参数设置状态
     */
    private String parameterSettingStatus;
}
