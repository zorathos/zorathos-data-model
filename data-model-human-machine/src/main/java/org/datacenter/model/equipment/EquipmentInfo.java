package org.datacenter.model.equipment;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 装备类，表示某一型号的装备信息
 * 表名plane_dir
 * @author wangminan
 * @description 装备类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipmentInfo {

    /**
     * 装备型号，主键 和 EquipmentCode 中的 equipmentNumber 不是一个概念 id
     */
    private String id;

    /**
     * 创建时间 create_time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    /**
     * 修改时间 update_time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime modificationTime;

    /**
     * 创建人 create_people
     */
    private String creator;

    /**
     * 更新人 update_people
     */
    private String modifier;

    /**
     * 老id old_id
     */
    private Integer oldId;

    /**
     * 飞机类型 plane_type
     */
    private String planeType;

    /**
     * 装备类型 equipment_type
     */
    private String equipmentType;

    /**
     * 飞机重量 plane_weight
     */
    private Double planeWeight;

    /**
     * 父ID parent_id
     */
    private String parentId;

    /**
     * 三维系统 threetype_system 1三型机 2体系 3小体系 4ACMI
     */
    private Integer _3DSystem;

    /**
     * 是否删除 is_deleted 1删除 2未删除
     */
    private Short isDeleted;

    /**
     * 装备模型 equipment_model
     */
    private String equipmentModel;

    /**
     * 单位 unit
     */
    private String unit;

    /**
     * 工作频段 work_band
     */
    private String workingFrequencyBand;

    /**
     * 经度 longitude
     */
    private Double longitude;

    /**
     * 纬度 latitude
     */
    private Double latitude;

    /**
     * 是否三维回放，1代表是，2代表否 is_three_back
     */
    private Integer is3DPlayback;
}
