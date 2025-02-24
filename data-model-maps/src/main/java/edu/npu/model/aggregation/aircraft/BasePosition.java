package edu.npu.model.aggregation.aircraft;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author : [wangminan]
 * @description : [一句话描述该类的功能]
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public abstract class BasePosition {
    private PositionBase positionBase;

    @Getter
    public enum PositionBase {
        Ground,
        Sensor;

        public static PositionBase fromString(String value) {
            for (PositionBase positionBase : PositionBase.values()) {
                if (positionBase.name().equalsIgnoreCase(value)) {
                    return positionBase;
                }
            }
            return null;
        }
    }
}
