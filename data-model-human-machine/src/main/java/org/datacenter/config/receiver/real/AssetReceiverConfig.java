package org.datacenter.config.receiver.real;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.datacenter.config.receiver.BaseReceiverConfig;

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
     * 接入ID
     */
    private Long importId;

    /**
     * 数据资产服务URL http://192.168.10.100:8088/datahandle/asset/getObjectifyAsset
     */
    private String listBaseUrl;

    /**
     * 数据资产列信息配置URL http://192.168.10.100:8088/datahandle/asset/getAssetValidConfig
     */
    private String configBaseUrl;

    /**
     * 数据资产导入的最终输入 架次号
     */
    private String sortieNumber;

    /**
     * Doris的 SQL 地址 是给 DDL 获取用的 只支持标准JDBC连接串的单个host 127.0.0.1:9030
     */
    private String sqlNodes;

    /**
     * Doris FE http 地址，支持多个地址，使用逗号分隔 127.0.0.1:8030
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

    @Override
    public boolean validate() {
        return true;
    }
}
