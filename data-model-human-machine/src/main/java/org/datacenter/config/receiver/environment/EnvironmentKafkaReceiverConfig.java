package org.datacenter.config.receiver.environment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.datacenter.config.receiver.BaseKafkaReceiverConfig;

/**
 * @author : [wangminan]
 * @description : 环境数据Kafka接收器配置
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@SuperBuilder
public class EnvironmentKafkaReceiverConfig extends BaseKafkaReceiverConfig {
}
