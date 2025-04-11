package org.datacenter.model.collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 生理传感器信息类，对应生理传感器表
 *
 * @author wangminan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CollectionSensor {
    /**
     * 传感器序列号
     */
    private Long sensorId;

    /**
     * 传感器名称
     */
    private String sensorName;

    /**
     * 设备序列号
     */
    private Long equipmentId;

    /**
     * 传感器生产厂家统一社会信用代码
     */
    private String manufacturerId;

    /**
     * 传感器生产厂家名称
     */
    private String manufacturerName;

    /**
     * 传感器生产厂家电话
     */
    private String manufacturePhone;

    /**
     * 传感器类型
     */
    private Short sensorType;

    /**
     * 传感器附加信息
     */
    private String additionalInfo;

    /**
     * 传感器状态
     * 默认值为0
     */
    private Short sensorStatus;
}
