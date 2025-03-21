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
     * 主键 auto-incrementing ID
     */
    private Long id;

    /**
     * 架次号 分区键
     */
    private String sortieNumber;

    @JsonProperty(value = "批次号")
    private String batchNumber; // Or String, depending on format

    @JsonProperty(value = "设备号")
    private String deviceNumber; // Or String, depending on format

    @JsonProperty(value = "航管号")
    private String flightControlNumber; // Or String

    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    @JsonProperty(value = "本地时间")
    private LocalTime localTime;

    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    @JsonProperty(value = "消息时间")
    private LocalTime messageTime;

    @JsonProperty(value = "消息序列号")
    private Long messageSequenceNumber;

    @JsonProperty(value = "经度")
    private String Longitude;

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
