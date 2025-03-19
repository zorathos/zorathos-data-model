package org.datacenter.model.plan;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : [wangminan]
 * @description : 飞行指挥官
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// 忽略不需要的字段
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightCmd {
    /**
     * 根ID
     */
    private String rootId;

    /**
     * 这个字段是咱自己的 主键 bigint auto increment，源库没有主键
     */
    private Long id;

    /**
     * 姓名
     */
    @JacksonXmlProperty(localName = "XM", isAttribute = true)
    private String name;

    /**
     * 类别
     */
    @JacksonXmlProperty(localName = "LB", isAttribute = true)
    private String lb;

    /**
     * 属性
     */
    @JacksonXmlProperty(localName = "SX", isAttribute = true)
    private String sx;
}
