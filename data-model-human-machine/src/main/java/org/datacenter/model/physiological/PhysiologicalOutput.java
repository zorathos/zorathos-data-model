package org.datacenter.model.physiological;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author : [wangminan]
 * @description : 生理数据输出基类，包含所有生理数据表共有的字段。所有具体生理数据实体类应继承此基类。
 */
@Data
public class PhysiologicalOutput {
    /**
     * 时间戳
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS", timezone = "GMT+8")
    private LocalDateTime timestamp;

    /**
     * 类型 1：sz  2：地面
     */
    private Short scenario;

    /**
     * 飞行员ID
     */
    private String subjectId;

    /**
     * 任务标识号
     */
    private Long taskId;

    /**
     * 疲劳等级标识（0-非疲劳/1-轻度疲劳/2-重度疲劳）
     */
    private Integer level;

    /**
     * 疲劳类别概率值
     */
    private Float probability;

    /**
     * 疲劳量化值
     */
    private Float score;

    /**
     * 疲劳可选：待确定数据1
     */
    private Float attr1;

    /**
     * 疲劳可选：待确定数据2
     */
    private Float attr2;
}
