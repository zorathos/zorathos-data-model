package edu.npu.model;

import edu.npu.model.aircraft.Aircraft;
import lombok.Builder;
import lombok.Data;

/**
 * @author : [Lenovo]
 * @description : [一句话描述该类的功能]
 */
@Data
@Builder
public class ObjectStatusExtra {
    private Aircraft aircraft;

    private Manipulator  manipulator;
}
