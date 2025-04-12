package org.datacenter.config;

import lombok.Data;

/**
 * @author : [wangminan]
 * @description : 系统配置基类
 */
@Data
public abstract class BaseConfig {

    /**
     * 从外部加载配置
     */
    public abstract void loadConfig();

    /**
     * 保存配置到外部
     */
    public abstract void saveConfig();
}
