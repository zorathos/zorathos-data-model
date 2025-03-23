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
public class EwsY9T {

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
     * 干扰方位角
     */
    private String jammingAzimuth;

    /**
     * 干扰频点数量
     */
    private String jammingFrequencyCount;

    /**
     * 干扰类型
     */
    private String jammingType;

    /**
     * 干扰波段
     */
    private String jammingBand;

    /**
     * 干扰方向
     */
    private String jammingDirection;

    /**
     * 干扰状态
     */
    private String jammingStatus;

    /**
     * 干扰俯仰角
     */
    private String jammingElevation;

    /**
     * 干扰开始频率
     */
    private String jammingStartFrequency;

    /**
     * 干扰终止频率
     */
    private String jammingEndFrequency;
}
