package org.datacenter.model.aggregation.sensor;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : [wangminan]
 * @description : 激光雷达或智能摄像头的额外信息
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class LiDARorSmartCamExtra extends BaseSensorPosture {
    /**
     * 说明:以感知设备自身为原点，探测视野中心视线为极轴，在相对感知设备的水平方向极坐标系下，探测边缘视线距离极轴最小夹角，以极轴逆时针方向为正;
     * 格式:浮点型数字，精确到小数点后1位，取值范围[-180,180];单位:度。
     */
    private Double horizontalFOVMin;
    /**
     * 说明:以感知设备自身为原点，探测视野中心视线为极轴，在相对感知设备的水平方向极坐标系下，探测边缘视线距离极轴最大夹角，以极轴逆时针方向为正;
     * 格式:浮点型数字，精确到小数点后1位，取值范围[-180,180];单位:度。
     */
    private Double horizontalFOVMax;
    /**
     * 说明:以感知设备自身为原点，探测视野中心视线为极轴，在相对感知设备的垂直方向极坐标系下，探测边缘视线距离极轴最小夹角，以极轴逆时针方向为正;
     * 格式:浮点型数字，精确到小数点后1位，取值范围[-90,90];单位:度。
     */
    private Double verticalFOVMin;
    /**
     * 说明:以感知设备自身为原点，探测视野中心视线为极轴，在相对感知设备的垂直方向极坐标系下，探测边缘视线距离极轴最大夹角，以极轴逆时针方向为正;
     * 格式:浮点型数字，精确到小数点后1位，取值范围[-90,90];单位:度。
     */
    private Double verticalFOVMax;
    /**
     * 说明:最大可探测范围，即以感知设备自身为原点，探测视线所能有效触达的最远距离;
     * 格式:浮点型数字，精确到小数点后2位，取值范围(0,10000);单位:米。
     */
    private Double perceivedRange;
}
