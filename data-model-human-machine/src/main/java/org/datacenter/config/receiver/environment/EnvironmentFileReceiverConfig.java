package org.datacenter.config.receiver.environment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.datacenter.config.receiver.BaseReceiverConfig;

/**
 * @author : [wangminan]
 * @description : 环境离线文件接收器
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnvironmentFileReceiverConfig extends BaseReceiverConfig {
    /**
     * 接入ID
     */
    private Long importId;
    private String url;

    @Override
    public boolean validate() {
        return false;
    }
}
