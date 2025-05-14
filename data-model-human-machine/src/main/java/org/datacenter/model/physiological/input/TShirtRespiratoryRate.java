package org.datacenter.model.physiological.input;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.datacenter.model.physiological.BasePhysiologicalInput;

/**
 * @author : [wangminan]
 * @description : 呼吸率输入
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class TShirtRespiratoryRate extends BasePhysiologicalInput {

    /**
     * 呼吸率
     */
    @JsonAlias("respiratory_rate")
    private Double respiratoryRate;
}
