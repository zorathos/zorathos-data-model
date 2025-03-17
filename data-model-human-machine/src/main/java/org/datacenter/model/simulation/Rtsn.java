package org.datacenter.model.simulation;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * RTSN Data Record
 * Represents the RTSN data recorded by the system.
 * Each field corresponds to a specific parameter from the RTSN data.
 *
 * @author wangminan
 */
@Data
public class Rtsn {

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
     * 发射空空武器时的雷达融合编号，超出范围填 0；
     * 参训装备（1-180），保留（181-255）
     */
    private Short targetId;

    /**
     * 目标的实虚属性：
     * 无效（0），实体目标（1），模拟器（2），虚拟目标（3）
     */
    private Short targetType;

    /**
     * 武器类型：
     * 空空武器（1-80），保留（81-242），地导类型（243-254），航炮（255）
     */
    private Short weaponType;

    /**
     * 武器挂架ID，范围 1-63，超出范围填 0
     */
    private Short pylonId;

    /**
     * 武器ID，各发射平台依次计数，循环递增，范围 1-63，超出范围填 0
     */
    private Short weaponId;
}
