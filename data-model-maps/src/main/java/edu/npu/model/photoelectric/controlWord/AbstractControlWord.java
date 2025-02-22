package io.github.wangminan.model.photoelectric.controlWord;

import lombok.Data;

/**
 * @author : [wangminan]
 * @description : [一句话描述该类的功能]
 */
@Data
public class AbstractControlWord {
    // 16位定长控制字
    protected int[] controlWord;

    public byte[] getControlWordInBytes() {
        byte[] bytes = new byte[16];
        for (int i = 0; i < 16; i++) {
            bytes[i] = (byte) controlWord[i];
        }
        return bytes;
    }

    protected int[] anotherControlWord; // 应对双控制字的情况

    public byte[] getAnotherControlWordInBytes() {
        byte[] bytes = new byte[16];
        for (int i = 0; i < 16; i++) {
            bytes[i] = (byte) anotherControlWord[i];
        }
        return bytes;
    }

    public AbstractControlWord() {
        controlWord = new int[16];
        anotherControlWord = new int[16];
    }

    protected void resetControlWord() {
        for (int i = 0; i < 16; i++) {
            controlWord[i] = 0;
        }
    }

    protected void resetControlWords() {
        for (int i = 0; i < 16; i++) {
            controlWord[i] = 0;
            anotherControlWord[i] = 0;
        }
    }

    public AbstractControlWord(int[] controlWord) {
        if (controlWord.length != 16) {
            throw new IllegalArgumentException("控制字长度必须为16位");
        }
        this.controlWord = controlWord;
    }

    public AbstractControlWord(int[] controlWord, int[] anotherControlWord) {
        if (controlWord.length != 16 || anotherControlWord.length != 16) {
            throw new IllegalArgumentException("控制字长度必须为16位");
        }
        this.controlWord = controlWord;
        this.anotherControlWord = anotherControlWord;
    }
}
