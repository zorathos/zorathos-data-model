package org.datacenter.model.physiological.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author wangminan
 * @description 手环生理数据输入实体，继承 {@link PhysiologicalInputBase}。包含腕部加速度、PPG、血氧及皮肤电导等多通道数据。
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WristbandInput extends PhysiologicalInputBase {
    /**
     * 原名: SHOUHUAN_id
     * 手环设备ID
     */
    private Integer wristbandId;

    /**
     * 原名: accel_x
     * 腕部加速度X轴（从6字节加速度数据中转换得到）
     */
    private Double accelX;

    /**
     * 原名: accel_y
     * 腕部加速度Y轴（从6字节加速度数据中转换得到）
     */
    private Double accelY;

    /**
     * 原名: accel_z
     * 腕部加速度Z轴（从6字节加速度数据中转换得到）
     */
    private Double accelZ;

    /**
     * 原名: ppg_red1
     * 红光PPG通道1数据，存储5个采样点（JSON数组格式）
     */
    private String ppgRed1;

    /**
     * 原名: ppg_red2
     * 红光PPG通道2数据，存储5个采样点（JSON数组格式）
     */
    private String ppgRed2;

    /**
     * 原名: ppg_red3
     * 红光PPG通道3数据，存储5个采样点（JSON数组格式）
     */
    private String ppgRed3;

    /**
     * 原名: ppg_red4
     * 红光PPG通道4数据，存储5个采样点（JSON数组格式）
     */
    private String ppgRed4;

    /**
     * 原名: ppg_infrared1
     * 红外PPG通道1数据，存储5个采样点（JSON数组格式）
     */
    private String ppgInfrared1;

    /**
     * 原名: ppg_infrared2
     * 红外PPG通道2数据，存储5个采样点（JSON数组格式）
     */
    private String ppgInfrared2;

    /**
     * 原名: ppg_infrared3
     * 红外PPG通道3数据，存储5个采样点（JSON数组格式）
     */
    private String ppgInfrared3;

    /**
     * 原名: ppg_infrared4
     * 红外PPG通道4数据，存储5个采样点（JSON数组格式）
     */
    private String ppgInfrared4;

    /**
     * 原名: spo2
     * 血氧饱和度，范围为 0~100%
     */
    private Integer spo2;

    /**
     * 原名: gsr_data
     * 皮肤电导数据，采用JSON格式存储，存储10个采样点
     */
    private String gsrData;
}
