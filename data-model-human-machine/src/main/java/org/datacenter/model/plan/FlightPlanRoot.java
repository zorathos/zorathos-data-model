package org.datacenter.model.plan;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author : [wangminan]
 * @description : 飞行计划
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "FLTPLAN")
public class FlightPlanRoot {

    /**
     * 我们自己加的字段 用来做主键ID 必须是String 因为所有数据插入之前都需要写入这个 所以用UUID生成
     */
    private String id;

    /**
     * 从飞行日期接口获取 不在XML中
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate flightDate;

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
        // UUID
        this.id = UUID.randomUUID().toString();
        this.flightCommands = new ArrayList<>();
        this.flightTasks = new ArrayList<>();
        this.flightPlans = new ArrayList<>();
    }

    public static FlightPlanRoot fromXml(String xml) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        FlightPlanRoot root = xmlMapper.readValue(xml, FlightPlanRoot.class);
        root.getFlightHead().setRootId(root.getId());
        root.getFlightNotes().setRootId(root.getId());
        root.getFlightCommands().forEach(flightCmd -> flightCmd.setRootId(root.getId()));
        root.getFlightTasks().forEach(flightTask -> flightTask.setRootId(root.getId()));
        root.getFlightPlans().forEach(flightPlan -> flightPlan.setRootId(root.getId()));
        return root;
    }
}
