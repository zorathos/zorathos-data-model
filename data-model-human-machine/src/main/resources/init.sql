# 初始化所有数据库 和TiDBDatabase类映射
CREATE DATABASE IF NOT EXISTS `human_machine`; # 人员与装备数据库
CREATE DATABASE IF NOT EXISTS `flight_plan`; # 飞行计划数据库
CREATE DATABASE IF NOT EXISTS `simulation`; # 模拟飞行数据库
CREATE DATABASE IF NOT EXISTS `real_world_flight`; # 实装飞行数据库
CREATE DATABASE IF NOT EXISTS `sorties`; # 架次数据库
CREATE DATABASE IF NOT EXISTS `physiological`;
# 生理数据库

# -------- 人员 --------
CREATE TABLE IF NOT EXISTS `human_machine`.`personnel_info`
(
    `id`                          varchar(255) NOT NULL COMMENT 'id（主键） ID',
    `unit_code`                   varchar(255) DEFAULT NULL COMMENT '单位代码 DWDM',
    `unit`                        varchar(255) DEFAULT NULL COMMENT '单位 DW',
    `personal_identifier`         varchar(255) DEFAULT NULL COMMENT '个人标识 GRBS',
    `name`                        varchar(255) DEFAULT NULL COMMENT '姓名 XM',
    `position`                    varchar(255) DEFAULT NULL COMMENT '职务 ZW',
    `appointment_date`            date         DEFAULT NULL COMMENT '任职年月 RZNY',
    `native_place`                varchar(255) DEFAULT NULL COMMENT '籍贯 JG',
    `family_background`           varchar(255) DEFAULT NULL COMMENT '家庭出身 JTCS',
    `education_level`             varchar(255) DEFAULT NULL COMMENT '文化程度 WHCD',
    `birthday`                    date         DEFAULT NULL COMMENT '生日 SR',
    `enlistment_date`             date         DEFAULT NULL COMMENT '入伍年月 RWNY',
    `rating_date`                 date         DEFAULT NULL COMMENT '评级年月 PJNY',
    `graduate_college`            varchar(255) DEFAULT NULL COMMENT '毕业学院 BYXY',
    `graduation_date`             date         DEFAULT NULL COMMENT '毕业年月 BYNY',
    `military_rank`               varchar(255) DEFAULT NULL COMMENT '军衔 JX',
    `pilot_role`                  varchar(255) DEFAULT NULL COMMENT '正副驾驶 ZFJS',
    `flight_level`                varchar(255) DEFAULT NULL COMMENT '飞行等级 FXDJ',
    `current_aircraft_model`      varchar(255) DEFAULT NULL COMMENT '现飞机型 XJX',
    `pxh`                         varchar(255) DEFAULT NULL COMMENT 'PXH',
    `code_name`                   varchar(255) DEFAULT NULL COMMENT '代号 DH',
    `bm`                          varchar(255) DEFAULT NULL COMMENT 'BM',
    `code_character`              varchar(255) DEFAULT NULL COMMENT '代字 DZ',
    `is_air_combat_commander`     varchar(255) DEFAULT NULL COMMENT '是否空战指挥员 SFKZZHY',
    `flight_outline`              varchar(255) DEFAULT NULL COMMENT '飞行提纲 FXTG',
    `lead_pilot`                  varchar(255) DEFAULT NULL COMMENT '长机 ZJ',
    `command_level_daytime`       varchar(255) DEFAULT NULL COMMENT '指挥水平（昼间） ZHSP_ZJ',
    `command_level_nighttime`     varchar(255) DEFAULT NULL COMMENT '指挥水平（夜间） ZHSP_YJ',
    `instructor`                  varchar(255) DEFAULT NULL COMMENT '教员 JY',
    `theoretical_instructor`      varchar(255) DEFAULT NULL COMMENT '理论教员 LLJY',
    `zbzt`                        varchar(255) DEFAULT NULL COMMENT 'ZBZT',
    `is_trainee`                  varchar(255) DEFAULT NULL COMMENT '是否学员 SFXY',
    `is_instructor`               varchar(255) DEFAULT NULL COMMENT '是否教官 SFJG',
    `qb`                          varchar(255) DEFAULT NULL COMMENT 'QB',
    `last_parachute_time_land`    date         DEFAULT NULL COMMENT '最后跳伞时间（陆） ZHTSSJ_L',
    `last_parachute_time_water`   date         DEFAULT NULL COMMENT '最后跳伞时间（水） ZHTSSJ_S',
    `modification_time`           date         DEFAULT NULL COMMENT '修改时间 XGSJ',
    `total_time_history`          varchar(255) DEFAULT NULL COMMENT '历年总时间 LNZSJ HH:mm',
    `total_time_current_year`     varchar(255) DEFAULT NULL COMMENT '本年总时间 BNZSJ HH:mm',
    `total_teaching_time_history` varchar(255) DEFAULT NULL COMMENT '历年任教时间 LNRJSJ HH:mm',
    PRIMARY KEY (`id`)
);


# -------- 装备 equipment_code --------
CREATE TABLE IF NOT EXISTS `human_machine`.`equipment_code`
(
    `id`                      varchar(32) NOT NULL COMMENT '装备编号,主键 和 EquipmentInfo 中的 id 不是一个概念 id',
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


# -------- 装备 equipment_info --------
CREATE TABLE IF NOT EXISTS `human_machine`.`equipment_info`
(
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

# -------- 飞行计划数据库 XML解析 --------
CREATE TABLE IF NOT EXISTS `flight_plan`.`flight_plan_root`
(
    `id`          varchar(255) NOT NULL COMMENT '根ID',
    `flight_date` date DEFAULT NULL COMMENT '飞行日期',
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `flight_plan`.`flight_head`
(
    `root_id`       varchar(255) DEFAULT NULL COMMENT '根ID',
    `id`            bigint NOT NULL AUTO_INCREMENT COMMENT '这个字段是咱自己的 主键 bigint auto increment,源库没有主键',
    `ver`           varchar(255) DEFAULT NULL COMMENT '版本',
    `title`         varchar(255) DEFAULT NULL COMMENT '标题',
    `timeline`      varchar(255) DEFAULT NULL COMMENT '时间线',
    `t_mode`        varchar(255) DEFAULT NULL COMMENT '模式',
    `plane_num`     int          DEFAULT NULL COMMENT '计划数量',
    `flights_time`  int          DEFAULT NULL COMMENT '开飞时刻',
    `total_time`    int          DEFAULT NULL COMMENT '总场时间',
    `exit_time`     int          DEFAULT NULL COMMENT '退离时刻',
    `sun_rise_time` varchar(255) DEFAULT NULL COMMENT '日出时刻',
    `sun_set_time`  varchar(255) DEFAULT NULL COMMENT '日落时刻',
    `dark_time`     varchar(255) DEFAULT NULL COMMENT '天黑时刻',
    `dawn_time`     varchar(255) DEFAULT NULL COMMENT '天亮时刻',
    `dxthh`         varchar(255) DEFAULT NULL COMMENT '大小天亮时刻',
    `zhshh`         varchar(255) DEFAULT NULL COMMENT '中午时刻',
    `dwsbxh`        varchar(255) DEFAULT NULL COMMENT '低温设备型号',
    PRIMARY KEY (`id`)
);



CREATE TABLE IF NOT EXISTS `flight_plan`.`flight_notes`
(
    `root_id` varchar(255) DEFAULT NULL COMMENT '根ID',
    `id`      bigint NOT NULL AUTO_INCREMENT COMMENT '这个字段是咱自己的 主键 bigint auto increment,源库没有主键',
    `note`    varchar(255) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `flight_plan`.`flight_cmd`
(
    `root_id` varchar(255) DEFAULT NULL COMMENT '根ID',
    `id`      bigint NOT NULL AUTO_INCREMENT COMMENT '这个字段是咱自己的 主键 bigint auto increment,源库没有主键',
    `name`    varchar(255) DEFAULT NULL COMMENT '姓名',
    `lb`      varchar(255) DEFAULT NULL COMMENT '类别',
    `sx`      varchar(255) DEFAULT NULL COMMENT '属性',
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `flight_plan`.`flight_task`
(
    `root_id` varchar(255) DEFAULT NULL COMMENT '根ID',
    `id`      bigint NOT NULL AUTO_INCREMENT COMMENT '这个字段是咱自己的 主键 bigint auto increment,源库没有主键',
    `model`   varchar(255) DEFAULT NULL COMMENT '型号',
    `code`    varchar(255) DEFAULT NULL COMMENT '代码',
    `name`    varchar(255) DEFAULT NULL COMMENT '姓名',
    `rw`      varchar(255) DEFAULT NULL COMMENT '任务',
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `flight_plan`.`flight_plan`
(
    `root_id`             varchar(255) DEFAULT NULL COMMENT '根ID',
    `id`                  bigint NOT NULL AUTO_INCREMENT COMMENT '主键,自增ID',
    `sortie_number`       varchar(255) DEFAULT NULL COMMENT '架次编号',
    `airport_id`          varchar(255) DEFAULT NULL COMMENT '机场ID JCID',
    `takeoff_time`        varchar(255) DEFAULT NULL COMMENT '起飞时间 HH:mm QFSK',
    `air_battle_time`     varchar(255) DEFAULT NULL COMMENT '空战时间 KZSK',
    `ys`                  varchar(255) DEFAULT NULL COMMENT 'YS',
    `plane_model`         varchar(255) DEFAULT NULL COMMENT '机型 DG',
    `practice_number`     varchar(255) DEFAULT NULL COMMENT '练习号 LXH',
    `cs`                  varchar(255) DEFAULT NULL COMMENT 'CS',
    `sj`                  varchar(255) DEFAULT NULL COMMENT '时间 SJ',
    `jhlx`                varchar(255) DEFAULT NULL COMMENT 'JHLX',
    `plan_time`           varchar(255) DEFAULT NULL COMMENT '计划时间 JHSJ',
    `height`              varchar(255) DEFAULT NULL COMMENT '高度 GD',
    `ky`                  varchar(255) DEFAULT NULL COMMENT 'KY',
    `fz`                  varchar(255) DEFAULT NULL COMMENT 'FZ',
    `formation_number`    varchar(255) DEFAULT NULL COMMENT '编队编号 BDNO',
    `is_leader_plane`     varchar(255) DEFAULT NULL COMMENT '是否长机 SFZJ',
    `formation_practice`  varchar(255) DEFAULT NULL COMMENT '编队练习 BDLX',
    `number_of_formation` varchar(255) DEFAULT NULL COMMENT '编队数量 BDSL',
    `front_name`          varchar(255) DEFAULT NULL COMMENT '前舱姓名 QCXM',
    `front_code`          varchar(255) DEFAULT NULL COMMENT '前舱代码 QCDM',
    `front_code_name`     varchar(255) DEFAULT NULL COMMENT '前舱代号 QCDH',
    `front_nick_name`     varchar(255) DEFAULT NULL COMMENT '前舱代字 QCDZ',
    `front_property`      varchar(255) DEFAULT NULL COMMENT '前舱性质 QCXZ',
    `back_name`           varchar(255) DEFAULT NULL COMMENT '后舱姓名 HCXM',
    `back_code`           varchar(255) DEFAULT NULL COMMENT '后舱代码 HCDM',
    `back_code_name`      varchar(255) DEFAULT NULL COMMENT '后舱代号 HCDH',
    `back_nick_name`      varchar(255) DEFAULT NULL COMMENT '后舱代字 HCDZ',
    `back_property`       varchar(255) DEFAULT NULL COMMENT '后舱性质 HCXZ',
    `xsms`                varchar(255) DEFAULT NULL COMMENT 'XSMS',
    `jkys`                varchar(255) DEFAULT NULL COMMENT 'JKYS',
    `yxyl`                varchar(255) DEFAULT NULL COMMENT 'YXYL',
    `wqgz`                varchar(255) DEFAULT NULL COMMENT 'WQGZ',
    `grfa`                varchar(255) DEFAULT NULL COMMENT 'GRFA',
    PRIMARY KEY (`id`)
);

# -------- sorties --------
CREATE TABLE IF NOT EXISTS `sorties`.`sorties_batch`
(
    `id`           varchar(255) NOT NULL COMMENT '主键ID',
    `batch_number` varchar(255) DEFAULT NULL COMMENT '批次号',
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `sorties`.`sorties`
(
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


# -------- 生理数据库 --------
CREATE TABLE IF NOT EXISTS `physiological`.`collection_task`
(
    task_id           BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '采集任务编号',
    sortie_number     VARCHAR(255) NOT NULL COMMENT '架次',
    collector_name    VARCHAR(255) NOT NULL COMMENT '采集人',
    subject_name      VARCHAR(255) NOT NULL COMMENT '被试人',
    collection_device VARCHAR(255) NOT NULL COMMENT '采集设备',
    task_type         VARCHAR(255) NOT NULL COMMENT '任务类型',
    task_start_time   DATETIME     NOT NULL COMMENT '任务开始时间',
    creator           VARCHAR(255) NOT NULL COMMENT '任务创建人',
    create_time       DATETIME     DEFAULT CURRENT_TIMESTAMP COMMENT '任务创建时间',
    modifier          VARCHAR(255) DEFAULT NULL COMMENT '任务修改人',
    modificationTime  DATETIME     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '任务修改时间'
) COMMENT ='飞行员生理数据采集任务表';


