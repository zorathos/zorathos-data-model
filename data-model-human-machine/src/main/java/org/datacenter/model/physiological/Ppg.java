package org.datacenter.model.physiological;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : [wangminan]
 * @description : 血氧
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ppg {
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
     * 采样的unix时间戳
     */
    private Long timestamp;

    /**
     * 血氧饱和度(B_SpO2）
     */
    private Integer bloodOxygenSaturation;

    /**
     * 绿光（PPG）
     */
    private double ppg;

    /**
     * 心率(B_HR)
     */
    private Integer heartRate;

    /**
     * 心率变异率(B_HRV)
     */
    private double heartRateVariability;

    /**
     * 皮电（GSR）
     */
    private double gsr;

    /**
     * 肤温（ST）
     */
    private float skinTemperature;

    /**
     * 皮电加速度（A - GSR）
     */
    private double gsrAcceleration;
}
