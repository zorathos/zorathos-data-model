CREATE DATABASE IF NOT EXISTS `sorties`;
-- sorties
# ---------------------------------------- sorties ----------------------------------------
CREATE TABLE IF NOT EXISTS `sorties`.`sorties_batch`
(
    `import_id`    BIGINT       NOT NULL COMMENT '导入ID',
    `id`           varchar(255) NOT NULL COMMENT '主键ID',
    `batch_number` varchar(255) DEFAULT NULL COMMENT '批次号',
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `sorties`.`sorties`
(
    `import_id`         BIGINT       NOT NULL COMMENT '导入ID',
    `airplane_model`    varchar(255)      DEFAULT NULL COMMENT '机型',
    `airplane_number`   varchar(255)      DEFAULT NULL COMMENT '机号',
    `arm_type`          varchar(255)      DEFAULT NULL COMMENT '武器类型',
    `batch_number`      varchar(255)      DEFAULT NULL COMMENT '批次',
    `camp`              bigint            DEFAULT NULL COMMENT '阵营',
    `camp_str`          varchar(255)      DEFAULT NULL COMMENT '阵营说明',
    `car_end_time`      datetime     NULL DEFAULT NULL COMMENT '开关车结束时间',
    `car_start_time`    datetime     NULL DEFAULT NULL COMMENT '开关车开始时间',
    `create_time`       datetime     NULL DEFAULT NULL COMMENT '创建时间',
    `down_pilot`        varchar(255)      DEFAULT NULL COMMENT '后舱飞行员',
    `folder_id`         varchar(255)      DEFAULT NULL COMMENT '文件ID',
    `folder_name`       varchar(255)      DEFAULT NULL COMMENT '文件名称',
    `icd_version`       varchar(255)      DEFAULT NULL COMMENT 'ICD 版本',
    `interpolation`     bigint            DEFAULT NULL COMMENT '插值精度',
    `is_effective`      bigint            DEFAULT NULL COMMENT '架次是否有效',
    `is_effective_name` varchar(255)      DEFAULT NULL COMMENT '架次是否有效',
    `location`          varchar(255)      DEFAULT NULL COMMENT '任务地点',
    `pilot`             varchar(255)      DEFAULT NULL COMMENT '飞行员代字',
    `qx_id`             varchar(255)      DEFAULT NULL COMMENT '嵌训ID',
    `remark`            varchar(255)      DEFAULT NULL COMMENT '备注',
    `role`              bigint            DEFAULT NULL COMMENT '角色',
    `role_str`          varchar(255)      DEFAULT NULL COMMENT '角色说明',
    `sky_time`          varchar(255)      DEFAULT NULL COMMENT '空中时间',
    `sortie_id`         varchar(255) NOT NULL COMMENT '主键ID',
    `sortie_number`     varchar(255) NOT NULL UNIQUE COMMENT '架次编号',
    `source`            bigint            DEFAULT NULL COMMENT '来源',
    `stealth`           bigint            DEFAULT NULL COMMENT '飞机隐身状态',
    `stealth_str`       varchar(255)      DEFAULT NULL COMMENT '飞机隐身状态说明',
    `subject`           varchar(255)      DEFAULT NULL COMMENT '科目',
    `sync_system`       bigint            DEFAULT NULL COMMENT '敌我识别同步系统',
    `sync_system_str`   varchar(255)      DEFAULT NULL COMMENT '敌我识别同步系统说明',
    `test_drive`        bigint            DEFAULT NULL COMMENT '试驾编号',
    `test_drive_str`    varchar(255)      DEFAULT NULL COMMENT '试驾编号说明',
    `up_pilot`          varchar(255)      DEFAULT NULL COMMENT '前舱飞行员',
    PRIMARY KEY (`sortie_id`)
);
