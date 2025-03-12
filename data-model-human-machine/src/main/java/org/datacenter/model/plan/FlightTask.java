package org.datacenter.model.plan;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : [wangminan]
 * @description : 飞行计划中的任务
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// 忽略不需要的字段
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightTask {
    /**
     * 根ID
     */
    private String rootId;

    /**
     * 这个字段是咱自己的 主键 bigint auto increment，源库没有主键
     */
    private long id;

    @JacksonXmlProperty(localName = "XH", isAttribute = true)
    private String xh;

    @JacksonXmlProperty(localName = "DM", isAttribute = true)
    private String dm;

    @JacksonXmlProperty(localName = "XM", isAttribute = true)
    private String xm;

    @JacksonXmlProperty(localName = "RW", isAttribute = true)
    private String rw;
}
