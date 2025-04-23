package org.datacenter.model.plan;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : [wangminan]
 * @description : 飞行计划
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "FLTPLAN")
@SuppressWarnings("deprecation")
public class FlightPlanRoot {

    /**
     * 使用系统计划编号
     */
    private String id;

    /**
     * 从飞行日期接口获取 不在XML中
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate flightDate;

    /**
     * 飞行时间 从接口KFSK拿
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime flightDateTime;

    @JacksonXmlProperty(localName = "HEAD")
    private FlightHead flightHead;

    @JacksonXmlProperty(localName = "NOTES")
    private FlightNotes flightNotes;

    @JacksonXmlElementWrapper(localName = "CMDS")
    @JacksonXmlProperty(localName = "CMD")
    private List<FlightCmd> flightCommands;

    @JacksonXmlElementWrapper(localName = "TSKS")
    @JacksonXmlProperty(localName = "TSK")
    private List<FlightTask> flightTasks;

    @JacksonXmlElementWrapper(localName = "FLTS")
    @JacksonXmlProperty(localName = "FLT")
    private List<FlightPlan> flightPlans;

    public FlightPlanRoot() {
        this.flightCommands = new ArrayList<>();
        this.flightTasks = new ArrayList<>();
        this.flightPlans = new ArrayList<>();
    }

    public static FlightPlanRoot fromXml(String xml, String rootId) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        xmlMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        xmlMapper.configure(JsonParser.Feature.INCLUDE_SOURCE_IN_LOCATION, true);
        xmlMapper.configure(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS, true);
        FlightPlanRoot root = xmlMapper.readValue(xml, FlightPlanRoot.class);
        root.setId(rootId);
        root.getFlightHead().setRootId(root.getId());
        root.getFlightNotes().setRootId(root.getId());
        root.getFlightCommands().forEach(flightCmd -> flightCmd.setRootId(root.getId()));
        root.getFlightTasks().forEach(flightTask -> flightTask.setRootId(root.getId()));
        root.getFlightPlans().forEach(flightPlan -> flightPlan.setRootId(root.getId()));
        return root;
    }
}
