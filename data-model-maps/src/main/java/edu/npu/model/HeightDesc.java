package edu.npu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

/**
 * 此类需要严格以Builder模式构建 否则Jackson序列化时会出现问题
 */
@Data
@Builder
public class HeightDesc {

    // 高度类型 推荐MSL
    private HeightType heightType;
    // 高度基准 推荐EGM2008
    @JsonProperty("baseModel")
    private BaseModel baseModel;
    @JsonProperty("baseDEM")
    private BaseDEM baseDEM;

    @Getter
    public enum HeightType {
        // HAE不需要BASE MODEL
        HAE,
        // BaseModel在EGM2008,EMG69,Other里选
        MSL,
        // BaseDEM在DTM和DSM之间选
        AGL;

        public static HeightType fromString(String value) {
            for (HeightType heightType : HeightType.values()) {
                if (heightType.name().equalsIgnoreCase(value)) {
                    return heightType;
                }
            }
            return null;
        }
    }

    @Getter
    public enum BaseModel {
        EGM2008,
        EGM96,
        Other;

        public static BaseModel fromString(String value) {
            for (BaseModel baseModel : BaseModel.values()) {
                if (baseModel.name().equalsIgnoreCase(value)) {
                    return baseModel;
                }
            }
            return null;
        }
    }

    @Getter
    public enum BaseDEM {
        DTM,
        DSM;

        public static BaseDEM fromString(String value) {
            for (BaseDEM baseDEM : BaseDEM.values()) {
                if (baseDEM.name().equalsIgnoreCase(value)) {
                    return baseDEM;
                }
            }
            return null;
        }
    }
}
