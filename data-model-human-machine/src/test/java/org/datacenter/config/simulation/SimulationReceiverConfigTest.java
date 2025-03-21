package org.datacenter.config.simulation;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author : [wangminan]
 * @description : 用例用的simulation config测试
 */
public class SimulationReceiverConfigTest {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        SimulationReceiverConfig config = SimulationReceiverConfig.builder()
                .url("s3://human-machine/simulation/simulated_data_large.csv")
                .sortieNumber("20250303_五_01_ACT-3_邱陈_J16_07#02")
                .build();
        try {
            String json = objectMapper.writeValueAsString(config);
            SimulationReceiverConfig config1 = objectMapper.readValue(json, SimulationReceiverConfig.class);
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
