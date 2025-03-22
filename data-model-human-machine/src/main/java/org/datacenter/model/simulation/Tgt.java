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
@Builder
@AllArgsConstructor
@JsonPropertyOrder({"aircraftId", "messageTime", "satelliteGuidanceTime", "localTime", "messageSequenceNumber", "targetCount", "identifier1", "sensor1", "pitch1", "azimuth1", "slantRange1", "identifier2", "sensor2", "pitch2", "azimuth2", "slantRange2", "identifier3", "sensor3", "pitch3", "azimuth3", "slantRange3", "identifier4", "sensor4", "pitch4", "azimuth4", "slantRange4", "identifier5", "sensor5", "pitch5", "azimuth5", "slantRange5", "identifier6", "sensor6", "pitch6", "azimuth6", "slantRange6", "identifier7", "sensor7", "pitch7", "azimuth7", "slantRange7", "identifier8", "sensor8", "pitch8", "azimuth8", "slantRange8"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tgt {

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
     * 目标数量
     */
    private String targetCount;

    /**
     * 标识1
     */
    private String identifier1;

    /**
     * 传感器1
     */
    private String sensor1;

    /**
     * 俯仰1
     */
    private String pitch1;

    /**
     * 方位1
     */
    private String azimuth1;

    /**
     * 斜距1
     */
    private String slantRange1;

    /**
     * 标识2
     */
    private String identifier2;

    /**
     * 传感器2
     */
    private String sensor2;

    /**
     * 俯仰2
     */
    private String pitch2;

    /**
     * 方位2
     */
    private String azimuth2;

    /**
     * 斜距2
     */
    private String slantRange2;

    /**
     * 标识3
     */
    private String identifier3;

    /**
     * 传感器3
     */
    private String sensor3;

    /**
     * 俯仰3
     */
    private String pitch3;

    /**
     * 方位3
     */
    private String azimuth3;

    /**
     * 斜距3
     */
    private String slantRange3;

    /**
     * 标识4
     */
    private String identifier4;

    /**
     * 传感器4
     */
    private String sensor4;

    /**
     * 俯仰4
     */
    private String pitch4;

    /**
     * 方位4
     */
    private String azimuth4;

    /**
     * 斜距4
     */
    private String slantRange4;

    /**
     * 标识5
     */
    private String identifier5;

    /**
     * 传感器5
     */
    private String sensor5;

    /**
     * 俯仰5
     */
    private String pitch5;

    /**
     * 方位5
     */
    private String azimuth5;

    /**
     * 斜距5
     */
    private String slantRange5;

    /**
     * 标识6
     */
    private String identifier6;

    /**
     * 传感器6
     */
    private String sensor6;

    /**
     * 俯仰6
     */
    private String pitch6;

    /**
     * 方位6
     */
    private String azimuth6;

    /**
     * 斜距6
     */
    private String slantRange6;

    /**
     * 标识7
     */
    private String identifier7;

    /**
     * 传感器7
     */
    private String sensor7;

    /**
     * 俯仰7
     */
    private String pitch7;

    /**
     * 方位7
     */
    private String azimuth7;

    /**
     * 斜距7
     */
    private String slantRange7;

    /**
     * 标识8
     */
    private String identifier8;

    /**
     * 传感器8
     */
    private String sensor8;

    /**
     * 俯仰8
     */
    private String pitch8;

    /**
     * 方位8
     */
    private String azimuth8;

    /**
     * 斜距8
     */
    private String slantRange8;
}
