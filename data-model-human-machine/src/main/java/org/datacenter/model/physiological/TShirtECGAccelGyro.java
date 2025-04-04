package org.datacenter.model.physiological;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : [ning]
 * @description : Tshirt的ECG数据
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TShirtECGAccelGyro {

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
     * ECG通道1数据(24位原始值转换后的电压或其它单位)
     */
    private double ecg1;


    /**
     * ECG通道2数据
     */
    private double ecg2;

    /**
     * ECG通道3数据
     */
    private double ecg3;

}
