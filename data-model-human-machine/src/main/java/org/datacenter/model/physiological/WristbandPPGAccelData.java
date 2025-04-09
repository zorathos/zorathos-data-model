package org.datacenter.model.physiological;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : [ning]
 * @description : Tshirt的PPG数据
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WristbandPPGAccelData {
    /**
     * 我们自己加的主键 auto_increment bigint
     */
    private Long id;

    /**
     * 架次号 关联
     */
    private String sortieNumber;

    /**
     * 采集用传感器Id
     */
    private String sensorId;

    /**
     * 采样时间
     */
    private Long sampleTimestamp;

    /**
     * 腕部加速度X轴(从6字节加速度数据中转换得到)
     */
    private Double accel_x;

    /**
     * 腕部加速度Y轴(从6字节加速度数据中转换得到)
     */
    private Double accel_y;

    /**
     * 腕部加速度Z轴(从6字节加速度数据中转换得到)
     */
    private Double accel_z;

    /**
     *红光PPG通道1数据，存储五个采样点（JSON数组格式）
     */
    private String ppg_red1;

    /**
     * 红光PPG通道2数据，存储五个采样点（JSON数组格式）
     */
    private String ppg_red2;

    /**
     * 红光PPG通道3数据，存储五个采样点（JSON数组格式）
     */
    private String ppg_red3;

    /**
     * 红光PPG通道4数据，存储五个采样点（JSON数组格式）
     */
    private String ppg_red4;

    /**
     * 红外PPG通道1数据，存储五个采样点（JSON数组格式）
     */
    private String ppg_infrared1;

    /**
     * 红外PPG通道2数据，存储五个采样点（JSON数组格式）
     */
    private String ppg_infrared2;

    /**
     * 红外PPG通道3数据，存储五个采样点（JSON数组格式）
     */
    private String ppg_infrared3;

    /**
     * 红外PPG通道4数据，存储五个采样点（JSON数组格式）
     */
    private String ppg_infrared4;
}
