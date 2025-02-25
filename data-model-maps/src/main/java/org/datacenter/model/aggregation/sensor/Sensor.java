package org.datacenter.model.aggregation.sensor;

import lombok.Builder;
import lombok.Data;

/**
 * 遥测设备详细信息
 */
@Data
@Builder
public class Sensor {

    /**
     * 如为国内企业，须使用统一社会信用代码
     * 如为国外企业，可采用邓白氏编码或其他国际企业唯一标识码，或SILAS专门分配的唯一标识码
     * 格式:18位以内文本字符
     * 默认值给西工大的统一社会信用代码
     */
    @Builder.Default
    private String sensorManufacturerID = "12100000435231705W";
    /**
     * 设备产品序列号 用于唯一标识感知设备
     * 格式:30位以内文本字符。
     * 如有设备制造商制定的出厂产品序列号，则按实际填写;如无，则按“10位以内上报方身份标识(Source)-19位上报方内部分配设备编号”填报。
     */
    private String sensorSN;
    /**
     * 如运营商为企事业单位 则由SensorOperatorInfo描述有关信息
     */
    private SensorOperatorInfo sensorOperatorInfo;
    /**
     * 设备安装位置信息 经纬高
     */
    private SensorLocation sensorLocation;
    /**
     * 设备姿态 使用欧拉角或者方位角体系描述
     */
    private BaseSensorPosture sensorPosture;
    /**
     * 设备附加说明
     */
    private BaseSensorExtra sensorExtra;
}
