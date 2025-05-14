package org.datacenter.config.receiver.simulation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.datacenter.config.receiver.BaseReceiverConfig;

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
public class SimulationReceiverConfig extends BaseReceiverConfig implements Serializable {

    @Serial
    private static final long serialVersionUID = 123143L;

    /**
     * 仿真数据在对象存储上的URL
     */
    private String url;

    /**
     * 接入ID
     */
    private long importId;

    /**
     * 仿真数据在对象存储上的批次名
     */
    private String batchNumber;

    @Override
    public boolean validate() {
        return true;
    }
}
