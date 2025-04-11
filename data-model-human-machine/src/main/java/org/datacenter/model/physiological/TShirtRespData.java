package org.datacenter.model.physiological;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : [ning]
 * @description : Tshirt的Resp数据
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TShirtRespData {

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
     * 呼吸带原始数据，存储50个采样点(数组或JSON字符串)
     */
    private String respData;
}
