package org.datacenter.model.physiological.input;

import com.fasterxml.jackson.annotation.JsonAlias;
import org.datacenter.model.physiological.BasePhysiologicalInput;

/**
 * @author : [wangminan]
 * @description : 心率输入
 */
public class TShirtHeartRate extends BasePhysiologicalInput {

    /**
     * 心率
     */
    @JsonAlias("heart_rate")
    private Integer heartRate;
}
