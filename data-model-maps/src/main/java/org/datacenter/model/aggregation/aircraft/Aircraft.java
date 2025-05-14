package org.datacenter.model.aggregation.aircraft;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

/**
 * @author : wangminan
 * @description : 用于补充信息 无人机具体信息
 */
@Data
@Builder
public class Aircraft {

    @Builder.Default
    private AircraftState aircraftState = AircraftState.NoRecord;
    @Builder.Default
    private AircraftType aircraftType = AircraftType.Other;
    @Builder.Default
    private AircraftCategory aircraftCategory = AircraftCategory.MicroUAV;
    private String aircraftName;
    private String aircraftModel;
    private String manufacturerName;
    private Double aircraftEmptyWeight;
    private Double aircraftEmptyWeightWithBattery;
    private Double actualPayloadWeight;
    private Double maxTakeoffWeight;
    @JsonAlias("SN")
    private String SN;

    /**
     * 无人机状态
     */
    @Getter
    public enum AircraftState {
        /**
         * 正常
         */
        Normal,
        /**
         * 注销
         */
        Deregister,
        /**
         * 无记录
         */
        NoRecord;

        public static AircraftState fromString(String value) {
            for (AircraftState aircraftState : AircraftState.values()) {
                if (aircraftState.name().equalsIgnoreCase(value)) {
                    return aircraftState;
                }
            }
            return null;
        }
    }

    /**
     * 无人机类型
     */
    @Getter
    public enum AircraftType {
        /**
         * 固定翼
         */
        FixedWingAircraft,
        /**
         * 旋翼航空器
         */
        Rotorcraft,
        /**
         * 多桨或多轴航空器
         */
        MultiRotorAircraft,
        /**
         * 复合翼航空器
         */
        CompoundWingAircraft,
        /**
         * 飞艇
         */
        Airship,
        /**
         * 其他
         */
        Other;

        public static AircraftType fromString(String value) {
            for (AircraftType aircraftType : AircraftType.values()) {
                if (aircraftType.name().equalsIgnoreCase(value)) {
                    return aircraftType;
                }
            }
            return null;
        }
    }

    /**
     * 无人机类别
     */
    @Getter
    public enum AircraftCategory {
        /**
         * 微型无人驾驶航空器
         */
        MicroUAV,
        /**
         * 轻型无人驾驶航空器
         */
        LightUAV,
        /**
         * 小型无人驾驶航空器
         */
        SmallUAV,
        /**
         * 中型无人驾驶航空器
         */
        MediumUAV,
        /**
         * 大型无人驾驶航空器
         */
        LargeUAV;

        public static AircraftCategory fromString(String value) {
            for (AircraftCategory aircraftCategory : AircraftCategory.values()) {
                if (aircraftCategory.name().equalsIgnoreCase(value)) {
                    return aircraftCategory;
                }
            }
            return null;
        }
    }
}
