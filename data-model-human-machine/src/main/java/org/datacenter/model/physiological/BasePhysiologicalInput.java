package org.datacenter.model.physiological;

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
 * @author wangminan
 * @description 生理数据基类，包含所有生理数据表共有的字段。所有具体生理数据实体类应继承此基类。
 */
@Data
// 我们加 SuperBuilder 是为了在子类中使用 @SuperBuilder 注解 这样子类也可以builder.父类属性
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BasePhysiologicalInput implements Serializable {

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

    @JsonAlias("pilot_id")
    protected Long pilotId;

    @JsonAlias("timestamp")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS", timezone = "GMT+8")
    protected LocalDateTime timestamp;
}
