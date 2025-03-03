package org.datacenter.config.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : [wangminan]
 * @description : 基础配置
 */
@Data
public abstract class BaseReceiverConfig {
    protected DataSourceType dataSourceType;
}
