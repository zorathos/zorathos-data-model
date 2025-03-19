package org.datacenter.model.original.radar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RadarTarget {
    private float xCoordinate;
    private float yCoordinate;
    private float zCoordinate;
    private float xSpeed;
    private float ySpeed;
    private float zSpeed;

    private Integer targetId;

    private Double snr; // 信噪比
    private Double rcs; // 反射截面积
    private Integer targetType;
    private Integer selectionFlag;

    // 计算后的数据

    private Double range; // 轴向距离

    private Double azimuth1; // 方位角 (以转台0度为基准)

    private Double azimuth2; // 方位角 (以正北0度为基准)

    private Double pitch; // 俯仰角

    private Double speed; // 速度大小

    private Double targetLat; //飞行物纬度

    private Double targetLon; //飞行物经度

    private Double altitude; //飞行物高度

    private Integer statusNum;

    private Integer isDelete;

    private LocalDateTime createTime; //创建时间

    @Override
    public String toString() {
        return "RadarTarget{" +
                "xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                ", zCoordinate=" + zCoordinate +
                ", xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                ", zSpeed=" + zSpeed +
                ", targetId=" + targetId +
                ", snr=" + snr +
                ", rcs=" + rcs +
                ", targetType=" + targetType +
                ", selectionFlag=" + selectionFlag +
                ", range=" + range +
                ", azimuth1=" + azimuth1 +
                ", azimuth2=" + azimuth2 +
                ", pitch=" + pitch +
                ", speed=" + speed +
                ", targetLat=" + targetLat +
                ", targetLon=" + targetLon +
                ", altitude=" + altitude +
                ", statusNum=" + statusNum +
                ", isDelete=" + isDelete +
                ", createTime=" + createTime +
                '}';
    }
}
