package org.datacenter.model.simulation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Tspi Data Record
 * Represents the data recorded from an aircraft's flight system.
 * Each field corresponds to a specific parameter from the flight data.
 *
 * @author wangminan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tspi {

    /**
     * 主键，自增ID
     */
    private Long id;

    /**
     * 数据记录时间
     */
    private LocalDateTime timestamp;

    /**
     * 惯性气压高度，单位：米
     */
    private Short inertialPressureAltitude;

    /**
     * 真航向，单位：0.01度
     */
    private Short trueHeading;

    /**
     * 位置经度，单位：度 源库可能为int
     */
    private Double longitude;

    /**
     * 位置纬度，单位：度 源库可能为int
     */
    private Double latitude;

    /**
     * 俯仰角，单位：0.01度
     */
    private Short pitchAngle;

    /**
     * 横滚角，单位：0.01度
     */
    private Short rollAngle;

    /**
     * 飞机训练状态（0：被击落，1：正常）
     */
    private Short aircraftTrainingStatus;

    /**
     * 北向速度，单位：0.125米/秒
     */
    private Short northVelocity;

    /**
     * 东向速度，单位：0.125米/秒
     */
    private Short eastVelocity;

    /**
     * 飞机实虚属性（0~3）
     */
    private Short aircraftAttribute;

    /**
     * 发动机加力状态（0：非加力，1：加力）
     */
    private Short engineAfterburnerStatus;

    /**
     * 红外干扰弹投放（0：未投放，1：投放）
     */
    private Short infraredDecoyRelease;

    /**
     * 天向速度，单位：0.125米/秒
     */
    private Short upwardVelocity;

    /**
     * 平台类型（0~63）
     */
    private Short platformType;

    /**
     * 载机卫星高度与惯性气压高度差值，单位：米
     */
    private Short satInertialAltitudeDiff;

    /**
     * 保留字段
     */
    private Integer reserved;
}
