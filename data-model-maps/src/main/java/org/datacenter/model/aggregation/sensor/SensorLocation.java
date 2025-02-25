package org.datacenter.model.aggregation.sensor;

import lombok.Builder;
import lombok.Data;

/**
 * @author wangminan
 * @description 遥感设备安装位置 经纬高
 */
@Data
@Builder
public class SensorLocation {
    /**
     * 经度
     */
    private Double longitude;
    /**
     * 纬度
     */
    private Double latitude;
    /**
     * 高度
     */
    private Double height;

}
