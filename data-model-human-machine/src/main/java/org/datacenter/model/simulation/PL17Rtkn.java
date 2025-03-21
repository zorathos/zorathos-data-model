package org.datacenter.model.simulation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonPropertyOrder({"飞机ID", "消息时间", "卫导时间", "本地时间", "消息序列号", "武器ID", "武器类型", "目标ID", "目标机实虚属性", "命中结果", "未命中原因", "脱靶量", "匹配失败原因", "干扰是否有效", "干扰", "加力", "迎头", "航向", "俯仰"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class PL17Rtkn {

    /**
     * 主键 auto-incrementing ID
     */
    private Long id;

    /**
     * 架次号 分区键
     */
    private String sortieNumber;

    @JsonProperty(value = "飞机ID")
    private String aircraftId;

    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    @JsonProperty(value = "消息时间")
    private LocalTime messageTime;

    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    @JsonProperty(value = "卫导时间")
    private LocalTime satelliteGuidanceTime;

    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    @JsonProperty(value = "本地时间")
    private LocalTime localTime;

    @JsonProperty(value = "消息序列号")
    private Long messageSequenceNumber;

    @JsonProperty(value = "武器ID")
    private String weaponId;

    @JsonProperty(value = "武器类型")
    private String weaponType;

    @JsonProperty(value = "目标ID")
    private String targetId;

    @JsonProperty(value = "目标机实虚属性")
    private String targetRealOrVirtual;

    @JsonProperty(value = "命中结果")
    private String hitResult;

    @JsonProperty(value = "未命中原因")
    private String missReason;

    @JsonProperty(value = "脱靶量")
    private String missDistance;

    @JsonProperty(value = "匹配失败原因")
    private String matchingFailureReason;

    @JsonProperty(value = "干扰是否有效")
    private String jammingEffective;

    @JsonProperty(value = "干扰")
    private String jamming;

    @JsonProperty(value = "加力")
    private String afterburner;

    @JsonProperty(value = "迎头")
    private String headOn;

    @JsonProperty(value = "航向")
    private String heading;

    @JsonProperty(value = "俯仰")
    private String pitch;
}
