package org.datacenter.config.plan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.datacenter.config.base.KafkaBaseReceiverConfig;

/**
 * @author : [wangminan]
 * @description : 飞行计划数据通过接口接收后投递到Kafka，Flink通过Kafka接收
 */
@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightPlanKafkaReceiverConfig extends KafkaBaseReceiverConfig {

}
