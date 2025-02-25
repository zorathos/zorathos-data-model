package org.datacenter.model.aggregation.sensor;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : [wangminan]
 * @description : 欧拉角姿态
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class EulerAnglePostureBase extends BaseSensorPosture {
    /**
     * 以感知设备固定点(一般同设备定位点)为原点
     * 以“北东地"为世界坐标系，以“右前上"为载体坐标系，感知设备绕世界X轴的旋转角度，顺时针旋转为正;
     * 格式:浮点型数字，精确到小数点后1位，取值范围[-180,180];单位:度。
     */
    private Double roll;
    /**
     * 说明:以感知设备固定点(一般同设备定位点)为原点，
     * 以"北东地"为世界坐标系，以“右前上"为载体坐标系，感知设备绕世界Y轴的旋转角度，顺时针旋转为正;
     * 格式:浮点型数字，精确到小数点后1位，取值范围[-90,90];单位:度。
     */
    private Double pitch;
    /**
     * 说明:以感知设备固定点(一般同设备定位点)为原点，
     * 以"北东地"为世界坐标系，以“右前上"为载体坐标系，感知设备绕世界Z轴的旋转角度，顺时针旋转为正;
     * 格式:浮点型数字，精确到小数点后1位，取值范围[-180,180];单位:度。
     */
    private Double yaw;
}
