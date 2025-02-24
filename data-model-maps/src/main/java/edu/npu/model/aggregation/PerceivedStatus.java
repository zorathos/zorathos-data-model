/**
 * Copyright 2025 bejson.com
 */
package edu.npu.model.aggregation;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.npu.model.aggregation.aircraft.BasePosition;
import edu.npu.model.aggregation.aircraft.BaseVelocity;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Singular;

import java.time.Duration;
import java.util.List;

/**
 * @author wangminan
 * @description 感知目标动态
 */
@Data
@Builder
public class PerceivedStatus {

    /**
     * 跟踪飞行活动编号，这玩意需要是唯一的
     * 格式:50位以内文本字符。30位以内飞行物唯一标识码(objectID)-8位跟踪日期(YYYYMMDD)-10位(数字或字母均可)以内随机码
     */
    private String trackID;
    /**
     * 飞行物唯一标识码，这玩意可以重复，飞行物可以重复出现
     * 格式:30位以内文本字符。10位以内上报方身份标识(Source)-19位以内上报方内部分配飞行物唯一标识码。
     */
    private String objectID;
    /**
     * 采集时间戳 unix 精确到毫秒
     */
    private Long sampleTime;
    /**
     * 累计采集时长 采用ISO8601格式 以PT开头
     */
    private String trackDuration;
    /**
     * 跟踪飞行物状态
     */
    private FlightStage flightStage;
    /**
     * 目标位置与精度
     */
    @Singular
    @JsonProperty("objectPosition")
    private List<BasePosition> objectPositions;
    /**
     * 飞行目标速度与精度
     */
    @Singular
    @JsonProperty("objectVelocity")
    private List<BaseVelocity> objectVelocities;
    /**
     * 对目标的补充描述
     */
    private ObjectStatusExtra objectStatusExtra;

    public void setTrackDuration(long milliseconds) {
        // 转duration后toString直接得到ISO8601格式
        Duration duration = Duration.ofMillis(milliseconds);
        this.trackDuration = duration.toString();
    }

    @Getter
    public enum FlightStage {
        Begin,
        TakingOff,
        Cruising,
        Landing,
        End;

        public FlightStage fromString(String value) {
            for (FlightStage stage : FlightStage.values()) {
                if (stage.name().equalsIgnoreCase(value)) {
                    return stage;
                }
            }
            return null;
        }
    }
}
