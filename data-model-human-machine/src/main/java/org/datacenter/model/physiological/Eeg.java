package org.datacenter.model.physiological;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : [wangminan]
 * @description : 脑电数据
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Eeg {

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
     * 采样时间
     */
    private Long sampleTimestamp;

    /**
     * Stream Name
     */
    private String streamName;

    /**
     * Channel Count
     */
    private Integer channelCount;

    /**
     * Sampling Rate
     */
    private double samplingRate;

    /**
     * Channel Format
     */
    private String channelFormat;

    /**
     * Channel_1
     */
    private Float channel1;

    /**
     * Channel_2
     */
    private Float channel2;

    /**
     * Channel_3
     */
    private Float channel3;

    /**
     * Channel_4
     */
    private Float channel4;

    /**
     * Channel_5
     */
    private Float channel5;

    /**
     * Channel_6
     */
    private Float channel6;

    /**
     * Channel_7
     */
    private Float channel7;

    /**
     * Channel_8
     */
    private Float channel8;

    /**
     * Channel_9
     */
    private Float channel9;

    /**
     * Channel_10
     */
    private Float channel10;

    /**
     * Channel_11
     */
    private Float channel11;

    /**
     * Channel_2
     */
    private Float channel12;

    /**
     * Channel_13
     */
    private Float channel13;

    /**
     * Channel_14
     */
    private Float channel14;

    /**
     * Channel_15
     */
    private Float channel15;

    /**
     * Channel_16
     */
    private Float channel16;
}
