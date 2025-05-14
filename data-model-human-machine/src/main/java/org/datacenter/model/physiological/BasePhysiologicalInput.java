package org.datacenter.model.physiological;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author wangminan
 * @description 生理数据基类，包含所有生理数据表共有的字段。所有具体生理数据实体类应继承此基类。
 */
@Data
public abstract class BasePhysiologicalInput implements Serializable {

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

    @JsonAlias("sampling_rate")
    protected Double samplingRate;
}
