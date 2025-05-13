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
 * @description : 架次接收配置
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SortiesReceiverConfig extends BaseReceiverConfig implements Serializable {

    @Serial
    private static final long serialVersionUID = 2134567890L;

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
    public enum RunMode implements Serializable {
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
