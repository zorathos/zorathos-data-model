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
    private String sortiesBatchUrl;
    private String sortiesBatchJson;

    @Override
    public boolean validate() {
        return !sortiesBatchUrl.isEmpty() && !sortiesBatchJson.isEmpty();
    }
}
