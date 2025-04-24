package org.datacenter.model.physiological.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author wangminan
 * @description 多通道T恤生理数据输入实体，继承 {@link PhysiologicalInputBase}，包含T恤设备ECG、呼吸及温度等多通道数据。
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TShirtInput extends PhysiologicalInputBase {
    /**
     * T恤设备ID device_id
     */
    private Integer tShirtId;

    /**
     * T恤ECG通道1数据（一组十个采样点，JSON格式）
     */
    private String ecg1;

    /**
     * T恤ECG通道2数据（JSON格式）
     */
    private String ecg2;

    /**
     * T恤ECG通道3数据（JSON格式）
     */
    private String ecg3;

    /**
     * ECG计算得到的心率，单位：BPM（次/分钟）
     */
    private Integer heartRate;

    /**
     * ECG计算得到的心率变异性（HRV），JSON格式
     */
    private String hrv;

    /**
     * T恤呼吸带原始数据，存储50个采样点（JSON数组或字符串）
     */
    private String respData;

    /**
     * T恤计算得到的呼吸率，单位：次/分钟
     */
    private Double respiratoryRate;

    /**
     * T恤腋下体温（转换后的温度值，单位℃）
     */
    private Float temperature;
}
