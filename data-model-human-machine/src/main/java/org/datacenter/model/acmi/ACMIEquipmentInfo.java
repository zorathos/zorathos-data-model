package org.datacenter.model.acmi;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 先进机装备基本信息类，表示飞机装备的基本信息
 * @author wangminan
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ACMIEquipmentInfo {

    /**
     * XXJ飞机号
     */
    private String aircraftNumber;

    /**
     * XXJ出厂编号
     */
    private String aircraftFactoryNumber;

    /**
     * 飞机机型
     */
    private String aircraftModel;

    /**
     * 制造厂
     */
    private String manufacturer;

    /**
     * 出厂日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate factoryDate;

    /**
     * 规定年限
     */
    private Integer specifiedYears;

    /**
     * 规定寿命
     */
    private Integer specifiedLifespan;

    /**
     * 规定起落
     */
    private Integer specifiedTakeOffLandings;

    /**
     * 剩余寿命
     */
    private Integer remainingLifespan;

    /**
     * 可否参训，0表示不可，1表示可
     */
    private Integer canParticipateInTraining;

    /**
     * 可否作战，0表示不可，1表示可
     */
    private Integer canBeUsedInCombat;
}
