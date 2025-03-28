package org.datacenter.config.crew;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.datacenter.config.BaseReceiverConfig;

/**
 * @author : [wangminan]
 * @description : 人员系统接收配置
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonnelReceiverConfig extends BaseReceiverConfig {

    /**
     * 人员系统查询URL http://192.168.0.18/fxy/bindfxylb?dwdm=90121&...
     */
    private String personnelUrl;

    @Override
    public boolean validate() {
        return !personnelUrl.isEmpty();
    }
}
