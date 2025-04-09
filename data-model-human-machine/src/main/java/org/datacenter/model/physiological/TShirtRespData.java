package org.datacenter.model.physiological;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    private LocalDateTime sampleTimestamp;

    /**
     * 呼吸带原始数据，存储50个采样点(数组或JSON字符串)
     */
    private String respData;
}
