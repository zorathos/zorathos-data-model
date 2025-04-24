package org.datacenter.config.receiver.crew;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.datacenter.config.receiver.BaseReceiverConfig;

/**
 * @author : [wangminan]
 * @description : 人员系统接收配置
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonnelAgentReceiverConfig extends BaseReceiverConfig {

    /**
     * 人员系统查询URL http://192.168.0.18/FXY/BindFxyLb?dwdm=90121&...
     */
    private String url;

    private StartupMode startupMode;

    /**
     * 输出文件的存储路径 是一个本地的地址 在startupMode为JSON_FILE时有效
     */
    private String outputDir;

    @Getter
    public enum StartupMode {
        KAFKA,
        JSON_FILE;

        public static StartupMode fromString(String mode) {
            for (StartupMode startupMode : StartupMode.values()) {
                if (startupMode.name().equalsIgnoreCase(mode)) {
                    return startupMode;
                }
            }
            throw new IllegalArgumentException("Unknown startup mode: " + mode);
        }
    }

    @Override
    public boolean validate() {
        return !url.isEmpty() && !outputDir.isEmpty() && startupMode != null;
    }
}
