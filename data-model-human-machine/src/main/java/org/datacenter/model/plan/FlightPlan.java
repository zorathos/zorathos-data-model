package org.datacenter.model.plan;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
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
// 忽略不需要的字段
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightPlan {

    /**
     * 根ID
     */
    private String rootId;

    /**
     * 这个字段是咱自己的 主键 bigint auto increment，源库没有主键
     */
    private Long id;

    /**
     * 机场ID JCID
     */
    @JacksonXmlProperty(localName = "JCID", isAttribute = true)
    private String airportId;

    /**
     * 起飞时间 HH:mm QFSK
     */
    @JacksonXmlProperty(localName = "QFSK", isAttribute = true)
    private String takeoffTime;

    /**
     * 空战时间 KZSK
     */
    @JacksonXmlProperty(localName = "KZSK", isAttribute = true)
    private String airBattleTime;

    /**
     * YS
     */
    @JacksonXmlProperty(localName = "YS", isAttribute = true)
    private String ys;

    /**
     * 大纲 DG
     */
    @JacksonXmlProperty(localName = "DG", isAttribute = true)
    private String outline;

    /**
     * LXH
     */
    @JacksonXmlProperty(localName = "LXH", isAttribute = true)
    private String lxh;

    /**
     * CS
     */
    @JacksonXmlProperty(localName = "CS", isAttribute = true)
    private String cs;

    /**
     * 时间 SJ
     */
    @JacksonXmlProperty(localName = "SJ", isAttribute = true)
    private String sj;

    /**
     * JHLX
     */
    @JacksonXmlProperty(localName = "JHLX", isAttribute = true)
    private String jhlx;

    /**
     * 计划时间 JHSJ
     */
    @JacksonXmlProperty(localName = "JHSJ", isAttribute = true)
    private String planTime;

    /**
     * 高度 GD
     */
    @JacksonXmlProperty(localName = "GD", isAttribute = true)
    private String height;

    /**
     * KY
     */
    @JacksonXmlProperty(localName = "KY", isAttribute = true)
    private String ky;

    /**
     * FZ
     */
    @JacksonXmlProperty(localName = "FZ", isAttribute = true)
    private String fz;

    /**
     * BDNO
     */
    @JacksonXmlProperty(localName = "BDNO", isAttribute = true)
    private String bdno;

    /**
     * 是否长机 SFZJ
     */
    @JacksonXmlProperty(localName = "SFZJ", isAttribute = true)
    private String isLeaderPlane;

    /**
     * 编队练习 BDLX
     */
    @JacksonXmlProperty(localName = "BDLX", isAttribute = true)
    private String formationPractice;

    /**
     * 编队数量 BDSL
     */
    @JacksonXmlProperty(localName = "BDSL", isAttribute = true)
    private String numberOfFormation;

    /**
     * 前舱姓名 QCXM
     */
    @JacksonXmlProperty(localName = "QCXM", isAttribute = true)
    private String frontName;

    /**
     * 前舱代码 QCDM
     */
    @JacksonXmlProperty(localName = "QCDM", isAttribute = true)
    private String frontCode;

    /**
     * 前舱代号 QCDH
     */
    @JacksonXmlProperty(localName = "QCDH", isAttribute = true)
    private String frontCodeName;

    /**
     * 前舱代字 QCDZ
     */
    @JacksonXmlProperty(localName = "QCDZ", isAttribute = true)
    private String frontNickName;

    /**
     * 前舱性质 QCXZ
     */
    @JacksonXmlProperty(localName = "QCXZ", isAttribute = true)
    private String frontProperty;

    /**
     * 后舱姓名 HCXM
     */
    @JacksonXmlProperty(localName = "HCXM", isAttribute = true)
    private String backName;

    /**
     * 后舱代码 HCDM
     */
    @JacksonXmlProperty(localName = "HCDM", isAttribute = true)
    private String backCode;

    /**
     * 后舱代号 HCDH
     */
    @JacksonXmlProperty(localName = "HCDH", isAttribute = true)
    private String backCodeName;

    /**
     * 后舱代字 HCDZ
     */
    @JacksonXmlProperty(localName = "HCDZ", isAttribute = true)
    private String backNickName;

    /**
     * 后舱性质 HCXZ
     */
    @JacksonXmlProperty(localName = "HCXZ", isAttribute = true)
    private String backProperty;

    /**
     * XSMS
     */
    @JacksonXmlProperty(localName = "XSMS", isAttribute = true)
    private String xsms;

    /**
     * JKYS
     */
    @JacksonXmlProperty(localName = "JKYS", isAttribute = true)
    private String jkys;

    /**
     * YXYL
     */
    @JacksonXmlProperty(localName = "YXYL", isAttribute = true)
    private String yxyl;

    /**
     * WQGZ
     */
    @JacksonXmlProperty(localName = "WQGZ", isAttribute = true)
    private String wqgz;

    /**
     * GRFA
     */
    @JacksonXmlProperty(localName = "GRFA", isAttribute = true)
    private String grfa;
}
