package org.datacenter.config.receiver.plan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.datacenter.config.receiver.BaseReceiverConfig;

/**
 * @author : [wangminan]
 * @description : 飞行计划实施与动态JSON文件接收器配置
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightPlanImplementationAndDynamicJsonFileReceiverConfig extends BaseReceiverConfig {

    /**
     * 接入ID
     */
    private String importId;

    /**
     * 接收器类型
     */
    private FlightPlanReceiverType receiverType;

    /**
     * 飞行计划Json文件在对象存储上的URL s3://开头
     */
    private String url;

    @Override
    public boolean validate() {
        return !url.isEmpty();
    }

    @Getter
    public enum FlightPlanReceiverType {
        DYNAMIC,
        IMPLEMENTATION;
        public static FlightPlanReceiverType fromString(String type) {
            for (FlightPlanReceiverType flightPlanReceiverType : FlightPlanReceiverType.values()) {
                if (flightPlanReceiverType.name().equalsIgnoreCase(type)) {
                    return flightPlanReceiverType;
                }
            }
            throw new IllegalArgumentException("Unknown receiver type: " + type);
        }
    }
}
