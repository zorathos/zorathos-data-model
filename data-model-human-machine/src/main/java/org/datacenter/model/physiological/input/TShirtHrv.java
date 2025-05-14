package org.datacenter.model.physiological.input;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.datacenter.model.physiological.BasePhysiologicalInput;

/**
 * @author : [wangminan]
 * @description : 心率变异性
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class TShirtHrv extends BasePhysiologicalInput {
    /**
     * 平均RR间期
     */
    @JsonAlias("rr_mean")
    private Double rrMean;

    /**
     * 平均心率
     */
    @JsonAlias("average_heart_rate")
    private Double averageHeartRate;

    /**
     * 相邻RR间期标准差
     */
    @JsonAlias("sdnn")
    private Double sdnn;

    /**
     * 相邻RR间期差值的均方根
     */
    @JsonAlias("rmssd")
    private Double rmssd;

    /**
     * 相邻RR间期差值大于50ms的比例
     */
    @JsonAlias("pnn50")
    private Double pnn50;

    /**
     * 非线性指标poincare plot的短轴标准差
     */
    @JsonAlias("sd1")
    private Double sd1;

    /**
     * 非线性指标poincare plot的长轴标准差
     */
    @JsonAlias("sd2")
    private Double sd2;

    /**
     * 非线性指标poincare plot两轴标准差的比值
     */
    @JsonAlias("sd1rsd2")
    private Double sd1rsd2;

    /**
     * RR间期序列的近似熵
     */
    @JsonAlias("apen")
    private Double apen;

    /**
     * 归一化的RR间期序列低频
     */
    @JsonAlias("lf_norm")
    private Double lfNorm;

    /**
     * 归一化的RR间期序列高频
     */
    @JsonAlias("hf_norm")
    private Double hfNorm;

    /**
     * RR间期序列低频与高频能量的比值
     */
    @JsonAlias("lfrhf")
    private Double lfrhf;

    /**
     * RR间期序列高频能量
     */
    @JsonAlias("hf")
    private Double hf;

    /**
     * RR间期序列低频能量
     */
    @JsonAlias("lf")
    private Double lf;

    /**
     * RR间期序列极低频能量
     */
    @JsonAlias("vlf")
    private Double vlf;

    /**
     * RR间期序列超低频能量
     */
    @JsonAlias("ulf")
    private Double ulf;

    /**
     * RR间期序列频谱总能量
     */
    @JsonAlias("ttlpwr")
    private Double ttlpwr;

    /**
     * 呼吸性窦性心律不齐
     */
    @JsonAlias("rsa")
    private Double rsa;
}
