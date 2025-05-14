package org.datacenter.model.crew;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 人员信息类，表示某一人员的详细信息 业务系统中为JSON结构，key值为汉语拼音缩写 需要转换
 *
 * @author wangminan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonnelInfo {

    /**
     * 导入ID
     */
    private Long importId;

    /**
     * 单位代码 DWDM
     */
    @JsonAlias("DWDM")
    private String unitCode;

    /**
     * 单位 DW
     */
    @JsonAlias("DW")
    private String unit;

    /**
     * 个人标识 GRBS
     */
    @JsonAlias("GRBS")
    private String personalIdentifier;

    /**
     * 姓名 XM
     */
    @JsonAlias("XM")
    private String name;

    /**
     * 职务 ZW
     */
    @JsonAlias("ZW")
    private String position;

    /**
     * 性别 XB
     */
    @JsonAlias("XB")
    private String sex;

    /**
     * 任职年月 RZNY
     */
    @JsonAlias("RZNY")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate appointmentDate;

    /**
     * 籍贯 JG
     */
    @JsonAlias("JG")
    private String nativePlace;

    /**
     * 家庭出身 JTCS
     */
    @JsonAlias("JTCS")
    private String familyBackground;

    /**
     * 文化程度 WHCD
     */
    @JsonAlias("WHCD")
    private String educationLevel;

    /**
     * 生日 SR
     */
    @JsonAlias("SR")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate birthday;

    /**
     * 入伍年月 RWNY
     */
    @JsonAlias("RWNY")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate enlistmentDate;

    /**
     * 评级年月 PJNY
     */
    @JsonAlias("PJNY")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate ratingDate;

    /**
     * 毕业学院 BYXY
     */
    @JsonAlias("BYXY")
    private String graduateCollege;

    /**
     * 毕业年月 BYNY
     */
    @JsonAlias("BYNY")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate graduationDate;

    /**
     * 军衔 JX
     */
    @JsonAlias("JX")
    private String militaryRank;

    /**
     * 正副驾驶 ZFJS
     */
    @JsonAlias("ZFJS")
    private String pilotRole;

    /**
     * 飞行等级 FXDJ
     */
    @JsonAlias("FXDJ")
    private String flightLevel;

    /**
     * 现飞机型 XFJX
     */
    @JsonAlias("XFJX")
    private String currentAircraftType;

    /**
     * PXH
     */
    @JsonAlias("PXH")
    private String pxh;

    /**
     * 代号 DH
     */
    @JsonAlias("DH")
    private String codeName;

    /**
     * BM
     */
    @JsonAlias("BM")
    private String bm;

    /**
     * 代字 DZ
     */
    @JsonAlias("DZ")
    private String codeCharacter;

    /**
     * 是否空战指挥员 SFKZZHY
     */
    @JsonAlias("SFKZZHY")
    private String isAirCombatCommander;

    /**
     * 飞行提纲 FXTG
     */
    @JsonAlias("FXTG")
    private String flightOutline;

    /**
     * 长机 ZJ
     */
    @JsonAlias("ZJ")
    private String leadPilot;

    /**
     * 指挥水平（昼间） ZHSP_ZJ
     */
    @JsonAlias("ZHSP_ZJ")
    private String commandLevelDaytime;

    /**
     * 指挥水平（夜间） ZHSP_YJ
     */
    @JsonAlias("ZHSP_YJ")
    private String commandLevelNighttime;

    /**
     * 教员 JY
     */
    @JsonAlias("JY")
    private String instructor;

    /**
     * 理论教员 LLJY
     */
    @JsonAlias("LLJY")
    private String theoreticalInstructor;

    /**
     * ZBZT
     */
    @JsonAlias("ZBZT")
    private String zbzt;

    /**
     * 是否学员 SFXY
     */
    @JsonAlias("SFXY")
    private String isTrainee;

    /**
     * 是否教官 SFJG
     */
    @JsonAlias("SFJG")
    private String isInstructor;

    /**
     * QB
     */
    @JsonAlias("QB")
    private String qb;

    /**
     * 最后跳伞时间（陆） ZHTSSJ_L
     */
    @JsonAlias("ZHTSSJ_L")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate lastParachuteTimeLand;

    /**
     * 最后跳伞时间（水） ZHTSSJ_S
     */
    @JsonAlias("ZHTSSJ_S")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate lastParachuteTimeWater;

    /**
     * 修改时间 XGSJ
     */
    @JsonAlias("XGSJ")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate modificationTime;

    /**
     * 历年总时间 LNZSJ HH:mm
     */
    @JsonAlias("LNZSJ")
    private String totalTimeHistory;

    /**
     * 本年总时间 BNZSJ HH:mm
     */
    @JsonAlias("BNZSJ")
    private String totalTimeCurrentYear;

    /**
     * 历年任教时间 LNRJSJ HH:mm
     */
    @JsonAlias("LNRJSJ")
    private String totalTeachingTimeHistory;
}
