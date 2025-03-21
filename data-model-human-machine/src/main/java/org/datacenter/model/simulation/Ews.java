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
@JsonPropertyOrder({"飞机ID", "消息时间", "卫导时间", "本地时间", "消息序列号", "左前干扰", "右前干扰", "左后干扰", "右后干扰", "吊舱前向干扰", "吊舱后向干扰"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ews {

    

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

    @JsonProperty(value = "左前干扰")
    private String leftFrontJamming;

    @JsonProperty(value = "右前干扰")
    private String rightFrontJamming;

    @JsonProperty(value = "左后干扰")
    private String leftRearJamming;

    @JsonProperty(value = "右后干扰")
    private String rightRearJamming;

    @JsonProperty(value = "吊舱前向干扰")
    private String podForwardJamming;

    @JsonProperty(value = "吊舱后向干扰")
    private String podRearwardJamming;
}
