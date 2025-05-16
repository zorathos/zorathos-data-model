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
 * @description : [光照强度]
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(callSuper = true)
public class Illuminance extends BaseEnvironmentInput {

    /**
     * 光照强度 单位lx
     */
    private Double illuminance;
}
