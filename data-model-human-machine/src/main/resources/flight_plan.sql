CREATE DATABASE IF NOT EXISTS `flight_plan`;
-- 飞行计划数据库
# ---------------------------------------- 飞行计划数据库 XML解析 ----------------------------------------
CREATE TABLE IF NOT EXISTS `flight_plan`.`flight_plan_root`
(
    `import_id`        BIGINT       NOT NULL COMMENT '导入ID',
    `id`               varchar(255) NOT NULL COMMENT '根ID',
    `flight_date`      date     DEFAULT NULL COMMENT '飞行日期',
    `flight_date_time` datetime DEFAULT NULL COMMENT '飞行日期时间',
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `flight_plan`.`flight_head`
(
    `import_id`     BIGINT NOT NULL COMMENT '导入ID',
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
    `import_id` BIGINT NOT NULL COMMENT '导入ID',
    `root_id`   varchar(255) DEFAULT NULL COMMENT '根ID',
    `id`        bigint NOT NULL AUTO_INCREMENT COMMENT '这个字段是咱自己的 主键 bigint auto increment,源库没有主键',
    `note`      varchar(255) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `flight_plan`.`flight_cmd`
(
    `import_id` BIGINT NOT NULL COMMENT '导入ID',
    `root_id`   varchar(255) DEFAULT NULL COMMENT '根ID',
    `id`        bigint NOT NULL AUTO_INCREMENT COMMENT '这个字段是咱自己的 主键 bigint auto increment,源库没有主键',
    `name`      varchar(255) DEFAULT NULL COMMENT '姓名',
    `lb`        varchar(255) DEFAULT NULL COMMENT '类别',
    `sx`        varchar(255) DEFAULT NULL COMMENT '属性',
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `flight_plan`.`flight_task`
(
    `import_id` BIGINT NOT NULL COMMENT '导入ID',
    `root_id`   varchar(255) DEFAULT NULL COMMENT '根ID',
    `id`        bigint NOT NULL AUTO_INCREMENT COMMENT '这个字段是咱自己的 主键 bigint auto increment,源库没有主键',
    `model`     varchar(255) DEFAULT NULL COMMENT '型号',
    `code`      varchar(255) DEFAULT NULL COMMENT '代码',
    `name`      varchar(255) DEFAULT NULL COMMENT '姓名',
    `rw`        varchar(255) DEFAULT NULL COMMENT '任务',
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `flight_plan`.`flight_plan`
(
    `import_id`           BIGINT NOT NULL COMMENT '导入ID',
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
