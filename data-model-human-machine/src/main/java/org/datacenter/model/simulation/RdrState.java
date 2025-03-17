package org.datacenter.model.simulation;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * RDRState Data Record
 * Represents the data recorded from the radar system state.
 * Each field corresponds to a specific parameter from the RDRState data.
 *
 * @author wangminan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RdrState {

    /**
     * 主键，自增ID
     */
    private Long id;

    /**
     * 数据记录时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime timestamp;

    /**
     * 雷达工作模式：
     * 单目标跟踪（STT，1）
     * 多目标跟踪（MTT，2）
     * 态势探查模式（SAM，3）
     * 锁定模式（HPT，4）
     */
    private Short radarMode;

    /**
     * 开关机状态：
     * 关机（0），开机（1）
     */
    private Short powerStatus;

    /**
     * 辐射状态：
     * 静默（0），辐射（1）
     */
    private Short radiationStatus;

    /**
     * 保留字段，用于未来扩展
     */
    private Integer reserved;
}
