package org.datacenter.model.physiological;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : [ning]
 * @description : Tshirt的温度和饱和度数据
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TShirtTempSpO2Data {
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
     * 腋下体温(转换后的温度值单位℃℃)
     */
    private float temperature;

    /**
     * 血氧饱和度(转换后的血氧值单位%)
     */
    private float spo2;
}
