package org.datacenter.config.keys;

import lombok.Getter;

@Getter
public enum HumanMachineIntegrationConfigKey {

    SORTIE_NUMBER("sortieNumber", "sortie_number", "架次编号");

    /**
     * 人机交互接收器启动时的对应配置的 flink 用的参数 和类中的驼峰属性名一致
     */
    private final String keyForParamsMap;

    /**
     * 持久化的时候存的Key 小写下划线分隔
     */
    private final String keyOfPersistence;

    /**
     * 配置的说明
     */
    private final String description;

    HumanMachineIntegrationConfigKey(String keyForParamsMap, String keyOfPersistence, String description) {
        this.keyForParamsMap = keyForParamsMap;
        this.keyOfPersistence = keyOfPersistence;
        this.description = description;
    }

    public HumanMachineIntegrationConfigKey fromKeyForParamsMap(String key) {
        for (HumanMachineIntegrationConfigKey value : values()) {
            if (value.keyForParamsMap.equals(key)) {
                return value;
            }
        }
        throw new IllegalArgumentException("No enum constant for key: " + key);
    }

    public HumanMachineIntegrationConfigKey fromKeyOfPersistence(String key) {
        for (HumanMachineIntegrationConfigKey value : values()) {
            if (value.keyOfPersistence.equals(key)) {
                return value;
            }
        }
        throw new IllegalArgumentException("No enum constant for key: " + key);
    }
}
