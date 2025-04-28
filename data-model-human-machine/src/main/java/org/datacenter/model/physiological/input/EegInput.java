package org.datacenter.model.physiological.input;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("NAODIAN_ID")
    private Integer deviceId;

    /**
     * 原名 Sampling_Rate
     * 采样率
     */
    @JsonProperty("Sampling_Rate")
    private Double samplingRate;

    /**
     * 原名 Channel_Format
     * 通道格式
     */
    @JsonProperty("Channel_Format")
    private String channelFormat;

    /**
     * 原名 Channel_1
     * 脑电原始电信号值1
     */
    @JsonProperty("Channel_1")
    private Float channel1;

    /**
     * 原名 Channel_2
     * 脑电原始电信号值2
     */
    @JsonProperty("Channel_2")
    private Float channel2;

    /**
     * 原名 Channel_3
     * 脑电原始电信号值3
     */
    @JsonProperty("Channel_3")
    private Float channel3;

    /**
     * 原名 Channel_4
     * 脑电原始电信号值4
     */
    @JsonProperty("Channel_4")
    private Float channel4;

    /**
     * 原名 Channel_5
     * 脑电原始电信号值5
     */
    @JsonProperty("Channel_5")
    private Float channel5;

    /**
     * 原名 Channel_6
     * 脑电原始电信号值6
     */
    @JsonProperty("Channel_6")
    private Float channel6;

    /**
     * 原名 Channel_7
     * 脑电原始电信号值7
     */
    @JsonProperty("Channel_7")
    private Float channel7;

    /**
     * 原名 Channel_8
     * 脑电原始电信号值8
     */
    @JsonProperty("Channel_8")
    private Float channel8;

    /**
     * 原名 Channel_9
     * 脑电原始电信号值9
     */
    @JsonProperty("Channel_9")
    private Float channel9;

    /**
     * 原名 Channel_10
     * 脑电原始电信号值10
     */
    @JsonProperty("Channel_10")
    private Float channel10;

    /**
     * 原名 Channel_11
     * 脑电原始电信号值11
     */
    @JsonProperty("Channel_11")
    private Float channel11;

    /**
     * 原名 Channel_12
     * 脑电原始电信号值12
     */
    @JsonProperty("Channel_12")
    private Float channel12;

    /**
     * 原名 Channel_13
     * 脑电原始电信号值13
     */
    @JsonProperty("Channel_13")
    private Float channel13;

    /**
     * 原名 Channel_14
     * 脑电原始电信号值14
     */
    @JsonProperty("Channel_14")
    private Float channel14;

    /**
     * 原名 Channel_15
     * 脑电原始电信号值15
     */
    @JsonProperty("Channel_15")
    private Float channel15;

    /**
     * 原名 Channel_16
     * 脑电原始电信号值16
     */
    @JsonProperty("Channel_16")
    private Float channel16;
}
