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
    /**
     * 数据资产导入的最终输入 架次号
     */
    private String sortieNumber;

    /**
     * Doris FE http 地址，支持多个地址，使用逗号分隔
     */
    private String feNodes;

    /**
     * Doris库的用户名
     */
    private String username;

    /**
     * Doris库的密码
     */
    private String password;
}
