package org.datacenter.config.real;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.datacenter.config.BaseReceiverConfig;

/**
 * @author : [wangminan]
 * @description : 资产接收器配置类
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssetReceiverConfig extends BaseReceiverConfig {
    private String url;
    private String driver;
    private String username;
    private String password;
}
