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
public abstract class KafkaBaseConfig extends BaseConfig{
    @Builder.Default
    protected DataSourceType dataSourceType = DataSourceType.KAFKA;
}
