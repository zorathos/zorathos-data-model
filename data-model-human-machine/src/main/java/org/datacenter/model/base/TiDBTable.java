package org.datacenter.model.base;

import lombok.Getter;

@Getter
public enum TiDBTable {

    /**
     * 人员信息表
     */
    PERSONNEL_INFO("personnel_info"),

    /**
     * 装备代码表
     */
    EQUIPMENT_CODE("equipment_code"),

    /**
     * 装备信息表
     */
    EQUIPMENT_INFO("equipment_info"),

    /**
     * {@link org.datacenter.model.plan.FlightCmd}
     */
    FLIGHT_CMD("flight_cmd"),

    /**
     * {@link org.datacenter.model.plan.FlightHead}
     */
    FLIGHT_HEAD("flight_head"),

    /**
     * {@link org.datacenter.model.plan.FlightNotes}
     */
    FLIGHT_NOTES("flight_notes"),

    /**
     * {@link org.datacenter.model.plan.FlightPlan}
     */
    FLIGHT_PLAN("flight_plan"),

    /**
     * {@link org.datacenter.model.plan.FlightPlanRoot}
     */
    FLIGHT_PLAN_ROOT("flight_plan_root"),

    /**
     * {@link org.datacenter.model.plan.FlightTask}
     */
    FLIGHT_TASK("flight_task"),

    /**
     * 架次批
     */
    SORTIES_BATCH("sorties_batch"),

    /**
     * 架次表
     */
    SORTIES("sorties");

    private final String name;

    TiDBTable(String name) {
        this.name = name;
    }

    public static TiDBTable fromName(String name) {
        for (TiDBTable table : TiDBTable.values()) {
            if (table.getName().equals(name)) {
                return table;
            }
        }
        return null;
    }
}
