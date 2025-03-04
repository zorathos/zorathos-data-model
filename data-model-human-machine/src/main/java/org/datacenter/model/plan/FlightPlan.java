package org.datacenter.model.plan;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : [wangminan]
 * @description : 飞行计划文件解析，从接口拉出来的是XML格式的飞行计划文件，需要解析成对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JacksonXmlRootElement(localName = "FLT")
public class FlightPlan {

    /**
     * 机场ID JCID
     */
    @JacksonXmlProperty(localName = "JCID")
    private String airportId;

    /**
     * 起飞时间 HH:mm QFSK
     */
    @JacksonXmlProperty(localName = "QFSK")
    private String takeoffTime;

    /**
     * 空战时间 KZSJ
     */
    @JacksonXmlProperty(localName = "KZSJ")
    private String airBattleTime;

    /**
     * YS
     */
    @JacksonXmlProperty(localName = "YS")
    private String ys;

    /**
     * 大纲 DG
     */
    @JacksonXmlProperty(localName = "DG")
    private String outline;

    /**
     * LX
     */
    @JacksonXmlProperty(localName = "LX")
    private String lx;

    /**
     * CS
     */
    @JacksonXmlProperty(localName = "CS")
    private String cs;

    /**
     * 时间 SJ
     */
    @JacksonXmlProperty(localName = "SJ")
    private String sj;

    /**
     * JHLX
     */
    @JacksonXmlProperty(localName = "JHLX")
    private String jhlx;

    /**
     * 计划时间 JHSJ
     */
    @JacksonXmlProperty(localName = "JHSJ")
    private String planTime;

    /**
     * 高度 GD
     */
    @JacksonXmlProperty(localName = "GD")
    private String height;

    /**
     * KY
     */
    @JacksonXmlProperty(localName = "KY")
    private String ky;

    /**
     * FZ
     */
    @JacksonXmlProperty(localName = "FZ")
    private String fz;

    /**
     * BDNO
     */
    @JacksonXmlProperty(localName = "BDNO")
    private String bdno;

    /**
     * 是否长机 SFZJ
     */
    @JacksonXmlProperty(localName = "SFZJ")
    private String isLeaderPlane;

    /**
     * 编队练习 BDLX
     */
    @JacksonXmlProperty(localName = "BDLX")
    private String formationPractice;

    /**
     * 编队数量 BDSL
     */
    @JacksonXmlProperty(localName = "BDSL")
    private String numberOfFormation;

    /**
     * 前舱姓名 QCXM
     */
    @JacksonXmlProperty(localName = "QCXM")
    private String frontName;

    /**
     * 前舱代码 QCDM
     */
    @JacksonXmlProperty(localName = "QCDM")
    private String frontCode;

    /**
     * 前舱代号 QCDH
     */
    @JacksonXmlProperty(localName = "QCDH")
    private String frontCodeName;

    /**
     * 前舱代字 QCDZ
     */
    @JacksonXmlProperty(localName = "QCDZ")
    private String frontNickName;

    /**
     * 前舱性质 QCXZ
     */
    @JacksonXmlProperty(localName = "QCXZ")
    private String frontProperty;

    /**
     * 后舱姓名 HCXM
     */
    @JacksonXmlProperty(localName = "HCXM")
    private String backName;

    /**
     * 后舱代码 HCDM
     */
    @JacksonXmlProperty(localName = "HCDM")
    private String backCode;

    /**
     * 后舱代号 HCDH
     */
    @JacksonXmlProperty(localName = "HCDH")
    private String backCodeName;

    /**
     * 后舱代字 HCDZ
     */
    @JacksonXmlProperty(localName = "HCDZ")
    private String backNickName;

    /**
     * 后舱性质 HCXZ
     */
    @JacksonXmlProperty(localName = "HCXZ")
    private String backProperty;

    /**
     * XSMS
     */
    @JacksonXmlProperty(localName = "XSMS")
    private String xsms;

    /**
     * JKYS
     */
    @JacksonXmlProperty(localName = "JKYS")
    private String jkys;

    /**
     * YXYL
     */
    @JacksonXmlProperty(localName = "YXYL")
    private String yxyl;

    /**
     * WQGZ
     */
    @JacksonXmlProperty(localName = "WQGZ")
    private String wqgz;

    /**
     * GRFA
     */
    @JacksonXmlProperty(localName = "GRFA")
    private String grfa;
}
