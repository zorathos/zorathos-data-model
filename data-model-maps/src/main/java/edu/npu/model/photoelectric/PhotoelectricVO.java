package io.github.wangminan.model.photoelectric;

/**
 * @description : 光电设备返回对象
 */
public class PhotoelectricVO {
    /**
     * 光电传感器ID，ID 编号
     * 无
     */
    private String id;
    /**
     * 跟踪通道 电视tv true/红外ir，true tv - false ir
     */
    private boolean isChannelTv;
    /**
     * 相关或质心，true correlation - false centroid
     */
    private boolean isCorrelation;
    /**
     * 红外开关机，true开机 - false关机
     */
    private boolean isIrPowerOn;
    /**
     * 激光开关，true开机 - false关机
     */
    private boolean isLaserOn;
    /**
     * 目标黑白
     */
    private boolean isPolarityBlack;
    /**
     * 红外热黑/热白
     */
    private boolean isPolarityIrBlack;
    /**
     * 伺服器开机/关机，true开机 - false关机
     */
    private boolean isServerPowerOn;
    /**
     * 激光能量，一般是12.5Hz/5Hz/1Hz
     */
    private double laserenergy;
    /**
     * 光电传感器名称
     * 无
     */
    private String name;

    public String getid() { return id; }
    public void setid(String value) { this.id = value; }

    public boolean getIsChannelTv() { return isChannelTv; }
    public void setIsChannelTv(boolean value) { this.isChannelTv = value; }

    public boolean getIsCorrelation() { return isCorrelation; }
    public void setIsCorrelation(boolean value) { this.isCorrelation = value; }

    public boolean getIsIrPowerOn() { return isIrPowerOn; }
    public void setIsIrPowerOn(boolean value) { this.isIrPowerOn = value; }

    public boolean getIsLaserOn() { return isLaserOn; }
    public void setIsLaserOn(boolean value) { this.isLaserOn = value; }

    public boolean getIsPolarityBlack() { return isPolarityBlack; }
    public void setIsPolarityBlack(boolean value) { this.isPolarityBlack = value; }

    public boolean getIsPolarityIrBlack() { return isPolarityIrBlack; }
    public void setIsPolarityIrBlack(boolean value) { this.isPolarityIrBlack = value; }

    public boolean getIsServerPowerOn() { return isServerPowerOn; }
    public void setIsServerPowerOn(boolean value) { this.isServerPowerOn = value; }

    public double getLaserenergy() { return laserenergy; }
    public void setLaserenergy(double value) { this.laserenergy = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }
}
