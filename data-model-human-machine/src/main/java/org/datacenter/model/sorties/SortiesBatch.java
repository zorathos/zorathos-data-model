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
     * 批次号
     */
    private String batchNumber;
}
