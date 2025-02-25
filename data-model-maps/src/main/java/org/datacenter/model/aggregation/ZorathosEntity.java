package org.datacenter.model.aggregation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

import java.util.List;

/**
 * @author wangminan
 * @description 最外层的封装 所有数据落库最终都是这个形式
 * #####-----#####
 * ZorathosEntity
 *  - {@link ZorathosData}
 *    - {@link ZorathosData.CoordinateReferenceSystem}
 *    - {@link HeightDesc}
 *    - {@link PerceivedStatus}
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZorathosEntity {

    /**
     * 默认常量
     */
    @Builder.Default
    private String dataType = "ZORATHOS_BASIC_DATA";
    /**
     * 协议版本
     */
    @Builder.Default
    private String version = "1.0";
    /**
     * 数据上报来源
     */
    @Builder.Default
    private String source = "ZORATHOS";
    private Long uploadTime;
    @Singular
    @JsonProperty("data")
    private List<ZorathosData> zorathosItems;
}
