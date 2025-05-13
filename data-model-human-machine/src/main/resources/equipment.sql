CREATE DATABASE IF NOT EXISTS `equipment`; -- 装备库
# ---------------------------------------- 装备 equipment_code ----------------------------------------
CREATE TABLE IF NOT EXISTS `equipment`.`equipment_code`
(
    `import_id`               varchar(255) NOT NULL COMMENT '导入ID',
    `id`                      varchar(32)  NOT NULL COMMENT '装备编号,主键 和 EquipmentInfo 中的 id 不是一个概念 id',
    `creator`                 varchar(32)  DEFAULT NULL COMMENT '创建人 create_people',
    `create_time`             datetime     DEFAULT NULL COMMENT '创建时间 create_time',
    `modifier`                varchar(32)  DEFAULT NULL COMMENT '修改人 update_people',
    `modification_time`       datetime     DEFAULT NULL COMMENT '修改时间 update_time',
    `old_id`                  int          DEFAULT NULL COMMENT '老ID old_id',
    `plane_old_id`            int          DEFAULT NULL COMMENT '飞机老ID plane_old_id',
    `c_coat`                  varchar(45)  DEFAULT NULL COMMENT '涂装号 c_coat',
    `c_interior`              varchar(45)  DEFAULT NULL COMMENT '内部编号 c_interior',
    `c_manufacturing`         varchar(45)  DEFAULT NULL COMMENT '出厂编号 c_manufacturing',
    `icd_version`             varchar(255) DEFAULT NULL COMMENT 'icd版本 icd_version',
    `avionics_system_version` varchar(255) DEFAULT NULL COMMENT '航电系统版本 avionics_system_version',
    `is_used`                 tinyint      DEFAULT NULL COMMENT '是否使用 is_used 1启用,2未启用',
    `is_deleted`              tinyint      DEFAULT NULL COMMENT '是否删除, 1正常,2删除',
    `used_time`               datetime     DEFAULT NULL COMMENT '使用时间 yyyy-MM-dd used_time',
    `icd_version_id`          varchar(32)  DEFAULT NULL COMMENT 'icd_version_id',
    PRIMARY KEY (`id`)
);

# ---------------------------------------- 装备 equipment_info ----------------------------------------
CREATE TABLE IF NOT EXISTS `equipment`.`equipment_info`
(
    `import_id`              varchar(255) NOT NULL COMMENT '导入ID',
    `id`                     varchar(255) NOT NULL COMMENT '装备型号,主键 和 EquipmentCode 中的 equipmentNumber 不是一个概念 id',
    `create_time`            datetime     NULL DEFAULT NULL COMMENT '创建时间',
    `modification_time`      datetime     NULL DEFAULT NULL COMMENT '修改时间',
    `creator`                varchar(255)      DEFAULT NULL COMMENT '创建人',
    `modifier`               varchar(255)      DEFAULT NULL COMMENT '更新人',
    `old_id`                 varchar(255)      DEFAULT NULL COMMENT '老id',
    `plane_type`             varchar(255)      DEFAULT NULL COMMENT '飞机类型',
    `equipment_type`         varchar(255)      DEFAULT NULL COMMENT '装备类型',
    `plane_weight`           double            DEFAULT NULL COMMENT '飞机重量',
    `parent_id`              varchar(255)      DEFAULT NULL COMMENT '父ID',
    `_3d_system`             tinyint           DEFAULT NULL COMMENT '三维系统（1三型机,2体系,3小体系,4ACMI）',
    `is_deleted`             tinyint           DEFAULT NULL COMMENT '是否删除（1删除,2未删除）',
    `equipment_model`        varchar(255)      DEFAULT NULL COMMENT '装备模型',
    `unit`                   varchar(255)      DEFAULT NULL COMMENT '单位',
    `working_frequency_band` varchar(255)      DEFAULT NULL COMMENT '工作频段',
    `longitude`              double            DEFAULT NULL COMMENT '经度',
    `latitude`               double            DEFAULT NULL COMMENT '纬度',
    `is_3d_playback`         tinyint           DEFAULT NULL COMMENT '是否三维回放（1代表是,2代表否）',
    PRIMARY KEY (`id`)
);
