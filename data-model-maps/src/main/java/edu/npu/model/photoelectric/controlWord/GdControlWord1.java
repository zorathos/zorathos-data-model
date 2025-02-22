package io.github.wangminan.model.photoelectric.controlWord;

import lombok.Getter;

/**
 * @author : [wangminan]
 * @description : GD控制字1 内容
 */
public class GdControlWord1 extends AbstractControlWord{

    public GdControlWord1() {
        super();
        resetControlWord();
    }

    public GdControlWord1(byte[] controlWord) {
        // 两字节控制字 转换到16位数组
        super();
        for (int i = 0; i < 16; i++) {
            this.controlWord[i] = (controlWord[0] >> i) & 0x01;
        }
    }

    public void setWorkState_Fight() {
        controlWord[15] = 1;
    }

    public void setWorkState_Standby() {
        controlWord[15] = 0;
    }

    public WorkState getWorkState() {
        return controlWord[15] == 1 ? WorkState.FIGHT : WorkState.STANDBY;
    }

    public void setWorkState(WorkState workState) {
        controlWord[15] = workState.getValue();
    }

    public void setCheckState_Null() {
        controlWord[14] = 0;
        controlWord[13] = 0;
        controlWord[12] = 0;
    }

    public void setCheckState_StatusCheck() {
        controlWord[14] = 1;
        controlWord[13] = 0;
        controlWord[12] = 0;
    }

    /**
     * 标定检查 100
     */
    public void setCheckState_CalibrationCheck() {
        controlWord[12] = 1;
        controlWord[13] = 0;
        controlWord[14] = 0;
    }

    public CheckState getCheckState() {
        if (controlWord[14] == 0 && controlWord[13] == 0 && controlWord[12] == 0) {
            return CheckState.NULL;
        } else if (controlWord[14] == 1 && controlWord[13] == 0 && controlWord[12] == 0) {
            return CheckState.STATUS_CHECK;
        } else if (controlWord[14] == 0 && controlWord[13] == 0 && controlWord[12] == 1) {
            return CheckState.CALIBRATION_CHECK;
        } else {
            return null;
        }
    }

    public void setCheckState(CheckState checkState) {
        controlWord[12] = checkState.getValue()[0];
        controlWord[13] = checkState.getValue()[1];
        controlWord[14] = checkState.getValue()[2];
    }

    public void setGdControl_Null() {
        controlWord[8] = 0;
        controlWord[9] = 0;
        controlWord[10] = 0;
        controlWord[11] = 0;
    }

    /**
     * 停托架 0001
     */
    public void setGdControl_StopBracket() {
        controlWord[8] = 0;
        controlWord[9] = 0;
        controlWord[10] = 0;
        controlWord[11] = 1;
    }

    /**
     * 停大地 0010
     */
    public void setGdControl_StopGround() {
        controlWord[8] = 0;
        controlWord[9] = 0;
        controlWord[10] = 1;
        controlWord[11] = 0;
    }

    /**
     * 归零 0011
     */
    public void setGdControl_Zero() {
        controlWord[8] = 0;
        controlWord[9] = 0;
        controlWord[10] = 1;
        controlWord[11] = 1;
    }

    /**
     * 目指A 0100
     */
    public void setGdControl_TargetA() {
        controlWord[8] = 0;
        controlWord[9] = 1;
        controlWord[10] = 0;
        controlWord[11] = 0;
    }

    /**
     * 目指B 0101
     */
    public void setGdControl_TargetB() {
        controlWord[8] = 0;
        controlWord[9] = 1;
        controlWord[10] = 0;
        controlWord[11] = 1;
    }

    /**
     * 跟踪 0110
     */
    public void setGdControl_Track() {
        controlWord[8] = 0;
        controlWord[9] = 1;
        controlWord[10] = 1;
        controlWord[11] = 0;
    }

    /**
     * 航路 1000
     */
    public void setGdControl_Route() {
        controlWord[8] = 1;
        controlWord[9] = 0;
        controlWord[10] = 0;
        controlWord[11] = 0;
    }

    /**
     * 稳瞄 1001
     */
    public void setGdControl_StableAim() {
        controlWord[8] = 1;
        controlWord[9] = 0;
        controlWord[10] = 0;
        controlWord[11] = 1;
    }

    public GdControl getGdControl() {
        if (controlWord[8] == 0 && controlWord[9] == 0 && controlWord[10] == 0 && controlWord[11] == 1) {
            return GdControl.STOP_BRACKET;
        } else if (controlWord[8] == 0 && controlWord[9] == 0 && controlWord[10] == 1 && controlWord[11] == 0) {
            return GdControl.STOP_GROUND;
        } else if (controlWord[8] == 0 && controlWord[9] == 0 && controlWord[10] == 1 && controlWord[11] == 1) {
            return GdControl.ZERO;
        } else if (controlWord[8] == 0 && controlWord[9] == 1 && controlWord[10] == 0 && controlWord[11] == 0) {
            return GdControl.TARGET_A;
        } else if (controlWord[8] == 0 && controlWord[9] == 1 && controlWord[10] == 0 && controlWord[11] == 1) {
            return GdControl.TARGET_B;
        } else if (controlWord[8] == 0 && controlWord[9] == 1 && controlWord[10] == 1 && controlWord[11] == 0) {
            return GdControl.TRACK;
        } else if (controlWord[8] == 1 && controlWord[9] == 0 && controlWord[10] == 0 && controlWord[11] == 0) {
            return GdControl.ROUTE;
        } else if (controlWord[8] == 1 && controlWord[9] == 0 && controlWord[10] == 0 && controlWord[11] == 1) {
            return GdControl.STABLE_AIM;
        } else {
            return null;
        }
    }

    public void setGdControl(GdControl gdControl) {
        controlWord[8] = gdControl.getValue()[0];
        controlWord[9] = gdControl.getValue()[1];
        controlWord[10] = gdControl.getValue()[2];
        controlWord[11] = gdControl.getValue()[3];
    }

    public void setWorkType_Manual() {
        controlWord[6] = 0;
        controlWord[7] = 0;
    }

    public void setWorkType_Auto() {
        controlWord[6] = 0;
        controlWord[7] = 1;
    }

    public WorkType getWorkType() {
        if (controlWord[6] == 0 && controlWord[7] == 0) {
            return WorkType.MANUAL;
        } else if (controlWord[6] == 0 && controlWord[7] == 1) {
            return WorkType.AUTO;
        }
        return null;
    }

    public void setWorkType(WorkType workType) {
        controlWord[6] = workType.getValue()[0];
        controlWord[7] = workType.getValue()[1];
    }

    // 接下来是火控

    /**
     * 无效火控 00
     */
    public void setFireControl_Invalid() {
        controlWord[4] = 0;
        controlWord[5] = 0;
    }

    /**
     * 开火 01
     */
    public void setFireControl_Fire() {
        controlWord[4] = 0;
        controlWord[5] = 1;
    }

    /**
     * 停火 10
     */
    public void setFireControl_StopFire() {
        controlWord[4] = 1;
        controlWord[5] = 0;
    }

    public FireControl getFireControl() {
        if (controlWord[4] == 0 && controlWord[5] == 0) {
            return FireControl.INVALID;
        } else if (controlWord[4] == 0 && controlWord[5] == 1) {
            return FireControl.FIRE;
        } else if (controlWord[4] == 1 && controlWord[5] == 0) {
            return FireControl.STOP_FIRE;
        }
        return null;
    }

    public void setFireControl(FireControl fireControl) {
        controlWord[4] = fireControl.getValue()[0];
        controlWord[5] = fireControl.getValue()[1];
    }

    // 最后是伺服开机停机 0 1
    public void setServoControl_Stop() {
        controlWord[0] = 0;
    }

    public void setServoControl_Start() {
        controlWord[0] = 1;
    }

    public ServoControl getServoControl() {
        return controlWord[0] == 0 ? ServoControl.STOP : ServoControl.START;
    }

    public void setServoControl(ServoControl servoControl) {
        controlWord[0] = servoControl.getValue();
    }


    @Getter
    public enum WorkState {
        FIGHT(1),
        STANDBY(0);

        private final int value;

        WorkState(int value) {
            this.value = value;
        }
    }

    @Getter
    public enum CheckState {
        NULL(0, 0, 0),
        STATUS_CHECK(1, 0, 0),
        CALIBRATION_CHECK(0, 0, 1);

        private final int[] value;

        CheckState(int... value) {
            this.value = value;
        }
    }

    @Getter
    public enum GdControl {
        STOP_BRACKET(0, 0, 0, 1),
        STOP_GROUND(0, 0, 1, 0),
        ZERO(0, 0, 1, 1),
        TARGET_A(0, 1, 0, 0),
        TARGET_B(0, 1, 0, 1),
        TRACK(0, 1, 1, 0),
        ROUTE(1, 0, 0, 0),
        STABLE_AIM(1, 0, 0, 1);

        private final int[] value;

        GdControl(int... value) {
            this.value = value;
        }
    }

    @Getter
    public enum WorkType {
        MANUAL(0, 0),
        AUTO(0, 1);

        private final int[] value;

        WorkType(int... value) {
            this.value = value;
        }
    }

    @Getter
    public enum FireControl {
        INVALID(0, 0),
        FIRE(0, 1),
        STOP_FIRE(1, 0);

        private final int[] value;

        FireControl(int... value) {
            this.value = value;
        }
    }

    @Getter
    public enum ServoControl {
        STOP(0),
        START(1);

        private final int value;

        ServoControl(int value) {
            this.value = value;
        }
    }
}
