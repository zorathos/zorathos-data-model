package org.datacenter.model.real;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : [wangminan]
 * @description : 响应体中的Property字段 表信息
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssetTableProperty {

    /**
     * 字段ID 源库没有 auto_increment bigint
     */
    private Long id;

    /**
     * 数据资产ID 源接口也没有 手动映射
     */
    private Long modelId;

    /**
     * 字段序号
     */
    private Long code;

    /**
     * 字段名称
     */
    private String name;

    /**
     * 属性类型
     */
    private String type;

    /**
     * 是否时间 在字段类型为Long时判断生效 1是
     */
    private int isTime;

    /**
     * 是否二维展示
     */
    private int twoDDisplay;

    /**
     * 属性标签
     */
    private String label;
}
