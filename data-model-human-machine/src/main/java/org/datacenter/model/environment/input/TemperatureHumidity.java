package org.datacenter.model.environment.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.datacenter.model.environment.BaseEnvironmentInput;

/**
 * @author : [wangminan]
 * @description : 温度与湿度传感器
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(callSuper = true)
public class TemperatureHumidity extends BaseEnvironmentInput {

    /**
     * 温度 单位℃
     */
    private Double temperature;

    /**
     * 相对湿度 单位RH
     */
    private Double humidity;
}
