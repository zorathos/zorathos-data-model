/**
 * Copyright 2025 bejson.com
 */
package edu.npu.model.aggregation.aircraft;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 通过传感器获取的位置与精度
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class SensorVelocity extends BaseVelocity {
    /**
     * 径向速度
     * 感知设备对飞行物探测分析得到的，在跟踪采样时刻，从感知设备到飞行物的直线(径向线)方向的飞行速度，远离感知设备为正值，靠近感知设备为负值;
     * -1000~1000 精确到小数点后1位 米/秒
     */
    private Double radialVelocity;
    /**
     * 径向速度的标准差
     * 0-100 精确到小数点后2位 米/秒
     */
    private Double deltaRadialVelocity;

    public SensorVelocity() {
        super(VelocityBase.Sensor);
    }

    public SensorVelocity(Double radialVelocity, Double deltaRadialVelocity) {
        super(VelocityBase.Sensor);
        this.radialVelocity = radialVelocity;
        this.deltaRadialVelocity = deltaRadialVelocity;
    }
}
