package org.datacenter.model.physiological;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

/**
 * 眼动数据 接入形式为CSV解析
 *
 * @author wangminan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// 不带id
@JsonPropertyOrder({"recordName, userName, validRatio, timeOfDay, " +
        "videoTime, recordingTimeStamp, gazeVelocity, serialSend, " +
        "serialReceive, udpSend, udpReceive, eventLabel, annotation, " +
        "validityLeft, validityRight, pupilPositionLeftX, pupilPositionLeftY, " +
        "pupilPositionRightX, pupilPositionRightY, pupilDiameterLeftPx, pupilDiameterLeftMm, " +
        "pupilDiameterRightPx, pupilDiameterRightMm, opennessLeft, opennessRight, " +
        "eyelidDistanceLeftPx, eyelidDistanceLeftMm, eyelidDistanceRightPx, " +
        "eyelidDistanceRightMm, ipd, gazePointIndex, gazePointX, gazePointY, " +
        "xOffset, yOffset, gazePointLeftX, gazePointLeftY, gazePointRightX, " +
        "gazePointRightY, gazeOriginLeftX, gazeOriginLeftY, gazeOriginLeftZ, " +
        "gazeOriginRightX, gazeOriginRightY, gazeOriginRightZ, gazeDirectionLeftX, " +
        "gazeDirectionLeftY, gazeDirectionLeftZ, gazeDirectionRightX, gazeDirectionRightY, " +
        "gazeDirectionRightZ, fixationIndex, fixationDuration, fixationPointX, fixationPointY, " +
        "saccadeIndex, saccadeDuration, saccadeAmplitude, saccadeVelocityAverage, saccadeVelocityPeak, " +
        "invalidIndex, invalidDuration, blinkIndex, blinkDuration, blinkEye, quatData, gyro, accel, mag"})
public class EyeMovement {

    /**
     * 我们自己加的id auto_increment bigint
     */
    private Long id;

    /**
     * Record Name
     */
    private String recordName;

    /**
     * User Name
     */
    private String userName;

    /**
     * Valid Ratio [%]
     */
    private Double validRatio;

    /**
     * Time of Day [HH:mm:ss.ms]
     */
    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    private LocalTime timeOfDay;

    /**
     * Video Time [HH:mm:ss.ms]
     */
    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    private LocalTime videoTime;

    /**
     * Recording Time Stamp [ms]
     */
    private Long recordingTimeStamp;

    /**
     * Gaze Velocity [px/ms]
     */
    private Double gazeVelocity;

    /**
     * Serial Send
     */
    private Integer serialSend;

    /**
     * Serial Receive
     */
    private Integer serialReceive;

    /**
     * UDP Send
     */
    private Integer udpSend;

    /**
     * UDP Receive
     */
    private Integer udpReceive;

    /**
     * Event Label
     */
    private String eventLabel;

    /**
     * Annotation
     */
    private String annotation;

    /**
     * Validity Left
     */
    private Double validityLeft;

    /**
     * Validity Right
     */
    private Double validityRight;

    /**
     * Pupil Position Left X
     */
    private Double pupilPositionLeftX;

    /**
     * Pupil Position Left Y
     */
    private Double pupilPositionLeftY;

    /**
     * Pupil Position Right X
     */
    private Double pupilPositionRightX;

    /**
     * Pupil Position Right Y
     */
    private Double pupilPositionRightY;

    /**
     * Pupil Diameter Left [px]
     */
    private Double pupilDiameterLeftPx;

    /**
     * Pupil Diameter Left [mm]
     */
    private Double pupilDiameterLeftMm;

    /**
     * Pupil Diameter Right [px]
     */
    private Double pupilDiameterRightPx;

    /**
     * Pupil Diameter Right [mm]
     */
    private Double pupilDiameterRightMm;

    /**
     * Openness Left [%]
     */
    private Double opennessLeft;

    /**
     * Openness Right [%]
     */
    private Double opennessRight;

    /**
     * Eyelid Distance Left [px]
     */
    private Double eyelidDistanceLeftPx;

    /**
     * Eyelid Distance Left [mm]
     */
    private Double eyelidDistanceLeftMm;

    /**
     * Eyelid Distance Right [px]
     */
    private Double eyelidDistanceRightPx;

    /**
     * Eyelid Distance Right [mm]
     */
    private Double eyelidDistanceRightMm;

    /**
     * Inter-Pupillary Distance (IPD) [mm]
     */
    private Double ipd;

    /**
     * Gaze Point Index
     */
    private Integer gazePointIndex;

    /**
     * Gaze Point X [px]
     */
    private Double gazePointX;

    /**
     * Gaze Point Y [px]
     */
    private Double gazePointY;

    /**
     * X Offset [px]
     */
    private Double xOffset;

    /**
     * Y Offset [px]
     */
    private Double yOffset;

    /**
     * Gaze Point Left X [px]
     */
    private Double gazePointLeftX;

    /**
     * Gaze Point Left Y [px]
     */
    private Double gazePointLeftY;

    /**
     * Gaze Point Right X [px]
     */
    private Double gazePointRightX;

    /**
     * Gaze Point Right Y [px]
     */
    private Double gazePointRightY;

    /**
     * Gaze Origin Left X [mm]
     */
    private Double gazeOriginLeftX;

    /**
     * Gaze Origin Left Y [mm]
     */
    private Double gazeOriginLeftY;

    /**
     * Gaze Origin Left Z [mm]
     */
    private Double gazeOriginLeftZ;

    /**
     * Gaze Origin Right X [mm]
     */
    private Double gazeOriginRightX;

    /**
     * Gaze Origin Right Y [mm]
     */
    private Double gazeOriginRightY;

    /**
     * Gaze Origin Right Z [mm]
     */
    private Double gazeOriginRightZ;

    /**
     * Gaze Direction Left X
     */
    private Double gazeDirectionLeftX;

    /**
     * Gaze Direction Left Y
     */
    private Double gazeDirectionLeftY;

    /**
     * Gaze Direction Left Z
     */
    private Double gazeDirectionLeftZ;

    /**
     * Gaze Direction Right X
     */
    private Double gazeDirectionRightX;

    /**
     * Gaze Direction Right Y
     */
    private Double gazeDirectionRightY;

    /**
     * Gaze Direction Right Z
     */
    private Double gazeDirectionRightZ;

    /**
     * Fixation Index
     */
    private Integer fixationIndex;

    /**
     * Fixation Duration [ms]
     */
    private Long fixationDuration;

    /**
     * Fixation Point X [px]
     */
    private Double fixationPointX;

    /**
     * Fixation Point Y [px]
     */
    private Double fixationPointY;

    /**
     * Saccade Index
     */
    private Integer saccadeIndex;

    /**
     * Saccade Duration [ms]
     */
    private Long saccadeDuration;

    /**
     * Saccade Amplitude [px]
     */
    private Double saccadeAmplitude;

    /**
     * Saccade Velocity Average [px/ms]
     */
    private Double saccadeVelocityAverage;

    /**
     * Saccade Velocity Peak [px/ms]
     */
    private Double saccadeVelocityPeak;

    /**
     * Invalid Index
     */
    private Integer invalidIndex;

    /**
     * Invalid Duration [ms]
     */
    private Long invalidDuration;

    /**
     * Blink Index
     */
    private Integer blinkIndex;

    /**
     * Blink Duration [ms]
     */
    private Long blinkDuration;

    /**
     * Blink Eye
     */
    private String blinkEye;

    /**
     * Quat Data
     */
    private String quatData;

    /**
     * Gyro Data
     */
    private String gyro;

    /**
     * Acceleration [g]
     */
    private String accel;

    /**
     * Magnetic Field Data
     */
    private String mag;
}

