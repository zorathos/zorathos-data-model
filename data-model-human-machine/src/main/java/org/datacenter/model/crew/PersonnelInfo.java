package org.datacenter.model.crew;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    private String importId;

    /**
     * 单位代码 DWDM
     */
    @JsonProperty("DWDM")
    private String unitCode;

    /**
     * 单位 DW
     */
    @JsonProperty("DW")
    private String unit;

    /**
     * 个人标识 GRBS
     */
    @JsonProperty("GRBS")
    private String personalIdentifier;

    /**
     * 姓名 XM
     */
    @JsonProperty("XM")
    private String name;

    /**
     * 职务 ZW
     */
    @JsonProperty("ZW")
    private String position;

    /**
     * 性别 XB
     */
    @JsonProperty("XB")
    private String sex;

    /**
     * 任职年月 RZNY
     */
    @JsonProperty("RZNY")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate appointmentDate;

    /**
     * 籍贯 JG
     */
    @JsonProperty("JG")
    private String nativePlace;

    /**
     * 家庭出身 JTCS
     */
    @JsonProperty("JTCS")
    private String familyBackground;

    /**
     * 文化程度 WHCD
     */
    @JsonProperty("WHCD")
    private String educationLevel;

    /**
     * 生日 SR
     */
    @JsonProperty("SR")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate birthday;

    /**
     * 入伍年月 RWNY
     */
    @JsonProperty("RWNY")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate enlistmentDate;

    /**
     * 评级年月 PJNY
     */
    @JsonProperty("PJNY")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate ratingDate;

    /**
     * 毕业学院 BYXY
     */
    @JsonProperty("BYXY")
    private String graduateCollege;

    /**
     * 毕业年月 BYNY
     */
    @JsonProperty("BYNY")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate graduationDate;

    /**
     * 军衔 JX
     */
    @JsonProperty("JX")
    private String militaryRank;

    /**
     * 正副驾驶 ZFJS
     */
    @JsonProperty("ZFJS")
    private String pilotRole;

    /**
     * 飞行等级 FXDJ
     */
    @JsonProperty("FXDJ")
    private String flightLevel;

    /**
     * 现飞机型 XFJX
     */
    @JsonProperty("XFJX")
    private String currentAircraftType;

    /**
     * PXH
     */
    @JsonProperty("PXH")
    private String pxh;

    /**
     * 代号 DH
     */
    @JsonProperty("DH")
    private String codeName;

    /**
     * BM
     */
    @JsonProperty("BM")
    private String bm;

    /**
     * 代字 DZ
     */
    @JsonProperty("DZ")
    private String codeCharacter;

    /**
     * 是否空战指挥员 SFKZZHY
     */
    @JsonProperty("SFKZZHY")
    private String isAirCombatCommander;

    /**
     * 飞行提纲 FXTG
     */
    @JsonProperty("FXTG")
    private String flightOutline;

    /**
     * 长机 ZJ
     */
    @JsonProperty("ZJ")
    private String leadPilot;

    /**
     * 指挥水平（昼间） ZHSP_ZJ
     */
    @JsonProperty("ZHSP_ZJ")
    private String commandLevelDaytime;

    /**
     * 指挥水平（夜间） ZHSP_YJ
     */
    @JsonProperty("ZHSP_YJ")
    private String commandLevelNighttime;

    /**
     * 教员 JY
     */
    @JsonProperty("JY")
    private String instructor;

    /**
     * 理论教员 LLJY
     */
    @JsonProperty("LLJY")
    private String theoreticalInstructor;

    /**
     * ZBZT
     */
    @JsonProperty("ZBZT")
    private String zbzt;

    /**
     * 是否学员 SFXY
     */
    @JsonProperty("SFXY")
    private String isTrainee;

    /**
     * 是否教官 SFJG
     */
    @JsonProperty("SFJG")
    private String isInstructor;

    /**
     * QB
     */
    @JsonProperty("QB")
    private String qb;

    /**
     * 最后跳伞时间（陆） ZHTSSJ_L
     */
    @JsonProperty("ZHTSSJ_L")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate lastParachuteTimeLand;

    /**
     * 最后跳伞时间（水） ZHTSSJ_S
     */
    @JsonProperty("ZHTSSJ_S")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate lastParachuteTimeWater;

    /**
     * 修改时间 XGSJ
     */
    @JsonProperty("XGSJ")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate modificationTime;

    /**
     * 历年总时间 LNZSJ HH:mm
     */
    @JsonProperty("LNZSJ")
    private String totalTimeHistory;

    /**
     * 本年总时间 BNZSJ HH:mm
     */
    @JsonProperty("BNZSJ")
    private String totalTimeCurrentYear;

    /**
     * 历年任教时间 LNRJSJ HH:mm
     */
    @JsonProperty("LNRJSJ")
    private String totalTeachingTimeHistory;
}
