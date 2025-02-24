package edu.npu.model.aggregation.aircraft;

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

    private Double range;
    private Double azimuth;
    private Double elevation;

    public SensorPosition() {
        super(PositionBase.Sensor);
    }

    public SensorPosition(Double range, Double azimuth, Double elevation) {
        super(PositionBase.Sensor);
        this.range = range;
        this.azimuth = azimuth;
        this.elevation = elevation;
    }
}
