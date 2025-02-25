package org.datacenter.model.aggregation.aircraft;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : wangminan
 * @description : 相对于Sensor的位置
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class SensorPosition extends BasePosition{

    /**
     * 0-10000 精确到小数点后两位 米
     */
    private Double range;
    /**
     * 以感知设备自身为原点，探测视野中心视线为极轴，在雷达自身水平面上，探测目材与极轴的夹角，逆时针方向增加;
     * [0,360) 精确到小数点后1位
     */
    private Double azimuth;
    /**
     * 以感知设备自身为原点，探测视野中心视线为极轴，在雷达自身垂直面上，探测目标与极轴的夹角，以逆时针方向为正;
     * -90~90 精确到小数点后1位
     */
    private Double elevation;
    /**
     * [0,100) 小数点后3位 米
     */
    private Double deltaRange;
    /**
     * [0,360) 小数点后1位
     */
    private Double deltaAzimuth;
    /**
     * -90~90 小数点后1位
     */
    private Double deltaElevation;

    public SensorPosition() {
        super(PositionBase.Sensor);
    }

    public SensorPosition(Double range, Double azimuth, Double elevation) {
        super(PositionBase.Sensor);
        this.range = range;
        this.azimuth = azimuth;
        this.elevation = elevation;
    }

    public SensorPosition(Double range, Double azimuth, Double elevation,
                          Double deltaRange, Double deltaAzimuth, Double deltaElevation) {
        super(PositionBase.Sensor);
        this.range = range;
        this.azimuth = azimuth;
        this.elevation = elevation;
        this.deltaRange = deltaRange;
        this.deltaAzimuth = deltaAzimuth;
        this.deltaElevation = deltaElevation;
    }
}
