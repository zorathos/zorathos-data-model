package org.datacenter.config.receiver.plan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.datacenter.config.receiver.BaseReceiverConfig;

/**
 * @author : [wangminan]
 * @description : 飞行计划JSON文件接收器配置
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightPlanJsonFileReceiverConfig extends BaseReceiverConfig {
    /**
     * 飞行计划Json文件在对象存储上的URL s3://开头
     */
    private String url;

    @Override
    public boolean validate() {
        return !url.isEmpty();
    }
}
