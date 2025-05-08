package org.datacenter.model.sorties;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : [wangminan]
 * @description : 飞行批次
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class SortiesBatch {
    /**
     * 主键ID
     */
    private String id;

    /**
     * 批次号 包含一组对抗数据 ATC-3程_辛_鸿陈_泽彦+ATCs青_林_鹏辉
     */
    private String batchNumber;
}
