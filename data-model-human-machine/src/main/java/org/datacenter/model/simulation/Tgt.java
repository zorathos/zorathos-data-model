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
@Builder
@AllArgsConstructor
@JsonPropertyOrder({"飞机ID", "消息时间", "卫导时间", "本地时间", "消息序列号", "目标数量", "targets"})
// Simplified order
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tgt {

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

    @JsonProperty(value = "目标数量")
    private String targetCount;

    @JsonProperty(value = "标识1")
    private String identifier1;

    @JsonProperty(value = "传感器1")
    private String sensor1;

    @JsonProperty(value = "俯仰1")
    private String pitch1;

    @JsonProperty(value = "方位1")
    private String azimuth1;

    @JsonProperty(value = "斜距1")
    private String slantRange1;

    @JsonProperty(value = "标识2")
    private String identifier2;

    @JsonProperty(value = "传感器2")
    private String sensor2;

    @JsonProperty(value = "俯仰2")
    private String pitch2;

    @JsonProperty(value = "方位2")
    private String azimuth2;

    @JsonProperty(value = "斜距2")
    private String slantRange2;

    @JsonProperty(value = "标识3")
    private String identifier3;

    @JsonProperty(value = "传感器3")
    private String sensor3;

    @JsonProperty(value = "俯仰3")
    private String pitch3;

    @JsonProperty(value = "方位3")
    private String azimuth3;

    @JsonProperty(value = "斜距3")
    private String slantRange3;

    @JsonProperty(value = "标识4")
    private String identifier4;

    @JsonProperty(value = "传感器4")
    private String sensor4;

    @JsonProperty(value = "俯仰4")
    private String pitch4;

    @JsonProperty(value = "方位4")
    private String azimuth4;

    @JsonProperty(value = "斜距4")
    private String slantRange4;

    @JsonProperty(value = "标识5")
    private String identifier5;

    @JsonProperty(value = "传感器5")
    private String sensor5;

    @JsonProperty(value = "俯仰5")
    private String pitch5;

    @JsonProperty(value = "方位5")
    private String azimuth5;

    @JsonProperty(value = "斜距5")
    private String slantRange5;

    @JsonProperty(value = "标识6")
    private String identifier6;

    @JsonProperty(value = "传感器6")
    private String sensor6;

    @JsonProperty(value = "俯仰6")
    private String pitch6;

    @JsonProperty(value = "方位6")
    private String azimuth6;

    @JsonProperty(value = "斜距6")
    private String slantRange6;

    @JsonProperty(value = "标识7")
    private String identifier7;

    @JsonProperty(value = "传感器7")
    private String sensor7;

    @JsonProperty(value = "俯仰7")
    private String pitch7;

    @JsonProperty(value = "方位7")
    private String azimuth7;

    @JsonProperty(value = "斜距7")
    private String slantRange7;

    @JsonProperty(value = "标识8")
    private String identifier8;

    @JsonProperty(value = "传感器8")
    private String sensor8;

    @JsonProperty(value = "俯仰8")
    private String pitch8;

    @JsonProperty(value = "方位8")
    private String azimuth8;

    @JsonProperty(value = "斜距8")
    private String slantRange8;
}
