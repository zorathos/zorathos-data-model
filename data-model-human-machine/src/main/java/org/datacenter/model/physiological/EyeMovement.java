package org.datacenter.model.physiological;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description  : 眼动
 * @author       : [wangminan]
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EyeMovement {

    /**
     * 我们自己加的主键 auto_increment bigint
     */
    private Long id;

    /**
     * 生理测试任务Id 关联
     */
    private Long taskId;

    /**
     * 采集用传感器Id
     */
    private Long sensorId;

    /**
     * 采样时间 微秒级时间戳
     */
    private Long sampleTimestamp;

    /**
     * Pupil Diameter Left[px]
     */
    private Float pupilDiameterLeftPx;

    /**
     * Pupil Diameter Left[mm]
     */
    private Float pupilDiameterLeftMm;

    /**
     * Pupil Diameter Right[px]
     */
    private Float pupilDiameterRightPx;

    /**
     * Pupil Diameter Right[mm]
     */
    private Float pupilDiameterRightMm;

    /**
     * pupil_distance Left
     */
    private Float pupilDistanceLeft;

    /**
     * pupil_distance Right
     */
    private Float pupilDistanceRight;

    /**
     * pupil_center_x Left
     */
    private Float pupilCenterXLeft;

    /**
     * pupil_center_y Left
     */
    private Float pupilCenterYLeft;

    /**
     * pupil_center_x Right
     */
    private Float pupilCenterXRight;

    /**
     * pupil_center_y Right
     */
    private Float pupilCenterYRight;

    /**
     * blank_Left
     */
    private Integer blankLeft;

    /**
     * blank_Right
     */
    private Integer blankRight;

    /**
     * Openness Left[%]
     */
    private Float opennessLeft;

    /**
     * Openness Right[%]
     */
    private Float opennessRight;

    /**
     * Gaze Point Left X[px]
     */
    private Float gazePointLeftX;

    /**
     * Gaze Point Left Y[px]
     */
    private Float gazePointLeftY;

    /**
     * Gaze Point Right X[px]
     */
    private Float gazePointRightX;

    /**
     * Gaze Point Right Y[px]
     */
    private Float gazePointRightY;

    /**
     * Gaze Origin Left X[mm]
     */
    private Float gazeOriginLeftX;

    /**
     * Gaze Origin Left Y[mm]
     */
    private Float gazeOriginLeftY;

    /**
     * Gaze Origin Left Z[mm]
     */
    private Float gazeOriginLeftZ;

    /**
     * Gaze Origin Right X[mm]
     */
    private Float gazeOriginRightX;

    /**
     * Gaze Origin Right Y[mm]
     */
    private Float gazeOriginRightY;

    /**
     * Gaze Origin Right Z[mm]
     */
    private Float gazeOriginRightZ;

    /**
     * Gaze Direction Left X
     */
    private Float gazeDirectionLeftX;

    /**
     * Gaze Direction Left Y
     */
    private Float gazeDirectionLeftY;

    /**
     * Gaze Direction Left Z
     */
    private Float gazeDirectionLeftZ;

    /**
     * Gaze Direction Right X
     */
    private Float gazeDirectionRightX;

    /**
     * Gaze Direction Right Y
     */
    private Float gazeDirectionRightY;

    /**
     * Gaze Direction Right Z
     */
    private Float gazeDirectionRightZ;

    /**
     * Fixation Duration[ms]
     */
    private long fixationDuration;

    /**
     * FIXATION_SACCADE_Count
     */
    private Integer fixationSaccadeCount;

    /**
     * FIXATION_SACCADE_State
     */
    private Integer fixationSaccadeState;

    /**
     * FIXATION_SACCADE_Center_x
     */
    private Float fixationSaccadeCenterX;

    /**
     * FIXATION_SACCADE_Center_y
     */
    private Float fixationSaccadeCenterY;
}
