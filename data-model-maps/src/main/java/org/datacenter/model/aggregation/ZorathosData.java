package org.datacenter.model.aggregation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Singular;
import org.datacenter.model.aggregation.sensor.Sensor;

import java.util.List;

/**
 * @author wangminan
 * @description 实际的数据内容 第一层
 */
@Data
@Builder
public class ZorathosData {

    /**
     * 传感器
     */
    private Sensor sensor;
    /**
     * 坐标参考系 默认用WGS84
     */
    @Builder.Default
    @JsonProperty("CRS")
    private CoordinateReferenceSystem CRS = CoordinateReferenceSystem.WGS84;
    /**
     * 高度描述符
     */
    private HeightDesc heightDesc;
    /**
     * 感知目标动态
     */
    @Singular
    @JsonProperty("perceivedStatus")
    private List<PerceivedStatus> perceivedStatuses;

    @Getter
    public enum CoordinateReferenceSystem {
        WGS84, // GPS
        CGCS2000, // 北斗
        PZ90; // 格罗纳斯

        public static CoordinateReferenceSystem fromString(String value) {
            for (CoordinateReferenceSystem crs : CoordinateReferenceSystem.values()) {
                if (crs.name().equalsIgnoreCase(value)) {
                    return crs;
                }
            }
            return null;
        }
    }
}
