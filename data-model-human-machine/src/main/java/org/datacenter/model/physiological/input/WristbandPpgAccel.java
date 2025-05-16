package org.datacenter.model.physiological.input;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.datacenter.model.physiological.BasePhysiologicalInput;

/**
 * @author : [wangminan]
 * @description : 腕带 红光，红外光，加速度 输入
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(callSuper = true)
public class WristbandPpgAccel extends BasePhysiologicalInput {

    /**
     * 红光PPG通道1数据
     */
    @JsonAlias("ppg_red1")
    private String ppgRed1;

    /**
     * 红光PPG通道2数据
     */
    @JsonAlias("ppg_red2")
    private String ppgRed2;

    /**
     * 红光PPG通道3数据
     */
    @JsonAlias("ppg_red3")
    private String ppgRed3;

    /**
     * 红光PPG通道4数据
     */
    @JsonAlias("ppg_red4")
    private String ppgRed4;

    /**
     * 红外PPG通道1数据
     */
    @JsonAlias("ppg_infrared1")
    private String ppgInfrared1;

    /**
     * 红外PPG通道2数据
     */
    @JsonAlias("ppg_infrared2")
    private String ppgInfrared2;

    /**
     * 红外PPG通道3数据
     */
    @JsonAlias("ppg_infrared3")
    private String ppgInfrared3;

    /**
     * 红外PPG通道4数据
     */
    @JsonAlias("ppg_infrared4")
    private String ppgInfrared4;

    /**
     * 腕部加速度X轴
     */
    @JsonAlias("accel_x")
    private Double accelX;

    /**
     * 腕部加速度Y轴
     */
    @JsonAlias("accel_y")
    private Double accelY;

    /**
     * 腕部加速度Z轴
     */
    @JsonAlias("accel_z")
    private Double accelZ;
}
