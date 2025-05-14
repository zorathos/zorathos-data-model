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
public class EwsKJ500 {

    /**
     * 导入ID
     */
    private long importId;
    /**
     * 批次号
     */
    private String batchNumber;

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
     * 方位起始角
     */
    private String azimuthStartAngle;

    /**
     * 扇区相对基准
     */
    private String sectorReference; // Could be an enum

    /**
     * 扇区类型
     */
    private String sectorType; // Could be an enum

    /**
     * 扇区号
     */
    private String sectorNumber;

    /**
     * 动作代码
     */
    private String actionCode; // Could be an enum

    /**
     * 范围终止角
     */
    private String azimuthEndAngle;
}
