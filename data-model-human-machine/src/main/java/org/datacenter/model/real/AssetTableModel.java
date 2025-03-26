package org.datacenter.model.real;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : [wangminan]
 * @description : DataAsset的简化字段 用于标定表信息
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssetTableModel {

    /**
     * id
     */
    private Long id;

    /**
     * 架次号
     */
    private String sortieNumber;

    /**
     * 数据资产id
     */
    private Long assetId;

    /**
     * ICD版本号
     */
    private Long icdId;

    /**
     * 模型名称
     */
    private String name;

    /**
     * 是否主表
     */
    private Integer isMaster;

    /**
     * 重复间隔
     */
    private int repeatInterval;

    /**
     * 重复次数
     */
    private int repeatTimes;
}
