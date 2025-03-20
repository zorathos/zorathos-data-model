package org.datacenter.model.equipment;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 装备编号类，表示装备的编号及相关信息
 * 表名plane_code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipmentCode {

    /**
     * 装备编号，主键 和 EquipmentInfo 中的 id 不是一个概念 id
     */
    private String id;

    /**
     * 创建人 create_people
     */
    private String creator;

    /**
     * 创建时间 create_time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    /**
     * 修改人 update_people
     */
    private String modifier;

    /**
     * 修改时间 update_time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime modificationTime;

    /**
     * 老ID old_id
     */
    private Integer oldId;

    /**
     * 飞机老ID plane_old_id
     */
    private Integer planeOldId;

    /**
     * 涂装号 c_coat
     */
    private String cCoat;

    /**
     * 内部编号 c_interior
     */
    private String cInterior;

    /**
     * 出厂编号 c_manufacturing
     */
    private String cManufacturing;

    /**
     * icd版本 icd_version
     */
    private String icdVersion;

    /**
     * 航电系统版本 avionics_system_version
     */
    private String avionicsSystemVersion;

    /**
     * is_used 是否被启用，1启用，2未启用
     */
    private Short isUsed;

    /**
     * 是否删除 删除标记位，1正常，2删除
     */
    private Short isDeleted;

    /**
     * 使用时间 yyyy-MM-dd used_time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime usedTime;

    /**
     * icd_version_id
     */
    private String icdVersionId;
}
