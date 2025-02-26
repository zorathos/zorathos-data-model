package org.datacenter.model.acmi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 飞行员信息类，表示飞行员的基本信息
 * @author wangminan
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ACMIPilotInfo {

    /**
     * 人类飞行员姓名
     */
    private String pilotName;

    /**
     * 人类飞行员代号
     */
    private String pilotCode;

    /**
     * 人类飞行员代字
     */
    private String pilotAlias;

    /**
     * 人类飞行员年龄
     */
    private Integer pilotAge;

    /**
     * 现飞机型
     */
    private String currentAircraftModel;
}
