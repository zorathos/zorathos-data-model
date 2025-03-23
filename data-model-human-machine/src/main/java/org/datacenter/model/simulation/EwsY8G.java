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
public class EwsY8G {

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
     * X波段干扰俯仰
     */
    private String xBandJammingElevation;

    /**
     * C波段干扰俯仰
     */
    private String cBandJammingElevation;

    /**
     * C波段干扰方位
     */
    private String cBandJammingAzimuth;

    /**
     * S波段干扰俯仰
     */
    private String sBandJammingElevation;

    /**
     * S波段干扰方位
     */
    private String sBandJammingAzimuth;

    /**
     * L波段干扰俯仰
     */
    private String lBandJammingElevation;

    /**
     * L波段干扰方位
     */
    private String lBandJammingAzimuth;

    /**
     * U波段干扰方位
     */
    private String uBandJammingAzimuth;

    /**
     * 干扰状态
     */
    private String jammingStatus;

    /**
     * X波段干扰方位角
     */
    private String xBandJammingAzimuthAngle;
}
