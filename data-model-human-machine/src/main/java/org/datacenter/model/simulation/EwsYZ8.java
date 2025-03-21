package org.datacenter.model.simulation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@JsonPropertyOrder({"飞机ID", "消息时间", "卫导时间", "本地时间", "消息序列号", "工作状态", "全向探测Q1频段", "全向探测Q2频段", "精测向J1频段", "精测向J2频段", "精测向J3频段", "高增益G1频段", "高增益G2频段"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class EwsYZ8 {

    

    /**
     * 架次号
     */
    private String sortieNumber;

    @JsonProperty(value = "飞机ID")
    private String aircraftId;

    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    @JsonProperty(value = "消息时间")
    private LocalTime messageTime;

    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    @JsonProperty(value = "卫导时间")
    private LocalTime satelliteGuidanceTime;

    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    @JsonProperty(value = "本地时间")
    private LocalTime localTime;

    @JsonProperty(value = "消息序列号")
    private Long messageSequenceNumber;

    @JsonProperty(value = "工作状态")
    private String workingStatus;

    @JsonProperty(value = "全向探测Q1频段")
    private String omnidirectionalDetectionQ1;

    @JsonProperty(value = "全向探测Q2频段")
    private String omnidirectionalDetectionQ2;

    @JsonProperty(value = "精测向J1频段")
    private String preciseDirectionFindingJ1;

    @JsonProperty(value = "精测向J2频段")
    private String preciseDirectionFindingJ2;

    @JsonProperty(value = "精测向J3频段")
    private String preciseDirectionFindingJ3;

    @JsonProperty(value = "高增益G1频段")
    private String highGainG1;

    @JsonProperty(value = "高增益G2频段")
    private String highGainG2;
}
