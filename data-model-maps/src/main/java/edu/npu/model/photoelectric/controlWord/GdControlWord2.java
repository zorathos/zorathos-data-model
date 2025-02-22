package io.github.wangminan.model.photoelectric.controlWord;

import lombok.Getter;

/**
 * @author : [wangminan]
 * @description : [一句话描述该类的功能]
 */
public class GdControlWord2 extends AbstractControlWord {
    public GdControlWord2() {
        super();
        for (int i = 0; i < 16; i++) {
            controlWord[i] = 0;
        }
    }

    public GdControlWord2(byte[] controlWord) {
        // 两字节控制字 转换到16位数组
        super();
        for (int i = 0; i < 16; i++) {
            this.controlWord[i] = (controlWord[0] >> i) & 0x01;
        }
    }

    /**
     * 伺服微调-不移动
     */
    public void setServoFineTuning_NoMove() {
        controlWord[13] = 0;
        controlWord[14] = 0;
        controlWord[15] = 0;
    }

    public void setServoFineTuning(ServoFineTuning servoFineTuning) {
        controlWord[13] = servoFineTuning.getValue()[0];
        controlWord[14] = servoFineTuning.getValue()[1];
        controlWord[15] = servoFineTuning.getValue()[2];
    }

    public ServoFineTuning getServoFineTuning() {
        if (controlWord[13] == 0 && controlWord[14] == 0 && controlWord[15] == 0) {
            return ServoFineTuning.NO_MOVE;
        }
        return null;
    }

    /**
     * 标定检查-标定有效
     */
    public void setCalibrationCheck_CalibrationValid() {
        controlWord[12] = 1;
    }

    /**
     * 标定检查-标定保存
     */
    public void setCalibrationCheck_CalibrationSave() {
        controlWord[11] = 1;
    }

    public CalibrationCheck_CalibrationValid getCalibrationCheck_CalibrationValid() {
        if (controlWord[12] == 1) {
            return CalibrationCheck_CalibrationValid.CALIBRATION_VALID;
        }
        return null;
    }

    public CalibrationCheck_CalibrationSave getCalibrationCheck_CalibrationSave() {
        if (controlWord[11] == 1) {
            return CalibrationCheck_CalibrationSave.CALIBRATION_SAVE;
        }
        return null;
    }

    public void setCalibrationCheck_CalibrationValid(CalibrationCheck_CalibrationValid calibrationCheck_CalibrationValid) {
        controlWord[12] = calibrationCheck_CalibrationValid.getValue();
    }

    public void setCalibrationCheck_CalibrationSave(CalibrationCheck_CalibrationSave calibrationCheck_CalibrationSave) {
        controlWord[11] = calibrationCheck_CalibrationSave.getValue();
    }


    @Getter
    public enum ServoFineTuning {
        NO_MOVE(0, 0, 0);

        private final int[] value;

        ServoFineTuning(int... value) {
            this.value = value;
        }
    }

    @Getter
    public enum CalibrationCheck_CalibrationValid{
        CALIBRATION_VALID(1);
        private final int value;
        CalibrationCheck_CalibrationValid(int value){
            this.value = value;
        }
    }

    @Getter
    public enum CalibrationCheck_CalibrationSave{
        CALIBRATION_SAVE(1);
        private final int value;
        CalibrationCheck_CalibrationSave(int value){
            this.value = value;
        }
    }
}
