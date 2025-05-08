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
    `id`    BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    `key`   VARCHAR(255) NOT NULL COMMENT '配置项',
    `value` TEXT         NOT NULL COMMENT '配置值'
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
    `id`               varchar(255) NOT NULL COMMENT '根ID',
    `flight_date`      date     DEFAULT NULL COMMENT '飞行日期',
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
    `id`               varchar(255) NOT NULL COMMENT '根ID',
    `flight_date`      date     DEFAULT NULL COMMENT '飞行日期',
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
    `id`               varchar(255) NOT NULL COMMENT '根ID',
    `flight_date`      date     DEFAULT NULL COMMENT '飞行日期',
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
# -- 生理数据输入
-- 脑电数据表
CREATE TABLE IF NOT EXISTS physiological.eeg_input
(
    Timestamp_BG   TIMESTAMP(6) COMMENT '采集数据阶段开始时间点',
    Timestamp_ED   TIMESTAMP(6) COMMENT '采集数据阶段结束时间点',
    Timestamp      TIMESTAMP(6) COMMENT '时间戳',
    Scenario       SMALLINT COMMENT '类型 1：sz  2：地面',
    Subject_ID     VARCHAR(50) COMMENT '飞行员ID',
    Task_ID        BIGINT COMMENT '任务标识号',
    sortieNumber   VARCHAR(50) COMMENT '架次号',
    NAODIAN_ID     INT COMMENT '脑电设备ID',
    Sampling_Rate  DOUBLE COMMENT '采样率',
    Channel_Format VARCHAR(100) COMMENT '通道格式',
    Channel_1      FLOAT COMMENT '脑电原始电信号值1',
    Channel_2      FLOAT COMMENT '脑电原始电信号值2',
    Channel_3      FLOAT COMMENT '脑电原始电信号值3',
    Channel_4      FLOAT COMMENT '脑电原始电信号值4',
    Channel_5      FLOAT COMMENT '脑电原始电信号值5',
    Channel_6      FLOAT COMMENT '脑电原始电信号值6',
    Channel_7      FLOAT COMMENT '脑电原始电信号值7',
    Channel_8      FLOAT COMMENT '脑电原始电信号值8',
    Channel_9      FLOAT COMMENT '脑电原始电信号值9',
    Channel_10     FLOAT COMMENT '脑电原始电信号值10',
    Channel_11     FLOAT COMMENT '脑电原始电信号值11',
    Channel_12     FLOAT COMMENT '脑电原始电信号值12',
    Channel_13     FLOAT COMMENT '脑电原始电信号值13',
    Channel_14     FLOAT COMMENT '脑电原始电信号值14',
    Channel_15     FLOAT COMMENT '脑电原始电信号值15',
    Channel_16     FLOAT COMMENT '脑电原始电信号值16',
    PRIMARY KEY (Timestamp, Subject_ID)
) COMMENT = '脑电数据输入';

-- 眼动数据表
CREATE TABLE IF NOT EXISTS physiological.eye_movement_input
(
    Timestamp_BG              TIMESTAMP(6) COMMENT '采集数据阶段开始时间点',
    Timestamp_ED              TIMESTAMP(6) COMMENT '采集数据阶段结束时间点',
    Timestamp                 TIMESTAMP(6) COMMENT '时间戳',
    Scenario                  SMALLINT COMMENT '类型 1：sz  2：地面',
    Subject_ID                VARCHAR(50) COMMENT '飞行员ID',
    Task_ID                   BIGINT COMMENT '任务标识号',
    sortieNumber              VARCHAR(50) COMMENT '架次号',
    YANDONG_id                INT COMMENT '眼动设备ID，眼动仪',
    Pupil_Diameter_Left_px    FLOAT COMMENT '左眼瞳孔直径，瞳孔长轴(0-1)，像素值与图像宽的比值',
    Pupil_Diameter_Left_mm    FLOAT COMMENT '左眼瞳孔直径，长轴毫米值(mm)',
    Pupil_Diameter_Right_px   FLOAT COMMENT '右眼瞳孔直径，瞳孔长轴(0-1)，像素值与图像宽的比值',
    Pupil_Diameter_Right_mm   FLOAT COMMENT '右眼瞳孔直径，长轴毫米值(mm)',
    pupil_distance_Left       FLOAT COMMENT '左眼瞳孔到镜头距离(mm)',
    pupil_distance_Right      FLOAT COMMENT '右眼瞳孔到镜头距离(mm)',
    pupil_center_x_Left       FLOAT COMMENT '左眼瞳孔中心X，归一化(0-1)，X轴水平向右，Y轴垂直向下',
    pupil_center_y_Left       FLOAT COMMENT '左眼瞳孔中心Y，归一化(0-1)，X轴水平向右，Y轴垂直向下',
    pupil_center_x_Right      FLOAT COMMENT '右眼瞳孔中心X，归一化(0-1)，X轴水平向右，Y轴垂直向下',
    pupil_center_y_Right      FLOAT COMMENT '右眼瞳孔中心Y，归一化(0-1)，X轴水平向右，Y轴垂直向下',
    blank_Left                INT COMMENT '左眼眨眼信息(0-5)：0 非眨眼，1 开始，2 闭眼过程，3 闭眼，4 睁眼过程，5 结束',
    blank_Right               INT COMMENT '右眼眨眼信息(0-5)：0 非眨眼，1 开始，2 闭眼过程，3 闭眼，4 睁眼过程，5 结束',
    Openness_Left             FLOAT COMMENT '左眼开合度(0-100)，接近0闭眼，100正常睁眼，大于100瞪眼',
    Openness_Right            FLOAT COMMENT '右眼开合度(0-100)，接近0闭眼，100正常睁眼，大于100瞪眼',
    Gaze_Point_Left_X         FLOAT COMMENT '左眼注视点X，范围依校准点',
    Gaze_Point_Left_Y         FLOAT COMMENT '左眼注视点Y，范围依校准点',
    Gaze_Point_Right_X        FLOAT COMMENT '右眼注视点X，范围依校准点',
    Gaze_Point_Right_Y        FLOAT COMMENT '右眼注视点Y，范围依校准点',
    Gaze_Origin_Left_X        FLOAT COMMENT '左眼注视瞳孔中心X坐标',
    Gaze_Origin_Left_Y        FLOAT COMMENT '左眼注视瞳孔中心Y坐标',
    Gaze_Origin_Left_Z        FLOAT COMMENT '左眼注视瞳孔中心Z坐标',
    Gaze_Origin_Right_X       FLOAT COMMENT '右眼注视瞳孔中心X坐标',
    Gaze_Origin_Right_Y       FLOAT COMMENT '右眼注视瞳孔中心Y坐标',
    Gaze_Origin_Right_Z       FLOAT COMMENT '右眼注视瞳孔中心Z坐标',
    Gaze_Direction_Left_X     FLOAT COMMENT '左眼注视矢量X分量',
    Gaze_Direction_Left_Y     FLOAT COMMENT '左眼注视矢量Y分量',
    Gaze_Direction_Left_Z     FLOAT COMMENT '左眼注视矢量Z分量',
    Gaze_Direction_Right_X    FLOAT COMMENT '右眼注视矢量X分量',
    Gaze_Direction_Right_Y    FLOAT COMMENT '右眼注视矢量Y分量',
    Gaze_Direction_Right_Z    FLOAT COMMENT '右眼注视矢量Z分量',
    Fixation_Duration_us      BIGINT COMMENT '持续时长，单位us',
    FIXATION_SACCADE_Count    INT COMMENT '参与注视的原始数据个数',
    FIXATION_SACCADE_State    INT COMMENT '注视状态',
    FIXATION_SACCADE_Center_x DOUBLE COMMENT '注视中心点X坐标',
    FIXATION_SACCADE_Center_y DOUBLE COMMENT '注视中心点Y坐标',
    ZYLSP_attr_1              FLOAT COMMENT '可选：待确定数据',
    ZYLSP_attr_2              FLOAT COMMENT '可选：待确定数据',
    PRIMARY KEY (Timestamp, Subject_ID)
) COMMENT = '眼动数据输入';

-- 脑氧数据表
CREATE TABLE IF NOT EXISTS physiological.hbo_input
(
    Timestamp_BG TIMESTAMP(6) COMMENT '采集数据阶段开始时间点',
    Timestamp_ED TIMESTAMP(6) COMMENT '采集数据阶段结束时间点',
    Timestamp    TIMESTAMP(6) COMMENT '时间戳',
    Scenario     SMALLINT COMMENT '类型 1：sz  2：地面',
    Subject_ID   VARCHAR(50) COMMENT '飞行员ID',
    Task_ID      BIGINT COMMENT '任务标识号',
    sortieNumber VARCHAR(50) COMMENT '架次号',
    deviceId     INT COMMENT '设备ID',
    HBO          INT COMMENT '脑氧饱和度',
    PRIMARY KEY (Timestamp, Subject_ID)
) COMMENT = '脑氧数据输入';

-- 心理量表数据表
CREATE TABLE IF NOT EXISTS physiological.psychological_scale_input
(
    Timestamp_BG          TIMESTAMP(6) COMMENT '采集数据阶段开始时间点',
    Timestamp_ED          TIMESTAMP(6) COMMENT '采集数据阶段结束时间点',
    Timestamp             TIMESTAMP(6) COMMENT '时间戳',
    Scenario              SMALLINT COMMENT '类型 1：sz  2：地面',
    Subject_ID            VARCHAR(50) COMMENT '飞行员ID',
    Task_ID               BIGINT COMMENT '任务标识号',
    sortieNumber          VARCHAR(50) COMMENT '架次号',
    YJQD_scale_type       JSON COMMENT '量表种类，JSON 格式',
    YJQD_scale_score      JSON COMMENT '量表打分方式，JSON 格式',
    YJQD_scale_sub_scores JSON COMMENT '分项得分，JSON 格式',
    PRIMARY KEY (Timestamp, Subject_ID)
) COMMENT = '心理量表数据输入';

-- 手环数据表
CREATE TABLE IF NOT EXISTS physiological.wristband_input
(
    Timestamp_BG  TIMESTAMP(6) COMMENT '采集数据阶段开始时间点',
    Timestamp_ED  TIMESTAMP(6) COMMENT '采集数据阶段结束时间点',
    Timestamp     TIMESTAMP(6) COMMENT '时间戳',
    Scenario      SMALLINT COMMENT '类型 1：sz  2：地面',
    Subject_ID    VARCHAR(50) COMMENT '飞行员ID',
    Task_ID       BIGINT COMMENT '任务标识号',
    sortieNumber  VARCHAR(50) COMMENT '架次号',
    SHOUHUAN_id   INT COMMENT '手环设备ID',
    accel_x       DOUBLE COMMENT '腕部加速度X轴（从6字节加速度数据中转换得到）',
    accel_y       DOUBLE COMMENT '腕部加速度Y轴（从6字节加速度数据中转换得到）',
    accel_z       DOUBLE COMMENT '腕部加速度Z轴（从6字节加速度数据中转换得到）',
    ppg_red1      JSON COMMENT '红光PPG通道1数据，存储5个采样点（JSON数组格式）',
    ppg_red2      JSON COMMENT '红光PPG通道2数据，存储5个采样点（JSON数组格式）',
    ppg_red3      JSON COMMENT '红光PPG通道3数据，存储5个采样点（JSON数组格式）',
    ppg_red4      JSON COMMENT '红光PPG通道4数据，存储5个采样点（JSON数组格式）',
    ppg_infrared1 JSON COMMENT '红外PPG通道1数据，存储5个采样点（JSON数组格式）',
    ppg_infrared2 JSON COMMENT '红外PPG通道2数据，存储5个采样点（JSON数组格式）',
    ppg_infrared3 JSON COMMENT '红外PPG通道3数据，存储5个采样点（JSON数组格式）',
    ppg_infrared4 JSON COMMENT '红外PPG通道4数据，存储5个采样点（JSON数组格式）',
    spo2          INT COMMENT '血氧饱和度，范围为 0~100%',
    gsr_data      JSON COMMENT '皮肤电导数据，采用JSON格式存储，存储10个采样点',
    PRIMARY KEY (Timestamp, Subject_ID)
) COMMENT = '手环生理数据输入';

-- T恤数据表
CREATE TABLE IF NOT EXISTS physiological.tshirt_input
(
    Timestamp_BG     TIMESTAMP(6) COMMENT '采集数据阶段开始时间点',
    Timestamp_ED     TIMESTAMP(6) COMMENT '采集数据阶段结束时间点',
    Timestamp        TIMESTAMP(6) COMMENT '时间戳',
    Scenario         SMALLINT COMMENT '类型 1：sz  2：地面',
    Subject_ID       VARCHAR(50) COMMENT '飞行员ID',
    Task_ID          BIGINT COMMENT '任务标识号',
    sortieNumber     VARCHAR(50) COMMENT '架次号',
    device_id        INT COMMENT 'T恤设备ID',
    ecg1             JSON COMMENT 'T恤ECG通道1数据（一组十个采样点，JSON格式）',
    ecg2             JSON COMMENT 'T恤ECG通道2数据（JSON格式）',
    ecg3             JSON COMMENT 'T恤ECG通道3数据（JSON格式）',
    heart_rate       INT COMMENT 'ECG计算得到的心率，单位：BPM（次/分钟）',
    hrv              JSON COMMENT 'ECG计算得到的心率变异性（HRV），JSON格式',
    resp_data        JSON COMMENT 'T恤呼吸带原始数据，存储50个采样点（JSON数组或字符串）',
    respiratory_rate DOUBLE COMMENT 'T恤计算得到的呼吸率，单位：次/分钟',
    temperature      FLOAT COMMENT 'T恤腋下体温（转换后的温度值，单位℃）',
    PRIMARY KEY (Timestamp, Subject_ID)
) COMMENT = '多通道T恤生理数据输入';


# -- 生理数据输出
-- 注意力水平表
CREATE TABLE physiological.attention_level
(
    ZYLSP_Timestamp_OUTPUT TIMESTAMP(6) COMMENT '时间戳',
    ZYLSP_Scenario         INT COMMENT '类型 1：sz  2：地面',
    ZYLSP_Subject_ID       VARCHAR(10) COMMENT '飞行员ID',
    ZYLSP_Task_ID          INT COMMENT '任务标识号',
    ZYLSP_LEVEL            INT COMMENT '注意力水平等级标识（0-分散/1-适度集中/2-高度集中）',
    ZYLSP_PR               FLOAT COMMENT '注意力水平类别概率值',
    ZYLSP_SCORE            FLOAT COMMENT '注意力水平量化值',
    ZYLSP_ATTR_1           FLOAT COMMENT '注意力水平可选：待确定数据1',
    ZYLSP_ATTR_2           FLOAT COMMENT '注意力水平可选：待确定数据2'
) COMMENT '注意力水平';

-- 警觉度表
CREATE TABLE physiological.alertness
(
    JJD_Timestamp_OUTPUT TIMESTAMP(6) COMMENT '时间戳',
    JJD_Scenario         INT COMMENT '类型 1：sz  2：地面',
    JJD_Subject_ID       VARCHAR(10) COMMENT '飞行员ID',
    JJD_Task_ID          INT COMMENT '任务标识号',
    JJD_LEVEL            INT COMMENT '警觉度等级标识（0-低警觉/1-适度警觉/2-高度警觉）',
    JJD_PR               FLOAT COMMENT '警觉度类别概率值',
    JJD_SCORE            FLOAT COMMENT '警觉度量化值',
    JJD_ATTR_1           FLOAT COMMENT '警觉度可选：待确定数据1',
    JJD_ATTR_2           FLOAT COMMENT '警觉度可选：待确定数据2'
) COMMENT '警觉度';

-- 平衡感知表
CREATE TABLE physiological.balance_perception
(
    PHGZ_Timestamp_OUTPUT TIMESTAMP(6) COMMENT '时间戳',
    PHGZ_Scenario         INT COMMENT '类型 1：sz  2：地面',
    PHGZ_Subject_ID       VARCHAR(10) COMMENT '飞行员ID',
    PHGZ_Task_ID          INT COMMENT '任务标识号',
    PHGZ_LEVEL            INT COMMENT '平衡感知等级标识（0-过度补偿/1-失衡/2-动态平衡/3-稳定平衡）',
    PHGZ_PR               FLOAT COMMENT '平衡感知类别概率值',
    PHGZ_SCORE            FLOAT COMMENT '平衡感知量化值',
    PHGZ_ATTR_1           FLOAT COMMENT '平衡感知可选：待确定数据1',
    PHGZ_ATTR_2           FLOAT COMMENT '平衡感知可选：待确定数据2'
) COMMENT '平衡感知';

-- 睡眠质量表
CREATE TABLE physiological.sleep_quality
(
    SMZL_Timestamp_OUTPUT TIMESTAMP(6) COMMENT '时间戳',
    SMZL_Scenario         INT COMMENT '类型 1：sz  2：地面',
    SMZL_Subject_ID       VARCHAR(10) COMMENT '飞行员ID',
    SMZL_Task_ID          INT COMMENT '任务标识号',
    SMZL_LEVEL            INT COMMENT '睡眠质量等级标识（0-不良/1-一般/2-优质）',
    SMZL_PR               FLOAT COMMENT '睡眠质量类别概率值',
    SMZL_SCORE            FLOAT COMMENT '睡眠质量量化值',
    SMZL_ATTR_1           FLOAT COMMENT '睡眠质量可选：待确定数据1',
    SMZL_ATTR_2           FLOAT COMMENT '睡眠质量可选：待确定数据2'
) COMMENT '睡眠质量';

-- 作息节律表
CREATE TABLE physiological.circadian_rhythm
(
    ZXJL_Timestamp_OUTPUT TIMESTAMP(6) COMMENT '时间戳',
    ZXJL_Scenario         INT COMMENT '类型 1：sz  2：地面',
    ZXJL_Subject_ID       VARCHAR(10) COMMENT '飞行员ID',
    ZXJL_Task_ID          INT COMMENT '任务标识号',
    ZXJL_LEVEL            INT COMMENT '作息节律等级标识（待定）',
    ZXJL_PR               FLOAT COMMENT '作息节律类别概率值',
    ZXJL_SCORE            FLOAT COMMENT '作息节律量化值',
    ZXJL_ATTR_1           FLOAT COMMENT '作息节律可选：待确定数据1',
    ZXJL_ATTR_2           FLOAT COMMENT '作息节律可选：待确定数据2'
) COMMENT '作息节律';

-- 肩部肌肉疲劳表
CREATE TABLE physiological.shoulder_fatigue
(
    JABJRPL_Timestamp_OUTPUT TIMESTAMP(6) COMMENT '时间戳',
    JABJRPL_Scenario         INT COMMENT '类型 1：sz  2：地面',
    JABJRPL_Subject_ID       VARCHAR(10) COMMENT '飞行员ID',
    JABJRPL_Task_ID          INT COMMENT '任务标识号',
    JABJRPL_LEVEL            INT COMMENT '肩部肌肉疲劳等级标识（0-非疲劳/1-轻度疲劳/2-重度疲劳）',
    JABJRPL_PR               FLOAT COMMENT '肩部肌肉疲劳类别概率值',
    JABJRPL_SCORE            FLOAT COMMENT '肩部肌肉疲劳量化值',
    JABJRPL_ATTR_1           FLOAT COMMENT '肩部肌肉疲劳可选：待确定数据1',
    JABJRPL_ATTR_2           FLOAT COMMENT '肩部肌肉疲劳可选：待确定数据2'
) COMMENT '肩部肌肉疲劳';

-- 颈部肌肉疲劳
CREATE TABLE physiological.neck_fatigue
(
    JIBJRPL_Timestamp_OUTPUT TIMESTAMP(6) COMMENT '时间戳',
    JIBJRPL_Scenario         INT COMMENT '类型 1：sz  2：地面',
    JIBJRPL_Subject_ID       VARCHAR(10) COMMENT '飞行员ID',
    JIBJRPL_Task_ID          INT COMMENT '任务标识号',
    JIBJRPL_LEVEL            INT COMMENT '颈部肌肉疲劳等级标识（0-非疲劳/1-轻度疲劳/2-重度疲劳）',
    JIBJRPL_PR               FLOAT COMMENT '颈部肌肉疲劳类别概率值',
    JIBJRPL_SCORE            FLOAT COMMENT '颈部肌肉疲劳量化值',
    JIBJRPL_ATTR_1           FLOAT COMMENT '颈部肌肉疲劳可选：待确定数据1',
    JIBJRPL_ATTR_2           FLOAT COMMENT '颈部肌肉疲劳可选：待确定数据2'
) COMMENT '颈部肌肉疲劳';

-- 手臂肌肉疲劳表
CREATE TABLE physiological.arm_fatigue
(
    SBJRPL_Timestamp_OUTPUT TIMESTAMP(6) COMMENT '时间戳',
    SBJRPL_Scenario         INT COMMENT '类型 1：sz  2：地面',
    SBJRPL_Subject_ID       VARCHAR(10) COMMENT '飞行员ID',
    SBJRPL_Task_ID          INT COMMENT '任务标识号',
    SBJRPL_LEVEL            INT COMMENT '手臂肌肉疲劳等级标识（0-非疲劳/1-轻度疲劳/2-重度疲劳）',
    SBJRPL_PR               FLOAT COMMENT '手臂肌肉疲劳类别概率值',
    SBJRPL_SCORE            FLOAT COMMENT '手臂肌肉疲劳量化值',
    SBJRPL_ATTR_1           FLOAT COMMENT '手臂肌肉疲劳可选：待确定数据1',
    SBJRPL_ATTR_2           FLOAT COMMENT '手臂肌肉疲劳可选：待确定数据2'
) COMMENT '手臂肌肉疲劳';

-- 腰部肌肉疲劳表
CREATE TABLE physiological.waist_fatigue
(
    YBJRPL_Timestamp_OUTPUT TIMESTAMP(6) COMMENT '时间戳',
    YBJRPL_Scenario         INT COMMENT '类型 1：sz  2：地面',
    YBJRPL_Subject_ID       VARCHAR(10) COMMENT '飞行员ID',
    YBJRPL_Task_ID          INT COMMENT '任务标识号',
    YBJRPL_LEVEL            INT COMMENT '腰部肌肉疲劳等级标识（0-非疲劳/1-轻度疲劳/2-重度疲劳）',
    YBJRPL_PR               FLOAT COMMENT '腰部肌肉疲劳类别概率值',
    YBJRPL_SCORE            FLOAT COMMENT '腰部肌肉疲劳量化值',
    YBJRPL_ATTR_1           FLOAT COMMENT '腰部肌肉疲劳可选：待确定数据1',
    YBJRPL_ATTR_2           FLOAT COMMENT '腰部肌肉疲劳可选：待确定数据2'
) COMMENT '腰部肌肉疲劳';

-- 脑力负荷表
CREATE TABLE physiological.mental_workload
(
    NLFH_Timestamp_OUTPUT TIMESTAMP(6) COMMENT '时间戳',
    NLFH_Scenario         INT COMMENT '类型 1：sz  2：地面',
    NLFH_Subject_ID       VARCHAR(10) COMMENT '飞行员ID',
    NLFH_Task_ID          INT COMMENT '任务标识号',
    NLFH_LEVEL            INT COMMENT '脑力负荷等级标识（0-低负荷/1-中负荷/2-高负荷）',
    NLFH_PR               FLOAT COMMENT '脑力负荷类别概率值',
    NLFH_SCORE            FLOAT COMMENT '脑力负荷量化值',
    NLFH_ATTR_1           FLOAT COMMENT '脑力负荷可选：待确定数据1',
    NLFH_ATTR_2           FLOAT COMMENT '脑力负荷可选：待确定数据2'
) COMMENT '脑力负荷';

-- 任务应激状态表
CREATE TABLE physiological.task_stress_status
(
    RWYJZT_Timestamp_OUTPUT TIMESTAMP(6) COMMENT '时间戳',
    RWYJZT_Scenario         INT COMMENT '类型 1：sz  2：地面',
    RWYJZT_Subject_ID       VARCHAR(10) COMMENT '飞行员ID',
    RWYJZT_Task_ID          INT COMMENT '任务标识号',
    RWYJZT_LEVEL            INT COMMENT '任务应激状态等级标识（0-正常/1-应激）',
    RWYJZT_PR               FLOAT COMMENT '任务应激状态类别概率值',
    RWYJZT_SCORE            FLOAT COMMENT '任务应激状态量化值',
    RWYJZT_ATTR_1           FLOAT COMMENT '任务应激状态可选：待确定数据1',
    RWYJZT_ATTR_2           FLOAT COMMENT '任务应激状态可选：待确定数据2'
) COMMENT '任务应激状态';

-- 精神疲劳表
CREATE TABLE physiological.mental_fatigue
(
    JSPL_Timestamp_OUTPUT TIMESTAMP(6) COMMENT '时间戳',
    JSPL_Scenario         INT COMMENT '类型 1：sz  2：地面',
    JSPL_Subject_ID       VARCHAR(10) COMMENT '飞行员ID',
    JSPL_Task_ID          INT COMMENT '任务标识号',
    JSPL_LEVEL            INT COMMENT '精神疲劳等级标识（0-轻度疲劳/1-中度疲劳/2-重度疲劳）',
    JSPL_PR               FLOAT COMMENT '精神疲劳类别概率值',
    JSPL_SCORE            FLOAT COMMENT '精神疲劳量化值',
    JSPL_ATTR_1           FLOAT COMMENT '精神疲劳可选：待确定数据1',
    JSPL_ATTR_2           FLOAT COMMENT '精神疲劳可选：待确定数据2'
) COMMENT '精神疲劳';

-- 视觉负荷表
CREATE TABLE physiological.visual_workload
(
    SJFH_Timestamp_OUTPUT TIMESTAMP(6) COMMENT '时间戳',
    SJFH_Scenario         INT COMMENT '类型 1：sz  2：地面',
    SJFH_Subject_ID       VARCHAR(10) COMMENT '飞行员ID',
    SJFH_Task_ID          INT COMMENT '任务标识号',
    SJFH_LEVEL            INT COMMENT '视觉负荷等级标识（0-低负荷/1-中负荷/2-高负荷）',
    SJFH_PR               FLOAT COMMENT '视觉负荷类别概率值',
    SJFH_SCORE            FLOAT COMMENT '视觉负荷量化值',
    SJFH_ATTR_1           FLOAT COMMENT '视觉负荷可选：待确定数据1',
    SJFH_ATTR_2           FLOAT COMMENT '视觉负荷可选：待确定数据2'
) COMMENT '视觉负荷';

-- 体力负荷表
CREATE TABLE physiological.physical_workload
(
    TLFH_Timestamp_OUTPUT TIMESTAMP(6) COMMENT '时间戳',
    TLFH_Scenario         INT COMMENT '类型 1：sz  2：地面',
    TLFH_Subject_ID       VARCHAR(10) COMMENT '飞行员ID',
    TLFH_Task_ID          INT COMMENT '任务标识号',
    TLFH_LEVEL            INT COMMENT '体力负荷等级标识（0-低负荷/1-中负荷/2-高负荷）',
    TLFH_PR               FLOAT COMMENT '体力负荷类别概率值',
    TLFH_SCORE            FLOAT COMMENT '体力负荷量化值',
    TLFH_ATTR_1           FLOAT COMMENT '体力负荷可选：待确定数据1',
    TLFH_ATTR_2           FLOAT COMMENT '体力负荷可选：待确定数据2'
) COMMENT '体力负荷';

-- 工作负荷表
CREATE TABLE physiological.workload
(
    GZFH_Timestamp_OUTPUT TIMESTAMP(6) COMMENT '时间戳',
    GZFH_Scenario         INT COMMENT '类型 1：sz  2：地面',
    GZFH_Subject_ID       VARCHAR(10) COMMENT '飞行员ID',
    GZFH_Task_ID          INT COMMENT '任务标识号',
    GZFH_LEVEL            INT COMMENT '工作负荷等级标识（0-低负荷/1-中负荷/2-高负荷）',
    GZFH_PR               FLOAT COMMENT '工作负荷类别概率值',
    GZFH_SCORE            FLOAT COMMENT '工作负荷量化值',
    GZFH_ATTR_1           FLOAT COMMENT '工作负荷可选：待确定数据1',
    GZFH_ATTR_2           FLOAT COMMENT '工作负荷可选：待确定数据2'
) COMMENT '工作负荷';

-- 应激强度表
CREATE TABLE physiological.stress_intensity
(
    YJQD_Timestamp_OUTPUT TIMESTAMP(6) COMMENT '时间戳',
    YJQD_Scenario         INT COMMENT '类型 1：sz  2：地面',
    YJQD_Subject_ID       VARCHAR(10) COMMENT '飞行员ID',
    YJQD_Task_ID          INT COMMENT '任务标识号',
    YJQD_LEVEL            INT COMMENT '应激强度等级标识（0-低负荷/1-中负荷/2-高负荷）',
    YJQD_PR               FLOAT COMMENT '应激强度类别概率值',
    YJQD_SCORE            FLOAT COMMENT '应激强度量化值',
    YJQD_ATTR_1           FLOAT COMMENT '应激强度可选：待确定数据1',
    YJQD_ATTR_2           FLOAT COMMENT '应激强度可选：待确定数据2'
) COMMENT '应激强度';

-- 缺氧状态表
CREATE TABLE physiological.hypoxia_status
(
    QYZT_Timestamp_OUTPUT TIMESTAMP(6) COMMENT '时间戳',
    QYZT_Scenario         INT COMMENT '类型 1：sz  2：地面',
    QYZT_Subject_ID       VARCHAR(10) COMMENT '飞行员ID',
    QYZT_Task_ID          INT COMMENT '任务标识号',
    QYZT_LEVEL            INT COMMENT '缺氧状态等级标识（0-正常/1-轻度缺氧/2-重度缺氧）',
    QYZT_PR               FLOAT COMMENT '缺氧状态类别概率值',
    QYZT_SCORE            FLOAT COMMENT '缺氧状态量化值',
    QYZT_ATTR_1           FLOAT COMMENT '缺氧状态可选：待确定数据1',
    QYZT_ATTR_2           FLOAT COMMENT '缺氧状态可选：待确定数据2'
) COMMENT '缺氧状态';

# # 按库构建 TiFlash 副本
# ALTER DATABASE `human_machine` SET TIFLASH REPLICA 1;
# ALTER DATABASE `flight_plan` SET TIFLASH REPLICA 1;
# ALTER DATABASE `simulation` SET TIFLASH REPLICA 1;
# ALTER DATABASE `real_world_flight` SET TIFLASH REPLICA 1;
# ALTER DATABASE `sorties` SET TIFLASH REPLICA 1;
# ALTER DATABASE `physiological` SET TIFLASH REPLICA 1;
# ALTER DATABASE `collection` SET TIFLASH REPLICA 1;


# ------------------------------------------ 仿真整合数据表 ----------------------------------------
create table simulation_integration.missile_integration
(
    sortie_number                  varchar(50)  not null comment '架次号',
    event_ts                       timestamp(3) not null comment '事件时间戳',
    aircraft_id                    varchar(50)  null comment '飞机ID',
    message_time                   time(3)      null comment '消息时间',
    satellite_guidance_time        time(3)      null comment '卫导时间',
    local_time                     time(3)      null comment '本地时间',
    message_sequence_number        bigint       null comment '消息序列号',
    weapon_id                      varchar(50)  null comment '武器ID',
    weapon_type                    varchar(50)  null comment '武器类型',
    target_id                      varchar(50)  null comment '目标ID',
    pylon_id                       varchar(50)  null comment '挂架ID',
    longitude                      varchar(50)  null comment '经度',
    latitude                       varchar(50)  null comment '纬度',
    altitude                       varchar(50)  null comment '高度',
    heading                        varchar(50)  null comment '航向',
    pitch                          varchar(50)  null comment '俯仰',
    roll                           varchar(50)  null comment '横滚',
    missile_speed                  varchar(50)  null comment '弹速度',
    aircraft_ground_speed          varchar(50)  null comment '载机地速',
    north_speed                    varchar(50)  null comment '北速',
    sky_speed                      varchar(50)  null comment '天速',
    east_speed                     varchar(50)  null comment '东速',
    north_wind_speed               varchar(50)  null comment '北向风速',
    vertical_wind_speed            varchar(50)  null comment '天向风速',
    east_wind_speed                varchar(50)  null comment '东向风速',
    aircraft_north_speed           varchar(50)  null comment '载机北速',
    aircraft_vertical_speed        varchar(50)  null comment '载机天速',
    aircraft_east_speed            varchar(50)  null comment '载机东速',
    missile_target_distance        varchar(50)  null comment '弹目距离',
    target_distance                varchar(50)  null comment '目标距离',
    target_longitude               varchar(50)  null comment '目标经度',
    target_latitude                varchar(50)  null comment '目标纬度',
    target_altitude                varchar(50)  null comment '目标高度',
    target_elevation_angle         varchar(50)  null comment '目标俯仰角',
    target_azimuth_angle           varchar(50)  null comment '目标方位角',
    target_tspi_status             varchar(50)  null comment '目标TSPI状态',
    target_real_or_virtual         varchar(50)  null comment '目标实虚属性',
    target_coordinate_validity     varchar(50)  null comment '目标经纬高有效标识',
    intercepted_weapon_id          varchar(50)  null comment '被拦截武器ID',
    seeker_azimuth                 varchar(50)  null comment '导引头视线方位角',
    seeker_elevation               varchar(50)  null comment '导引头视线俯仰角',
    seeker_id                      varchar(50)  null comment '导引头号',
    seeker_head_number             varchar(50)  null comment '导引头号',
    seeker_azimuth_center          varchar(50)  null comment '导引头方位中心',
    seeker_pitch_center            varchar(50)  null comment '导引头俯仰中心',
    interception_status            varchar(50)  null comment '截获状态',
    interception_flag              varchar(50)  null comment '截获标志',
    non_interception_reason        varchar(50)  null comment '未截获原因',
    hit_result                     varchar(50)  null comment '命中结果',
    miss_reason                    varchar(50)  null comment '未命中原因',
    miss_distance                  varchar(50)  null comment '脱靶量',
    matching_failure_reason        varchar(50)  null comment '匹配失败原因',
    termination_flag               varchar(50)  null comment '终止标志',
    distance_interception_flag     varchar(50)  null comment '距离截获标志',
    speed_interception_flag        varchar(50)  null comment '速度截获标志',
    angle_interception_flag        varchar(50)  null comment '角度截获标志',
    command_machine_status         varchar(50)  null comment '指令机状态',
    ground_angle_satisfaction_flag varchar(50)  null comment '擦地角满足标志',
    zero_crossing_flag             varchar(50)  null comment '过零标志',
    aircraft_angle_of_attack       varchar(50)  null comment '载机攻角',
    impact_angle_validity          varchar(50)  null comment '落角有效性',
    entry_angle                    varchar(50)  null comment '进入角',
    impact_angle                   varchar(50)  null comment '落角',
    direction_validity             varchar(50)  null comment '方向有效性',
    missile_attack_mode            varchar(50)  null comment '导弹攻击模式',
    trajectory_type                varchar(50)  null comment '弹道类型',
    jamming_effective              varchar(50)  null comment '干扰是否有效',
    jamming                        varchar(50)  null comment '干扰',
    afterburner                    varchar(50)  null comment '加力',
    head_on                        varchar(50)  null comment '迎头',
    intercepting_member_id         varchar(50)  null comment '截获成员ID',
    intercepting_equipment_id      varchar(50)  null comment '截获装备ID',
    intercepting_equipment_type    varchar(50)  null comment '截获装备类型',
    launcher_id                    varchar(50)  null comment '发射方ID',
    ground_defense_equipment_type  varchar(50)  null comment '地导装备类型',
    ground_defense_equipment_id    varchar(50)  null comment '地导装备ID',
    source_table                   varchar(50)  null comment '数据来源表',
    primary key (sortie_number, event_ts)
) comment '导弹数据整合表' partition by key (`sortie_number`) partitions 1;

CREATE TABLE simulation_integration.plane_state_integration
(
    sortie_number            VARCHAR(50)  NOT NULL COMMENT '架次号',
    event_ts                 TIMESTAMP(3) NOT NULL COMMENT '事件时间戳',
    aircraft_id              VARCHAR(50)  NULL COMMENT '飞机ID',
    aircraft_type            VARCHAR(50)  NULL COMMENT '飞机类型',
    message_time             TIME(3)      NULL COMMENT '消息时间',
    satellite_guidance_time  TIME(3)      NULL COMMENT '卫导时间',
    local_time               TIME(3)      NULL COMMENT '本地时间',
    message_sequence_number  BIGINT       NULL COMMENT '消息序列号',
    -- 位置和姿态数据
    longitude                VARCHAR(50)  NULL COMMENT '经度',
    latitude                 VARCHAR(50)  NULL COMMENT '纬度',
    pressure_altitude        VARCHAR(50)  NULL COMMENT '气压高度',
    satellite_altitude       VARCHAR(50)  NULL COMMENT '卫星高度',
    roll                     VARCHAR(50)  NULL COMMENT '横滚',
    pitch                    VARCHAR(50)  NULL COMMENT '俯仰',
    heading                  VARCHAR(50)  NULL COMMENT '航向',
    -- 速度数据
    north_velocity           VARCHAR(50)  NULL COMMENT '北向速度',
    vertical_velocity        VARCHAR(50)  NULL COMMENT '天向速度',
    east_velocity            VARCHAR(50)  NULL COMMENT '东向速度',
    indicated_airspeed       VARCHAR(50)  NULL COMMENT '表速(km/h)',
    -- 飞行状态数据
    true_angle_of_attack     VARCHAR(50)  NULL COMMENT '真攻角',
    mach_number              VARCHAR(50)  NULL COMMENT '马赫数',
    normal_load_factor       VARCHAR(50)  NULL COMMENT '法向过载',
    field_elevation          VARCHAR(50)  NULL COMMENT '场高',
    radio_altitude           VARCHAR(50)  NULL COMMENT '无线电高度',
    remaining_fuel           VARCHAR(50)  NULL COMMENT '余油量',
    -- 训练/演习状态
    training_status          VARCHAR(50)  NULL COMMENT '训练状态',
    scenario                 VARCHAR(50)  NULL COMMENT '场景',
    manual_respawn           VARCHAR(50)  NULL COMMENT '手动复活',
    parameter_setting_status VARCHAR(50)  NULL COMMENT '参数设置状态',
    encryption_status        VARCHAR(50)  NULL COMMENT '加密状态',
    -- 对抗措施
    chaff                    VARCHAR(50)  NULL COMMENT '干扰弹',
    afterburner              VARCHAR(50)  NULL COMMENT '加力',
    -- 命令相关
    command_type             VARCHAR(50)  NULL COMMENT '导调/导调回复',
    command_id               VARCHAR(50)  NULL COMMENT '命令ID',
    command_content          VARCHAR(50)  NULL COMMENT '命令内容',
    response_sequence_number BIGINT       NULL COMMENT '回复序列号',
    -- 其他状态
    delay_status             VARCHAR(50)  NULL COMMENT '延迟状态',
    -- 来源信息
    source_table             VARCHAR(50)  NULL COMMENT '数据来源表',
    PRIMARY KEY (sortie_number, event_ts)
) COMMENT = '飞机状态整合表' PARTITION BY KEY (`sortie_number`) PARTITIONS 1;

