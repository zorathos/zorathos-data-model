package org.datacenter.model.simulation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonPropertyOrder({"飞机ID", "飞机代字", "飞机代号", "红蓝属性", "飞行批次"})
public class Sendto3DData {

    /**
     * 主键 auto-incrementing ID
     */
    private Long id;

    @JsonProperty(value = "飞机ID")
    private String aircraftId;  // Or Integer, depending on ID format

    @JsonProperty(value = "飞机代字")
    private String aircraftCallsign;

    @JsonProperty(value = "飞机代号")
    private String aircraftCodeName;

    @JsonProperty(value = "红蓝属性")
    private String redBlueAffiliation; // Or an enum (e.g., enum Affiliation { RED, BLUE })

    @JsonProperty(value = "飞行批次")
    private String flightBatch; // Or Integer
}
