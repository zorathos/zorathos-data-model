package org.datacenter.model.physiological.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class EyeTrackingInput extends PhysiologicalInputBase {
    /**
     * 原名: pupil_diameter_left_px
     * 左眼瞳孔直径，瞳孔长轴(0-1)，像素值与图像宽的比值
     */
    @JsonAlias("pupil_diameter_left_px")
    private Float pupilDiameterLeftPx;

    /**
     * 原名: pupil_diameter_left_mm
     * 左眼瞳孔直径，长轴毫米值(mm)
     */
    @JsonAlias("pupil_diameter_left_mm")
    private Float pupilDiameterLeftMm;

    /**
     * 原名: pupil_diameter_right_px
     * 右眼瞳孔直径，瞳孔长轴(0-1)，像素值与图像宽的比值
     */
    @JsonAlias("pupil_diameter_right_px")
    private Float pupilDiameterRightPx;

    /**
     * 原名: pupil_diameter_right_mm
     * 右眼瞳孔直径，长轴毫米值(mm)
     */
    @JsonAlias("pupil_diameter_right_mm")
    private Float pupilDiameterRightMm;

    /**
     * 原名: pupil_distance_left
     * 左眼瞳孔到镜头距离(mm)
     */
    @JsonAlias("pupil_distance_left")
    private Float pupilDistanceLeft;

    /**
     * 原名: pupil_distance_right
     * 右眼瞳孔到镜头距离(mm)
     */
    @JsonAlias("pupil_distance_right")
    private Float pupilDistanceRight;

    /**
     * 原名: pupil_center_x_left
     * 左眼瞳孔中心X，归一化(0-1)，X轴水平向右，Y轴垂直向下
     */
    @JsonAlias("pupil_center_x_left")
    private Float pupilCenterXLeft;

    /**
     * 原名: pupil_center_y_left
     * 左眼瞳孔中心Y，归一化(0-1)，X轴水平向右，Y轴垂直向下
     */
    @JsonAlias("pupil_center_y_left")
    private Float pupilCenterYLeft;

    /**
     * 原名: pupil_center_x_right
     * 右眼瞳孔中心X，归一化(0-1)，X轴水平向右，Y轴垂直向下
     */
    @JsonAlias("pupil_center_x_right")
    private Float pupilCenterXRight;

    /**
     * 原名: pupil_center_y_right
     * 右眼瞳孔中心Y，归一化(0-1)，X轴水平向右，Y轴垂直向下
     */
    @JsonAlias("pupil_center_y_right")
    private Float pupilCenterYRight;

    /**
     * 原名: blank_left
     * 左眼眨眼信息(0-5)：0 非眨眼，1 开始，2 闭眼过程，3 闭眼，4 睁眼过程，5 结束
     */
    @JsonAlias("blank_left")
    private Integer blankLeft;

    /**
     * 原名: blank_right
     * 右眼眨眼信息(0-5)：0 非眨眼，1 开始，2 闭眼过程，3 闭眼，4 睁眼过程，5 结束
     */
    @JsonAlias("blank_right")
    private Integer blankRight;

    /**
     * 原名: openness_left
     * 左眼开合度(0-100)，接近0闭眼，100正常睁眼，大于100瞪眼
     */
    @JsonAlias("openness_left")
    private Float opennessLeft;

    /**
     * 原名: openness_right
     * 右眼开合度(0-100)，接近0闭眼，100正常睁眼，大于100瞪眼
     */
    @JsonAlias("openness_right")
    private Float opennessRight;

    /**
     * 原名: gaze_point_left_x
     * 左眼注视点X，范围依校准点
     */
    @JsonAlias("gaze_point_left_x")
    private Float gazePointLeftX;

    /**
     * 原名: gaze_point_left_y
     * 左眼注视点Y，范围依校准点
     */
    @JsonAlias("gaze_point_left_y")
    private Float gazePointLeftY;

    /**
     * 原名: gaze_point_right_x
     * 右眼注视点X，范围依校准点
     */
    @JsonAlias("gaze_point_right_x")
    private Float gazePointRightX;

    /**
     * 原名: gaze_point_right_y
     * 右眼注视点Y，范围依校准点
     */
    @JsonAlias("gaze_point_right_y")
    private Float gazePointRightY;

    /**
     * 原名: gaze_origin_left_x
     * 左眼注视瞳孔中心X坐标
     */
    @JsonAlias("gaze_origin_left_x")
    private Float gazeOriginLeftX;

    /**
     * 原名: gaze_origin_left_y
     * 左眼注视瞳孔中心Y坐标
     */
    @JsonAlias("gaze_origin_left_y")
    private Float gazeOriginLeftY;

    /**
     * 原名: gaze_origin_left_Z
     * 左眼注视瞳孔中心Z坐标
     */
    @JsonAlias("gaze_origin_left_Z")
    private Float gazeOriginLeftZ;

    /**
     * 原名: gaze_origin_right_x
     * 右眼注视瞳孔中心X坐标
     */
    @JsonAlias("gaze_origin_right_x")
    private Float gazeOriginRightX;

    /**
     * 原名: gaze_origin_right_y
     * 右眼注视瞳孔中心Y坐标
     */
    @JsonAlias("gaze_origin_right_y")
    private Float gazeOriginRightY;

    /**
     * 原名: gaze_origin_right_Z
     * 右眼注视瞳孔中心Z坐标
     */
    @JsonAlias("gaze_origin_right_Z")
    private Float gazeOriginRightZ;

    /**
     * 原名: gaze_direction_left_x
     * 左眼注视矢量X分量
     */
    @JsonAlias("gaze_direction_left_x")
    private Float gazeDirectionLeftX;

    /**
     * 原名: gaze_direction_left_y
     * 左眼注视矢量Y分量
     */
    @JsonAlias("gaze_direction_left_y")
    private Float gazeDirectionLeftY;

    /**
     * 原名: gaze_direction_left_Z
     * 左眼注视矢量Z分量
     */
    @JsonAlias("gaze_direction_left_Z")
    private Float gazeDirectionLeftZ;

    /**
     * 原名: gaze_direction_right_x
     * 右眼注视矢量X分量
     */
    @JsonAlias("gaze_direction_right_x")
    private Float gazeDirectionRightX;

    /**
     * 原名: gaze_direction_right_y
     * 右眼注视矢量Y分量
     */
    @JsonAlias("gaze_direction_right_y")
    private Float gazeDirectionRightY;

    /**
     * 原名: gaze_direction_right_Z
     * 右眼注视矢量Z分量
     */
    @JsonAlias("gaze_direction_right_Z")
    private Float gazeDirectionRightZ;

    /**
     * 原名: fixation_duration_us
     * 持续时长，单位us
     */
    @JsonAlias("fixation_duration_us")
    private Long fixationDurationUs;

    /**
     * 原名: fixation_saccade_count
     * 参与注视的原始数据个数
     */
    @JsonAlias("fixation_saccade_count")
    private Integer fixationSaccadeCount;

    /**
     * 原名: fixation_saccade_state
     * 注视状态
     */
    @JsonAlias("fixation_saccade_state")
    private Integer fixationSaccadeState;

    /**
     * 原名: fixation_saccade_center_x
     * 注视中心点X坐标
     */
    @JsonAlias("fixation_saccade_center_x")
    private Double fixationSaccadeCenterX;

    /**
     * 原名: fixation_saccade_center_y
     * 注视中心点Y坐标
     */
    @JsonAlias("fixation_saccade_center_y")
    private Double fixationSaccadeCenterY;
}
