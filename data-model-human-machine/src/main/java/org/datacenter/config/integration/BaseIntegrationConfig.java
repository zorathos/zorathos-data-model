package org.datacenter.config.integration;

import org.datacenter.exception.ZorathosException;

import java.io.Serializable;

/**
 * @author : [wangminan]
 * @description : 基底集成配置类
 */
public abstract class BaseIntegrationConfig implements Serializable {
    public String toParameterString() {
        // 通过反射遍历除了 serialVersionUID 外的所有属性 转换为 --key1 value1 --key2 value2 的形式
        StringBuilder sb = new StringBuilder();
        for (var field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(this);
                if (value != null && !field.getName().equals("serialVersionUID")) {
                    sb.append("--").append(field.getName()).append(" ").append(value).append(" ");
                }
            } catch (IllegalAccessException e) {
                throw new ZorathosException(e, "Error accessing field: " + field.getName());
            }
        }
        return sb.toString().trim();
    }

    public abstract boolean validate();
}
