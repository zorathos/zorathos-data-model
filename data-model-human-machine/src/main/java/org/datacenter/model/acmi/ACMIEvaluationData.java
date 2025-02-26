package org.datacenter.model.acmi;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * ACMI二期评估显示分系统记录数据类，表示ACMI记录的飞行数据
 * @author : [wangminan]
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ACMIEvaluationData {
    /**
     * 飞机号
     */
    private String aircraftNumber;

    /**
     * 机型
     */
    private String aircraftModel;

    /**
     * 任务名称
     */
    private String missionName;

    /**
     * 任务时间，格式为YYYY-MM-DD HH:MM
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private LocalDateTime missionTime;

    /**
     * 时刻，格式为HH:MM
     */
    private String time;

    /**
     * 横滚，单位为°
     */
    private Double roll;

    /**
     * 俯仰，单位为°
     */
    private Double pitch;

    /**
     * 航向，单位为°
     */
    private Double heading;

    /**
     * 北向速度，单位为m/s
     */
    private Double northwardSpeed;

    /**
     * 天向速度，单位为m/s
     */
    private Double upwardSpeed;

    /**
     * 东向速度，单位为m/s
     */
    private Double eastwardSpeed;

    /**
     * 法向过载，单位为G
     */
    private Double normalAcceleration;

    /**
     * 表速，单位为m/s（屏显显示为km/h）
     */
    private Double indicatedSpeed;

    /**
     * 截获状态，截获或未截获
     */
    private String interceptionStatus;

    /**
     * 未截获原因，未开机或被干扰
     */
    private String nonInterceptionReason;

    /**
     * 导引头视线方位角，单位为°
     */
    private Double seekerAzimuth;

    /**
     * 导引头视线俯仰角，单位为°
     */
    private Double seekerElevation;

    /**
     * 雷达工作模式
     */
    private RadarMode radarMode;

    /**
     * 枚举类：雷达工作模式
     */
    @Getter
    public enum RadarMode {
        /**
         * 表扫描边测距，包含SAM态势感知、TTS双目标态势感知
         */
        RWS,
        /**
         * 边扫描边跟踪
         */
        TWS,
        /**
         * 速度搜索带测距
         */
        VS_VSR,
        /**
         * 远距离搜索
         */
        LRS_ULS,
        /**
         * 聚光灯模式
         */
        SPOT_LIGHT;

        public static RadarMode fromString(String value) {
            for (RadarMode radarMode : RadarMode.values()) {
                if (radarMode.name().equalsIgnoreCase(value)) {
                    return radarMode;
                }
            }
            return null;
        }
    }
}
