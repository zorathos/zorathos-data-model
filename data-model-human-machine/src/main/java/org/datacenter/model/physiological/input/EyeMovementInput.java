package org.datacenter.model.physiological.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.datacenter.model.physiological.PhysiologicalInputBase;

/**
 * @author wangminan
 * @description 眼动数据输入实体，继承 {@link PhysiologicalInputBase}。包含注视点、瞳孔参数、眨眼状态、注视中心及可选属性等字段。
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EyeMovementInput extends PhysiologicalInputBase {
    /**
     * 原名: YANDONG_id
     * 眼动设备ID，眼动仪
     */
    private Integer deviceId;

    /**
     * 原名: Pupil_Diameter_Left_px
     * 左眼瞳孔直径，瞳孔长轴(0-1)，像素值与图像宽的比值
     */
    private Float pupilDiameterLeftPx;

    /**
     * 原名: Pupil_Diameter_Left_mm
     * 左眼瞳孔直径，长轴毫米值(mm)
     */
    private Float pupilDiameterLeftMm;

    /**
     * 原名: Pupil_Diameter_Right_px
     * 右眼瞳孔直径，瞳孔长轴(0-1)，像素值与图像宽的比值
     */
    private Float pupilDiameterRightPx;

    /**
     * 原名: Pupil_Diameter_Right_mm
     * 右眼瞳孔直径，长轴毫米值(mm)
     */
    private Float pupilDiameterRightMm;

    /**
     * 原名: pupil_distance_Left
     * 左眼瞳孔到镜头距离(mm)
     */
    private Float pupilDistanceLeft;

    /**
     * 原名: pupil_distance_Right
     * 右眼瞳孔到镜头距离(mm)
     */
    private Float pupilDistanceRight;

    /**
     * 原名: pupil_center_x_Left
     * 左眼瞳孔中心X，归一化(0-1)，X轴水平向右，Y轴垂直向下
     */
    private Float pupilCenterXLeft;

    /**
     * 原名: pupil_center_y_Left
     * 左眼瞳孔中心Y，归一化(0-1)，X轴水平向右，Y轴垂直向下
     */
    private Float pupilCenterYLeft;

    /**
     * 原名: pupil_center_x_Right
     * 右眼瞳孔中心X，归一化(0-1)，X轴水平向右，Y轴垂直向下
     */
    private Float pupilCenterXRight;

    /**
     * 原名: pupil_center_y_Right
     * 右眼瞳孔中心Y，归一化(0-1)，X轴水平向右，Y轴垂直向下
     */
    private Float pupilCenterYRight;

    /**
     * 原名: blank_Left
     * 左眼眨眼信息(0-5)：0 非眨眼，1 开始，2 闭眼过程，3 闭眼，4 睁眼过程，5 结束
     */
    private Integer blankLeft;

    /**
     * 原名: blank_Right
     * 右眼眨眼信息(0-5)：0 非眨眼，1 开始，2 闭眼过程，3 闭眼，4 睁眼过程，5 结束
     */
    private Integer blankRight;

    /**
     * 原名: Openness_Left
     * 左眼开合度(0-100)，接近0闭眼，100正常睁眼，大于100瞪眼
     */
    private Float opennessLeft;

    /**
     * 原名: Openness_Right
     * 右眼开合度(0-100)，接近0闭眼，100正常睁眼，大于100瞪眼
     */
    private Float opennessRight;

    /**
     * 原名: Gaze_Point_Left_X
     * 左眼注视点X，范围依校准点
     */
    private Float gazePointLeftX;

    /**
     * 原名: Gaze_Point_Left_Y
     * 左眼注视点Y，范围依校准点
     */
    private Float gazePointLeftY;

    /**
     * 原名: Gaze_Point_Right_X
     * 右眼注视点X，范围依校准点
     */
    private Float gazePointRightX;

    /**
     * 原名: Gaze_Point_Right_Y
     * 右眼注视点Y，范围依校准点
     */
    private Float gazePointRightY;

    /**
     * 原名: Gaze_Origin_Left_X
     * 左眼注视瞳孔中心X坐标
     */
    private Float gazeOriginLeftX;

    /**
     * 原名: Gaze_Origin_Left_Y
     * 左眼注视瞳孔中心Y坐标
     */
    private Float gazeOriginLeftY;

    /**
     * 原名: Gaze_Origin_Left_Z
     * 左眼注视瞳孔中心Z坐标
     */
    private Float gazeOriginLeftZ;

    /**
     * 原名: Gaze_Origin_Right_X
     * 右眼注视瞳孔中心X坐标
     */
    private Float gazeOriginRightX;

    /**
     * 原名: Gaze_Origin_Right_Y
     * 右眼注视瞳孔中心Y坐标
     */
    private Float gazeOriginRightY;

    /**
     * 原名: Gaze_Origin_Right_Z
     * 右眼注视瞳孔中心Z坐标
     */
    private Float gazeOriginRightZ;

    /**
     * 原名: Gaze_Direction_Left_X
     * 左眼注视矢量X分量
     */
    private Float gazeDirectionLeftX;

    /**
     * 原名: Gaze_Direction_Left_Y
     * 左眼注视矢量Y分量
     */
    private Float gazeDirectionLeftY;

    /**
     * 原名: Gaze_Direction_Left_Z
     * 左眼注视矢量Z分量
     */
    private Float gazeDirectionLeftZ;

    /**
     * 原名: Gaze_Direction_Right_X
     * 右眼注视矢量X分量
     */
    private Float gazeDirectionRightX;

    /**
     * 原名: Gaze_Direction_Right_Y
     * 右眼注视矢量Y分量
     */
    private Float gazeDirectionRightY;

    /**
     * 原名: Gaze_Direction_Right_Z
     * 右眼注视矢量Z分量
     */
    private Float gazeDirectionRightZ;

    /**
     * 原名: Fixation_Duration_us
     * 持续时长，单位us
     */
    private Long fixationDurationUs;

    /**
     * 原名: FIXATION_SACCADE_Count
     * 参与注视的原始数据个数
     */
    private Integer fixationSaccadeCount;

    /**
     * 原名: FIXATION_SACCADE_State
     * 注视状态
     */
    private Integer fixationSaccadeState;

    /**
     * 原名: FIXATION_SACCADE_Center_x
     * 注视中心点X坐标
     */
    private Double fixationSaccadeCenterX;

    /**
     * 原名: FIXATION_SACCADE_Center_y
     * 注视中心点Y坐标
     */
    private Double fixationSaccadeCenterY;

    /**
     * 原名: ZYLSP_attr_1
     * 可选：待确定数据
     */
    private Float zylspAttr1;

    /**
     * 原名: ZYLSP_attr_2
     * 可选：待确定数据
     */
    private Float zylspAttr2;
}
