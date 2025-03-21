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
@JsonPropertyOrder({"地防ID", "消息时间", "卫导时间", "本地时间", "消息序列号", "装备类型", "装备编号", "目标方位角", "目标俯仰角", "目标斜距", "通道号", "目标批号"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class SaTgt {

    /**
     * 主键 auto-incrementing ID
     */
    private Long id;

    /**
     * 架次号
     */
    private String sortieNumber;

    @JsonProperty(value = "地防ID")
    private String groundDefenseId;

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

    @JsonProperty(value = "装备类型")
    private String equipmentType;

    @JsonProperty(value = "装备编号")
    private String equipmentNumber;

    @JsonProperty(value = "目标方位角")
    private String targetAzimuth;

    @JsonProperty(value = "目标俯仰角")
    private String targetElevation;

    @JsonProperty(value = "目标斜距")
    private String targetSlantRange;

    @JsonProperty(value = "通道号")
    private String channelNumber;

    @JsonProperty(value = "目标批号")
    private String targetBatchNumber;
}
