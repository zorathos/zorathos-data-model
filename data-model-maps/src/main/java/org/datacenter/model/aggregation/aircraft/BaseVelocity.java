package org.datacenter.model.aggregation.aircraft;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author : [wangminan]
 * @description : Velocity基类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public abstract class BaseVelocity {
    private VelocityBase velocityBase;

    @Getter
    public enum VelocityBase {
        Ground,
        Sensor;

        public static VelocityBase fromString(String value) {
            for (VelocityBase velocityBase : VelocityBase.values()) {
                if (velocityBase.name().equalsIgnoreCase(value)) {
                    return velocityBase;
                }
            }
            return null;
        }
    }
}
