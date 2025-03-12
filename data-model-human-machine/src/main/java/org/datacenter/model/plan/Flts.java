package org.datacenter.model.plan;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.List;

/**
 * @author : [wangminan]
 * @description : 飞行计划
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Flts {
    @JacksonXmlElementWrapper(localName = "FLTS")
    @JacksonXmlProperty(localName = "FLT")
    private List<FlightPlan> flightPlans;
}
