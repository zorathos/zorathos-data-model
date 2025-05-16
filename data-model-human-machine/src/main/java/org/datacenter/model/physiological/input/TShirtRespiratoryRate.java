package org.datacenter.model.physiological.input;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.datacenter.model.physiological.BasePhysiologicalInput;

/**
 * @author : [wangminan]
 * @description : 呼吸率输入
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(callSuper = true)
public class TShirtRespiratoryRate extends BasePhysiologicalInput {

    /**
     * 呼吸率
     */
    @JsonAlias("respiratory_rate")
    private Double respiratoryRate;
}
