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
@JsonPropertyOrder({"飞机ID", "消息时间", "卫导时间", "本地时间", "消息序列号", "X波段干扰俯仰", "C波段干扰俯仰", "C波段干扰方位", "S波段干扰俯仰", "S波段干扰方位", "L波段干扰俯仰", "L波段干扰方位", "U波段干扰方位", "干扰状态", "X波段干扰方位角"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class EwsY8G {

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

    @JsonProperty(value = "X波段干扰俯仰")
    private String xBandJammingElevation;

    @JsonProperty(value = "C波段干扰俯仰")
    private String cBandJammingElevation;

    @JsonProperty(value = "C波段干扰方位")
    private String cBandJammingAzimuth;

    @JsonProperty(value = "S波段干扰俯仰")
    private String sBandJammingElevation;

    @JsonProperty(value = "S波段干扰方位")
    private String sBandJammingAzimuth;

    @JsonProperty(value = "L波段干扰俯仰")
    private String lBandJammingElevation;

    @JsonProperty(value = "L波段干扰方位")
    private String lBandJammingAzimuth;

    @JsonProperty(value = "U波段干扰方位")
    private String uBandJammingAzimuth;

    @JsonProperty(value = "干扰状态")
    private String jammingStatus;

    @JsonProperty(value = "X波段干扰方位角")
    private String xBandJammingAzimuthAngle;
}
