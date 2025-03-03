package org.datacenter.config.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author : [wangminan]
 * @description : Kafka数据接收器基础配置
 */
@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class KafkaBaseReceiverConfig extends BaseReceiverConfig {
    @Builder.Default
    protected DataSourceType dataSourceType = DataSourceType.KAFKA;

    /**
     * 在配置文件中指定的bootstrap sever列表
     * Kafka单体或集群均可
     * 类似于"192.168.0.1:9002,192.168.0.2:9002"这样的字符串
     */
    protected String bootstrapServers;

    /**
     * 消费者组ID
     */
    protected String groupId;

    /**
     * Kafka主题
     */
    protected String topic;
}
