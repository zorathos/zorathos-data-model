package io.github.wangminan.model.radar;

import lombok.Data;

@Data
public class RadarTargetVO {
    private float range;        // 轴向距离
    private float azimuth;      // 方位角 (以正北0度为基准)
    private float pitch;        // 俯仰角

    // 可以根据需要添加其他字段
}
