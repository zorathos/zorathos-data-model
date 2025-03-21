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
@JsonPropertyOrder({"发送方ID", "消息时间", "本地时间", "消息序列号", "消息标识", "消息长度", "错误信息"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorData {


    /**
     * 架次号
     */
    private String sortieNumber;

    @JsonProperty(value = "发送方ID")
    private String senderId;

    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    @JsonProperty(value = "消息时间")
    private LocalTime messageTime;

    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    @JsonProperty(value = "本地时间")
    private LocalTime localTime;

    @JsonProperty(value = "消息序列号")
    private Long messageSequenceNumber;

    @JsonProperty(value = "消息标识")
    private String messageId;

    @JsonProperty(value = "消息长度")
    private String messageLength;

    @JsonProperty(value = "错误信息")
    private String errorMessage;
}
