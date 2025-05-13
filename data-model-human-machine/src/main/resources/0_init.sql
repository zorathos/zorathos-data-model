# 初始化所有数据库 和TiDBDatabase类映射
CREATE DATABASE IF NOT EXISTS `simulation_integration`; -- 实装飞行数据库
CREATE DATABASE IF NOT EXISTS `physiological`; -- 生理数据库
CREATE DATABASE IF NOT EXISTS `config`;

# ---------------------------------------- 配置 ----------------------------------------
CREATE TABLE IF NOT EXISTS `config`.`receiver_config`
(
    `id`    BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    `key`   VARCHAR(255) NOT NULL COMMENT '配置项',
    `value` TEXT         NOT NULL COMMENT '配置值'
);

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

