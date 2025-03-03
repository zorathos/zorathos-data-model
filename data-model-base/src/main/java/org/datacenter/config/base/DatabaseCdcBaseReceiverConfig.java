package org.datacenter.config.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author : [wangminan]
 * @description : 数据库配置 使用Flink CDC
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class DatabaseCdcBaseReceiverConfig extends BaseReceiverConfig {
    protected DataSourceType dataSourceType = DataSourceType.DATABASE_CDC;
}
