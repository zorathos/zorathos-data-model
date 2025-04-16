package org.datacenter.config.keys;

import lombok.Getter;

/**
 * @author : [wangminan]
 * @description : 人机交互的接收器配置的Keys 与 `config`.`receiver_config` 映射
 */
@Getter
public enum HumanMachineReceiverConfigKey {
    // 装备配置组
    EQUIPMENT_CODE_HOST("host", "equipment_code_host", "装备系统的host"),
    EQUIPMENT_CODE_PORT("port", "equipment_code_port", "装备系统的port"),
    EQUIPMENT_CODE_DATABASE("database", "equipment_code_database", "装备系统的数据库"),
    EQUIPMENT_CODE_USERNAME("username", "equipment_code_username", "装备系统的用户名"),
    EQUIPMENT_CODE_PASSWORD("password", "equipment_code_password", "装备系统的密码"),
    EQUIPMENT_CODE_TABLE("table", "equipment_code_table", "装备系统的表"),
    EQUIPMENT_INFO_HOST("host", "equipment_info_host", "装备系统的host"),
    EQUIPMENT_INFO_PORT("port", "equipment_info_port", "装备系统的port"),
    EQUIPMENT_INFO_DATABASE("database", "equipment_info_database", "装备系统的数据库"),
    EQUIPMENT_INFO_USERNAME("username", "equipment_info_username", "装备系统的用户名"),
    EQUIPMENT_INFO_PASSWORD("password", "equipment_info_password", "装备系统的密码"),
    EQUIPMENT_INFO_TABLE("table", "equipment_info_table", "装备系统的表"),

    // 生理配置组
    PHYSIOLOGY_FILE_URL("url", "physiology_file_url", "生理数据文件的url"),
    PHYSIOLOGY_KAFKA_TOPIC("topic", "physiology_kafka_topic", "生理数据投递的kafka topic"),

    // 实装配置组
    ASSET_LIST_BASE_URL("listBaseUrl", "asset_list_base_url", "实装列表的url"),
    ASSET_CONFIG_BASE_URL("configBaseUrl", "asset_config_base_url", "实装配置的url"),
    ASSET_SORTIE_NUMBER("sortieNumber", "asset_sortie_number", "实装的架次"),
    ASSET_SQL_NODES("sqlNodes", "asset_sql_nodes", "实装的sql节点"),
    ASSET_FE_NODES("feNodes", "asset_fe_nodes", "实装的fe节点"),
    ASSET_USERNAME("username", "asset_username", "实装的用户名"),
    ASSET_PASSWORD("password", "asset_password", "实装的密码"),

    // 仿真配置组
    SIMULATION_URL("url", "simulation_url", "仿真数据文件的url"),
    SIMULATION_SORTIE_NUMBER("sortieNumber", "simulation_sortie_number", "仿真数据的架次");

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

    HumanMachineReceiverConfigKey(String keyForParamsMap, String keyOfPersistence, String description) {
        this.keyForParamsMap = keyForParamsMap;
        this.keyOfPersistence = keyOfPersistence;
        this.description = description;
    }

    public HumanMachineReceiverConfigKey fromKeyForParamsMap(String key) {
        for (HumanMachineReceiverConfigKey value : values()) {
            if (value.keyForParamsMap.equals(key)) {
                return value;
            }
        }
        throw new IllegalArgumentException("No enum constant for key: " + key);
    }

    public HumanMachineReceiverConfigKey fromKeyOfPersistence(String key) {
        for (HumanMachineReceiverConfigKey value : values()) {
            if (value.keyOfPersistence.equals(key)) {
                return value;
            }
        }
        throw new IllegalArgumentException("No enum constant for key: " + key);
    }
}
