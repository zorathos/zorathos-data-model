package org.datacenter.model.simulation;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class HJPlaneData {

    private long id; // Optional: auto-incrementing ID

    @JsonProperty(value = "批次号")
    private String batchNumber; // Or int, depending on format

    @JsonProperty(value = "设备号")
    private String deviceNumber; // Or int, depending on format

    @JsonProperty(value = "航管号")
    private String flightControlNumber; // Or int

    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    @JsonProperty(value = "本地时间")
    private LocalTime localTime;

    // Handle potential formatting issues of "消息时间"
    @JsonProperty(value = "消息时间")
    private String messageTime;

    @JsonProperty(value = "消息序列号")
    private long messageSequenceNumber;

    @JsonProperty(value = "经度")
    private double longitude;

    @JsonProperty(value = "纬度")
    private double latitude;

    @JsonProperty(value = "高度")
    private double altitude;

    @JsonProperty(value = "地速")
    private double groundSpeed;

    @JsonProperty(value = "垂直速度")
    private double verticalSpeed;

    @JsonProperty(value = "航向")
    private double heading;
}