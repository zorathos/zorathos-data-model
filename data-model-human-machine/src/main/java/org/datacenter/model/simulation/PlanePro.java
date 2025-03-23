package org.datacenter.model.simulation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanePro {

    /**
     * 架次号
     */
    private String sortieNumber;

    /**
     * 飞机ID
     */
    private String aircraftId;

    /**
     * 飞机代字
     */
    private String aircraftCallsign;

    /**
     * 飞机代号
     */
    private String aircraftCodeName;

    /**
     * 红蓝属性
     */
    private String redBlueAffiliation;

    /**
     * 飞行批次
     */
    private String flightBatch;
}
