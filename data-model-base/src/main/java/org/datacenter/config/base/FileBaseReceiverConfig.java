package org.datacenter.config.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author : [wangminan]
 * @description : 文件接收器基础配置
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class FileBaseReceiverConfig extends BaseReceiverConfig {
    protected DataSourceType dataSourceType = DataSourceType.FILE;
}
