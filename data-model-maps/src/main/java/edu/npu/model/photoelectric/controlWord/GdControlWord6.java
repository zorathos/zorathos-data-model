package edu.npu.model.photoelectric.controlWord;

import lombok.Getter;

/**
 * @author : [wangminan]
 * @description : [一句话描述该类的功能]
 */
public class GdControlWord6 extends AbstractControlWord {

    public GdControlWord6() {
        super();
        for (int i = 0; i < 16; i++) {
            controlWord[i] = 0;
        }
    }

    public GdControlWord6(byte[] controlWord) {
        // 两字节控制字 转换到16位数组
        super();
        for (int i = 0; i < 16; i++) {
            this.controlWord[i] = (controlWord[0] >> i) & 0x01;
        }
    }

    // 视场增 焦距减 连续 0x01
    public void fieldOfViewIncreaseFocusDecreaseContinuous() {
        resetControlWord();
        controlWord[15] = 1;
    }

    // 视场减 焦距增 连续 0x02
    public void fieldOfViewDecreaseFocusIncreaseContinuous() {
        resetControlWord();
        controlWord[14] = 1;
    }

    public FieldOfView getFieldOfView() {
        if (controlWord[15] == 1) {
            return FieldOfView.INCREASE;
        } else if (controlWord[14] == 1) {
            return FieldOfView.DECREASE;
        }
        return null;
    }

    public void setFieldOfView(FieldOfView fieldOfView) {
        if (fieldOfView == FieldOfView.INCREASE) {
            fieldOfViewIncreaseFocusDecreaseContinuous();
        } else if (fieldOfView == FieldOfView.DECREASE) {
            fieldOfViewDecreaseFocusIncreaseContinuous();
        }
    }

    @Getter
    public enum FieldOfView {
        INCREASE(1),
        DECREASE(2);

        private int value;

        FieldOfView(int value) {
            this.value = value;
        }
    }
}
