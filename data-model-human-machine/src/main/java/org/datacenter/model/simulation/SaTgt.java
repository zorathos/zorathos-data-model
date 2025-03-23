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
public class SaTgt {

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
     * 装备类型
     */
    private String equipmentType;

    /**
     * 装备编号
     */
    private String equipmentNumber;

    /**
     * 目标方位角
     */
    private String targetAzimuth;

    /**
     * 目标俯仰角
     */
    private String targetElevation;

    /**
     * 目标斜距
     */
    private String targetSlantRange;

    /**
     * 通道号
     */
    private String channelNumber;

    /**
     * 目标批号
     */
    private String targetBatchNumber;
}
