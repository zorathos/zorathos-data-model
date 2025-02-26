package org.datacenter.model.crew;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 人员信息
 *
 * @author wangminan
 * @description 人员信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Personnel {
    /**
     * id 唯一标识符
     */
    private String id;

    /**
     * 单位代码
     */
    private String unitCode;

    /**
     * 单位简称
     */
    private String unitAbbreviation;

    /**
     * 排序
     */
    private Integer sortOrder;

    /**
     * 姓名
     */
    private String name;

    /**
     * 在编 (0: 否, 1: 是)
     */
    private Byte onStaff;

    /**
     * 在位情况
     */
    private String presenceStatus;

    /**
     * 指挥员 (0: 否, 1: 是)
     */
    private Byte isCommander;

    /**
     * 教员 (0: 否, 1: 是)
     */
    private Byte isInstructor;

    /**
     * 何种长机
     */
    private String aircraftType;

    /**
     * 新（学）员 (0: 否, 1: 是)
     */
    private Byte isTrainee;

    /**
     * 超视距教员 (0: 否, 1: 是)
     */
    private Byte isBvrInstructor;

    /**
     * 代字
     */
    private String codeName;

    /**
     * 作战代号
     */
    private String combatCode;

    /**
     * 飞行总时间（今年）
     */
    private Integer flightHoursThisYear;

    /**
     * 飞行总时间（历年）
     */
    private Integer flightHoursTotal;

    /**
     * 英文代号
     */
    private String englishCode;

    /**
     * 期班
     */
    private String trainingClass;

    /**
     * 部别
     */
    private String department;

    /**
     * 职别
     */
    private String position;

    /**
     * 军衔
     */
    private String rank;

    /**
     * 现飞机型
     */
    private String currentAircraft;

    /**
     * 前后舱 (0: 前舱, 1: 后舱)
     */
    private Byte seatPosition;

    /**
     * 飞行等级
     */
    private String flightLevel;

    /**
     * 任职年月
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date appointmentDate;

    /**
     * 评级年月
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date ratingDate;

    /**
     * 训练层次
     */
    private String trainingLevel;

    /**
     * 最近跳伞（陆）
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastLandParachuteDate;

    /**
     * 最近跳伞（水）
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastWaterParachuteDate;

    /**
     * 最后修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastModifiedTime;
}
