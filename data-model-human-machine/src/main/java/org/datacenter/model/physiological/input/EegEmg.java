package org.datacenter.model.physiological.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.datacenter.model.physiological.BasePhysiologicalInput;

/**
 * @author wangminan
 * @description 脑电肌电数据输入实体，继承 {@link BasePhysiologicalInput}，包含设备信息及10导脑电和8导肌电原始电信号。
 * 导入方式在线
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class EegEmg extends BasePhysiologicalInput {

    /**
     * 原名 channel_1
     * 脑电原始电信号值1
     */
    @JsonAlias("channel_1")
    private Float channel1;

    /**
     * 原名 channel_2
     * 脑电原始电信号值2
     */
    @JsonAlias("channel_2")
    private Float channel2;

    /**
     * 原名 channel_3
     * 脑电原始电信号值3
     */
    @JsonAlias("channel_3")
    private Float channel3;

    /**
     * 原名 channel_4
     * 脑电原始电信号值4
     */
    @JsonAlias("channel_4")
    private Float channel4;

    /**
     * 原名 channel_5
     * 脑电原始电信号值5
     */
    @JsonAlias("channel_5")
    private Float channel5;

    /**
     * 原名 channel_6
     * 脑电原始电信号值6
     */
    @JsonAlias("channel_6")
    private Float channel6;

    /**
     * 原名 channel_7
     * 脑电原始电信号值7
     */
    @JsonAlias("channel_7")
    private Float channel7;

    /**
     * 原名 channel_8
     * 脑电原始电信号值8
     */
    @JsonAlias("channel_8")
    private Float channel8;

    /**
     * 原名 channel_9
     * 脑电原始电信号值9
     */
    @JsonAlias("channel_9")
    private Float channel9;

    /**
     * 原名 channel_10
     * 脑电原始电信号值10
     */
    @JsonAlias("channel_10")
    private Float channel10;

    /**
     * 肌电原始电信号值1
     * 肌电信号_左颈
     */
    @JsonAlias("emg_1")
    private Float emg1;

    /**
     * 肌电原始电信号值2
     * 肌电信号_右颈
     */
    @JsonAlias("emg_2")
    private Float emg2;

    /**
     * 肌电原始电信号值3
     * 肌电信号_左肩
     */
    @JsonAlias("emg_3")
    private Float emg3;

    /**
     * 肌电原始电信号值4
     * 肌电信号_右肩
     */
    @JsonAlias("emg_4")
    private Float emg4;

    /**
     * 肌电原始电信号值5
     * 肌电信号_左臂
     */
    @JsonAlias("emg_5")
    private Float emg5;

    /**
     * 肌电原始电信号值6
     * 肌电信号_右臂
     */
    @JsonAlias("emg_6")
    private Float emg6;

    /**
     * 肌电原始电信号值7
     * 肌电信号_左腰
     */
    @JsonAlias("emg_7")
    private Float emg7;

    /**
     * 肌电原始电信号值8
     * 肌电信号_右腰
     */
    @JsonAlias("emg_8")
    private Float emg8;
}
