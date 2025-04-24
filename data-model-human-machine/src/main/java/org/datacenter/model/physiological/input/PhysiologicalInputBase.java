package org.datacenter.model.physiological.input;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author wangminan
 * @description 生理数据基类，包含所有生理数据表共有的字段。所有具体生理数据实体类应继承此基类。
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhysiologicalInputBase {
    /**
     * 采集数据阶段开始时间点
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS", timezone = "GMT+8")
    private LocalDateTime timestampBg;

    /**
     * 采集数据阶段结束时间点
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS", timezone = "GMT+8")
    private LocalDateTime timestampEd;

    /**
     * 时间戳
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS", timezone = "GMT+8")
    private LocalDateTime timestamp;

    /**
     * 类型 1：sz  2：地面
     */
    private Short scenario;

    /**
     * 飞行员ID
     */
    private String subjectId;

    /**
     * 任务标识号
     */
    private Long taskId;

    /**
     * 架次号
     */
    private String sortieNumber;
}
