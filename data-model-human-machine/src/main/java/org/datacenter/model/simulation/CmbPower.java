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
public class CmbPower {

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
     * 可用导弹数量
     */
    private String availableMissileCount;

    /**
     * 可用目标通道数量
     */
    private String availableTargetChannelCount;

    /**
     * 训练模式
     */
    private String trainingMode;

    /**
     * 允许重置导弹
     */
    private String allowMissileReset;

    /**
     * 自主复活
     */
    private String autoRespawn;
}
