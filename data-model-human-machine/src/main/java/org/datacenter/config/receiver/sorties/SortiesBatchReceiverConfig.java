package org.datacenter.config.receiver.sorties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.datacenter.config.receiver.BaseReceiverConfig;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author : [wangminan]
 * @description : 批次接收配置
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SortiesBatchReceiverConfig extends BaseReceiverConfig implements Serializable {

    @Serial
    private static final long serialVersionUID = 2345678910L;

    /**
     * 接入ID
     */
    private String importId;

    private RunMode runMode;

    /**
     * 批次查询URL /task/dataAsset/queryAllBatches
     */
    private String url;

    /**
     * 批次查询JSON
     * {
     * "acmiTimeEnd": "",
     * "acmiTimeStart": ""
     * }
     * ewogICJhY21pVGltZUVuZCI6ICIiLAogICJhY21pVGltZVN0YXJ0IjogIiIKfQo=
     */
    private String json;

    @Getter
    public enum RunMode {
        AT_ONCE,
        SCHEDULED;

        public static SortiesBatchReceiverConfig.RunMode fromString(String mode) {
            for (SortiesBatchReceiverConfig.RunMode runMode : SortiesBatchReceiverConfig.RunMode.values()) {
                if (runMode.name().equalsIgnoreCase(mode)) {
                    return runMode;
                }
            }
            throw new IllegalArgumentException("Unknown run mode: " + mode);
        }
    }

    @Override
    public boolean validate() {
        return !url.isEmpty() && !json.isEmpty();
    }
}
