package org.datacenter.model.simulation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * RTKN Data Record
 * Represents the data recorded from the RTKN system.
 * Each field corresponds to a specific parameter from the RTKN data.
 *
 * @author wangminan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rtkn {

    /**
     * 主键，自增ID
     */
    private Long id;

    /**
     * 目标虚实属性：无效、实体、模拟器、虚拟，范围0~4
     */
    private Short targetType;

    /**
     * 表示武器的唯一标识，范围0~4
     */
    private Short weaponId;

    /**
     * 武器类型，如空空武器、空面武器等，范围0~255
     */
    private Short weaponType;

    /**
     * 未命中原因，如无效武器飞行时间到、武器飞行速度过小、雷达弹装订数据无效、海拔小于0、海拔大于极值，范围0~12
     */
    private Short missedReason;

    /**
     * 匹配失败的内部原因，范围0~6
     */
    private Short matchFailReason;

    /**
     * 脱靶距离（米），范围0~4094、分辨率0.5米
     */
    private Float missDistance;

    /**
     * 命中状态：未命中(0)、命中(1)
     */
    private Short hitResult;

    /**
     * 保留字段
     */
    private Integer reserved;
}
