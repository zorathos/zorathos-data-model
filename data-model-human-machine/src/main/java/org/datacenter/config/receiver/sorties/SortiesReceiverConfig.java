package org.datacenter.config.receiver.sorties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.datacenter.config.receiver.BaseReceiverConfig;

/**
 * @author : [wangminan]
 * @description : 架次接收配置
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SortiesReceiverConfig extends BaseReceiverConfig {

    /**
     * 接入ID
     */
    private String importId;

    private RunMode runMode;

    /**
     * 架次查询URL /task/dataAsset/querySortiesByBatchId
     */
    private String baseUrl;

    @Getter
    public enum RunMode {
        AT_ONCE,
        SCHEDULED;

        public static RunMode fromString(String mode) {
            for (RunMode runMode : RunMode.values()) {
                if (runMode.name().equalsIgnoreCase(mode)) {
                    return runMode;
                }
            }
            throw new IllegalArgumentException("Unknown run mode: " + mode);
        }
    }

    @Override
    public boolean validate() {
        return !baseUrl.isEmpty();
    }
}
