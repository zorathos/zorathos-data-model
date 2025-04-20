package org.datacenter.config.integration.simalation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.datacenter.config.integration.BaseIntegrationConfig;

/**
 * @author : [wangminan]
 * @description : [模拟数据集成配置]
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SimulationIntegrationConfig extends BaseIntegrationConfig {
    /**
     * 仿真数据在对象存储上的架次名
     */
    private String sortieNumber;

    @Override
    public boolean validate() {
        return !sortieNumber.isEmpty();
    }
}
