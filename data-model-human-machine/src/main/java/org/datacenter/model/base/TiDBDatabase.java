package org.datacenter.model.base;

import lombok.Getter;

/**
 * TiDB数据库枚举 接入使用
 *
 * @author wangminan
 */
@Getter
public enum TiDBDatabase {
    /**
     * 大库 非时序化数据 存飞行员和装备数据 下面应该有 personnel_info, equipment_code 和 equipment_info 3个表
     */
    HUMAN_MACHINE("human_machine"),

    /**
     * 飞行计划数据库
     * 内含 flight_cmd flight_head flight_notes flight_plan flight_plan_root flight_task 6个表
     */
    FLIGHT_PLAN("flight_plan"),

    /**
     * 模拟飞行数据库
     */
    SIMULATION("simulation"),

    /**
     * 模拟数据集成数据库
     */
    SIMULATION_INTEGRATION("simulation_integration"),

    /**
     * 实装飞行数据库
     */
    REAL_WORLD_FLIGHT("real_world_flight"),

    /**
     * 架次数据库 包含 sorties_batch和sorties两个表
     */
    SORTIES("sorties"),

    /**
     * 生理数据库 包含 多通道背心 脑电 三维动捕 血氧手环 眼动仪 五个表
     */
    PHYSIOLOGICAL("physiological");

    private final String name;

    TiDBDatabase(String name) {
        this.name = name;
    }

    public static TiDBDatabase fromName(String name) {
        for (TiDBDatabase database : TiDBDatabase.values()) {
            if (database.getName().equals(name)) {
                return database;
            }
        }
        return null;
    }
}
