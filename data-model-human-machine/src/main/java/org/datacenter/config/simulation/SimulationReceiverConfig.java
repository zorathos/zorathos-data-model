package org.datacenter.config.simulation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.datacenter.config.BaseReceiverConfig;

/**
 * @author : [wangminan]
 * @description : 仿真数据接收器配置
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SimulationReceiverConfig extends BaseReceiverConfig {
    /**
     * 仿真数据在对象存储上的URL
     */
    private String url;

    /**
     * 仿真数据在对象存储上的架次名
     */
    private String sortieNumber;
}
