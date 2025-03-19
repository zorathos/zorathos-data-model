package org.datacenter.model.aggregation.aircraft;

import lombok.Builder;
import lombok.Data;

/**
 * @author wangminan
 * @description 无人机操纵器信息
 */
@Data
@Builder
public class Manipulator {
    /**
     * 无人机操作器经度
     */
    private Double Longitude;
    /**
     * 无人机操作器纬度
     */
    private Double latitude;
}
