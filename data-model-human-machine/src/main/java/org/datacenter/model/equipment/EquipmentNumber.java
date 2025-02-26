package org.datacenter.model.equipment;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 装备编号类，表示装备的编号及相关信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipmentNumber {

    /**
     * 装备编号，主键 和 EquipmentInfo 中的 id 不是一个概念
     */
    private String id;

    /**
     * 出场编号
     */
    private Integer sceneNumber;

    /**
     * 内部编号
     */
    private Integer internalNumber;

    /**
     * 航电版本
     */
    private Integer avionicsVersion;

    /**
     * ICD版本
     */
    private String icdVersion;

    /**
     * ICD启用日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date icdEnableDate;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date creationTime;

    /**
     * 修改人
     */
    private String modifier;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date modificationTime;

    /**
     * 操作，存储为 JSON 格式的数据
     */
    private String operation;
}
