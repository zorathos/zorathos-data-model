package org.datacenter.model.original.camera;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PanoramicCameraData {
    private String deviceId;
    private LocalDateTime timestamp;
    private String mainStreamUrl;    // 主码流RTSP地址
    private String subStreamUrl;     // 子码流RTSP地址
    private Boolean mainStreamStatus; // 主码流状态
    private Boolean subStreamStatus;  // 子码流状态
    private Integer width;               // 视频宽度
    private Integer height;              // 视频高度
    private Integer fps;                 // 帧率
    private String codec;            // 编码格式(H264/H265)
    private String resolution;       // 分辨率
    private String streamType;       // 流类型(main/sub)
    private Long mainStreamFrameCount;
    private Long subStreamFrameCount;
}
