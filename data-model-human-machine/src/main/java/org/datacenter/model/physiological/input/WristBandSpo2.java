package org.datacenter.model.physiological.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.datacenter.model.physiological.BasePhysiologicalInput;

/**
 * @author : [wangminan]
 * @description : 手环血氧
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class WristBandSpo2 extends BasePhysiologicalInput {

    /**
     * 血样饱和度 范围0~100%
     */
    private Integer spo2;
}
