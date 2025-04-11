package org.datacenter.model.collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 采集设备信息类，对应采集设备表
 *
 * @author wangminan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CollectionEquipment {
    /**
     * 设备序列号
     */
    private Long equipmentId;

    /**
     * 设备名称
     */
    private String equipmentName;

    /**
     * IP地址
     */
    private String ipAddress;

    /**
     * 设备状态
     * 默认值为0
     */
    private Short equipmentStatus;

    /**
     * 设备类型
     */
    private Short equipmentType;

    /**
     * 设备附加信息
     */
    private String additionalInfo;
}
