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
@JsonPropertyOrder({"aircraftId", "messageTime", "satelliteGuidanceTime", "localTime", "messageSequenceNumber", "workingStatus", "omnidirectionalDetectionQ1", "omnidirectionalDetectionQ2", "preciseDirectionFindingJ1", "preciseDirectionFindingJ2", "preciseDirectionFindingJ3", "highGainG1", "highGainG2"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class EwsYZ8 {

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
     * 工作状态
     */
    private String workingStatus;

    /**
     * 全向探测Q1频段
     */
    private String omnidirectionalDetectionQ1;

    /**
     * 全向探测Q2频段
     */
    private String omnidirectionalDetectionQ2;

    /**
     * 精测向J1频段
     */
    private String preciseDirectionFindingJ1;

    /**
     * 精测向J2频段
     */
    private String preciseDirectionFindingJ2;

    /**
     * 精测向J3频段
     */
    private String preciseDirectionFindingJ3;

    /**
     * 高增益G1频段
     */
    private String highGainG1;

    /**
     * 高增益G2频段
     */
    private String highGainG2;
}
