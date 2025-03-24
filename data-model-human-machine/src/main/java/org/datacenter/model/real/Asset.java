package org.datacenter.model.real;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : [wangminan]
 * @description 实装飞行 数据资产
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Asset {

    /**
     * 数据资产ID
     */
    private Long id;

    /**
     * 数据资产名称
     */
    private String name;

    /**
     * 数据资产全名
     */
    private String fullName;

    /**
     * 数据资产模型
     */
    private String model;

    /**
     * ICD ID
     */
    private int icdId;

    /**
     * ICD
     */
    private String icd;

    /**
     * 数据库名称
     */
    private String dbName;

    /**
     * 数据来源 来源（0-机载总线 1-ACMI 2-装备 3-数据库）
     */
    private Short source;

    /**
     * 备注
     */
    private String remark;

    /**
     * 对象化标志
     */
    private Integer objectifyFlag;

    /**
     * 复制标志
     */
    private Integer copyFlag;

    /**
     * 标签
     */
    private String labels;

    /**
     * 标签列表
     */
    private List<String> labelList;

    /**
     * 时间帧
     */
    private Integer timeFrame;

    /**
     * 时间类型
     */
    private Integer timeType;
}
