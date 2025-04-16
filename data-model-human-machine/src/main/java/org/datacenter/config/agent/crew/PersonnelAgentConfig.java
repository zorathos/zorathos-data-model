package org.datacenter.config.agent.crew;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.datacenter.config.BaseReceiverAndAgentConfig;

/**
 * @author : [wangminan]
 * @description : 人员系统接收配置
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonnelAgentConfig extends BaseReceiverAndAgentConfig {

    /**
     * 人员系统查询URL http://192.168.0.18/FXY/BindFxyLb?dwdm=90121&...
     */
    private String url;

    @Override
    public boolean validate() {
        return !url.isEmpty();
    }
}
