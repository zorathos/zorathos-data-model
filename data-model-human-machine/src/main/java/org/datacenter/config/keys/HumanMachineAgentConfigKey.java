package org.datacenter.config.keys;

import lombok.Getter;

/**
 * @author : [wangminan]
 * @description : Agent的配置项
 */
@Getter
public enum HumanMachineAgentConfigKey {
    // 启动agent的类路径 不需要持久化 通过反射加载
    AGENT_CLASS("agentClass", "", "Agent的类路径"),

    // 人员与飞行计划通用配置组
    PERSONNEL_AND_PLAN_LOGIN_URL("loginUrl", "personnel_and_plan_login_url", "人员与飞行计划登录的url"),
    PERSONNEL_AND_PLAN_LOGIN_JSON("loginJson", "personnel_and_plan_login_json", "人员与飞行计划登录的json"),

    // 人员系统配置组
    PERSONNEL_URL("url", "personnel_url", "人员信息拉取的url"),

    // 飞行计划配置组
    FLIGHT_PLAN_FLIGHT_DATE_URL("flightDateUrl", "flight_plan_flight_date_url", "飞行计划日期拉取的url"),
    FLIGHT_PLAN_FLIGHT_CODE_URL("flightCodeUrl", "flight_plan_flight_code_url", "飞行计划编号号拉取的url"),
    FLIGHT_PLAN_FLIGHT_XML_URL("flightXmlUrl", "flight_plan_flight_xml_url", "飞行计划xml拉取的url");

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

    HumanMachineAgentConfigKey(String keyForParamsMap, String keyOfPersistence, String description) {
        this.keyForParamsMap = keyForParamsMap;
        this.keyOfPersistence = keyOfPersistence;
        this.description = description;
    }

    public HumanMachineAgentConfigKey fromKeyForParamsMap(String key) {
        for (HumanMachineAgentConfigKey value : values()) {
            if (value.keyForParamsMap.equals(key)) {
                return value;
            }
        }
        throw new IllegalArgumentException("No enum constant for key: " + key);
    }

    public HumanMachineAgentConfigKey fromKeyOfPersistence(String key) {
        for (HumanMachineAgentConfigKey value : values()) {
            if (value.keyOfPersistence.equals(key)) {
                return value;
            }
        }
        throw new IllegalArgumentException("No enum constant for key: " + key);
    }
}
