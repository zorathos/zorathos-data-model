package io.github.wangminan.model.photoelectric.controlWord;

import lombok.Getter;

/**
 * @author : [wangminan]
 * @description : 光电控制字4和5
 */
public class GdControlWord45 extends AbstractControlWord {

    public GdControlWord45() {
        super();
        for (int i = 0; i < 16; i++) {
            controlWord[i] = 0;
            anotherControlWord[i] = 0;
        }
    }

    public GdControlWord45(byte[] controlWord1, byte[] controlWord2) {
        super();
        for (int i = 0; i < 16; i++) {
            this.controlWord[i] = (controlWord1[0] >> i) & 0x01;
        }
        for (int i = 0; i < 16; i++) {
            this.anotherControlWord[i] = (controlWord2[0] >> i) & 0x01;
        }
    }

    // 接下来需要把16进制值逐位赋值给controlWord数组 例如 0x22 表示 0010 0010

    // 无动作 0x00 0x00
    public void none() {
        resetControlWords();
    }

    // 启动自检 0x01 0x00
    public void startSelfCheck() {
        resetControlWords();
        controlWord[15] = 1;
    }

    // 极性转换 白热 0x02 0x00
    public void irPolarityConversionWhite() {
        resetControlWords();
        controlWord[6] = 1;
    }

    // 极性转换 黑热 0x22 0x00
    public void irPolarityConversionBlack() {
        resetControlWords();
        controlWord[2] = 1;
        controlWord[6] = 1;
    }

    public IRPolarity getIRPolarity() {
        return controlWord[6] == 0 ? IRPolarity.WHITE : IRPolarity.BLACK;
    }

    public void setIRPolarity(IRPolarity irPolarity) {
        controlWord[6] = irPolarity.getValue();
    }

    // 调焦增 0x03 0x00
    public void focusIncrease() {
        resetControlWords();
        controlWord[6] = 1;
        controlWord[7] = 1;
    }

    // 调焦减 0x23 0x00
    public void focusDecrease() {
        resetControlWords();
        controlWord[2] = 1;
        controlWord[6] = 1;
        controlWord[7] = 1;
    }

    // 自动调焦 0x16 0x00
    public void autoFocus() {
        resetControlWords();
        controlWord[3] = 1;
        controlWord[5] = 1;
        controlWord[6] = 1;
    }

    // 自动控制增益亮度 0xaa 0x00
    public void autoControlGainBrightness() {
        resetControlWords();
        controlWord[0] = 1;
        controlWord[2] = 1;
        controlWord[4] = 1;
        controlWord[6] = 1;
    }

    // 对比度增 0x04 0x00
    public void contrastIncrease() {
        resetControlWords();
        controlWord[5] = 1;
    }

    // 对比度减 0x24 0x00
    public void contrastDecrease() {
        resetControlWords();
        controlWord[2] = 1;
        controlWord[5] = 1;
    }

    // 亮度增 0x14 0x00
    public void brightnessIncrease() {
        resetControlWords();
        controlWord[3] = 1;
        controlWord[5] = 1;
    }

    // 亮度减 0x15 0x00
    public void brightnessDecrease() {
        resetControlWords();
        controlWord[3] = 1;
        controlWord[5] = 1;
        controlWord[7] = 1;
    }

    // 十字位置方位增 0x06 0x00
    public void crossPositionIncrease() {
        resetControlWords();
        controlWord[6] = 1;
        controlWord[7] = 1;
    }

    // 十字位置方位减 0x26 0x00
    public void crossPositionDecrease() {
        resetControlWords();
        controlWord[2] = 1;
        controlWord[6] = 1;
        controlWord[7] = 1;
    }

    // 十字位置俯仰增 0x07 0x00
    public void crossPositionPitchIncrease() {
        resetControlWords();
        controlWord[5] = 1;
        controlWord[6] = 1;
        controlWord[7] = 1;
    }

    // 十字位置俯仰减 0x27 0x00
    public void crossPositionPitchDecrease() {
        resetControlWords();
        controlWord[2] = 1;
        controlWord[5] = 1;
        controlWord[6] = 1;
        controlWord[7] = 1;
    }

    // 十字线加载 0x08 0x00
    public void crossLineLoad() {
        resetControlWords();
        controlWord[7] = 1;
    }

    // 十字线隐藏 0x28 0x00
    public void crossLineHide() {
        resetControlWords();
        controlWord[2] = 1;
        controlWord[7] = 1;
    }

    // 字符显示 0x09 0x00
    public void characterDisplay() {
        resetControlWords();
        controlWord[4] = 1;
        controlWord[7] = 1;
    }

    // 字符隐藏 0x29 0x00
    public void characterHide() {
        resetControlWords();
        controlWord[2] = 1;
        controlWord[4] = 1;
        controlWord[7] = 1;
    }

    // 存储命令 // 0x0b 0x00
    public void storageCommand() {
        resetControlWords();
        controlWord[4] = 1;
        controlWord[6] = 1;
        controlWord[7] = 1;
    }

    // 内部校正 0x0c 0x00
    public void internalCorrection() {
        resetControlWords();
        controlWord[4] = 1;
        controlWord[5] = 1;
    }

    // 外部校正 0x0d 0x00
    public void externalCorrection() {
        resetControlWords();
        controlWord[4] = 1;
        controlWord[5] = 1;
        controlWord[7] = 1;
    }

    // 读取累计工作时间 0x0f 0x00
    public void readTotalWorkingTime() {
        resetControlWords();
        controlWord[4] = 1;
        controlWord[5] = 1;
        controlWord[6] = 1;
        controlWord[7] = 1;
    }

    // 调用缺省状态 0x10 0x00
    public void callDefaultState() {
        resetControlWords();
        controlWord[3] = 1;
    }

    // 切换到大视场 0x30 0x00
    public void switchToWideField() {
        resetControlWords();
        controlWord[2] = 1;
        controlWord[3] = 1;
    }

    // 切换到小视场 0x32 0x00
    public void switchToSmallField() {
        resetControlWords();
        controlWord[2] = 1;
        controlWord[3] = 1;
        controlWord[6] = 1;
    }

    // 切换到中1视场 0x34 0x00
    public void switchToMedium1Field() {
        resetControlWords();
        controlWord[2] = 1;
        controlWord[3] = 1;
        controlWord[5] = 1;
    }

    // 切换到中2视场 0x35 0x00
    public void switchToMedium2Field() {
        resetControlWords();
        controlWord[2] = 1;
        controlWord[3] = 1;
        controlWord[5] = 1;
        controlWord[7] = 1;
    }

    // 电子变倍 0x33 0x01 开
    public void electronicZoomOn() {
        resetControlWords();
        controlWord[2] = 1;
        controlWord[3] = 1;
        controlWord[6] = 1;
        controlWord[7] = 1;
        anotherControlWord[7] = 1;
    }

    // 电子变倍 0x33 0x00 关
    public void electronicZoomOff() {
        resetControlWords();
        controlWord[2] = 1;
        controlWord[3] = 1;
        controlWord[6] = 1;
        controlWord[7] = 1;
    }

    // 变焦+ 步进 0x42 0x00
    public void zoomIn() {
        resetControlWords();
        controlWord[1] = 1;
        controlWord[6] = 1;
    }

    // 变焦- 步进 0x40 0x00
    public void zoomOut() {
        resetControlWords();
        controlWord[1] = 1;
        controlWord[6] = 0;
    }

    // 变焦+ 连续 0x44 0x00
    public void zoomInContinuous() {
        resetControlWords();
        controlWord[1] = 1;
        controlWord[5] = 1;
    }

    // 变焦- 连续 0x48 0x00
    public void zoomOutContinuous() {
        resetControlWords();
        controlWord[1] = 1;
        controlWord[4] = 1;
    }

    // 变焦停止 0x49 0x00
    public void zoomStop() {
        resetControlWords();
        controlWord[1] = 1;
        controlWord[4] = 1;
        controlWord[7] = 1;
    }

    // 字段太多了 其他字段不加了 目前控制字段45 只用到红外加断电和极性转换
    // 红外加电 0xff 0x01
    public void irPowerOn() {
        resetControlWords();
        controlWord[0] = 1;
        controlWord[1] = 1;
        controlWord[2] = 1;
        controlWord[3] = 1;
        controlWord[4] = 1;
        controlWord[5] = 1;
        controlWord[6] = 1;
        controlWord[7] = 1;
        anotherControlWord[7] = 1;
    }

    // 红外断电 0xff 0x00
    public void irPowerOff() {
        resetControlWords();
        controlWord[0] = 1;
        controlWord[1] = 1;
        controlWord[2] = 1;
        controlWord[3] = 1;
        controlWord[4] = 1;
        controlWord[5] = 1;
        controlWord[6] = 1;
        controlWord[7] = 1;
    }

    public IRPower getIRPower() {
        boolean powerOn = true;
        for (int i = 0; i < 8; i++) {
            if (controlWord[i] == 0) {
                powerOn = false;
                break;
            }
        }
        if (anotherControlWord[7] != 1) {
            powerOn = false;
        }
        return powerOn ? IRPower.ON : IRPower.OFF;
    }

    public void setIRPower(IRPower irPower) {
        if (irPower == IRPower.ON) {
            irPowerOn();
        } else {
            irPowerOff();
        }
    }

    @Getter
    public enum IRPolarity {
        WHITE(0), BLACK(1);

        private final int value;

        IRPolarity(int value) {
            this.value = value;
        }
    }

    @Getter
    public enum IRPower {
        ON(1), OFF(0);

        private final int value;

        IRPower(int value) {
            this.value = value;
        }
    }
}
