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
@JsonPropertyOrder({"地防ID", "消息时间", "卫导时间", "本地时间", "消息序列号", "营地类型", "装备类型", "装备ID", "状态", "指北角", "经度", "纬度", "高度", "假阵地编号"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class GTspi {

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

    @JsonProperty(value = "营地类型")
    private String campType;

    @JsonProperty(value = "装备类型")
    private String equipmentType;

    @JsonProperty(value = "装备ID")
    private String equipmentId;

    @JsonProperty(value = "状态")
    private String status;

    @JsonProperty(value = "指北角")
    private String northAngle;

    @JsonProperty(value = "经度")
    private String longitude;

    @JsonProperty(value = "纬度")
    private String latitude;

    @JsonProperty(value = "高度")
    private String altitude;

    @JsonProperty(value = "假阵地编号")
    private String decoyPositionId;
}
