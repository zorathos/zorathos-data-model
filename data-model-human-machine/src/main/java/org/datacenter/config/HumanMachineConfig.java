package org.datacenter.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.datacenter.config.keys.HumanMachineSysConfigKey;
import org.datacenter.exception.ZorathosException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author : [wangminan]
 * @description : 人机交互系统数据采集系统配置
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
public class HumanMachineConfig extends BaseConfig {

    private final String ZORATHOS_HUMAN_MACHINE_CONFIG = "ZORATHOS_HUMAN_MACHINE_CONFIG";

    private boolean useSystemEnv;

    /**
     * 使用单例模式封装提供给外部使用的系统properties
     */
    private static volatile Properties humanMachineProperties;

    public HumanMachineConfig() {
        if (humanMachineProperties == null) {
            synchronized (HumanMachineConfig.class) {
                if (humanMachineProperties == null) {
                    humanMachineProperties = new Properties();
                }
            }
        }
        useSystemEnv = false;
    }

    /**
     * 获取配置项 请使用枚举Key替换
     *
     * @param key 键
     * @return 值
     */
    @Deprecated
    public static void setProperty(String key, String value) {
        humanMachineProperties.setProperty(key, value);
    }

    /**
     * 设置配置项
     *
     * @param configKey 键
     * @param value     值
     */
    public static void setProperty(HumanMachineSysConfigKey configKey, String value) {
        humanMachineProperties.setProperty(configKey.getKey(), value);
    }

    /**
     * 获取配置项 请使用枚举Key替换
     *
     * @param key 键
     * @return 值
     */
    @Deprecated
    public static String getProperty(String key) {
        return humanMachineProperties.getProperty(key);
    }

    public static String getProperty(HumanMachineSysConfigKey configKey) {
        return humanMachineProperties.getProperty(configKey.getKey());
    }

    /**
     * 获取配置项 请使用枚举Key替换
     *
     * @param key         键
     * @param alternative 替代值
     * @return 值
     */
    @Deprecated
    public static String getProperty(String key, String alternative) {
        return humanMachineProperties.getProperty(key, alternative);
    }

    public static String getProperty(HumanMachineSysConfigKey configKey, String alternative) {
        return humanMachineProperties.getProperty(configKey.getKey(), alternative);
    }

    @Override
    public synchronized void loadConfig() {
        /*
         * 逐条打印System.getenv
         */
        System.getenv().forEach((k, v) -> log.info("System env key:{}, value:{}", k, v));

        // 从系统中获取 "ZORATHOS_HUMAN_MACHINE_CONFIG" 环境变量
        if (System.getenv(ZORATHOS_HUMAN_MACHINE_CONFIG) != null) {
            File externelConfigFile = new File(System.getenv(ZORATHOS_HUMAN_MACHINE_CONFIG));
            log.info("ZORATHOS_HUMAN_MACHINE_CONFIG found in system env, trying to load sys config from file {}", externelConfigFile.getAbsolutePath());
            // 从配置文件加载
            try (
                    InputStream fis = new FileInputStream(externelConfigFile);
                    BufferedReader br = new BufferedReader(new InputStreamReader(fis))
            ) {
                humanMachineProperties.load(br);
                useSystemEnv = true;
            } catch (IOException e) {
                throw new ZorathosException(e, "You have   ZORATHOS_HUMAN_MACHINE_CONFIG in system environment, but error occurs while loading properties from file " + externelConfigFile.getAbsolutePath());
            }
        } else {
            log.info("ZORATHOS_HUMAN_MACHINE_CONFIG not found in system env, trying to load sys config from embedded file human-machine.properties");
            // 从resources文件夹加载
            try (// 判断human-machine.properties是否存在
                 InputStream embeddedConfigFis = HumanMachineConfig.class.getClassLoader().getResourceAsStream("human-machine.properties")
            ) {
                if (embeddedConfigFis == null) {
                    throw new ZorathosException("You don't have ZORATHOS_HUMAN_MACHINE_CONFIG in system environment, and human-machine.properties is not found in classpath");
                }
                try (BufferedReader br = new BufferedReader(new InputStreamReader(embeddedConfigFis))) {
                    humanMachineProperties.load(br);
                }
            } catch (IOException e) {
                throw new ZorathosException(e, "You don't have ZORATHOS_HUMAN_MACHINE_CONFIG in system environment, and error occurs while loading properties from embedded file human-machine.properties");
            }
        }
    }

    @Override
    public synchronized void saveConfig() {
        if (!useSystemEnv) {
            // 不是使用系统环境变量的情况 使用的是 bundle 在 resource 里的的配置文件
            throw new ZorathosException("You are using the embedded config file. It is not allowed to save the config to it.");
        }
        // 遍历 humanMachineProperties 写入文件
        try {
            File externelConfigFile = new File(System.getenv(ZORATHOS_HUMAN_MACHINE_CONFIG));
            if (!externelConfigFile.exists()) {
                throw new ZorathosException("You have ZORATHOS_HUMAN_MACHINE_CONFIG in system environment, but the file " + externelConfigFile.getAbsolutePath() + " does not exist");
            }
            try (FileWriter fw = new FileWriter(externelConfigFile)) {
                humanMachineProperties.store(fw, "Zorathos Human Machine Sys Config");
            }
        } catch (IOException e) {
            throw new ZorathosException(e, "Error occurs while saving properties to file " + System.getenv(ZORATHOS_HUMAN_MACHINE_CONFIG));
        }
    }
}
