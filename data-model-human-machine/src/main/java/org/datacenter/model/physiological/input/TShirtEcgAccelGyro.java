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
 * @description : 心电输入
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(callSuper = true)
public class TShirtEcgAccelGyro extends BasePhysiologicalInput {

    /**
     *  ECG通道Ⅰ数据	一条记录中为一组十个ecg1数据，每个数据间隔4ms
     */
    @JsonAlias("ecg1")
    private String ecg1;

    /**
     *  ECG通道Ⅱ数据	一条记录中为一组十个ecg2数据，每个数据间隔4ms
     */
    @JsonAlias("ecg2")
    private String ecg2;

    /**
     *  ECG通道Ⅲ数据	一条记录中为一组十个ecg3数据，每个数据间隔4ms
     */
    @JsonAlias("ecg3")
    private String ecg3;

    /**
     * 三轴加速度X轴
     */
    @JsonAlias("accel_x")
    private Double accelX;

    /**
     * 三维加速度Y轴
     */
    @JsonAlias("accel_y")
    private Double accelY;

    /**
     * 三维加速度Z轴
     */
    @JsonAlias("accel_z")
    private Double accelZ;

    /**
     * 三维陀螺仪X轴
     */
    @JsonAlias("gyro_x")
    private Double gyroX;

    /**
     * 三维陀螺仪Y轴
     */
    @JsonAlias("gyro_y")
    private Double gyroY;

    /**
     * 三维陀螺仪Z轴
     */
    @JsonAlias("gyro_z")
    private Double gyroZ;
}
