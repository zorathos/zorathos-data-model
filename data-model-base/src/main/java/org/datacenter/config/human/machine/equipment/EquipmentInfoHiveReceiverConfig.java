package org.datacenter.config.human.machine.equipment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.datacenter.config.base.DatabaseJdbcBaseReceiverConfig;

/**
 * @author : [wangminan]
 * @description : 从Hive导入EquipmentInfo的有关配置
 */
@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class EquipmentInfoHiveReceiverConfig extends DatabaseJdbcBaseReceiverConfig {
}
