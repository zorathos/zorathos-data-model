package org.datacenter.config.receiver;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author : [wangminan]
 * @description : Kafka接收器的通用基类配置
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@SuperBuilder
public abstract class BaseKafkaReceiverConfig extends BaseReceiverConfig {
    /**
     * 接入ID
     */
    protected Long importId;
    protected String topic;

    @Override
    public boolean validate() {
        return topic != null && !topic.isEmpty();
    }
}
