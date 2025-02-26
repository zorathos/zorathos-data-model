package org.datacenter.model.acmi;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 先进机架次计划数据类，表示飞机的飞行计划信息
 * @author wangminan
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ACMISchedule {

    /**
     * XXJ飞机号
     */
    private String aircraftNumber;

    /**
     * 飞机机型
     */
    private String aircraftModel;

    /**
     * 飞行科目
     */
    private String flightSubject;

    /**
     * 前舱人类飞行员姓名
     */
    private String frontCockpitPilotName;

    /**
     * 后舱人类飞行员姓名
     */
    private String rearCockpitPilotName;

    /**
     * 前舱人类飞行员代号
     */
    private String frontCockpitPilotCode;

    /**
     * 后舱人类飞行员代号
     */
    private String rearCockpitPilotCode;

    /**
     * 前舱人类飞行员代字
     */
    private String frontCockpitPilotAlias;

    /**
     * 后舱人类飞行员代字
     */
    private String rearCockpitPilotAlias;

    /**
     * 开车时刻
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private LocalDateTime startTime;

    /**
     * 起飞时刻
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private LocalDateTime takeOffTime;

    /**
     * 转换时刻
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private LocalDateTime transitionTime;

    /**
     * 着陆时刻
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private LocalDateTime landingTime;

    /**
     * 关车时刻
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private LocalDateTime shutDownTime;
}
