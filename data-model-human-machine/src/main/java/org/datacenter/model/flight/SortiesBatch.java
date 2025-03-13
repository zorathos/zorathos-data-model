package org.datacenter.model.flight;

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
public class SortiesBatch {
    /**
     * 主键ID
     */
    private String id;

    /**
     * 批次号
     */
    private String batchNumber;
}
