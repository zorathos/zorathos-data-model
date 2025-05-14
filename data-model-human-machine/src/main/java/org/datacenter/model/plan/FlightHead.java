package org.datacenter.model.plan;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents the HEAD element in the flight plan XML.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// 忽略不需要的字段
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightHead {
    /**
     * 导入ID
     */
    private Long importId;

    /**
     * 根ID
     */
    private String rootId;

    /**
     * 这个字段是咱自己的 主键 bigint auto increment，源库没有主键
     */
    private Long id;

    /**
     * 版本
     */
    @JacksonXmlProperty(localName = "VER", isAttribute = true)
    private String ver;

    /**
     * 标题
     */
    @JacksonXmlProperty(localName = "TITLE", isAttribute = true)
    private String title;

    /**
     * 时间线
     */
    @JacksonXmlProperty(localName = "TIMELINE", isAttribute = true)
    private String timeline;

    /**
     * 模式
     */
    @JacksonXmlProperty(localName = "TMODE", isAttribute = true)
    private String tMode;

    /**
     * 计划数量
     */
    @JacksonXmlProperty(localName = "PLANENUM", isAttribute = true)
    private Integer planeNum;

    /**
     * 开飞时刻
     */
    @JacksonXmlProperty(localName = "KFSK", isAttribute = true)
    private Integer flightsTime;

    /**
     * 总场时间
     */
    @JacksonXmlProperty(localName = "ZCSJ", isAttribute = true)
    private Integer totalTime;

    /**
     * 退离时刻
     */
    @JacksonXmlProperty(localName = "TLSK", isAttribute = true)
    private Integer exitTime;

    /**
     * 日出时刻
     */
    @JacksonXmlProperty(localName = "RCSK", isAttribute = true)
    private String sunRiseTime;

    /**
     * 日落时刻
     */
    @JacksonXmlProperty(localName = "RLSK", isAttribute = true)
    private String sunSetTime;

    /**
     * 天黑时刻
     */
    @JacksonXmlProperty(localName = "THSK", isAttribute = true)
    private String darkTime;

    /**
     * 天亮时刻
     */
    @JacksonXmlProperty(localName = "TTHH", isAttribute = true)
    private String dawnTime;

    /**
     * 大小天亮时刻
     */
    @JacksonXmlProperty(localName = "DXTHH", isAttribute = true)
    private String dxthh;

    /**
     * 中午时刻
     */
    @JacksonXmlProperty(localName = "ZHSHH", isAttribute = true)
    private String zhshh;

    /**
     * 低温设备型号
     */
    @JacksonXmlProperty(localName = "DWSBXH", isAttribute = true)
    private String dwsbxh;
}
