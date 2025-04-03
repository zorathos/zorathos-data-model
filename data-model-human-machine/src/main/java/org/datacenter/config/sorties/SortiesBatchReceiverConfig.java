package org.datacenter.config.sorties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.datacenter.config.BaseReceiverConfig;

/**
 * @author : [wangminan]
 * @description : 批次接收配置
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SortiesBatchReceiverConfig extends BaseReceiverConfig {

    /**
     * 批次查询URL /task/dataAsset/queryAllBatches
     */
    private String sortiesBatchUrl;

    /**
     * 批次查询JSON
     * {
     *   "acmiTimeEnd": "",
     *   "acmiTimeStart": ""
     * }
     * ewogICJhY21pVGltZUVuZCI6ICIiLAogICJhY21pVGltZVN0YXJ0IjogIiIKfQo=
     */
    private String sortiesBatchJson;

    @Override
    public boolean validate() {
        return !sortiesBatchUrl.isEmpty() && !sortiesBatchJson.isEmpty();
    }
}
