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
public class Ews {

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
     * 左前干扰
     */
    private String leftFrontJamming;

    /**
     * 右前干扰
     */
    private String rightFrontJamming;

    /**
     * 左后干扰
     */
    private String leftRearJamming;

    /**
     * 右后干扰
     */
    private String rightRearJamming;

    /**
     * 吊舱前向干扰
     */
    private String podForwardJamming;

    /**
     * 吊舱后向干扰
     */
    private String podRearwardJamming;
}
