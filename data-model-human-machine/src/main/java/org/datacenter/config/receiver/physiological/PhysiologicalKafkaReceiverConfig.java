package org.datacenter.config.receiver.physiological;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.datacenter.config.receiver.BaseReceiverConfig;

/**
 * @author : [wangminan]
 * @description : 生理数据kafka数据接收器配置
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhysiologicalKafkaReceiverConfig extends BaseReceiverConfig {

    private String topic;

    @Override
    public boolean validate() {
        return !topic.isEmpty();
    }
}
