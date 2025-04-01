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
     * 架次号 关联
     */
    private String sortieNumber;

    /**
     * 采集用传感器Id
     */
    private String sensorId;

    /**
     * 采样的unix时间戳
     */
    private Long timestamp;

    /**
     * Pupil Diameter Left[px]
     */
    private float pupilDiameterLeftPx;

    /**
     * Pupil Diameter Left[mm]
     */
    private float pupilDiameterLeftMm;

    /**
     * Pupil Diameter Right[px]
     */
    private float pupilDiameterRightPx;

    /**
     * Pupil Diameter Right[mm]
     */
    private float pupilDiameterRightMm;

    /**
     * pupil_distance Left
     */
    private float pupilDistanceLeft;

    /**
     * pupil_distance Right
     */
    private float pupilDistanceRight;

    /**
     * pupil_center_x Left
     */
    private float pupilCenterXLeft;

    /**
     * pupil_center_y Left
     */
    private float pupilCenterYLeft;

    /**
     * pupil_center_x Right
     */
    private float pupilCenterXRight;

    /**
     * pupil_center_y Right
     */
    private float pupilCenterYRight;

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
    private float opennessLeft;

    /**
     * Openness Right[%]
     */
    private float opennessRight;

    /**
     * Gaze Point Left X[px]
     */
    private float gazePointLeftX;

    /**
     * Gaze Point Left Y[px]
     */
    private float gazePointLeftY;

    /**
     * Gaze Point Right X[px]
     */
    private float gazePointRightX;

    /**
     * Gaze Point Right Y[px]
     */
    private float gazePointRightY;

    /**
     * Gaze Origin Left X[mm]
     */
    private float gazeOriginLeftX;

    /**
     * Gaze Origin Left Y[mm]
     */
    private float gazeOriginLeftY;

    /**
     * Gaze Origin Left Z[mm]
     */
    private float gazeOriginLeftZ;

    /**
     * Gaze Origin Right X[mm]
     */
    private float gazeOriginRightX;

    /**
     * Gaze Origin Right Y[mm]
     */
    private float gazeOriginRightY;

    /**
     * Gaze Origin Right Z[mm]
     */
    private float gazeOriginRightZ;

    /**
     * Gaze Direction Left X
     */
    private float gazeDirectionLeftX;

    /**
     * Gaze Direction Left Y
     */
    private float gazeDirectionLeftY;

    /**
     * Gaze Direction Left Z
     */
    private float gazeDirectionLeftZ;

    /**
     * Gaze Direction Right X
     */
    private float gazeDirectionRightX;

    /**
     * Gaze Direction Right Y
     */
    private float gazeDirectionRightY;

    /**
     * Gaze Direction Right Z
     */
    private float gazeDirectionRightZ;

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
    private float fixationSaccadeCenterX;

    /**
     * FIXATION_SACCADE_Center_y
     */
    private float fixationSaccadeCenterY;
}
