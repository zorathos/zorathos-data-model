package org.datacenter.config.receiver.plan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.datacenter.config.receiver.BaseReceiverConfig;

/**
 * @author : [wangminan]
 * @description : 航迹系统接收配置
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightPlanAgentReceiverConfig extends BaseReceiverConfig {

    /**
     * 飞行日期URL http://192.168.0.18/fxjh/getfxrq?from=1970-01-01&to=" + today + "&dwdm=90121"
     */
    private String flightDateUrl;

    /**
     * 飞行计划URL http://192.168.0.18/fxdt/BindJHxx?dwdm=90121&_=1742546210611&rq=" + flightDate.getDate().toString()
     * 日期参数由agent拼接
     */
    private String flightCodeUrl;

    /**
     * 获取飞行XML http://192.168.0.18/fxdt/getxml?jhbh=" + planCode.getCode()
     * 计划参数由agent拼接
     */
    private String flightXmlUrl;

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
        return !flightDateUrl.isEmpty() && !flightCodeUrl.isEmpty() && !flightXmlUrl.isEmpty()
                && !outputDir.isEmpty() && startupMode != null;
    }
}
