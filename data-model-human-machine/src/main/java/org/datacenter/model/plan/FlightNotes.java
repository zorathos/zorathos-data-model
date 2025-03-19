package org.datacenter.model.plan;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : [wangminan]
 * @description : 备注
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// 忽略不需要的字段
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightNotes {

    /**
     * 根ID
     */
    private String rootId;

    /**
     * 这个字段是咱自己的 主键 bigint auto increment，源库没有主键
     */
    private Long id;

    @JacksonXmlProperty(localName = "NOTE", isAttribute = true)
    private String note;
}
