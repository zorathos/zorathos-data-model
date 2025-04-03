package org.datacenter.config;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author : [wangminan]
 * @description : 接收器配置 与系统级配置不同的是，系统级配置一经指定之后进入打包流程 基本不变更。 接收器配置从flink-agent传入 由agent指定
 * 对所有URL 不带base的说明要补充完整参数 带base的只需要基URL即可
 * 对所有JSON请求体 都需要使用BASE64编码后传入
 */
public abstract class BaseReceiverConfig implements Serializable {

    @Serial
    private static final long serialVersionUID = 123142L;

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
                throw new RuntimeException("Error accessing field: " + field.getName(), e);
            }
        }
        return sb.toString().trim();
    }

    public abstract boolean validate();
}
