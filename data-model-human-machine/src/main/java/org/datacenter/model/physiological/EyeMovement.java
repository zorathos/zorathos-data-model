package org.datacenter.model.physiological;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private double validRatio;

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
    private long recordingTimeStamp;

    /**
     * Gaze Velocity [px/ms]
     */
    private double gazeVelocity;

    /**
     * Serial Send
     */
    private int serialSend;

    /**
     * Serial Receive
     */
    private int serialReceive;

    /**
     * UDP Send
     */
    private int udpSend;

    /**
     * UDP Receive
     */
    private int udpReceive;

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
    private double validityLeft;

    /**
     * Validity Right
     */
    private double validityRight;

    /**
     * Pupil Position Left X
     */
    private double pupilPositionLeftX;

    /**
     * Pupil Position Left Y
     */
    private double pupilPositionLeftY;

    /**
     * Pupil Position Right X
     */
    private double pupilPositionRightX;

    /**
     * Pupil Position Right Y
     */
    private double pupilPositionRightY;

    /**
     * Pupil Diameter Left [px]
     */
    private double pupilDiameterLeftPx;

    /**
     * Pupil Diameter Left [mm]
     */
    private double pupilDiameterLeftMm;

    /**
     * Pupil Diameter Right [px]
     */
    private double pupilDiameterRightPx;

    /**
     * Pupil Diameter Right [mm]
     */
    private double pupilDiameterRightMm;

    /**
     * Openness Left [%]
     */
    private double opennessLeft;

    /**
     * Openness Right [%]
     */
    private double opennessRight;

    /**
     * Eyelid Distance Left [px]
     */
    private double eyelidDistanceLeftPx;

    /**
     * Eyelid Distance Left [mm]
     */
    private double eyelidDistanceLeftMm;

    /**
     * Eyelid Distance Right [px]
     */
    private double eyelidDistanceRightPx;

    /**
     * Eyelid Distance Right [mm]
     */
    private double eyelidDistanceRightMm;

    /**
     * Inter-Pupillary Distance (IPD) [mm]
     */
    private double ipd;

    /**
     * Gaze Point Index
     */
    private int gazePointIndex;

    /**
     * Gaze Point X [px]
     */
    private double gazePointX;

    /**
     * Gaze Point Y [px]
     */
    private double gazePointY;

    /**
     * X Offset [px]
     */
    private double xOffset;

    /**
     * Y Offset [px]
     */
    private double yOffset;

    /**
     * Gaze Point Left X [px]
     */
    private double gazePointLeftX;

    /**
     * Gaze Point Left Y [px]
     */
    private double gazePointLeftY;

    /**
     * Gaze Point Right X [px]
     */
    private double gazePointRightX;

    /**
     * Gaze Point Right Y [px]
     */
    private double gazePointRightY;

    /**
     * Gaze Origin Left X [mm]
     */
    private double gazeOriginLeftX;

    /**
     * Gaze Origin Left Y [mm]
     */
    private double gazeOriginLeftY;

    /**
     * Gaze Origin Left Z [mm]
     */
    private double gazeOriginLeftZ;

    /**
     * Gaze Origin Right X [mm]
     */
    private double gazeOriginRightX;

    /**
     * Gaze Origin Right Y [mm]
     */
    private double gazeOriginRightY;

    /**
     * Gaze Origin Right Z [mm]
     */
    private double gazeOriginRightZ;

    /**
     * Gaze Direction Left X
     */
    private double gazeDirectionLeftX;

    /**
     * Gaze Direction Left Y
     */
    private double gazeDirectionLeftY;

    /**
     * Gaze Direction Left Z
     */
    private double gazeDirectionLeftZ;

    /**
     * Gaze Direction Right X
     */
    private double gazeDirectionRightX;

    /**
     * Gaze Direction Right Y
     */
    private double gazeDirectionRightY;

    /**
     * Gaze Direction Right Z
     */
    private double gazeDirectionRightZ;

    /**
     * Fixation Index
     */
    private int fixationIndex;

    /**
     * Fixation Duration [ms]
     */
    private long fixationDuration;

    /**
     * Fixation Point X [px]
     */
    private double fixationPointX;

    /**
     * Fixation Point Y [px]
     */
    private double fixationPointY;

    /**
     * Saccade Index
     */
    private int saccadeIndex;

    /**
     * Saccade Duration [ms]
     */
    private long saccadeDuration;

    /**
     * Saccade Amplitude [px]
     */
    private double saccadeAmplitude;

    /**
     * Saccade Velocity Average [px/ms]
     */
    private double saccadeVelocityAverage;

    /**
     * Saccade Velocity Peak [px/ms]
     */
    private double saccadeVelocityPeak;

    /**
     * Invalid Index
     */
    private int invalidIndex;

    /**
     * Invalid Duration [ms]
     */
    private long invalidDuration;

    /**
     * Blink Index
     */
    private int blinkIndex;

    /**
     * Blink Duration [ms]
     */
    private long blinkDuration;

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

