package org.datacenter.model.sorties;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author : [wangminan]
 * @description : 飞行架次数据 注意与飞行计划进行区分
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sorties {
    public static final String END_SIGNAL_PREFIX = "END_SIGNAL_";

    /**
     * 导入ID
     */
    private Long importId;

    /**
     * 机型
     */
    private String airplaneModel;

    /**
     * 机号
     */
    private String airplaneNumber;

    /**
     * 武器类型
     */
    private String armType;

    /**
     * 批次
     */
    private String batchNumber;

    /**
     * 阵营 BIGINT
     */
    private Long camp;

    /**
     * 阵营说明
     */
    private String campStr;

    /**
     * 开关车结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime carEndTime;

    /**
     * 开关车开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime carStartTime;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    /**
     * 后舱飞行员
     */
    private String downPilot;

    /**
     * 文件ID BIGINT
     */
    private String folderId;

    /**
     * 文件名称
     */
    private String folderName;

    /**
     * ICD 版本
     */
    private String icdVersion;

    /**
     * 插值精度
     */
    private Long interpolation;

    /**
     * 架次是否有效 BIGINT
     */
    private Long isEffective;

    /**
     * 架次是否有效
     */
    private String isEffectiveName;

    /**
     * 任务地点
     */
    private String location;

    /**
     * 飞行员代字
     */
    private String pilot;

    /**
     * 嵌训ID
     */
    private String qxId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 角色 BIGINT
     */
    private Long role;

    /**
     * 角色说明
     */
    private String roleStr;

    /**
     * 空中时间
     */
    private String skyTime;

    /**
     * 主键ID
     */
    private String sortieId;

    /**
     * 架次编号
     */
    private String sortieNumber;

    /**
     * 来源 BIGINT
     */
    private Long source;

    /**
     * 飞机隐身状态 BIGINT
     */
    private Long stealth;

    /**
     * 飞机隐身状态说明
     */
    private String stealthStr;

    /**
     * 科目
     */
    private String subject;

    /**
     * 敌我识别同步系统
     */
    private Long syncSystem;

    /**
     * 敌我识别同步系统说明
     */
    private String syncSystemStr;

    /**
     * 试驾编号 BIGINT
     */
    private Long testDrive;

    /**
     * 试驾编号说明
     */
    private String testDriveStr;

    /**
     * 前舱飞行员
     */
    private String upPilot;
}
