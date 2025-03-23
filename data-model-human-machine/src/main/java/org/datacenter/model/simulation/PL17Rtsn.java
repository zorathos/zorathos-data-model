package org.datacenter.model.simulation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PL17Rtsn {

    /**
     * 架次号
     */
    private String sortieNumber;

    /**
     * 飞机ID
     */
    private String aircraftId;

    /**
     * 消息时间
     */
    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    private LocalTime messageTime;

    /**
     * 卫导时间
     */
    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    private LocalTime satelliteGuidanceTime;

    /**
     * 本地时间
     */
    @JsonFormat(pattern = "HH:mm:ss.SSS", timezone = "GMT+8")
    private LocalTime localTime;

    /**
     * 消息序列号
     */
    private Long messageSequenceNumber;

    /**
     * 目标ID
     */
    private String targetId;

    /**
     * 被拦截武器ID
     */
    private String interceptedWeaponId;

    /**
     * 目标实虚属性
     */
    private String targetRealOrVirtual;

    /**
     * 武器ID
     */
    private String weaponId;

    /**
     * 挂架ID
     */
    private String pylonId;

    /**
     * 武器类型
     */
    private String weaponType;

    /**
     * 弹道类型
     */
    private String trajectoryType;

    /**
     * 导弹攻击模式
     */
    private String missileAttackMode;
}
