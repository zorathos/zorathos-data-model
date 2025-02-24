package edu.npu.model.aggregation;

import edu.npu.model.aggregation.aircraft.Aircraft;
import lombok.Builder;
import lombok.Data;

/**
 * @author : wangminan
 * @description : 对目标的补充描述
 */
@Data
@Builder
public class ObjectStatusExtra {
    private Aircraft aircraft;
    private Manipulator manipulator;
}
