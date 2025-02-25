package org.datacenter.model.aggregation;

import org.datacenter.model.aggregation.aircraft.Aircraft;
import lombok.Builder;
import lombok.Data;
import org.datacenter.model.aggregation.aircraft.Manipulator;

/**
 * @author : wangminan
 * @description : 对目标的补充描述
 */
@Data
@Builder
public class ObjectStatusExtra {
    /**
     * 无人机信息
     */
    private Aircraft aircraft;
    /**
     * 操纵器信息
     */
    private Manipulator manipulator;
}
