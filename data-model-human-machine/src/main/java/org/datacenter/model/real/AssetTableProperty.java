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
     * 字段序号
     */
    private Long code;

    /**
     * 字段名称
     */
    private String name;

    /**
     * 字段类型
     */
    private String type;

    /**
     * 是否时间 在字段类型为Long时判断生效 1是
     */
    private int isTime;
    private int twoDDisplay;
    private String label;
}
