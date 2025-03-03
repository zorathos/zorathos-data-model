package org.datacenter.config.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author : [wangminan]
 * @description : 数据库JDBC接收器配置
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class DatabaseJdbcBaseReceiverConfig extends BaseReceiverConfig {
    protected DataSourceType dataSourceType = DataSourceType.DATABASE_JDBC;
}
