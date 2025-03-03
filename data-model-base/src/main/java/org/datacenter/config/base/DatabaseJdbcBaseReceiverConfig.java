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
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class DatabaseJdbcBaseReceiverConfig extends BaseReceiverConfig {
    @Builder.Default
    protected DataSourceType dataSourceType = DataSourceType.DATABASE_JDBC;
}
