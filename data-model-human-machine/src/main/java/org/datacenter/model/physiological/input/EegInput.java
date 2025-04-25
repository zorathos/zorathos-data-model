package org.datacenter.model.physiological.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.datacenter.model.physiological.PhysiologicalInputBase;

/**
 * @author wangminan
 * @description 脑电数据输入实体，继承 {@link PhysiologicalInputBase}，包含设备信息及16路原始电信号。
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EegInput extends PhysiologicalInputBase {
    /**
     * 脑电设备ID NAODIAN_ID
     */
    private Integer deviceId;

    /**
     * 采样率
     */
    private Double samplingRate;

    /**
     * 通道格式
     */
    private String channelFormat;

    /**
     * 脑电原始电信号值1
     */
    private Float channel1;

    /**
     * 脑电原始电信号值2
     */
    private Float channel2;

    /**
     * 脑电原始电信号值3
     */
    private Float channel3;

    /**
     * 脑电原始电信号值4
     */
    private Float channel4;

    /**
     * 脑电原始电信号值5
     */
    private Float channel5;

    /**
     * 脑电原始电信号值6
     */
    private Float channel6;

    /**
     * 脑电原始电信号值7
     */
    private Float channel7;

    /**
     * 脑电原始电信号值8
     */
    private Float channel8;

    /**
     * 脑电原始电信号值9
     */
    private Float channel9;

    /**
     * 脑电原始电信号值10
     */
    private Float channel10;

    /**
     * 脑电原始电信号值11
     */
    private Float channel11;

    /**
     * 脑电原始电信号值12
     */
    private Float channel12;

    /**
     * 脑电原始电信号值13
     */
    private Float channel13;

    /**
     * 脑电原始电信号值14
     */
    private Float channel14;

    /**
     * 脑电原始电信号值15
     */
    private Float channel15;

    /**
     * 脑电原始电信号值16
     */
    private Float channel16;
}
