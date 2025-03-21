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
@JsonPropertyOrder({"批次号", "设备号", "航管号", "本地时间", "消息时间", "消息序列号", "经度", "纬度", "高度", "地速", "垂直速度", "航向"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class HJPlaneData {


    /**
     * 架次号
     */
    private String sortieNumber;

    @JsonProperty(value = "批次号")
    private String batchNumber;

    @JsonProperty(value = "设备号")
    private String deviceNumber;

    @JsonProperty(value = "航管号")
    private String flightControlNumber;

    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    @JsonProperty(value = "本地时间")
    private LocalTime localTime;

    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    @JsonProperty(value = "消息时间")
    private LocalTime messageTime;

    @JsonProperty(value = "消息序列号")
    private Long messageSequenceNumber;

    @JsonProperty(value = "经度")
    private String longitude;

    @JsonProperty(value = "纬度")
    private String latitude;

    @JsonProperty(value = "高度")
    private String altitude;

    @JsonProperty(value = "地速")
    private String groundSpeed;

    @JsonProperty(value = "垂直速度")
    private String verticalSpeed;

    @JsonProperty(value = "航向")
    private String heading;
}
