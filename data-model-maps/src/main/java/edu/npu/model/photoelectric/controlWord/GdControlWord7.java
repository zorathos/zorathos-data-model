package io.github.wangminan.model.photoelectric.controlWord;

import lombok.Getter;

/**
 * @author : [wangminan]
 * @description : [一句话描述该类的功能]
 */
public class GdControlWord7 extends AbstractControlWord {

    public GdControlWord7() {
        super();
        for (int i = 0; i < 16; i++) {
            controlWord[i] = 0;
        }
    }

    public GdControlWord7(byte[] controlWord) {
        // 两字节控制字 转换到16位数组
        super();
        for (int i = 0; i < 16; i++) {
            this.controlWord[i] = (controlWord[0] >> i) & 0x01;
        }
    }

    // 激光加电 0x01
    public void laserPowerOn() {
        resetControlWord();
        controlWord[15] = 1;
    }

    // 激光下电 0x00
    public void laserPowerOff() {
        resetControlWord();
    }

    public LaserPower getLaserPower() {
        if (controlWord[15] == 1) {
            return LaserPower.ON;
        } else if (controlWord[15] == 0) {
            return LaserPower.OFF;
        }
        return null;
    }

    public void setLaserPower(LaserPower laserPower) {
        if (laserPower == LaserPower.ON) {
            laserPowerOn();
        } else if (laserPower == LaserPower.OFF) {
            laserPowerOff();
        }
    }

    // 激光能量1Hz
    public void laserEnergy1Hz() {
        resetControlWord();
    }

    // 激光能量5Hz
    public void laserEnergy5Hz() {
        resetControlWord();
        controlWord[13] = 1;
    }

    // 激光能量12.5Hz
    public void laserEnergy12_5Hz() {
        resetControlWord();
        controlWord[12] = 1;
    }

    public LaserEnergy getLaserEnergy() {
        if (controlWord[13] == 0 && controlWord[12] == 0) {
            return LaserEnergy._1HZ;
        } else if (controlWord[13] == 1 && controlWord[12] == 0) {
            return LaserEnergy._5HZ;
        } else if (controlWord[13] == 0 && controlWord[12] == 1) {
            return LaserEnergy._12_5HZ;
        }
        return null;
    }

    public void setLaserEnergy(LaserEnergy laserEnergy) {
        if (laserEnergy == LaserEnergy._1HZ) {
            laserEnergy1Hz();
        } else if (laserEnergy == LaserEnergy._5HZ) {
            laserEnergy5Hz();
        } else if (laserEnergy == LaserEnergy._12_5HZ) {
            laserEnergy12_5Hz();
        }
    }

    @Getter
    public enum LaserPower {
        ON(1),
        OFF(2);

        private final int value;

        LaserPower(int value) {
            this.value = value;
        }
    }

    @Getter
    public enum LaserEnergy {
        _1HZ(0,0),
        _5HZ(0, 1),
        _12_5HZ(1,0);

        private final int[] value;

        LaserEnergy(int... value) {
            this.value = value;
        }
    }
}
