package org.datacenter.model.aggregation.sensor;

import lombok.Builder;
import lombok.Data;

/**
 * 感知设备详细信息
 */
@Data
@Builder
public class Sensor {

    private String sensorManufacturerID;
    private String sensorSN;
    private SensorOperatorInfo sensorOperatorInfo;
    private SensorLocation sensorLocation;
    private SensorPosture sensorPosture;
    private SensorExtra sensorExtra;

}
