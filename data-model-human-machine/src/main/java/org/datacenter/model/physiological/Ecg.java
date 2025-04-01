package org.datacenter.model.physiological;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : [wangminan]
 * @description : 心电数据
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ecg {

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
     * 心电（ECG）
     */
    private double ecg;

    /**
     * 心率（T_HR)
     */
    private Integer heartRate;

    /**
     * 心率变异率(T_HRV)
     */
    private double heartRateVariability;

    /**
     * 呼吸率(Resp)
     */
    private double respirationRate;

    /**
     * 体温（T)
     */
    private float temperature;

    /**
     * 血氧饱和度(T_SpO2）
     */
    private Integer bloodOxygenSaturation;
}
