package edu.npu.model.original.photoelectric;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhotoelectricData {
    private String deviceId;                // 设备ID
    private LocalDateTime timestamp;        // 时间戳

    // RTSP流地址
    private String visibleLightUrl;         // 可见光RTSP地址

    // 设备状态
    private boolean visibleLightStatus;     // 可见光状态

    // 视频参数
    private int width;                      // 视频宽度
    private int height;                     // 视频高度
    private int fps;                        // 帧率
    private String codec;                   // 编码格式
    private String resolution;              // 分辨率7

    // 流类型
    private String currentStreamType;       // 当前流类型(visible/infrared)

    // 帧计数
    private long visibleLightFrameCount;    // 可见光帧计数

    // 云台参数（可选）
    private Double panAngle;                // 水平角度
    private Double tiltAngle;               // 俯仰角度
    private Double zoomLevel;               // 变焦级别

    // 帧数据（如果需要）
    private byte[] visibleLightFrame;       // 可见光帧数据
}
