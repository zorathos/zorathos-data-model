CREATE DATABASE IF NOT EXISTS `real_world_flight`; -- 实装飞行数据库
# ---------------------------------------- real_world_flight ----------------------------------------
-- asset_summary 表
CREATE TABLE IF NOT EXISTS real_world_flight.asset_summary
(
    `import_id`    varchar(255) NOT NULL COMMENT '导入ID',
    id             BIGINT PRIMARY KEY COMMENT '数据资产ID 对应着AssetTableModel的asset_id字段',
    sortie_number  VARCHAR(50) COMMENT '架次号',
    name           VARCHAR(255) COMMENT '数据资产名称',
    full_name      VARCHAR(255) COMMENT '数据资产全名',
    model          VARCHAR(255) COMMENT '数据资产模型',
    icd_id         INT COMMENT 'ICD ID',
    icd            VARCHAR(255) COMMENT 'ICD',
    db_name        VARCHAR(255) COMMENT '数据库名称',
    source         SMALLINT COMMENT '数据来源 来源（0-机载总线 1-ACMI 2-装备 3-数据库）',
    remark         TEXT COMMENT '备注',
    objectify_flag INT COMMENT '对象化标志',
    copy_flag      INT COMMENT '复制标志',
    labels         VARCHAR(255) COMMENT '标签',
    time_frame     INT COMMENT '时间帧',
    time_type      INT COMMENT '时间类型',
    INDEX idx_sortie_number (sortie_number)
);

-- asset_table_model 表
CREATE TABLE IF NOT EXISTS real_world_flight.asset_table_model
(
    `import_id`     varchar(255) NOT NULL COMMENT '导入ID',
    id              BIGINT PRIMARY KEY COMMENT 'id',
    sortie_number   VARCHAR(50) COMMENT '架次号',
    asset_id        BIGINT COMMENT '数据资产id',
    icd_id          BIGINT COMMENT 'ICD版本号',
    name            VARCHAR(255) COMMENT '模型名称',
    is_master       INT COMMENT '是否主表',
    repeat_interval INT COMMENT '重复间隔',
    repeat_times    INT COMMENT '重复次数',
    INDEX idx_sortie_number (sortie_number)
);

-- asset_table_property 表
CREATE TABLE IF NOT EXISTS real_world_flight.asset_table_property
(
    `import_id`   varchar(255) NOT NULL COMMENT '导入ID',
    id            BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '字段ID 源库没有 auto_increment bigint',
    sortie_number VARCHAR(50) COMMENT '架次号',
    model_id      BIGINT COMMENT '数据资产ID 源接口也没有 手动映射',
    code          VARCHAR(255) COMMENT '字段序号',
    name          VARCHAR(255) COMMENT '字段名称',
    type          VARCHAR(255) COMMENT '属性类型',
    is_time       INT COMMENT '是否时间 在字段类型为Long时判断生效 1是',
    two_d_display INT COMMENT '是否二维展示',
    label         VARCHAR(255) COMMENT '属性标签',
    INDEX idx_sortie_number (sortie_number)
);
