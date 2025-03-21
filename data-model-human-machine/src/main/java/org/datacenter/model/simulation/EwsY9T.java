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
@JsonPropertyOrder({"飞机ID", "消息时间", "卫导时间", "本地时间", "消息序列号", "干扰方位角", "干扰频点数量", "干扰类型", "干扰波段", "干扰方向", "干扰状态", "干扰俯仰角", "干扰开始频率", "干扰终止频率"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class EwsY9T {

    /**
     * 主键 auto-incrementing ID
     */
    private Long id;

    /**
     * 架次号 分区键
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

    @JsonProperty(value = "干扰方位角")
    private String jammingAzimuth;

    @JsonProperty(value = "干扰频点数量")
    private String jammingFrequencyCount;

    @JsonProperty(value = "干扰类型")
    private String jammingType;

    @JsonProperty(value = "干扰波段")
    private String jammingBand;

    @JsonProperty(value = "干扰方向")
    private String jammingDirection;

    @JsonProperty(value = "干扰状态")
    private String jammingStatus;

    @JsonProperty(value = "干扰俯仰角")
    private String jammingElevation;

    @JsonProperty(value = "干扰开始频率")
    private String jammingStartFrequency;

    @JsonProperty(value = "干扰终止频率")
    private String jammingEndFrequency;
}
