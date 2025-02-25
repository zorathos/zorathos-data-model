package org.datacenter.model.aggregation.sensor;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : [wangminan]
 * @description : 指向角
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class PointAnglePostureBase extends BaseSensorPosture {
    /**
     * 方位角 0~360 小数点后1位
     */
    private Double azimuth;
    /**
     * 俯仰角 -90~90 小数点后1位
     */
    private Double elevation;
    /**
     * 旋转角 -180~180 小数点后1位 逆时针正
     */
    private Double twist;
}
