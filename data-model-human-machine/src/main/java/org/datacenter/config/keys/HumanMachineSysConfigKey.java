package org.datacenter.config.keys;

import lombok.Getter;

/**
 * @author : [wangminan]
 * @description : 人机交互的系统配置的Keys 系统配置只用于存储系统级别的配置
 */
@Getter
public enum HumanMachineSysConfigKey {

    // 基础配置
    CONFIG_TYPE("config.type", "配置类型"),
    CONFIG_VERSION("config.version", "配置版本"),
    CONFIG_S3_URL("config.s3.url", "S3存储地址"),

    // Kafka配置组
    KAFKA_BOOTSTRAP_SERVERS("kafka.bootstrap.servers", "Kafka服务器地址"),
    KAFKA_CONSUMER_GROUP_ID("kafka.consumer.group-id", "消费者组ID"),
    KAFKA_TOPIC_FLIGHT_PLAN_ROOT("kafka.topic.flightPlanRoot", "飞行计划主题"),
    KAFKA_TOPIC_PERSONNEL("kafka.topic.personnel", "人员主题"),
    KAFKA_TOPIC_SORTIES_BATCH("kafka.topic.sortiesBatch", "批量出航主题"),
    KAFKA_TOPIC_SORTIES("kafka.topic.sorties", "出航主题"),
    KAFKA_OFFSET_TIMESTAMP("kafka.offset.timestamp", "时间戳偏移(毫秒)"),
    KAFKA_SECURITY_ENABLED("kafka.security.enabled", "安全认证启用"),
    KAFKA_SECURITY_PROTOCOL("kafka.security.protocol", "安全协议"),
    KAFKA_SASL_MECHANISM("kafka.sasl.mechanism", "SASL机制"),
    KAFKA_USERNAME("kafka.username", "Kafka用户名"),
    KAFKA_PASSWORD("kafka.password", "Kafka密码"),

    // TiDB配置组
    TIDB_URL_PREFIX("tidb.url.prefix", "TiDB URL前缀"),
    TIDB_URL_SUFFIX("tidb.url.suffix", "TiDB URL后缀"),
    TIDB_MYSQL_DRIVER_NAME("tidb.mysql.driverName", "MySQL驱动名称"),
    TIDB_USERNAME("tidb.username", "TiDB用户名"),
    TIDB_PASSWORD("tidb.password", "TiDB密码"),
    TIDB_CONNECTION_CHECK_TIMEOUT_SECONDS("tidb.connectionCheckTimeoutSeconds", "连接检查超时(秒)"),
    TIDB_POOL_MAX_TOTAL("tidb.pool.maxTotal", "连接池最大连接数"),
    TIDB_POOL_MAX_IDLE("tidb.pool.maxIdle", "连接池最大空闲连接"),
    TIDB_POOL_MIN_IDLE("tidb.pool.minIdle", "连接池最小空闲连接"),

    // Flink配置组
    FLINK_CHECKPOINT_INTERVAL("flink.checkpoint.interval", "检查点间隔(秒)"),
    FLINK_CHECKPOINT_TIMEOUT("flink.checkpoint.timeout", "检查点超时(秒)"),
    FLINK_JDBC_SINKER_BATCH_SIZE("flink.jdbc.sinker.batchSize", "JDBC Sink批处理大小"),
    FLINK_JDBC_SINKER_BATCH_INTERVAL("flink.jdbc.sinker.batchInterval", "JDBC Sink批处理间隔"),
    FLINK_JDBC_SINKER_MAX_RETRIES("flink.jdbc.sinker.maxRetries", "JDBC Sink最大重试次数"),

    // Redis配置组
    REDIS_HOST("redis.host", "Redis主机"),
    REDIS_PORT("redis.port", "Redis端口"),
    REDIS_PASSWORD("redis.password", "Redis密码"),
    REDIS_TIMEOUT("redis.timeout", "Redis超时(秒)"),
    REDIS_POOL_MAX_TOTAL("redis.pool.maxTotal", "Redis连接池最大连接数"),
    REDIS_POOL_MAX_IDLE("redis.pool.maxIdle", "Redis连接池最大空闲连接"),
    REDIS_POOL_MIN_IDLE("redis.pool.minIdle", "Redis连接池最小空闲连接"),

    // MinIO配置组
    MINIO_ENDPOINT("minio.endpoint", "MinIO端点"),
    MINIO_ACCESS_KEY_ID("minio.accessKeyId", "MinIO访问密钥ID"),
    MINIO_ACCESS_KEY_SECRET("minio.accessKeySecret", "MinIO访问密钥密钥"),
    MINIO_BUCKET("minio.bucket", "MinIO桶"),

    // Receiver配置组
    RECEIVER_EQUIPMENT_TIDB_EQUIPMENT_INFO_TABLE("receiver.equipment.tidb.equipmentInfo.table", "装备信息表"),
    RECEIVER_EQUIPMENT_TIDB_EQUIPMENT_CODE_TABLE("receiver.equipment.tidb.equipmentCode.table", "装备代码表"),

    // Agent配置组
    AGENT_INTERVAL_FLIGHT_PLAN("agent.interval.flightPlan", "飞行计划拉取间隔(分钟)"),
    AGENT_INTERVAL_PERSONNEL("agent.interval.personnel", "人员拉取间隔(分钟)"),
    AGENT_INTERVAL_SORTIES_BATCH("agent.interval.sortiesBatch", "批量出航拉取间隔(分钟)"),
    AGENT_INTERVAL_SORTIES("agent.interval.sorties", "出航拉取间隔(分钟)"),
    AGENT_RETRIES_KAFKA("agent.retries.kafka", "Kafka重试次数"),
    AGENT_RETRIES_HTTP("agent.retries.http", "HTTP重试次数"),
    AGENT_RETRIES_REDIS("agent.retries.redis", "Redis重试次数");

    private final String key;
    private final String description;

    HumanMachineSysConfigKey(String key, String description) {
        this.key = key;
        this.description = description;
    }

    @Override
    public String toString() {
        return key;
    }

    /**
     * 根据配置键名查找枚举
     */
    public static HumanMachineSysConfigKey fromKey(String key) {
        for (HumanMachineSysConfigKey configKey : values()) {
            if (configKey.key.equals(key)) {
                return configKey;
            }
        }
        return null;
    }
}
