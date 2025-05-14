package org.datacenter.model.simulation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class HJPlaneData {

    /**
     * 导入ID
     */
    private long importId;
    /**
     * 批次号
     */
    private String batchNumber;

    /**
     * 本地批次号
     */
    private String localBatchNumber;

    /**
     * 设备号
     */
    private String deviceNumber;

    /**
     * 航管号
     */
    private String flightControlNumber;

    /**
     * 本地时间
     */
    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    private LocalTime localTime;

    /**
     * 消息时间
     */
    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    private LocalTime messageTime;

    /**
     * 消息序列号
     */
    private Long messageSequenceNumber;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 高度
     */
    private String altitude;

    /**
     * 地速
     */
    private String groundSpeed;

    /**
     * 垂直速度
     */
    private String verticalSpeed;

    /**
     * 航向
     */
    private String heading;
}
