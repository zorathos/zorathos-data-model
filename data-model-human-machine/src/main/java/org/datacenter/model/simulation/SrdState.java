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
@JsonPropertyOrder({"groundDefenseId", "messageTime", "satelliteGuidanceTime", "localTime", "messageSequenceNumber", "campType", "equipmentType", "equipmentNumber", "powerOn", "emitterFrequencyBand", "decoyBlinkPeriod", "antennaPointing"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class SrdState {

    /**
     * 架次号
     */
    private String sortieNumber;

    /**
     * 地防ID
     */
    private String groundDefenseId;

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
     * 营地类型
     */
    private String campType;

    /**
     * 装备类型
     */
    private String equipmentType;

    /**
     * 装备编号
     */
    private String equipmentNumber;

    /**
     * 是否开机
     */
    private String powerOn;

    /**
     * 辐射源频段
     */
    private String emitterFrequencyBand;

    /**
     * 诱饵闪烁周期
     */
    private String decoyBlinkPeriod;

    /**
     * 天线指向
     */
    private String antennaPointing;
}
