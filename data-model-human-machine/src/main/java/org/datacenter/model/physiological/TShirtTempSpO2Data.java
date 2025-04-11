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
     * 生理测试任务Id 关联
     */
    private Long taskId;

    /**
     * 采集用传感器Id
     */
    private Long sensorId;

    /**
     * 采样时间 微秒级时间戳
     */
    private Long sampleTimestamp;

    /**
     * 腋下体温(转换后的温度值单位℃℃)
     */
    private Float temperature;

    /**
     * 血氧饱和度(转换后的血氧值单位%)
     */
    private Integer spo2;
}
