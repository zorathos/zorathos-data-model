package org.datacenter.model.equipment;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 装备类，表示某一型号的装备信息
 * @author wangminan
 * @description 装备类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipmentInfo {

    /**
     * 装备型号，主键 和 EquipmentNumber 中的 equipmentNumber 不是一个概念
     */
    private String id;

    /**
     * 装备重量
     */
    private Double equipmentWeight;

    /**
     * 是否三维回放，1代表是，0代表否
     */
    private Integer is3DPlayback;

    /**
     * 装备类型
     */
    private String equipmentType;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date creationTime;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 操作，存储为 JSON 格式的数据
     */
    private String operation;

}
