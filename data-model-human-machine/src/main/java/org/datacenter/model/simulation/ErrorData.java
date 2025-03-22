package org.datacenter.model.simulation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonPropertyOrder({"senderId", "messageTime", "localTime", "messageSequenceNumber", "messageId", "messageLength", "errorMessage"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorData {

    /**
     * 架次号
     */
    private String sortieNumber;

    /**
     * 发送方ID
     */
    private String senderId;

    /**
     * 消息时间
     */
    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    private LocalTime messageTime;

    /**
     * 本地时间
     */
    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    private LocalTime localTime;

    /**
     * 消息序列号
     */
    private Long messageSequenceNumber;

    /**
     * 消息标识
     */
    private String messageId;

    /**
     * 消息长度
     */
    private String messageLength;

    /**
     * 错误信息
     */
    private String errorMessage;
}
