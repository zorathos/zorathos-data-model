package org.datacenter.config.receiver.simulation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.datacenter.config.BaseReceiverAndAgentConfig;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author : [wangminan]
 * @description : 仿真数据接收器配置
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SimulationReceiverAndAgentConfig extends BaseReceiverAndAgentConfig implements Serializable {

    @Serial
    private static final long serialVersionUID = 123143L;

    /**
     * 仿真数据在对象存储上的URL
     */
    private String url;

    /**
     * 仿真数据在对象存储上的架次名
     */
    private String sortieNumber;

    @Override
    public boolean validate() {
        return true;
    }
}
