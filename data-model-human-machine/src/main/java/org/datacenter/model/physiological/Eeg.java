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
     * 采样的unix时间戳
     */
    private Long timestamp;


    /**
     * Stream Name
     */
    private String streamName;

    /**
     * Channel Count
     */
    private int channelCount;

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
    private float channel1;

    /**
     * Channel_2
     */
    private float channel2;

    /**
     * Channel_3
     */
    private float channel3;

    /**
     * Channel_4
     */
    private float channel4;

    /**
     * Channel_5
     */
    private float channel5;

    /**
     * Channel_6
     */
    private float channel6;

    /**
     * Channel_7
     */
    private float channel7;

    /**
     * Channel_8
     */
    private float channel8;

    /**
     * Channel_9
     */
    private float channel9;

    /**
     * Channel_10
     */
    private float channel10;

    /**
     * Channel_11
     */
    private float channel11;

    /**
     * Channel_2
     */
    private float channel12;

    /**
     * Channel_13
     */
    private float channel13;

    /**
     * Channel_14
     */
    private float channel14;

    /**
     * Channel_15
     */
    private float channel15;

    /**
     * Channel_16
     */
    private float channel16;
}
