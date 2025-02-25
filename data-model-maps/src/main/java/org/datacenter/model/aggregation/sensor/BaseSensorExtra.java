package org.datacenter.model.aggregation.sensor;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

/**
 * @author wangminan
 * @description : 传感器额外信息
 * 目前只有激光雷达和智能视觉摄像头除了SensorCategory还要新增其他字段
 */
@Data
@Builder
public class BaseSensorExtra {
    @Builder.Default
    private SensorCategory sensorCategory = SensorCategory.Radar;

    @Getter
    public enum SensorCategory {
        /**
         * 传统地面雷达
         */
        Radar,
        /**
         * 传统毫米波雷达
         */
        mmWaveRadar,
        /**
         * 4D高清传统毫米波雷达
         */
        @JsonProperty("4DmmWaveRadar")
        _4DmmWaveRadar,
        /**
         * 激光雷达
         */
        LiDAR,
        /**
         * 智能视觉摄像头
         */
        SmartCam,
        /**
         * 通感一体设施
         */
        @JsonProperty("5G-A")
        _5G_A,
        /**
         * 实时定位系统
         * 包括基于AOA(到达角度定位)以及TDOA到达时间差定位、TOA(到达时间)、TW-TOF(双向飞行时间)NFER(近场电磁测距)等技术的各类无线电定位系统;
         */
        RTLS,
        /**
         * Other:其他感知设备类型，如
         * UltraSound(超声波探测仪)Sattelite(声纳测量仪)等
         */
        Other;

        public static SensorCategory fromString(String value) {
            for (SensorCategory sensorCategory : SensorCategory.values()) {
                if (sensorCategory.name().equalsIgnoreCase(value)) {
                    return sensorCategory;
                }
            }
            return null;
        }
    }
}
