package org.datacenter.model.environment;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author : [wangminan]
 * @description : 环境基底
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseEnvironmentInput implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 导入ID
     */
    private Long importId;

    @JsonAlias("record_id")
    protected Long recordId;

    @JsonAlias("task_id")
    protected Long taskId;

    @JsonAlias("device_id")
    protected Long deviceId;

    @JsonAlias("timestamp")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS", timezone = "GMT+8")
    protected LocalDateTime timestamp;
}
