package org.datacenter.model.physiological;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author wangminan
 * @description 生理数据基类，包含所有生理数据表共有的字段。所有具体生理数据实体类应继承此基类。
 */
@Data
public abstract class PhysiologicalInputBase {
    /**
     * 原名 Timestamp_BG
     * 采集数据阶段开始时间点
     */
    @JsonProperty("Timestamp_BG")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS", timezone = "GMT+8")
    private LocalDateTime timestampBg;

    /**
     * 原名 Timestamp_ED
     * 采集数据阶段结束时间点
     */
    @JsonProperty("Timestamp_ED")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS", timezone = "GMT+8")
    private LocalDateTime timestampEd;

    /**
     * 原名 Timestamp
     * 时间戳
     */
    @JsonProperty("Timestamp")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS", timezone = "GMT+8")
    private LocalDateTime timestamp;

    /**
     * 原名: Scenario
     * 类型 1：sz  2：地面
     */
    @JsonProperty("Scenario")
    private Short scenario;

    /**
     * 原名: Subject_ID
     * 飞行员ID
     */
    @JsonProperty("Subject_ID")
    private String subjectId;

    /**
     * 原名 Task_ID
     * 任务标识号
     */
    @JsonProperty("Task_ID")
    private Long taskId;

    /**
     * 架次号
     */
    @JsonProperty("Sortie_Number")
    private String sortieNumber;
}
