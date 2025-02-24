package edu.npu.model.aggregation.aircraft;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author : [wangminan]
 * @description : 对地的速度
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroundVelocity extends BaseVelocity {

    /**
     * 感知设备对飞行物探测分析得到的，在跟踪采样时刻，飞行物在水平方向的飞行速度，也即实际相对地球表面飞行的速度
     * 0-1000 精确到小数点后1位 米/秒
     */
    @JsonProperty("GS")
    private Double gs;
    /**
     * 垂直飞行速度 上升正 下降负
     * -1000~1000 精确到小数点后1位 米/秒
     */
    @JsonProperty("VS")
    private Double vs;
    /**
     * 飞行物的航向角，即飞行物的航向与正北方向的夹角，逆时针方向增加
     * [0,360) 精确到小数点后1位
     */
    private Double trackAngle;
    /**
     * 地速标准差
     * 0-100 精确到小数点后2位 米/秒
     */
    private Double deltaGS;
    /**
     * 垂直速度标准差
     * 0-100 精确到小数点后2位 米/秒
     */
    private Double deltaVS;
}
