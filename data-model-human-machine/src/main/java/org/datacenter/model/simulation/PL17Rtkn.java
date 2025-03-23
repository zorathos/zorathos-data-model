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
public class PL17Rtkn {

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
     * 武器类型
     */
    private String weaponType;

    /**
     * 目标ID
     */
    private String targetId;

    /**
     * 目标机实虚属性
     */
    private String targetRealOrVirtual;

    /**
     * 命中结果
     */
    private String hitResult;

    /**
     * 未命中原因
     */
    private String missReason;

    /**
     * 脱靶量
     */
    private String missDistance;

    /**
     * 匹配失败原因
     */
    private String matchingFailureReason;

    /**
     * 干扰是否有效
     */
    private String jammingEffective;

    /**
     * 干扰
     */
    private String jamming;

    /**
     * 加力
     */
    private String afterburner;

    /**
     * 迎头
     */
    private String headOn;

    /**
     * 航向
     */
    private String heading;

    /**
     * 俯仰
     */
    private String pitch;
}
