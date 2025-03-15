package org.datacenter.model.simulation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TGTData Data Record
 * Represents the target data recorded by the system.
 * Each field corresponds to a specific parameter from the TGTData data.
 *
 * @author wangminan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TgtData {

    /**
     * 主键，自增ID
     */
    private Long id;

    /**
     * 目标个数，范围 0~8
     */
    private Integer targetCount;

    /**
     * 目标1状态：
     * 正在制导（1），其他（0）
     */
    private Byte target1Status;

    /**
     * 目标1传感器类型：
     * 雷达（0），光雷（1），传感器融合（2），头瞄/头显（3）
     */
    private Byte target1Sensor;

    /**
     * 目标1方位角，单位：度，范围 -180~180（无效为其他值）
     */
    private Integer target1Azimuth;

    /**
     * 目标1俯仰角，单位：度，范围 -90~90（无效为其他值）
     */
    private Integer target1Elevation;

    /**
     * 目标1斜距，单位：米，范围 0~524284
     */
    private Integer target1SlantRange;

    /**
     * 保留字段，未具体说明
     */
    private Integer reserved;
}
