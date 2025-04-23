# 初始化所有数据库 和TiDBDatabase类映射
CREATE DATABASE IF NOT EXISTS `personnel`; -- 人员库
CREATE DATABASE IF NOT EXISTS `equipment`; -- 装备库
CREATE DATABASE IF NOT EXISTS `flight_plan`; -- 飞行计划数据库
CREATE DATABASE IF NOT EXISTS `flight_plan_implementation`; -- 飞行计划实施库
CREATE DATABASE IF NOT EXISTS `flight_plan_dynamic`; -- 飞行计划动态库
CREATE DATABASE IF NOT EXISTS `simulation`; -- 模拟飞行数据库
CREATE DATABASE IF NOT EXISTS `simulation_integration`; -- 实装飞行数据库
CREATE DATABASE IF NOT EXISTS `real_world_flight`; -- 实装飞行数据库
CREATE DATABASE IF NOT EXISTS `sorties`; -- 架次数据库
CREATE DATABASE IF NOT EXISTS `physiological`; -- 生理数据库
CREATE DATABASE IF NOT EXISTS `collection`; -- 采集数据库
CREATE DATABASE IF NOT EXISTS `config`;

# ---------------------------------------- 配置 ----------------------------------------
CREATE TABLE IF NOT EXISTS `config`.`receiver_config`
(
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    `key` VARCHAR(255) NOT NULL COMMENT '配置项',
    `value` TEXT NOT NULL COMMENT '配置值'
);

# ---------------------------------------- 人员 ----------------------------------------
CREATE TABLE IF NOT EXISTS `personnel`.`personnel_info`
(
    `personal_identifier`         varchar(255) COMMENT '个人标识 GRBS',
    `unit_code`                   varchar(255) DEFAULT NULL COMMENT '单位代码 DWDM',
    `unit`                        varchar(255) DEFAULT NULL COMMENT '单位 DW',
    `name`                        varchar(255) DEFAULT NULL COMMENT '姓名 XM',
    `position`                    varchar(255) DEFAULT NULL COMMENT '职务 ZW',
    `sex`                         varchar(10)  DEFAULT NULL COMMENT '性别 XB',
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
    `current_aircraft_type`       varchar(255) DEFAULT NULL COMMENT '现飞机型 XFJX',
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
    PRIMARY KEY (`personal_identifier`)
);


# ---------------------------------------- 装备 equipment_code ----------------------------------------
CREATE TABLE IF NOT EXISTS `equipment`.`equipment_code`
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


# ---------------------------------------- 装备 equipment_info ----------------------------------------
CREATE TABLE IF NOT EXISTS `equipment`.`equipment_info`
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

# ---------------------------------------- 飞行计划数据库 XML解析 ----------------------------------------
CREATE TABLE IF NOT EXISTS `flight_plan`.`flight_plan_root`
(
    `id`          varchar(255) NOT NULL COMMENT '根ID',
    `flight_date` date DEFAULT NULL COMMENT '飞行日期',
    `flight_date_time` datetime DEFAULT NULL COMMENT '飞行日期时间',
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

# ---------------------------------------- 飞行计划实施数据库 XML解析 ----------------------------------------
CREATE TABLE IF NOT EXISTS `flight_plan_implementation`.`flight_plan_root`
(
    `id`          varchar(255) NOT NULL COMMENT '根ID',
    `flight_date` date DEFAULT NULL COMMENT '飞行日期',
    `flight_date_time` datetime DEFAULT NULL COMMENT '飞行日期时间',
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `flight_plan_implementation`.`flight_head`
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

CREATE TABLE IF NOT EXISTS `flight_plan_implementation`.`flight_notes`
(
    `root_id` varchar(255) DEFAULT NULL COMMENT '根ID',
    `id`      bigint NOT NULL AUTO_INCREMENT COMMENT '这个字段是咱自己的 主键 bigint auto increment,源库没有主键',
    `note`    varchar(255) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `flight_plan_implementation`.`flight_cmd`
(
    `root_id` varchar(255) DEFAULT NULL COMMENT '根ID',
    `id`      bigint NOT NULL AUTO_INCREMENT COMMENT '这个字段是咱自己的 主键 bigint auto increment,源库没有主键',
    `name`    varchar(255) DEFAULT NULL COMMENT '姓名',
    `lb`      varchar(255) DEFAULT NULL COMMENT '类别',
    `sx`      varchar(255) DEFAULT NULL COMMENT '属性',
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `flight_plan_implementation`.`flight_task`
(
    `root_id` varchar(255) DEFAULT NULL COMMENT '根ID',
    `id`      bigint NOT NULL AUTO_INCREMENT COMMENT '这个字段是咱自己的 主键 bigint auto increment,源库没有主键',
    `model`   varchar(255) DEFAULT NULL COMMENT '型号',
    `code`    varchar(255) DEFAULT NULL COMMENT '代码',
    `name`    varchar(255) DEFAULT NULL COMMENT '姓名',
    `rw`      varchar(255) DEFAULT NULL COMMENT '任务',
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `flight_plan_implementation`.`flight_plan`
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

# ---------------------------------------- 飞行现场动态数据库 XML解析 ----------------------------------------
CREATE TABLE IF NOT EXISTS `flight_plan_dynamic`.`flight_plan_root`
(
    `id`          varchar(255) NOT NULL COMMENT '根ID',
    `flight_date` date DEFAULT NULL COMMENT '飞行日期',
    `flight_date_time` datetime DEFAULT NULL COMMENT '飞行日期时间',
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `flight_plan_dynamic`.`flight_head`
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

CREATE TABLE IF NOT EXISTS `flight_plan_dynamic`.`flight_notes`
(
    `root_id` varchar(255) DEFAULT NULL COMMENT '根ID',
    `id`      bigint NOT NULL AUTO_INCREMENT COMMENT '这个字段是咱自己的 主键 bigint auto increment,源库没有主键',
    `note`    varchar(255) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `flight_plan_dynamic`.`flight_cmd`
(
    `root_id` varchar(255) DEFAULT NULL COMMENT '根ID',
    `id`      bigint NOT NULL AUTO_INCREMENT COMMENT '这个字段是咱自己的 主键 bigint auto increment,源库没有主键',
    `name`    varchar(255) DEFAULT NULL COMMENT '姓名',
    `lb`      varchar(255) DEFAULT NULL COMMENT '类别',
    `sx`      varchar(255) DEFAULT NULL COMMENT '属性',
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `flight_plan_dynamic`.`flight_task`
(
    `root_id` varchar(255) DEFAULT NULL COMMENT '根ID',
    `id`      bigint NOT NULL AUTO_INCREMENT COMMENT '这个字段是咱自己的 主键 bigint auto increment,源库没有主键',
    `model`   varchar(255) DEFAULT NULL COMMENT '型号',
    `code`    varchar(255) DEFAULT NULL COMMENT '代码',
    `name`    varchar(255) DEFAULT NULL COMMENT '姓名',
    `rw`      varchar(255) DEFAULT NULL COMMENT '任务',
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `flight_plan_dynamic`.`flight_plan`
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

# ---------------------------------------- sorties ----------------------------------------
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

# ---------------------------------------- 模拟飞行数据库 ----------------------------------------
CREATE TABLE IF NOT EXISTS `simulation`.`aa_traj`
(
    `sortie_number`                  VARCHAR(50) COMMENT '架次号',
    `aircraft_id`                    VARCHAR(50) COMMENT '飞机ID',
    `message_time`                   TIME(3) COMMENT '消息时间（精确到毫秒）',
    `satellite_guidance_time`        TIME(3) COMMENT '卫导时间（精确到毫秒）',
    `local_time`                     TIME(3) COMMENT '本地时间（精确到毫秒）',
    `message_sequence_number`        BIGINT COMMENT '消息序列号',
    `weapon_id`                      VARCHAR(50) COMMENT '武器ID',
    `pylon_id`                       VARCHAR(50) COMMENT '挂架ID',
    `weapon_type`                    VARCHAR(50) COMMENT '武器类型',
    `target_id`                      VARCHAR(50) COMMENT '目标ID',
    `longitude`                      VARCHAR(50) COMMENT '经度',
    `latitude`                       VARCHAR(50) COMMENT '纬度',
    `altitude`                       VARCHAR(50) COMMENT '高度',
    `missile_target_distance`        VARCHAR(50) COMMENT '弹目距离',
    `missile_speed`                  VARCHAR(50) COMMENT '弹速度',
    `interception_status`            VARCHAR(50) COMMENT '截获状态',
    `non_interception_reason`        VARCHAR(50) COMMENT '未截获原因',
    `seeker_azimuth`                 VARCHAR(50) COMMENT '导引头视线方位角',
    `seeker_elevation`               VARCHAR(50) COMMENT '导引头视线俯仰角',
    `target_tspi_status`             VARCHAR(50) COMMENT '目标TSPI状态',
    `command_machine_status`         VARCHAR(50) COMMENT '指令机状态',
    `ground_angle_satisfaction_flag` VARCHAR(50) COMMENT '擦地角满足标志',
    `zero_crossing_flag`             VARCHAR(50) COMMENT '过零标志',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'Aatraj' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

ALTER TABLE `simulation`.`aa_traj`
    COALESCE PARTITION 4;


CREATE TABLE IF NOT EXISTS `simulation`.`ag_rtsn`
(
    `sortie_number`                     VARCHAR(50) COMMENT '架次号',
    `aircraft_id`                       VARCHAR(50) COMMENT '飞机ID',
    `message_time`                      TIME(3) COMMENT '消息时间（精确到毫秒）',
    `satellite_guidance_time`           TIME(3) COMMENT '卫导时间（精确到毫秒）',
    `local_time`                        TIME(3) COMMENT '本地时间（精确到毫秒）',
    `message_sequence_number`           BIGINT COMMENT '消息序列号',
    `weapon_id`                         VARCHAR(50) COMMENT '武器ID',
    `weapon_pylon_id`                   VARCHAR(50) COMMENT '武器挂架ID',
    `weapon_type`                       VARCHAR(50) COMMENT '武器类型',
    `number_of_missiles_released`       VARCHAR(50) COMMENT '投放弹数',
    `aircraft_ground_speed`             VARCHAR(50) COMMENT '载机地速',
    `aircraft_longitude`                VARCHAR(50) COMMENT '载机经度',
    `aircraft_latitude`                 VARCHAR(50) COMMENT '载机纬度',
    `aircraft_altitude`                 VARCHAR(50) COMMENT '载机高度',
    `aircraft_heading`                  VARCHAR(50) COMMENT '载机航向',
    `aircraft_pitch`                    VARCHAR(50) COMMENT '载机俯仰',
    `aircraft_roll`                     VARCHAR(50) COMMENT '载机横滚',
    `aircraft_angle_of_attack`          VARCHAR(50) COMMENT '载机攻角',
    `aircraft_north_speed`              VARCHAR(50) COMMENT '载机北速',
    `aircraft_vertical_speed`           VARCHAR(50) COMMENT '载机天速',
    `aircraft_east_speed`               VARCHAR(50) COMMENT '载机东速',
    `north_wind_speed`                  VARCHAR(50) COMMENT '北向风速',
    `vertical_wind_speed`               VARCHAR(50) COMMENT '天向风速',
    `east_wind_speed`                   VARCHAR(50) COMMENT '东向风速',
    `target_longitude`                  VARCHAR(50) COMMENT '目标经度',
    `target_latitude`                   VARCHAR(50) COMMENT '目标纬度',
    `target_altitude`                   VARCHAR(50) COMMENT '目标高度',
    `target_distance`                   VARCHAR(50) COMMENT '目标距离',
    `seeker_head_number`                VARCHAR(50) COMMENT '导引头号',
    `target_coordinate_validity`        VARCHAR(50) COMMENT '目标经纬高有效标识',
    `target_azimuth_elevation_validity` VARCHAR(50) COMMENT '目标方位俯仰有效标识',
    `target_elevation_angle`            VARCHAR(50) COMMENT '目标俯仰角(惯性侧滑角)',
    `target_azimuth_angle`              VARCHAR(50) COMMENT '目标方位角(真空速)',
    `impact_angle_validity`             VARCHAR(50) COMMENT '落角有效性',
    `entry_angle`                       VARCHAR(50) COMMENT '进入角',
    `impact_angle`                      VARCHAR(50) COMMENT '落角',
    `direction_validity`                VARCHAR(50) COMMENT '方向有效性',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'AgRtsn' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

CREATE TABLE IF NOT EXISTS `simulation`.`ag_traj`
(
    `sortie_number`               VARCHAR(50) COMMENT '架次号',
    `aircraft_id`                 VARCHAR(50) COMMENT '飞机ID',
    `message_time`                TIME(3) COMMENT '消息时间（精确到毫秒）',
    `satellite_guidance_time`     TIME(3) COMMENT '卫导时间（精确到毫秒）',
    `local_time`                  TIME(3) COMMENT '本地时间（精确到毫秒）',
    `message_sequence_number`     BIGINT COMMENT '消息序列号',
    `weapon_id`                   VARCHAR(50) COMMENT '武器ID',
    `weapon_type`                 VARCHAR(50) COMMENT '武器类型',
    `longitude`                   VARCHAR(50) COMMENT '经度',
    `latitude`                    VARCHAR(50) COMMENT '纬度',
    `altitude`                    VARCHAR(50) COMMENT '高度',
    `heading`                     VARCHAR(50) COMMENT '航向',
    `pitch`                       VARCHAR(50) COMMENT '俯仰',
    `north_speed`                 VARCHAR(50) COMMENT '北速',
    `sky_speed`                   VARCHAR(50) COMMENT '天速',
    `east_speed`                  VARCHAR(50) COMMENT '东速',
    `seeker_id`                   VARCHAR(50) COMMENT '导引头号',
    `interception_flag`           VARCHAR(50) COMMENT '截获标志',
    `termination_flag`            VARCHAR(50) COMMENT '终止标志',
    `intercepting_member_id`      VARCHAR(50) COMMENT '截获成员ID',
    `intercepting_equipment_id`   VARCHAR(50) COMMENT '截获装备ID',
    `intercepting_equipment_type` VARCHAR(50) COMMENT '截获装备类型',
    `launcher_id`                 VARCHAR(50) COMMENT '发射方ID',
    `seeker_azimuth_center`       VARCHAR(50) COMMENT '导引头方位中心',
    `seeker_pitch_center`         VARCHAR(50) COMMENT '导引头俯仰中心',
    `target_id`                   VARCHAR(50) COMMENT '目标ID',
    `missile_target_distance`     VARCHAR(50) COMMENT '弹目距离',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'AgTraj' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

CREATE TABLE IF NOT EXISTS `simulation`.`cd_drone_plane_state`
(
    `sortie_number`            VARCHAR(50) COMMENT '架次号',
    `aircraft_id`              VARCHAR(50) COMMENT '飞机ID',
    `message_time`             TIME(3) COMMENT '消息时间（精确到毫秒）',
    `satellite_guidance_time`  TIME(3) COMMENT '卫导时间（精确到毫秒）',
    `local_time`               TIME(3) COMMENT '本地时间（精确到毫秒）',
    `message_sequence_number`  BIGINT COMMENT '消息序列号',
    `true_angle_of_attack`     VARCHAR(50) COMMENT '真攻角',
    `mach_number`              VARCHAR(50) COMMENT '马赫数',
    `normal_load_factor`       VARCHAR(50) COMMENT '法向过载',
    `indicated_airspeed`       VARCHAR(50) COMMENT '表速(km/h)',
    `field_elevation`          VARCHAR(50) COMMENT '场高',
    `radio_altitude`           VARCHAR(50) COMMENT '无线电高度',
    `remaining_fuel`           VARCHAR(50) COMMENT '余油量',
    `manual_respawn`           VARCHAR(50) COMMENT '手动复活',
    `parameter_setting_status` VARCHAR(50) COMMENT '参数设置状态',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'CdDronePlaneState' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

CREATE TABLE IF NOT EXISTS `simulation`.`cd_drone_tspi`
(
    `sortie_number`           VARCHAR(50) COMMENT '架次号',
    `aircraft_id`             VARCHAR(50) COMMENT '飞机ID',
    `aircraft_type`           VARCHAR(50) COMMENT '飞机类型',
    `message_time`            TIME(3) COMMENT '消息时间（精确到毫秒）',
    `satellite_guidance_time` TIME(3) COMMENT '卫导时间（精确到毫秒）',
    `local_time`              TIME(3) COMMENT '本地时间（精确到毫秒）',
    `message_sequence_number` BIGINT COMMENT '消息序列号',
    `longitude`               VARCHAR(50) COMMENT '经度',
    `latitude`                VARCHAR(50) COMMENT '纬度',
    `pressure_altitude`       VARCHAR(50) COMMENT '气压高度',
    `roll`                    VARCHAR(50) COMMENT '横滚',
    `pitch`                   VARCHAR(50) COMMENT '俯仰',
    `heading`                 VARCHAR(50) COMMENT '航向',
    `satellite_altitude`      VARCHAR(50) COMMENT '卫星高度',
    `training_status`         VARCHAR(50) COMMENT '训练状态',
    `chaff`                   VARCHAR(50) COMMENT '干扰弹',
    `afterburner`             VARCHAR(50) COMMENT '加力',
    `north_velocity`          VARCHAR(50) COMMENT '北向速度',
    `vertical_velocity`       VARCHAR(50) COMMENT '天向速度',
    `east_velocity`           VARCHAR(50) COMMENT '东向速度',
    `delay_status`            VARCHAR(50) COMMENT '延迟状态',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'CdDroneTspi' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

CREATE TABLE IF NOT EXISTS `simulation`.`cmb_power`
(
    `sortie_number`                  VARCHAR(50) COMMENT '架次号',
    `ground_defense_id`              VARCHAR(50) COMMENT '地防ID',
    `message_time`                   TIME(3) COMMENT '消息时间（精确到毫秒）',
    `satellite_guidance_time`        TIME(3) COMMENT '卫导时间（精确到毫秒）',
    `local_time`                     TIME(3) COMMENT '本地时间（精确到毫秒）',
    `message_sequence_number`        BIGINT COMMENT '消息序列号',
    `available_missile_count`        VARCHAR(50) COMMENT '可用导弹数量',
    `available_target_channel_count` VARCHAR(50) COMMENT '可用目标通道数量',
    `training_mode`                  VARCHAR(50) COMMENT '训练模式',
    `allow_missile_reset`            VARCHAR(50) COMMENT '允许重置导弹',
    `auto_respawn`                   VARCHAR(50) COMMENT '自主复活',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'CmbPower' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

CREATE TABLE IF NOT EXISTS `simulation`.`command`
(
    `sortie_number`            VARCHAR(50) COMMENT '架次号',
    `aircraft_id`              VARCHAR(50) COMMENT '飞机ID',
    `message_time`             TIME(3) COMMENT '消息时间（精确到毫秒）',
    `satellite_guidance_time`  TIME(3) COMMENT '卫导时间（精确到毫秒）',
    `local_time`               TIME(3) COMMENT '本地时间（精确到毫秒）',
    `message_sequence_number`  BIGINT COMMENT '消息序列号',
    `command_type`             VARCHAR(50) COMMENT '导调/导调回复',
    `command_id`               VARCHAR(50) COMMENT '命令ID',
    `command_content`          VARCHAR(50) COMMENT '命令内容',
    `response_sequence_number` BIGINT COMMENT '回复序列号',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'Command' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

CREATE TABLE IF NOT EXISTS `simulation`.`eo_state`
(
    `sortie_number`           VARCHAR(50) COMMENT '架次号',
    `aircraft_id`             VARCHAR(50) COMMENT '飞机ID',
    `message_time`            TIME(3) COMMENT '消息时间（精确到毫秒）',
    `satellite_guidance_time` TIME(3) COMMENT '卫导时间（精确到毫秒）',
    `local_time`              TIME(3) COMMENT '本地时间（精确到毫秒）',
    `message_sequence_number` BIGINT COMMENT '消息序列号',
    `working_mode`            VARCHAR(50) COMMENT '工作模式',
    `power_status`            VARCHAR(50) COMMENT '开机状态',
    `standby_status`          VARCHAR(50) COMMENT '待机状态',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'EoState' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

CREATE TABLE IF NOT EXISTS `simulation`.`error_data`
(
    `sortie_number`           VARCHAR(50) COMMENT '架次号',
    `sender_id`               VARCHAR(50) COMMENT '发送方ID',
    `message_time`            TIME(3) COMMENT '消息时间（精确到毫秒）',
    `local_time`              TIME(3) COMMENT '本地时间（精确到毫秒）',
    `message_sequence_number` BIGINT COMMENT '消息序列号',
    `message_id`              VARCHAR(50) COMMENT '消息标识',
    `message_length`          VARCHAR(50) COMMENT '消息长度',
    `error_message`           VARCHAR(50) COMMENT '错误信息',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'ErrorData' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

CREATE TABLE IF NOT EXISTS `simulation`.`ews`
(
    `sortie_number`           VARCHAR(50) COMMENT '架次号',
    `aircraft_id`             VARCHAR(50) COMMENT '飞机ID',
    `message_time`            TIME(3) COMMENT '消息时间（精确到毫秒）',
    `satellite_guidance_time` TIME(3) COMMENT '卫导时间（精确到毫秒）',
    `local_time`              TIME(3) COMMENT '本地时间（精确到毫秒）',
    `message_sequence_number` BIGINT COMMENT '消息序列号',
    `left_front_jamming`      VARCHAR(50) COMMENT '左前干扰',
    `right_front_jamming`     VARCHAR(50) COMMENT '右前干扰',
    `left_rear_jamming`       VARCHAR(50) COMMENT '左后干扰',
    `right_rear_jamming`      VARCHAR(50) COMMENT '右后干扰',
    `pod_forward_jamming`     VARCHAR(50) COMMENT '吊舱前向干扰',
    `pod_rearward_jamming`    VARCHAR(50) COMMENT '吊舱后向干扰',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'Ews' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

CREATE TABLE IF NOT EXISTS `simulation`.`ews_y8g`
(
    `sortie_number`                VARCHAR(50) COMMENT '架次号',
    `aircraft_id`                  VARCHAR(50) COMMENT '飞机ID',
    `message_time`                 TIME(3) COMMENT '消息时间（精确到毫秒）',
    `satellite_guidance_time`      TIME(3) COMMENT '卫导时间（精确到毫秒）',
    `local_time`                   TIME(3) COMMENT '本地时间（精确到毫秒）',
    `message_sequence_number`      BIGINT COMMENT '消息序列号',
    `x_band_jamming_elevation`     VARCHAR(50) COMMENT 'X波段干扰俯仰',
    `c_band_jamming_elevation`     VARCHAR(50) COMMENT 'C波段干扰俯仰',
    `c_band_jamming_azimuth`       VARCHAR(50) COMMENT 'C波段干扰方位',
    `s_band_jamming_elevation`     VARCHAR(50) COMMENT 'S波段干扰俯仰',
    `s_band_jamming_azimuth`       VARCHAR(50) COMMENT 'S波段干扰方位',
    `l_band_jamming_elevation`     VARCHAR(50) COMMENT 'L波段干扰俯仰',
    `l_band_jamming_azimuth`       VARCHAR(50) COMMENT 'L波段干扰方位',
    `u_band_jamming_azimuth`       VARCHAR(50) COMMENT 'U波段干扰方位',
    `jamming_status`               VARCHAR(50) COMMENT '干扰状态',
    `x_band_jamming_azimuth_angle` VARCHAR(50) COMMENT 'X波段干扰方位角',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'EwsY8G' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

CREATE TABLE IF NOT EXISTS `simulation`.`ews_y9t`
(
    `sortie_number`           VARCHAR(50) COMMENT '架次号',
    `aircraft_id`             VARCHAR(50) COMMENT '飞机ID',
    `message_time`            TIME(3) COMMENT '消息时间（精确到毫秒）',
    `satellite_guidance_time` TIME(3) COMMENT '卫导时间（精确到毫秒）',
    `local_time`              TIME(3) COMMENT '本地时间（精确到毫秒）',
    `message_sequence_number` BIGINT COMMENT '消息序列号',
    `jamming_azimuth`         VARCHAR(50) COMMENT '干扰方位角',
    `jamming_frequency_count` VARCHAR(50) COMMENT '干扰频点数量',
    `jamming_type`            VARCHAR(50) COMMENT '干扰类型',
    `jamming_band`            VARCHAR(50) COMMENT '干扰波段',
    `jamming_direction`       VARCHAR(50) COMMENT '干扰方向',
    `jamming_status`          VARCHAR(50) COMMENT '干扰状态',
    `jamming_elevation`       VARCHAR(50) COMMENT '干扰俯仰角',
    `jamming_start_frequency` VARCHAR(50) COMMENT '干扰开始频率',
    `jamming_end_frequency`   VARCHAR(50) COMMENT '干扰终止频率',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'EwsY9T' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

CREATE TABLE IF NOT EXISTS `simulation`.`ews_yz8`
(
    `sortie_number`                VARCHAR(50) COMMENT '架次号',
    `aircraft_id`                  VARCHAR(50) COMMENT '飞机ID',
    `message_time`                 TIME(3) COMMENT '消息时间（精确到毫秒）',
    `satellite_guidance_time`      TIME(3) COMMENT '卫导时间（精确到毫秒）',
    `local_time`                   TIME(3) COMMENT '本地时间（精确到毫秒）',
    `message_sequence_number`      BIGINT COMMENT '消息序列号',
    `working_status`               VARCHAR(50) COMMENT '工作状态',
    `omnidirectional_detection_q1` VARCHAR(50) COMMENT '全向探测Q1频段',
    `omnidirectional_detection_q2` VARCHAR(50) COMMENT '全向探测Q2频段',
    `precise_direction_finding_j1` VARCHAR(50) COMMENT '精测向J1频段',
    `precise_direction_finding_j2` VARCHAR(50) COMMENT '精测向J2频段',
    `precise_direction_finding_j3` VARCHAR(50) COMMENT '精测向J3频段',
    `high_gain_g1`                 VARCHAR(50) COMMENT '高增益G1频段',
    `high_gain_g2`                 VARCHAR(50) COMMENT '高增益G2频段',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'EwsYZ8' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

CREATE TABLE IF NOT EXISTS `simulation`.`g_tspi`
(
    `sortie_number`           VARCHAR(50) COMMENT '架次号',
    `ground_defense_id`       VARCHAR(50) COMMENT '地防ID',
    `message_time`            TIME(3) COMMENT '消息时间（精确到毫秒）',
    `satellite_guidance_time` TIME(3) COMMENT '卫导时间（精确到毫秒）',
    `local_time`              TIME(3) COMMENT '本地时间（精确到毫秒）',
    `message_sequence_number` BIGINT COMMENT '消息序列号',
    `camp_type`               VARCHAR(50) COMMENT '营地类型',
    `equipment_type`          VARCHAR(50) COMMENT '装备类型',
    `equipment_id`            VARCHAR(50) COMMENT '装备ID',
    `status`                  VARCHAR(50) COMMENT '状态',
    `north_angle`             VARCHAR(50) COMMENT '指北角',
    `longitude`               VARCHAR(50) COMMENT '经度',
    `latitude`                VARCHAR(50) COMMENT '纬度',
    `altitude`                VARCHAR(50) COMMENT '高度',
    `decoy_position_id`       VARCHAR(50) COMMENT '假阵地编号',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'GTspi' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

CREATE TABLE IF NOT EXISTS `simulation`.`ews_kj500`
(
    `sortie_number`           VARCHAR(50) COMMENT '架次号',
    `aircraft_id`             VARCHAR(50) COMMENT '飞机ID',
    `message_time`            TIME(3) COMMENT '消息时间（精确到毫秒）',
    `satellite_guidance_time` TIME(3) COMMENT '卫导时间（精确到毫秒）',
    `local_time`              TIME(3) COMMENT '本地时间（精确到毫秒）',
    `message_sequence_number` BIGINT COMMENT '消息序列号',
    `azimuth_start_angle`     VARCHAR(50) COMMENT '方位起始角',
    `sector_reference`        VARCHAR(50) COMMENT '扇区相对基准',
    `sector_type`             VARCHAR(50) COMMENT '扇区类型',
    `sector_number`           VARCHAR(50) COMMENT '扇区号',
    `action_code`             VARCHAR(50) COMMENT '动作代码',
    `azimuth_end_angle`       VARCHAR(50) COMMENT '范围终止角',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'EwsKJ500' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

CREATE TABLE IF NOT EXISTS `simulation`.`g_tspi_back`
(
    `sortie_number`                    VARCHAR(50) COMMENT '架次号',
    `ground_defense_id`                VARCHAR(50) COMMENT '地防ID',
    `message_time`                     TIME(3) COMMENT '消息时间（精确到毫秒）',
    `satellite_guidance_time`          TIME(3) COMMENT '卫导时间（精确到毫秒）',
    `local_time`                       TIME(3) COMMENT '本地时间（精确到毫秒）',
    `message_sequence_number`          BIGINT COMMENT '消息序列号',
    `response_message_sequence_number` BIGINT COMMENT '回复消息序列号',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'GTspiBack' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

CREATE TABLE IF NOT EXISTS `simulation`.`hit_result`
(
    `sortie_number` VARCHAR(50) COMMENT '架次号',
    `launcher_id`   VARCHAR(50) COMMENT '发射方ID',
    `target_id`     VARCHAR(50) COMMENT '目标ID',
    `weapon_type`   VARCHAR(50) COMMENT '武器类型',
    `weapon_id`     VARCHAR(50) COMMENT '武器ID',
    `launch_time`   VARCHAR(50) COMMENT '发射时间',
    `end_time`      TIME(3) COMMENT '结束时间（精确到毫秒）',
    `hit_result`    VARCHAR(50) COMMENT '命中结果',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'HitResult' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

CREATE TABLE IF NOT EXISTS `simulation`.`hj_plane_data`
(
    `sortie_number`           VARCHAR(50) COMMENT '架次号',
    `batch_number`            VARCHAR(50) COMMENT '批次号',
    `device_number`           VARCHAR(50) COMMENT '设备号',
    `flight_control_number`   VARCHAR(50) COMMENT '航管号',
    `local_time`              TIME(3) COMMENT '本地时间（精确到毫秒）',
    `message_time`            TIME(3) COMMENT '消息时间（精确到毫秒）',
    `message_sequence_number` BIGINT COMMENT '消息序列号',
    `longitude`               VARCHAR(50) COMMENT '经度',
    `latitude`                VARCHAR(50) COMMENT '纬度',
    `altitude`                VARCHAR(50) COMMENT '高度',
    `ground_speed`            VARCHAR(50) COMMENT '地速',
    `vertical_speed`          VARCHAR(50) COMMENT '垂直速度',
    `heading`                 VARCHAR(50) COMMENT '航向',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'HJPlaneData' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

CREATE TABLE IF NOT EXISTS `simulation`.`ir_msl`
(
    `sortie_number`           VARCHAR(50) COMMENT '架次号',
    `aircraft_id`             VARCHAR(50) COMMENT '飞机ID',
    `message_time`            TIME(3) COMMENT '消息时间（精确到毫秒）',
    `satellite_guidance_time` TIME(3) COMMENT '卫导时间（精确到毫秒）',
    `local_time`              TIME(3) COMMENT '本地时间（精确到毫秒）',
    `message_sequence_number` BIGINT COMMENT '消息序列号',
    `seeker_azimuth`          VARCHAR(50) COMMENT '导引头方位角',
    `seeker_elevation`        VARCHAR(50) COMMENT '导引头俯仰角',
    `weapon_type`             VARCHAR(50) COMMENT '武器类型',
    `interception_flag`       VARCHAR(50) COMMENT '截获标识',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'IrMsl' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

CREATE TABLE IF NOT EXISTS `simulation`.`pl17_rtkn`
(
    `sortie_number`           VARCHAR(50) COMMENT '架次号',
    `aircraft_id`             VARCHAR(50) COMMENT '飞机ID',
    `message_time`            TIME(3) COMMENT '消息时间（精确到毫秒）',
    `satellite_guidance_time` TIME(3) COMMENT '卫导时间（精确到毫秒）',
    `local_time`              TIME(3) COMMENT '本地时间（精确到毫秒）',
    `message_sequence_number` BIGINT COMMENT '消息序列号',
    `weapon_id`               VARCHAR(50) COMMENT '武器ID',
    `weapon_type`             VARCHAR(50) COMMENT '武器类型',
    `target_id`               VARCHAR(50) COMMENT '目标ID',
    `target_real_or_virtual`  VARCHAR(50) COMMENT '目标机实虚属性',
    `hit_result`              VARCHAR(50) COMMENT '命中结果',
    `miss_reason`             VARCHAR(50) COMMENT '未命中原因',
    `miss_distance`           VARCHAR(50) COMMENT '脱靶量',
    `matching_failure_reason` VARCHAR(50) COMMENT '匹配失败原因',
    `jamming_effective`       VARCHAR(50) COMMENT '干扰是否有效',
    `jamming`                 VARCHAR(50) COMMENT '干扰',
    `afterburner`             VARCHAR(50) COMMENT '加力',
    `head_on`                 VARCHAR(50) COMMENT '迎头',
    `heading`                 VARCHAR(50) COMMENT '航向',
    `pitch`                   VARCHAR(50) COMMENT '俯仰',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'PL17Rtkn' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

CREATE TABLE IF NOT EXISTS `simulation`.`pl17_rtsn`
(
    `sortie_number`           VARCHAR(50) COMMENT '架次号',
    `aircraft_id`             VARCHAR(50) COMMENT '飞机ID',
    `message_time`            TIME(3) COMMENT '消息时间（精确到毫秒）',
    `satellite_guidance_time` TIME(3) COMMENT '卫导时间（精确到毫秒）',
    `local_time`              TIME(3) COMMENT '本地时间（精确到毫秒）',
    `message_sequence_number` BIGINT COMMENT '消息序列号',
    `target_id`               VARCHAR(50) COMMENT '目标ID',
    `intercepted_weapon_id`   VARCHAR(50) COMMENT '被拦截武器ID',
    `target_real_or_virtual`  VARCHAR(50) COMMENT '目标实虚属性',
    `weapon_id`               VARCHAR(50) COMMENT '武器ID',
    `pylon_id`                VARCHAR(50) COMMENT '挂架ID',
    `weapon_type`             VARCHAR(50) COMMENT '武器类型',
    `trajectory_type`         VARCHAR(50) COMMENT '弹道类型',
    `missile_attack_mode`     VARCHAR(50) COMMENT '导弹攻击模式',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'PL17Rtsn' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

CREATE TABLE IF NOT EXISTS `simulation`.`pl17_traj`
(
    `sortie_number`                  VARCHAR(50) COMMENT '架次号',
    `aircraft_id`                    VARCHAR(50) COMMENT '飞机ID',
    `message_time`                   TIME(3) COMMENT '消息时间（精确到毫秒）',
    `satellite_guidance_time`        TIME(3) COMMENT '卫导时间（精确到毫秒）',
    `local_time`                     TIME(3) COMMENT '本地时间（精确到毫秒）',
    `message_sequence_number`        BIGINT COMMENT '消息序列号',
    `weapon_id`                      VARCHAR(50) COMMENT '武器ID',
    `pylon_id`                       VARCHAR(50) COMMENT '挂架ID',
    `weapon_type`                    VARCHAR(50) COMMENT '武器类型',
    `target_id`                      VARCHAR(50) COMMENT '目标ID',
    `longitude`                      VARCHAR(50) COMMENT '经度',
    `latitude`                       VARCHAR(50) COMMENT '纬度',
    `altitude`                       VARCHAR(50) COMMENT '高度',
    `missile_target_distance`        VARCHAR(50) COMMENT '弹目距离',
    `missile_speed`                  VARCHAR(50) COMMENT '弹速度(m/s)',
    `interception_status`            VARCHAR(50) COMMENT '截获状态',
    `non_interception_reason`        VARCHAR(50) COMMENT '未截获原因',
    `seeker_azimuth`                 VARCHAR(50) COMMENT '导引头视线方位角',
    `seeker_elevation`               VARCHAR(50) COMMENT '导引头视线俯仰角',
    `target_tspi_status`             VARCHAR(50) COMMENT '目标TSPI状态',
    `command_machine_status`         VARCHAR(50) COMMENT '指令机状态',
    `ground_angle_satisfaction_flag` VARCHAR(50) COMMENT '擦地角满足标志',
    `zero_crossing_flag`             VARCHAR(50) COMMENT '过零标志',
    `distance_interception_flag`     VARCHAR(50) COMMENT '距离截获标志',
    `speed_interception_flag`        VARCHAR(50) COMMENT '速度截获标志',
    `angle_interception_flag`        VARCHAR(50) COMMENT '角度截获标志',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'PL17Traj' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

CREATE TABLE IF NOT EXISTS `simulation`.`plane_pro`
(
    `sortie_number`        VARCHAR(50) COMMENT '架次号',
    `aircraft_id`          VARCHAR(50) COMMENT '飞机ID',
    `aircraft_callsign`    VARCHAR(50) COMMENT '飞机代字',
    `aircraft_code_name`   VARCHAR(50) COMMENT '飞机代号',
    `red_blue_affiliation` VARCHAR(50) COMMENT '红蓝属性',
    `flight_batch`         VARCHAR(50) COMMENT '飞行批次',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'PlanePro' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

CREATE TABLE IF NOT EXISTS `simulation`.`plane_state`
(
    `sortie_number`            VARCHAR(50) COMMENT '架次号',
    `aircraft_id`              VARCHAR(50) COMMENT '飞机ID',
    `message_time`             TIME(3) COMMENT '消息时间（精确到毫秒）',
    `satellite_guidance_time`  TIME(3) COMMENT '卫导时间（精确到毫秒）',
    `local_time`               TIME(3) COMMENT '本地时间（精确到毫秒）',
    `message_sequence_number`  BIGINT COMMENT '消息序列号',
    `true_angle_of_attack`     VARCHAR(50) COMMENT '真攻角',
    `mach_number`              VARCHAR(50) COMMENT '马赫数',
    `normal_load_factor`       VARCHAR(50) COMMENT '法向过载',
    `indicated_airspeed`       VARCHAR(50) COMMENT '表速(km/h)',
    `field_elevation`          VARCHAR(50) COMMENT '场高',
    `radio_altitude`           VARCHAR(50) COMMENT '无线电高度',
    `remaining_fuel`           VARCHAR(50) COMMENT '余油量',
    `scenario`                 VARCHAR(50) COMMENT '场景',
    `manual_respawn`           VARCHAR(50) COMMENT '手动复活',
    `parameter_setting_status` VARCHAR(50) COMMENT '参数设置状态',
    `encryption_status`        VARCHAR(50) COMMENT '加密状态',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'PlaneState' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

CREATE TABLE IF NOT EXISTS `simulation`.`rdr_state`
(
    `sortie_number`           VARCHAR(50) COMMENT '架次号',
    `aircraft_id`             VARCHAR(50) COMMENT '飞机ID',
    `message_time`            TIME(3) COMMENT '消息时间（精确到毫秒）',
    `satellite_guidance_time` TIME(3) COMMENT '卫导时间（精确到毫秒）',
    `local_time`              TIME(3) COMMENT '本地时间（精确到毫秒）',
    `message_sequence_number` BIGINT COMMENT '消息序列号',
    `working_mode`            VARCHAR(50) COMMENT '工作模式',
    `air_sea_scan_ratio`      VARCHAR(50) COMMENT '空海扫描比',
    `power_status`            VARCHAR(50) COMMENT '开机状态',
    `emission_status`         VARCHAR(50) COMMENT '辐射状态',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'RdrState' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

CREATE TABLE IF NOT EXISTS `simulation`.`rtsn`
(
    `sortie_number`           VARCHAR(50) COMMENT '架次号',
    `aircraft_id`             VARCHAR(50) COMMENT '飞机ID',
    `message_time`            TIME(3) COMMENT '消息时间（精确到毫秒）',
    `satellite_guidance_time` TIME(3) COMMENT '卫导时间（精确到毫秒）',
    `local_time`              TIME(3) COMMENT '本地时间（精确到毫秒）',
    `message_sequence_number` BIGINT COMMENT '消息序列号',
    `target_id`               VARCHAR(50) COMMENT '目标ID',
    `intercepted_weapon_id`   VARCHAR(50) COMMENT '被拦截武器ID',
    `target_real_or_virtual`  VARCHAR(50) COMMENT '目标实虚属性',
    `weapon_id`               VARCHAR(50) COMMENT '武器ID',
    `pylon_id`                VARCHAR(50) COMMENT '挂架ID',
    `weapon_type`             VARCHAR(50) COMMENT '武器类型',
    `trajectory_type`         VARCHAR(50) COMMENT '弹道类型',
    `missile_attack_mode`     VARCHAR(50) COMMENT '导弹攻击模式',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'Rtsn' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

CREATE TABLE IF NOT EXISTS `simulation`.`sa_tgt`
(
    `sortie_number`           VARCHAR(50) COMMENT '架次号',
    `ground_defense_id`       VARCHAR(50) COMMENT '地防ID',
    `message_time`            TIME(3) COMMENT '消息时间（精确到毫秒）',
    `satellite_guidance_time` TIME(3) COMMENT '卫导时间（精确到毫秒）',
    `local_time`              TIME(3) COMMENT '本地时间（精确到毫秒）',
    `message_sequence_number` BIGINT COMMENT '消息序列号',
    `equipment_type`          VARCHAR(50) COMMENT '装备类型',
    `equipment_number`        VARCHAR(50) COMMENT '装备编号',
    `target_azimuth`          VARCHAR(50) COMMENT '目标方位角',
    `target_elevation`        VARCHAR(50) COMMENT '目标俯仰角',
    `target_slant_range`      VARCHAR(50) COMMENT '目标斜距',
    `channel_number`          VARCHAR(50) COMMENT '通道号',
    `target_batch_number`     VARCHAR(50) COMMENT '目标批号',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'SaTgt' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

CREATE TABLE IF NOT EXISTS `simulation`.`sa_traj`
(
    `sortie_number`           VARCHAR(50) COMMENT '架次号',
    `aircraft_id`             VARCHAR(50) COMMENT '飞机ID',
    `message_time`            TIME(3) COMMENT '消息时间（精确到毫秒）',
    `satellite_guidance_time` TIME(3) COMMENT '卫导时间（精确到毫秒）',
    `local_time`              TIME(3) COMMENT '本地时间（精确到毫秒）',
    `message_sequence_number` BIGINT COMMENT '消息序列号',
    `weapon_id`               VARCHAR(50) COMMENT '武器ID',
    `pylon_id`                VARCHAR(50) COMMENT '挂架ID',
    `weapon_type`             VARCHAR(50) COMMENT '武器类型',
    `target_id`               VARCHAR(50) COMMENT '目标ID',
    `intercepted_weapon_id`   VARCHAR(50) COMMENT '被拦截武器ID',
    `longitude`               VARCHAR(50) COMMENT '经度',
    `latitude`                VARCHAR(50) COMMENT '纬度',
    `altitude`                VARCHAR(50) COMMENT '高度',
    `missile_target_distance` VARCHAR(50) COMMENT '弹目距离',
    `missile_speed`           VARCHAR(50) COMMENT '弹速度(m/s)',
    `interception_status`     VARCHAR(50) COMMENT '截获状态',
    `non_interception_reason` VARCHAR(50) COMMENT '未截获原因',
    `seeker_azimuth`          VARCHAR(50) COMMENT '导引头视线方位角',
    `seeker_elevation`        VARCHAR(50) COMMENT '导引头视线俯仰角',
    `target_tspi_status`      VARCHAR(50) COMMENT '目标TSPI状态',
    `command_machine_status`  VARCHAR(50) COMMENT '指令机状态',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'SaTraj' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

CREATE TABLE IF NOT EXISTS `simulation`.`send_to_3d_data`
(
    `sortie_number`        VARCHAR(50) COMMENT '架次号',
    `aircraft_id`          VARCHAR(50) COMMENT '飞机ID',
    `aircraft_callsign`    VARCHAR(50) COMMENT '飞机代字',
    `aircraft_code_name`   VARCHAR(50) COMMENT '飞机代号',
    `red_blue_affiliation` VARCHAR(50) COMMENT '红蓝属性',
    `flight_batch`         VARCHAR(50) COMMENT '飞行批次',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'Sendto3DData' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

CREATE TABLE IF NOT EXISTS `simulation`.`rtkn`
(
    `sortie_number`                  VARCHAR(50) COMMENT '架次号',
    `aircraft_id`                    VARCHAR(50) COMMENT '飞机ID',
    `message_time`                   TIME(3) COMMENT '消息时间（精确到毫秒）',
    `satellite_guidance_time`        TIME(3) COMMENT '卫导时间（精确到毫秒）',
    `local_time`                     TIME(3) COMMENT '本地时间（精确到毫秒）',
    `message_sequence_number`        BIGINT COMMENT '消息序列号',
    `weapon_id`                      VARCHAR(50) COMMENT '武器ID',
    `weapon_type`                    VARCHAR(50) COMMENT '武器类型',
    `target_id`                      VARCHAR(50) COMMENT '目标ID',
    `intercepted_weapon_id`          VARCHAR(50) COMMENT '被拦截武器ID',
    `hit_result`                     VARCHAR(50) COMMENT '命中结果',
    `miss_reason`                    VARCHAR(50) COMMENT '未命中原因',
    `miss_distance`                  VARCHAR(50) COMMENT '脱靶量',
    `matching_failure_reason`        VARCHAR(50) COMMENT '匹配失败原因',
    `ground_defense_equipment_type`  VARCHAR(50) COMMENT '地导装备类型',
    `ground_defense_equipment_id`    VARCHAR(50) COMMENT '地导装备ID',
    `ground_defense_equipment_type1` VARCHAR(50) COMMENT '地导装备类型.1',
    `ground_defense_equipment_id1`   VARCHAR(50) COMMENT '地导装备ID.1',
    `ground_defense_equipment_type2` VARCHAR(50) COMMENT '地导装备类型.2',
    `ground_defense_equipment_id2`   VARCHAR(50) COMMENT '地导装备ID.2',
    `ground_defense_equipment_type3` VARCHAR(50) COMMENT '地导装备类型.3',
    `ground_defense_equipment_id3`   VARCHAR(50) COMMENT '地导装备ID.3',
    `jamming_effective`              VARCHAR(50) COMMENT '干扰是否有效',
    `jamming`                        VARCHAR(50) COMMENT '干扰',
    `afterburner`                    VARCHAR(50) COMMENT '加力',
    `head_on`                        VARCHAR(50) COMMENT '迎头',
    `heading`                        VARCHAR(50) COMMENT '航向',
    `pitch`                          VARCHAR(50) COMMENT '俯仰',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'Rtkn' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

CREATE TABLE IF NOT EXISTS `simulation`.`srd_state`
(
    `sortie_number`           VARCHAR(50) COMMENT '架次号',
    `ground_defense_id`       VARCHAR(50) COMMENT '地防ID',
    `message_time`            TIME(3) COMMENT '消息时间（精确到毫秒）',
    `satellite_guidance_time` TIME(3) COMMENT '卫导时间（精确到毫秒）',
    `local_time`              TIME(3) COMMENT '本地时间（精确到毫秒）',
    `message_sequence_number` BIGINT COMMENT '消息序列号',
    `camp_type`               VARCHAR(50) COMMENT '营地类型',
    `equipment_type`          VARCHAR(50) COMMENT '装备类型',
    `equipment_number`        VARCHAR(50) COMMENT '装备编号',
    `power_on`                VARCHAR(50) COMMENT '是否开机',
    `emitter_frequency_band`  VARCHAR(50) COMMENT '辐射源频段',
    `decoy_blink_period`      VARCHAR(50) COMMENT '诱饵闪烁周期',
    `antenna_pointing`        VARCHAR(50) COMMENT '天线指向',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'SrdState' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

CREATE TABLE IF NOT EXISTS `simulation`.`tgt`
(
    `sortie_number`           VARCHAR(50) COMMENT '架次号',
    `aircraft_id`             VARCHAR(50) COMMENT '飞机ID',
    `message_time`            TIME(3) COMMENT '消息时间（精确到毫秒）',
    `satellite_guidance_time` TIME(3) COMMENT '卫导时间（精确到毫秒）',
    `local_time`              TIME(3) COMMENT '本地时间（精确到毫秒）',
    `message_sequence_number` BIGINT COMMENT '消息序列号',
    `target_count`            VARCHAR(50) COMMENT '目标数量',
    `identifier1`             VARCHAR(50) COMMENT '标识1',
    `sensor1`                 VARCHAR(50) COMMENT '传感器1',
    `pitch1`                  VARCHAR(50) COMMENT '俯仰1',
    `azimuth1`                VARCHAR(50) COMMENT '方位1',
    `slant_range1`            VARCHAR(50) COMMENT '斜距1',
    `identifier2`             VARCHAR(50) COMMENT '标识2',
    `sensor2`                 VARCHAR(50) COMMENT '传感器2',
    `pitch2`                  VARCHAR(50) COMMENT '俯仰2',
    `azimuth2`                VARCHAR(50) COMMENT '方位2',
    `slant_range2`            VARCHAR(50) COMMENT '斜距2',
    `identifier3`             VARCHAR(50) COMMENT '标识3',
    `sensor3`                 VARCHAR(50) COMMENT '传感器3',
    `pitch3`                  VARCHAR(50) COMMENT '俯仰3',
    `azimuth3`                VARCHAR(50) COMMENT '方位3',
    `slant_range3`            VARCHAR(50) COMMENT '斜距3',
    `identifier4`             VARCHAR(50) COMMENT '标识4',
    `sensor4`                 VARCHAR(50) COMMENT '传感器4',
    `pitch4`                  VARCHAR(50) COMMENT '俯仰4',
    `azimuth4`                VARCHAR(50) COMMENT '方位4',
    `slant_range4`            VARCHAR(50) COMMENT '斜距4',
    `identifier5`             VARCHAR(50) COMMENT '标识5',
    `sensor5`                 VARCHAR(50) COMMENT '传感器5',
    `pitch5`                  VARCHAR(50) COMMENT '俯仰5',
    `azimuth5`                VARCHAR(50) COMMENT '方位5',
    `slant_range5`            VARCHAR(50) COMMENT '斜距5',
    `identifier6`             VARCHAR(50) COMMENT '标识6',
    `sensor6`                 VARCHAR(50) COMMENT '传感器6',
    `pitch6`                  VARCHAR(50) COMMENT '俯仰6',
    `azimuth6`                VARCHAR(50) COMMENT '方位6',
    `slant_range6`            VARCHAR(50) COMMENT '斜距6',
    `identifier7`             VARCHAR(50) COMMENT '标识7',
    `sensor7`                 VARCHAR(50) COMMENT '传感器7',
    `pitch7`                  VARCHAR(50) COMMENT '俯仰7',
    `azimuth7`                VARCHAR(50) COMMENT '方位7',
    `slant_range7`            VARCHAR(50) COMMENT '斜距7',
    `identifier8`             VARCHAR(50) COMMENT '标识8',
    `sensor8`                 VARCHAR(50) COMMENT '传感器8',
    `pitch8`                  VARCHAR(50) COMMENT '俯仰8',
    `azimuth8`                VARCHAR(50) COMMENT '方位8',
    `slant_range8`            VARCHAR(50) COMMENT '斜距8',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'Tgt' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

CREATE TABLE IF NOT EXISTS `simulation`.`tspi`
(
    `sortie_number`           VARCHAR(50) COMMENT '架次号',
    `aircraft_id`             VARCHAR(50) COMMENT '飞机ID',
    `aircraft_type`           VARCHAR(50) COMMENT '飞机类型',
    `message_time`            TIME(3) COMMENT '消息时间（精确到毫秒）',
    `satellite_guidance_time` TIME(3) COMMENT '卫导时间（精确到毫秒）',
    `local_time`              TIME(3) COMMENT '本地时间（精确到毫秒）',
    `message_sequence_number` BIGINT COMMENT '消息序列号',
    `longitude`               VARCHAR(50) COMMENT '经度',
    `latitude`                VARCHAR(50) COMMENT '纬度',
    `pressure_altitude`       VARCHAR(50) COMMENT '气压高度',
    `roll`                    VARCHAR(50) COMMENT '横滚',
    `pitch`                   VARCHAR(50) COMMENT '俯仰',
    `heading`                 VARCHAR(50) COMMENT '航向',
    `satellite_altitude`      VARCHAR(50) COMMENT '卫星高度',
    `training_status`         VARCHAR(50) COMMENT '训练状态',
    `chaff`                   VARCHAR(50) COMMENT '干扰弹',
    `afterburner`             VARCHAR(50) COMMENT '加力',
    `north_velocity`          VARCHAR(50) COMMENT '北向速度',
    `vertical_velocity`       VARCHAR(50) COMMENT '天向速度',
    `east_velocity`           VARCHAR(50) COMMENT '东向速度',
    INDEX idx_sortie_number (`sortie_number`)
) COMMENT = 'Tspi' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

/*-
    # 建表时需要在架次号上加索引
    CREATE TABLE IF NOT EXISTS `simulation`.`partition_test`
    (
        `sortie_number` VARCHAR(50) COMMENT '架次号',
        `aircraft_id`   VARCHAR(50) COMMENT '飞机ID',
        INDEX idx_sortie_number (`sortie_number`)
    ) COMMENT = 'PartitionTest' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

    INSERT INTO `simulation`.`partition_test`
    values ('20250303_五_01_ACT-3_邱陈_J16_07#02', '1');

    # 通过 explain 的 access object 得到具体分区 partition:p0
    EXPLAIN
    SELECT 1
    FROM `simulation`.`partition_test`
    WHERE `sortie_number` = '20250303_五_01_ACT-3_邱陈_J16_07#02';
-*/

/*CREATE TABLE `test`
(
    `sortie_number`           varchar(50) DEFAULT NULL COMMENT '架次号',
    `message_time`            time(3)     DEFAULT NULL COMMENT '消息时间（精确到毫秒）',
    `satellite_guidance_time` time(3)     DEFAULT NULL COMMENT '卫导时间（精确到毫秒）',
    `local_time`              time(3)     DEFAULT NULL COMMENT '本地时间（精确到毫秒）'
);*/

# ---------------------------------------- real_world_flight ----------------------------------------
-- asset_summary 表
CREATE TABLE IF NOT EXISTS real_world_flight.asset_summary
(
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

# ---------------------------------------- 采集数据表 ----------------------------------------
CREATE TABLE IF NOT EXISTS collection.collection_task
(
    task_id           BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '任务编号',
    task_status       TINYINT      NOT NULL DEFAULT 0 COMMENT '任务状态', -- 0-已下发未执行 1-执行中 2-已完成 3-执行异常]
    equipment_id      BIGINT       NOT NULL COMMENT '设备序列号',
    sensor_id         BIGINT       NOT NULL COMMENT '传感器序列号',
    sorties_number    VARCHAR(255) NOT NULL COMMENT '架次',
    collector_name    VARCHAR(255) NOT NULL COMMENT '采集人',
    subject_name      VARCHAR(255) NOT NULL COMMENT '被试人',
    collection_device VARCHAR(255) NOT NULL COMMENT '采集设备',
    task_type         VARCHAR(255) NOT NULL COMMENT '任务类型',
    task_start_time   LONG         NOT NULL COMMENT '任务开始时间  UNIX微秒级时间戳',
    creator           VARCHAR(255) NOT NULL COMMENT '任务创建人',
    create_time       LONG         NOT NULL COMMENT '任务创建时间 UNIX微秒级时间戳',
    modifier          VARCHAR(255)          DEFAULT NULL COMMENT '任务修改人',
    modificationTime  LONG                  DEFAULT NULL COMMENT '任务修改时间  UNIX微秒级时间戳'
) COMMENT ='飞行员生理数据采集任务表';

CREATE TABLE IF NOT EXISTS collection.collection_sensor
(
    sensor_id         BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '传感器序列号',
    sensor_name       VARCHAR(255) NOT NULL COMMENT '传感器名称',
    equipment_id      BIGINT       NOT NULL COMMENT '设备序列号',
    manufacturer_id   VARCHAR(255) NOT NULL COMMENT '传感器生产厂家统一社会信用代码',
    manufacturer_name VARCHAR(255) NOT NULL COMMENT '传感器生产厂家名称',
    manufacture_phone VARCHAR(255) NOT NULL COMMENT '传感器生产厂家电话',
    sensor_type       TINYINT      NOT NULL COMMENT '传感器类型',                  -- 0-脑电 1-眼动 2-床垫 ... 采集自己看着办
    additional_info   VARCHAR(255)          DEFAULT NULL COMMENT '传感器附加信息', -- 传感器附加信息
    sensor_status     TINYINT      NOT NULL DEFAULT 0 COMMENT '传感器状态'         -- 0-离线 1-在线空闲 2-在线使用中
) COMMENT ='生理传感器表';

CREATE TABLE IF NOT EXISTS collection.collection_equipment
(
    equipment_id     BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '设备序列号',
    equipment_name   VARCHAR(255) NOT NULL COMMENT '设备名称',
    ip_address       VARCHAR(255) NOT NULL COMMENT 'IP地址',
    equipment_status TINYINT      NOT NULL DEFAULT 0 COMMENT '设备状态',       -- 0-离线 1-在线空闲 2-在线使用中
    equipment_type   TINYINT      NOT NULL COMMENT '设备类型',                 -- 0-机载 1-地面笔记本 2-地面服务器 3-其他
    additional_info  VARCHAR(255)          DEFAULT NULL COMMENT '设备附加信息' -- 设备附加信息
) COMMENT ='采集设备表';

# ---------------------------------------- 生理数据表 ----------------------------------------
#     physiological
CREATE TABLE IF NOT EXISTS physiological.eeg
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    task_id          LONG COMMENT '生理测试任务Id 关联',
    sensor_id        LONG COMMENT '采集用传感器Id',
    sample_timestamp LONG COMMENT '采样时间 微秒级时间戳',
    stream_name      VARCHAR(255) COMMENT 'Stream Name',
    channel_count    INT COMMENT 'Channel Count',
    sampling_rate    DOUBLE COMMENT 'Sampling Rate',
    channel_format   VARCHAR(255) COMMENT 'Channel Format',
    channel_1        FLOAT COMMENT 'Channel_1',
    channel_2        FLOAT COMMENT 'Channel_2',
    channel_3        FLOAT COMMENT 'Channel_3',
    channel_4        FLOAT COMMENT 'Channel_4',
    channel_5        FLOAT COMMENT 'Channel_5',
    channel_6        FLOAT COMMENT 'Channel_6',
    channel_7        FLOAT COMMENT 'Channel_7',
    channel_8        FLOAT COMMENT 'Channel_8',
    channel_9        FLOAT COMMENT 'Channel_9',
    channel_10       FLOAT COMMENT 'Channel_10',
    channel_11       FLOAT COMMENT 'Channel_11',
    channel_12       FLOAT COMMENT 'Channel_12',
    channel_13       FLOAT COMMENT 'Channel_13',
    channel_14       FLOAT COMMENT 'Channel_14',
    channel_15       FLOAT COMMENT 'Channel_15',
    channel_16       FLOAT COMMENT 'Channel_16'
) COMMENT ='脑电数据';

CREATE TABLE IF NOT EXISTS physiological.eye_movement
(
    id                        BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    task_id                   LONG COMMENT '生理测试任务Id 关联',
    sensor_id                 LONG COMMENT '采集用传感器Id',
    sample_timestamp          LONG COMMENT '采样时间 微秒级时间戳',
    pupil_diameter_left_px    FLOAT COMMENT 'Pupil Diameter Left[px]',
    pupil_diameter_left_mm    FLOAT COMMENT 'Pupil Diameter Left[mm]',
    pupil_diameter_right_px   FLOAT COMMENT 'Pupil Diameter Right[px]',
    pupil_diameter_right_mm   FLOAT COMMENT 'Pupil Diameter Right[mm]',
    pupil_distance_left       FLOAT COMMENT 'pupil_distance Left',
    pupil_distance_right      FLOAT COMMENT 'pupil_distance Right',
    pupil_center_x_left       FLOAT COMMENT 'pupil_center_x Left',
    pupil_center_y_left       FLOAT COMMENT 'pupil_center_y Left',
    pupil_center_x_right      FLOAT COMMENT 'pupil_center_x Right',
    pupil_center_y_right      FLOAT COMMENT 'pupil_center_y Right',
    blank_left                INT COMMENT 'blank_Left',
    blank_right               INT COMMENT 'blank_Right',
    openness_left             FLOAT COMMENT 'Openness Left[%]',
    openness_right            FLOAT COMMENT 'Openness Right[%]',
    gaze_point_left_x         FLOAT COMMENT 'Gaze Point Left X[px]',
    gaze_point_left_y         FLOAT COMMENT 'Gaze Point Left Y[px]',
    gaze_point_right_x        FLOAT COMMENT 'Gaze Point Right X[px]',
    gaze_point_right_y        FLOAT COMMENT 'Gaze Point Right Y[px]',
    gaze_origin_left_x        FLOAT COMMENT 'Gaze Origin Left X[mm]',
    gaze_origin_left_y        FLOAT COMMENT 'Gaze Origin Left Y[mm]',
    gaze_origin_left_z        FLOAT COMMENT 'Gaze Origin Left Z[mm]',
    gaze_origin_right_x       FLOAT COMMENT 'Gaze Origin Right X[mm]',
    gaze_origin_right_y       FLOAT COMMENT 'Gaze Origin Right Y[mm]',
    gaze_origin_right_z       FLOAT COMMENT 'Gaze Origin Right Z[mm]',
    gaze_direction_left_x     FLOAT COMMENT 'Gaze Direction Left X',
    gaze_direction_left_y     FLOAT COMMENT 'Gaze Direction Left Y',
    gaze_direction_left_z     FLOAT COMMENT 'Gaze Direction Left Z',
    gaze_direction_right_x    FLOAT COMMENT 'Gaze Direction Right X',
    gaze_direction_right_y    FLOAT COMMENT 'Gaze Direction Right Y',
    gaze_direction_right_z    FLOAT COMMENT 'Gaze Direction Right Z',
    fixation_duration         BIGINT COMMENT 'Fixation Duration[ms]',
    fixation_saccade_count    INT COMMENT 'FIXATION_SACCADE_Count',
    fixation_saccade_state    INT COMMENT 'FIXATION_SACCADE_State',
    fixation_saccade_center_x FLOAT COMMENT 'FIXATION_SACCADE_Center_x',
    fixation_saccade_center_y FLOAT COMMENT 'FIXATION_SACCADE_Center_y'
) COMMENT ='眼动数据';

CREATE TABLE IF NOT EXISTS physiological.motion_capture
(
    id                                       BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    task_id                                  LONG COMMENT '生理测试任务Id 关联',
    sensor_id                                LONG COMMENT '采集用传感器Id',
    sample_timestamp                         LONG COMMENT '采样时间 微秒级时间戳',
    hips_qx                                  FLOAT COMMENT 'Hips_qx',
    hips_qy                                  FLOAT COMMENT 'Hips_qy',
    hips_qz                                  FLOAT COMMENT 'Hips_qz',
    hips_px                                  FLOAT COMMENT 'Hips_px',
    hips_py                                  FLOAT COMMENT 'Hips_py',
    hips_pz                                  FLOAT COMMENT 'Hips_pz',
    hips_timestamp                           LONG COMMENT 'Hips_Timestamp',
    joint_tag_spine_qx                       FLOAT COMMENT 'JointTag_Spine_qx',
    joint_tag_spine_qy                       FLOAT COMMENT 'JointTag_Spine_qy',
    joint_tag_spine_qz                       FLOAT COMMENT 'JointTag_Spine_qz',
    joint_tag_spine_px                       FLOAT COMMENT 'JointTag_Spine_px',
    joint_tag_spine_py                       FLOAT COMMENT 'JointTag_Spine_py',
    joint_tag_spine_pz                       FLOAT COMMENT 'JointTag_Spine_pz',
    joint_tag_spine_timestamp                LONG COMMENT 'JointTag_Spine_Timestamp',
    joint_tag_spine1_qx                      FLOAT COMMENT 'JointTag_Spine1_qx',
    joint_tag_spine1_qy                      FLOAT COMMENT 'JointTag_Spine1_qy',
    joint_tag_spine1_qz                      FLOAT COMMENT 'JointTag_Spine1_qz',
    joint_tag_spine1_px                      FLOAT COMMENT 'JointTag_Spine1_px',
    joint_tag_spine1_py                      FLOAT COMMENT 'JointTag_Spine1_py',
    joint_tag_spine1_pz                      FLOAT COMMENT 'JointTag_Spine1_pz',
    joint_tag_spine1_timestamp               LONG COMMENT 'JointTag_Spine1_Timestamp',
    joint_tag_spine2_qx                      FLOAT COMMENT 'JointTag_Spine2_qx',
    joint_tag_spine2_qy                      FLOAT COMMENT 'JointTag_Spine2_qy',
    joint_tag_spine2_qz                      FLOAT COMMENT 'JointTag_Spine2_qz',
    joint_tag_spine2_px                      FLOAT COMMENT 'JointTag_Spine2_px',
    joint_tag_spine2_py                      FLOAT COMMENT 'JointTag_Spine2_py',
    joint_tag_spine2_pz                      FLOAT COMMENT 'JointTag_Spine2_pz',
    joint_tag_spine2_timestamp               LONG COMMENT 'JointTag_Spine2_Timestamp',
    joint_tag_neck_qx                        FLOAT COMMENT 'JointTag_Neck_qx',
    joint_tag_neck_qy                        FLOAT COMMENT 'JointTag_Neck_qy',
    joint_tag_neck_qz                        FLOAT COMMENT 'JointTag_Neck_qz',
    joint_tag_neck_px                        FLOAT COMMENT 'JointTag_Neck_px',
    joint_tag_neck_py                        FLOAT COMMENT 'JointTag_Neck_py',
    joint_tag_neck_pz                        FLOAT COMMENT 'JointTag_Neck_pz',
    joint_tag_neck_timestamp                 LONG COMMENT 'JointTag_Neck_Timestamp',
    joint_tag_neck1_qx                       FLOAT COMMENT 'JointTag_Neck1_qx',
    joint_tag_neck1_qy                       FLOAT COMMENT 'JointTag_Neck1_qy',
    joint_tag_neck1_qz                       FLOAT COMMENT 'JointTag_Neck1_qz',
    joint_tag_neck1_px                       FLOAT COMMENT 'JointTag_Neck1_px',
    joint_tag_neck1_py                       FLOAT COMMENT 'JointTag_Neck1_py',
    joint_tag_neck1_pz                       FLOAT COMMENT 'JointTag_Neck1_pz',
    joint_tag_neck1_timestamp                LONG COMMENT 'JointTag_Neck1_Timestamp',
    joint_tag_head_qx                        FLOAT COMMENT 'JointTag_Head_qx',
    joint_tag_head_qy                        FLOAT COMMENT 'JointTag_Head_qy',
    joint_tag_head_qz                        FLOAT COMMENT 'JointTag_Head_qz',
    joint_tag_head_px                        FLOAT COMMENT 'JointTag_Head_px',
    joint_tag_head_py                        FLOAT COMMENT 'JointTag_Head_py',
    joint_tag_head_pz                        FLOAT COMMENT 'JointTag_Head_pz',
    joint_tag_head_timestamp                 BIGINT COMMENT 'JointTag_Head_Timestamp',
    joint_tag_right_shoulder_qx              FLOAT COMMENT 'JointTag_RightShoulder_qx',
    joint_tag_right_shoulder_qy              FLOAT COMMENT 'JointTag_RightShoulder_qy',
    joint_tag_right_shoulder_qz              FLOAT COMMENT 'JointTag_RightShoulder_qz',
    joint_tag_right_shoulder_px              FLOAT COMMENT 'JointTag_RightShoulder_px',
    joint_tag_right_shoulder_py              FLOAT COMMENT 'JointTag_RightShoulder_py',
    joint_tag_right_shoulder_pz              FLOAT COMMENT 'JointTag_RightShoulder_pz',
    joint_tag_right_shoulder_timestamp       LONG COMMENT 'JointTag_RightShoulder_Timestamp',
    joint_tag_right_arm_qx                   FLOAT COMMENT 'JointTag_RightArm_qx',
    joint_tag_right_arm_qy                   FLOAT COMMENT 'JointTag_RightArm_qy',
    joint_tag_right_arm_qz                   FLOAT COMMENT 'JointTag_RightArm_qz',
    joint_tag_right_arm_px                   FLOAT COMMENT 'JointTag_RightArm_px',
    joint_tag_right_arm_py                   FLOAT COMMENT 'JointTag_RightArm_py',
    joint_tag_right_arm_pz                   FLOAT COMMENT 'JointTag_RightArm_pz',
    joint_tag_right_arm_timestamp            LONG COMMENT 'JointTag_RightArm_Timestamp',
    joint_tag_right_fore_arm_qx              FLOAT COMMENT 'JointTag_RightForeArm_qx',
    joint_tag_right_fore_arm_qy              FLOAT COMMENT 'JointTag_RightForeArm_qy',
    joint_tag_right_fore_arm_qz              FLOAT COMMENT 'JointTag_RightForeArm_qz',
    joint_tag_right_fore_arm_px              FLOAT COMMENT 'JointTag_RightForeArm_px',
    joint_tag_right_fore_arm_py              FLOAT COMMENT 'JointTag_RightForeArm_py',
    joint_tag_right_fore_arm_pz              FLOAT COMMENT 'JointTag_RightForeArm_pz',
    joint_tag_right_fore_arm_timestamp       LONG COMMENT 'JointTag_RightForeArm_Timestamp',
    joint_tag_right_hand_qx                  FLOAT COMMENT 'JointTag_RightHand_qx',
    joint_tag_right_hand_qy                  FLOAT COMMENT 'JointTag_RightHand_qy',
    joint_tag_right_hand_qz                  FLOAT COMMENT 'JointTag_RightHand_qz',
    joint_tag_right_hand_px                  FLOAT COMMENT 'JointTag_RightHand_px',
    joint_tag_right_hand_py                  FLOAT COMMENT 'JointTag_RightHand_py',
    joint_tag_right_hand_pz                  FLOAT COMMENT 'JointTag_RightHand_pz',
    joint_tag_right_hand_timestamp           LONG COMMENT 'JointTag_RightHand_Timestamp',
    joint_tag_right_in_hand_index_qx         FLOAT COMMENT 'JointTag_RightInHandIndex_qx',
    joint_tag_right_in_hand_index_qy         FLOAT COMMENT 'JointTag_RightInHandIndex_qy',
    joint_tag_right_in_hand_index_qz         FLOAT COMMENT 'JointTag_RightInHandIndex_qz',
    joint_tag_right_in_hand_index_px         FLOAT COMMENT 'JointTag_RightInHandIndex_px',
    joint_tag_right_in_hand_index_py         FLOAT COMMENT 'JointTag_RightInHandIndex_py',
    joint_tag_right_in_hand_index_pz         FLOAT COMMENT 'JointTag_RightInHandIndex_pz',
    joint_tag_right_in_hand_index_timestamp  LONG COMMENT 'JointTag_RightInHandIndex_Timestamp',
    joint_tag_right_in_hand_middle_qx        FLOAT COMMENT 'JointTag_RightInHandMiddle_qx',
    joint_tag_right_in_hand_middle_qy        FLOAT COMMENT 'JointTag_RightInHandMiddle_qy',
    joint_tag_right_in_hand_middle_qz        FLOAT COMMENT 'JointTag_RightInHandMiddle_qz',
    joint_tag_right_in_hand_middle_px        FLOAT COMMENT 'JointTag_RightInHandMiddle_px',
    joint_tag_right_in_hand_middle_py        FLOAT COMMENT 'JointTag_RightInHandMiddle_py',
    joint_tag_right_in_hand_middle_pz        FLOAT COMMENT 'JointTag_RightInHandMiddle_pz',
    joint_tag_right_in_hand_middle_timestamp LONG COMMENT 'JointTag_RightInHandMiddle_Timestamp',
    joint_tag_left_shoulder_qx               FLOAT COMMENT 'JointTag_LeftShoulder_qx',
    joint_tag_left_shoulder_qy               FLOAT COMMENT 'JointTag_LeftShoulder_qy',
    joint_tag_left_shoulder_qz               FLOAT COMMENT 'JointTag_LeftShoulder_qz',
    joint_tag_left_shoulder_px               FLOAT COMMENT 'JointTag_LeftShoulder_px',
    joint_tag_left_shoulder_py               FLOAT COMMENT 'JointTag_LeftShoulder_py',
    joint_tag_left_shoulder_pz               FLOAT COMMENT 'JointTag_LeftShoulder_pz',
    joint_tag_left_shoulder_timestamp        LONG COMMENT 'JointTag_LeftShoulder_Timestamp',
    joint_tag_left_arm_qx                    FLOAT COMMENT 'JointTag_LeftArm_qx',
    joint_tag_left_arm_qy                    FLOAT COMMENT 'JointTag_LeftArm_qy',
    joint_tag_left_arm_qz                    FLOAT COMMENT 'JointTag_LeftArm_qz',
    joint_tag_left_arm_px                    FLOAT COMMENT 'JointTag_LeftArm_px',
    joint_tag_left_arm_py                    FLOAT COMMENT 'JointTag_LeftArm_py',
    joint_tag_left_arm_pz                    FLOAT COMMENT 'JointTag_LeftArm_pz',
    joint_tag_left_arm_timestamp             LONG COMMENT 'JointTag_LeftArm_Timestamp',
    joint_tag_left_fore_arm_qx               FLOAT COMMENT 'JointTag_LeftForeArm_qx',
    joint_tag_left_fore_arm_qy               FLOAT COMMENT 'JointTag_LeftForeArm_qy',
    joint_tag_left_fore_arm_qz               FLOAT COMMENT 'JointTag_LeftForeArm_qz',
    joint_tag_left_fore_arm_px               FLOAT COMMENT 'JointTag_LeftForeArm_px',
    joint_tag_left_fore_arm_py               FLOAT COMMENT 'JointTag_LeftForeArm_py',
    joint_tag_left_fore_arm_pz               FLOAT COMMENT 'JointTag_LeftForeArm_pz',
    joint_tag_left_fore_arm_timestamp        LONG COMMENT 'JointTag_LeftForeArm_Timestamp',
    joint_tag_left_hand_qx                   FLOAT COMMENT 'JointTag_LeftHand_qx',
    joint_tag_left_hand_qy                   FLOAT COMMENT 'JointTag_LeftHand_qy',
    joint_tag_left_hand_qz                   FLOAT COMMENT 'JointTag_LeftHand_qz',
    joint_tag_left_hand_px                   FLOAT COMMENT 'JointTag_LeftHand_px',
    joint_tag_left_hand_py                   FLOAT COMMENT 'JointTag_LeftHand_py',
    joint_tag_left_hand_pz                   FLOAT COMMENT 'JointTag_LeftHand_pz',
    joint_tag_left_hand_timestamp            LONG COMMENT 'JointTag_LeftHand_Timestamp',
    joint_tag_left_in_hand_index_qx          FLOAT COMMENT 'JointTag_LeftInHandIndex_qx',
    joint_tag_left_in_hand_index_qy          FLOAT COMMENT 'JointTag_LeftInHandIndex_qy',
    joint_tag_left_in_hand_index_qz          FLOAT COMMENT 'JointTag_LeftInHandIndex_qz',
    joint_tag_left_in_hand_index_px          FLOAT COMMENT 'JointTag_LeftInHandIndex_px',
    joint_tag_left_in_hand_index_py          FLOAT COMMENT 'JointTag_LeftInHandIndex_py',
    joint_tag_left_in_hand_index_pz          FLOAT COMMENT 'JointTag_LeftInHandIndex_pz',
    joint_tag_left_in_hand_index_timestamp   LONG COMMENT 'JointTag_LeftInHandIndex_Timestamp',
    joint_tag_left_in_hand_middle_qx         FLOAT COMMENT 'JointTag_LeftInHandMiddle_qx',
    joint_tag_left_in_hand_middle_qy         FLOAT COMMENT 'JointTag_LeftInHandMiddle_qy',
    joint_tag_left_in_hand_middle_qz         FLOAT COMMENT 'JointTag_LeftInHandMiddle_qz',
    joint_tag_left_in_hand_middle_px         FLOAT COMMENT 'JointTag_LeftInHandMiddle_px',
    joint_tag_left_in_hand_middle_py         FLOAT COMMENT 'JointTag_LeftInHandMiddle_py',
    joint_tag_left_in_hand_middle_pz         FLOAT COMMENT 'JointTag_LeftInHandMiddle_pz',
    joint_tag_left_in_hand_middle_timestamp  LONG COMMENT 'JointTag_LeftInHandMiddle_Timestamp'
) COMMENT ='三维动捕数据';

CREATE TABLE IF NOT EXISTS physiological.t_shirt_ecg_accel_gyro
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '我们自己加的主键 auto_increment bigint',
    task_id          LONG COMMENT '生理测试任务Id 关联',
    sensor_id        LONG COMMENT '采集用传感器Id',
    sample_timestamp LONG COMMENT '采样时间 微秒级时间戳',
    ecg1             DOUBLE COMMENT 'ECG通道1数据(24位原始值转换后的电压或其它单位)',
    ecg2             DOUBLE COMMENT 'ECG通道2数据',
    ecg3             DOUBLE COMMENT 'ECG通道3数据'
) COMMENT ='Tshirt的ECG数据';

CREATE TABLE IF NOT EXISTS physiological.t_shirt_resp_data
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '我们自己加的主键 auto_increment bigint',
    task_id          LONG COMMENT '生理测试任务Id 关联',
    sensor_id        LONG COMMENT '采集用传感器Id',
    sample_timestamp LONG COMMENT '采样时间 微秒级时间戳',
    resp_data        JSON COMMENT '呼吸带原始数据，存储50个采样点(数组或JSON字符串)'
) COMMENT ='Tshirt的Resp数据';

CREATE TABLE IF NOT EXISTS physiological.t_shirt_temp_sp_o2_data
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '我们自己加的主键 auto_increment bigint',
    task_id          LONG COMMENT '生理测试任务Id 关联',
    sensor_id        LONG COMMENT '采集用传感器Id',
    sample_timestamp LONG COMMENT '采样时间 微秒级时间戳',
    temperature      FLOAT COMMENT '腋下体温(转换后的温度值单位℃)',
    spo2             INT COMMENT '血氧饱和度(转换后的血氧值单位%)'
) COMMENT ='Tshirt的温度和饱和度数据';

CREATE TABLE IF NOT EXISTS physiological.wristband_ppg_accel_data
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '我们自己加的主键 auto_increment bigint',
    task_id          LONG COMMENT '生理测试任务Id 关联',
    sensor_id        LONG COMMENT '采集用传感器Id',
    sample_timestamp LONG COMMENT '采样时间 微秒级时间戳',
    accel_x          DOUBLE COMMENT '腕部加速度X轴(从6字节加速度数据中转换得到)',
    accel_y          DOUBLE COMMENT '腕部加速度Y轴(从6字节加速度数据中转换得到)',
    accel_z          DOUBLE COMMENT '腕部加速度Z轴(从6字节加速度数据中转换得到)',
    ppg_red1         JSON COMMENT '红光PPG通道1数据，存储五个采样点（JSON数组格式）',
    ppg_red2         JSON COMMENT '红光PPG通道2数据，存储五个采样点（JSON数组格式）',
    ppg_red3         JSON COMMENT '红光PPG通道3数据，存储五个采样点（JSON数组格式）',
    ppg_red4         JSON COMMENT '红光PPG通道4数据，存储五个采样点（JSON数组格式）',
    ppg_infrared1    JSON COMMENT '红外PPG通道1数据，存储五个采样点（JSON数组格式）',
    ppg_infrared2    JSON COMMENT '红外PPG通道2数据，存储五个采样点（JSON数组格式）',
    ppg_infrared3    JSON COMMENT '红外PPG通道3数据，存储五个采样点（JSON数组格式）',
    ppg_infrared4    JSON COMMENT '红外PPG通道4数据，存储五个采样点（JSON数组格式）'
) COMMENT ='腕带PPG和加速度数据';

# 按库构建 TiFlash 副本
ALTER DATABASE `human_machine` SET TIFLASH REPLICA 1;
ALTER DATABASE `flight_plan` SET TIFLASH REPLICA 1;
ALTER DATABASE `simulation` SET TIFLASH REPLICA 1;
ALTER DATABASE `real_world_flight` SET TIFLASH REPLICA 1;
ALTER DATABASE `sorties` SET TIFLASH REPLICA 1;
ALTER DATABASE `physiological` SET TIFLASH REPLICA 1;
ALTER DATABASE `collection` SET TIFLASH REPLICA 1;
