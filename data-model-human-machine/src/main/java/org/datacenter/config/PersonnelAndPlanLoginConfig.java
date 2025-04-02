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
    /**
     * 登录URL http://192.168.0.18/home/login
     */
    private String loginUrl;

    /**
     * 登录请求参数
     * {
     *   "userInput": "user",
     *   "grbsInput": "user",
     *   "passwordInput": "123456",
     * }
     * 输入系统时请做base64编码 否则会在处理parameter的时候被切分
     */
    private String loginJson;


    @Override
    public boolean validate() {
        return !loginUrl.isEmpty() && !loginJson.isEmpty();
    }
}
