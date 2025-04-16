package org.datacenter.config.receiver.equipment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.datacenter.config.BaseReceiverAndAgentConfig;

/**
 * @author : [wangminan]
 * @description : 装备接收配置
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipmentCodeReceiverAndAgentConfig extends BaseReceiverAndAgentConfig {
    private String host;
    private String port;
    private String database;
    private String username;
    private String password;
    private String table;

    @Override
    public boolean validate() {
        return !host.isEmpty() && !port.isEmpty() && !database.isEmpty() && !username.isEmpty() && !password.isEmpty() && !table.isEmpty();
    }
}
