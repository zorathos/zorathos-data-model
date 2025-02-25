package org.datacenter.model.aggregation.aircraft;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author : [wangminan]
 * @description : 位置基类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public abstract class BasePosition {
    private PositionBase positionBase;

    @Getter
    public enum PositionBase {
        /**
         * 基于地面
         */
        Ground,
        /**
         * 基于传感器
         */
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
