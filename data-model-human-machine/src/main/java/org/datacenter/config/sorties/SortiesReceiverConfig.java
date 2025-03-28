package org.datacenter.config.sorties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.datacenter.config.BaseReceiverConfig;

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

    private String sortiesBaseUrl;

    @Override
    public boolean validate() {
        return !sortiesBaseUrl.isEmpty();
    }
}
