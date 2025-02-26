package org.datacenter.model.crew;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 人员信息类，表示某一人员的详细信息 业务系统中为JSON结构，key值为汉语拼音缩写 需要转换
 * @author wangminan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonnelInfo {

    /**
     * id（主键） ID
     */
    private String id;

    /**
     * 单位代码 DWDM
     */
    private String unitCode;

    /**
     * 单位 DW
     */
    private String unit;

    /**
     * 个人标识 GRBS
     */
    private String personalIdentifier;

    /**
     * 姓名 XM
     */
    private String name;

    /**
     * 职务 ZW
     */
    private String position;

    /**
     * 任职年月 RZNY
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date appointmentDate;

    /**
     * 籍贯 JG
     */
    private String nativePlace;

    /**
     * 家庭出身 JTCS
     */
    private String familyBackground;

    /**
     * 文化程度 WHCD
     */
    private String educationLevel;

    /**
     * 生日 SR
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;

    /**
     * 入伍年月 RWNY
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date enlistmentDate;

    /**
     * 评级年月 PJNY
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date ratingDate;

    /**
     * 毕业学院 BYXY
     */
    private String graduateCollege;

    /**
     * 毕业年月 BYNY
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date graduationDate;

    /**
     * 军衔 JX
     */
    private String militaryRank;

    /**
     * 正副驾驶 ZFJS
     */
    private String pilotRole;

    /**
     * 飞行等级 FXDJ
     */
    private String flightLevel;

    /**
     * 现飞机型 XJX
     */
    private String currentAircraftModel;

    /**
     * 代号 DH
     */
    private String codeName;

    /**
     * 代字 DZ
     */
    private String codeCharacter;

    /**
     * 是否空战指挥员 SFKZZHY
     */
    private String isAirCombatCommander;

    /**
     * 飞行提纲 FXTG
     */
    private String flightOutline;

    /**
     * 长机 CJ
     */
    private String leadPilot;

    /**
     * 指挥水平（昼间） ZHSP_ZJ
     */
    private String commandLevelDaytime;

    /**
     * 指挥水平（夜间） ZHSP_YJ
     */
    private String commandLevelNighttime;

    /**
     * 教员 JY
     */
    private String instructor;

    /**
     * 理论教员 LLJY
     */
    private String theoreticalInstructor;

    /**
     * 是否学员 SFXY
     */
    private String isTrainee;

    /**
     * 是否教官 SFJJ
     */
    private String isInstructor;

    /**
     * 最后跳伞时间（陆） ZHTSSJ_L
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date lastParachuteTimeLand;

    /**
     * 最后跳伞时间（水） ZHTSSJ_S
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date lastParachuteTimeWater;

    /**
     * 修改时间 XGSJ
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date modificationTime;

    /**
     * 历年总时间 LNZSJ HH:mm
     */
    private String totalTimeHistory;

    /**
     * 本年总时间 BNZSJ HH:mm
     */
    private String totalTimeCurrentYear;

    /**
     * 历年任教时间 LNRJSJ HH:mm
     */
    private String totalTeachingTimeHistory;
}
