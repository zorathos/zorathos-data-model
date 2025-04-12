package org.datacenter.config.receiver.sorties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.datacenter.config.receiver.BaseReceiverConfig;

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
    private String url;

    /**
     * 批次查询JSON
     * {
     *   "acmiTimeEnd": "",
     *   "acmiTimeStart": ""
     * }
     * ewogICJhY21pVGltZUVuZCI6ICIiLAogICJhY21pVGltZVN0YXJ0IjogIiIKfQo=
     */
    private String json;

    @Override
    public boolean validate() {
        return !url.isEmpty() && !json.isEmpty();
    }
}
