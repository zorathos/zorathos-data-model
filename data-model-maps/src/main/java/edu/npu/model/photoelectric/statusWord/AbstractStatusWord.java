package edu.npu.model.photoelectric.statusWord;

/**
 * @author : [wangminan]
 * @description : [一句话描述该类的功能]
 */
public class AbstractStatusWord {
    protected int[] statusWord;

    public byte[] getStatusWordInBytes() {
        byte[] bytes = new byte[16];
        for (int i = 0; i < 16; i++) {
            bytes[i] = (byte) statusWord[i];
        }
        return bytes;
    }

    public AbstractStatusWord() {
        statusWord = new int[16];
    }

    public AbstractStatusWord(int[] statusWord) {
        if (statusWord.length != 16) {
            throw new IllegalArgumentException("状态字长度必须为16位");
        }
        this.statusWord = statusWord;
    }

    public AbstractStatusWord(byte[] statusWord) {
        if (statusWord.length != 16) {
            throw new IllegalArgumentException("状态字长度必须为16位");
        }
        this.statusWord = new int[16];
        for (int i = 0; i < 16; i++) {
            this.statusWord[i] = statusWord[i];
        }
    }
}
