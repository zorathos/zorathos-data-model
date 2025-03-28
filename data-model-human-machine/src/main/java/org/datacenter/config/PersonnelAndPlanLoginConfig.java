package org.datacenter.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author : [wangminan]
 * @description : 登录URL
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonnelAndPlanLoginConfig extends BaseReceiverConfig {
    private String loginUrl;
    private String loginJson;


    @Override
    public boolean validate() {
        return !loginUrl.isEmpty() && !loginJson.isEmpty();
    }
}
