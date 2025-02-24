package edu.npu.model.aggregation.aircraft;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : wangminan
 * @description : 相对于大地的位置
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class GroundPosition extends BasePosition{
    /**
     * -180~180 精确到小数点后7位
     */
    private Double longitude;
    /**
     * -90~90 精确到小数点后7位
     */
    private Double latitude;
    /**
     * 精确到小数点后两位 米
     */
    private Double height;
    /**
     * 感知设备定位经度的标准差 精确到小数点后两位 米
     */
    private Double deltaLongitude;
    /**
     * 感知设备定位纬度的标准差 精确到小数点后两位 米
     */
    private Double deltaLatitude;
    /**
     * 感知设备定位高度的标准差 精确到小数点后两位 米
     */
    private Double deltaHeight;

    public GroundPosition() {
        super(PositionBase.Ground);
    }

    public GroundPosition(Double longitude, Double latitude, Double height, Double deltaLongitude, Double deltaLatitude, Double deltaHeight) {
        super(PositionBase.Ground);
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
        this.deltaLongitude = deltaLongitude;
        this.deltaLatitude = deltaLatitude;
        this.deltaHeight = deltaHeight;
    }
}
