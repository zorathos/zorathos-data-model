package org.datacenter.model.base;

import lombok.Getter;

/**
 * Enum representing various TiDB tables.
 * Each enum constant corresponds to a specific table in the TiDB database.
 */
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
    SORTIES("sorties"),

    AA_TRAJ("aa_traj"),
    AG_RTSN("ag_rtsn"),
    AG_TRAJ("ag_traj"),
    CD_DRONE_PLANE_STATE("cd_drone_plane_state"),
    CMB_POWER("cmb_power"),
    COMMAND("command"),
    EO_STATE("eo_state"),
    ERROR_DATA("error_data"),
    EWS("ews"),
    EWS_KJ500("ews_kj500"),
    EWS_Y8G("ews_y8g"),
    EWS_Y9T("ews_y9t"),
    EWS_YZ8("ews_yz8"),
    GT_SPI("gt_spi"),
    GT_SPI_BACK("gt_spi_back"),
    HIT_RESULT("hit_result"),
    HJ_PLANE_DATA("hj_plane_data"),
    IR_MSL("ir_msl"),
    PL17_RTK("pl17_rtkn"),
    PL17_RTSN("pl17_rtsn"),
    PL17_TRAJ("pl17_traj"),
    PLANE_PRO("plane_pro"),
    PLANE_STATE("plane_state"),
    RDR_STATE("rdr_state"),
    RTKN("rtkn"),
    RTSN("rtsn"),
    SA_TGT("sa_tgt"),
    SA_TRAJ("sa_traj"),
    SENDTO_3D_DATA("sendto_3d_data"),
    SRD_STATE("srd_state"),
    TGT("tgt"),
    TSPI("tspi"),

    /**
     * 数据模型摘要
     */
    ASSET_SUMMARY("asset_summary"),

    /**
     * 数据资产模型
     */
    ASSET_TABLE_MODEL("asset_table_model"),

    /**
     * 数据资产配置
     */
    ASSET_TABLE_PROPERTY("asset_table_property");

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
