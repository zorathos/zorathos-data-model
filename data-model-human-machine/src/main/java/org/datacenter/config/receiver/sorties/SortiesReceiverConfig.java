package org.datacenter.config.receiver.sorties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.datacenter.config.receiver.BaseReceiverConfig;

/**
 * @author : [wangminan]
 * @description : 架次接收配置
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SortiesReceiverConfig extends BaseReceiverConfig {

    /**
     * 架次查询URL /task/dataAsset/querySortiesByBatchId
     */
    private String baseUrl;

    @Override
    public boolean validate() {
        return !baseUrl.isEmpty();
    }
}
