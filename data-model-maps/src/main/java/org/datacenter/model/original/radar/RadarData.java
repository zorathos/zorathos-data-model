package org.datacenter.model.original.radar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RadarData {
    private String deviceId;                // 设备ID
    private LocalDateTime timestamp;        // 数据时间戳
    private String protocolType;           // 协议类型
    private Integer frameCount;                // 帧计数
    private float searchDirection;         // 搜索方位
    private Integer searchCycle;              // 搜索周期
    private Integer pulseGroupNumber;         // 当前脉冲组号

    private List<RadarTarget> targets;    // 目标列表

    // 统计信息
    private Integer totalTargetCount;         // 总目标数
    private Integer validTargetCount;         // 有效目标数（信噪比>0且航迹编号不为0）

    // 设备状态
    private Boolean isActive;             // 设备是否活跃
    private String status;                // 设备状态描述

    // 扩展字段，用于存储其他可能需要的信息
    private String extendedInfo;          // 扩展信息
}
