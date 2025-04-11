package org.datacenter.model.collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 飞行员生理数据采集任务类，对应飞行员生理数据采集任务表
 *
 * @author wangminan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CollectionTask {
    /**
     * 任务编号
     */
    private Long taskId;

    /**
     * 任务状态
     * 默认值为0
     */
    private Short taskStatus;

    /**
     * 设备序列号
     */
    private Long equipmentId;

    /**
     * 传感器序列号
     */
    private Long sensorId;

    /**
     * 架次
     */
    private String sortiesNumber;

    /**
     * 采集人
     */
    private String collectorName;

    /**
     * 被试人
     */
    private String subjectName;

    /**
     * 采集设备
     */
    private String collectionDevice;

    /**
     * 任务类型
     */
    private String taskType;

    /**
     * 任务开始时间 unix微秒级时间戳
     */
    private Long taskStartTime;

    /**
     * 任务创建人
     */
    private String creator;

    /**
     * 任务创建时间 unix微秒级时间戳
     */
    private Long createTime;

    /**
     * 任务修改人
     */
    private String modifier;

    /**
     * 任务修改时间 unix微秒级时间戳
     */
    private Long modificationTime;
}
