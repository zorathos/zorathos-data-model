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
public class Tspi {

    /**
     * 架次号
     */
    private String sortieNumber;

    /**
     * 飞机ID
     */
    private String aircraftId;

    /**
     * 飞机类型
     */
    private String aircraftType;

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
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 气压高度
     */
    private String pressureAltitude;

    /**
     * 横滚
     */
    private String roll;

    /**
     * 俯仰
     */
    private String pitch;

    /**
     * 航向
     */
    private String heading;

    /**
     * 卫星高度
     */
    private String satelliteAltitude;

    /**
     * 训练状态
     */
    private String trainingStatus;

    /**
     * 干扰弹
     */
    private String chaff;

    /**
     * 加力
     */
    private String afterburner;

    /**
     * 北向速度
     */
    private String northVelocity;

    /**
     * 天向速度
     */
    private String verticalVelocity;

    /**
     * 东向速度
     */
    private String eastVelocity;
}
