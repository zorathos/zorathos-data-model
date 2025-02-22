package edu.npu.model.photoelectric.statusWord;

import static edu.npu.util.PhotoElectronicByteUtil.bytesToUnsignedShort;

/**
 * @author : [wangminan]
 * @description : [一句话描述该类的功能]
 */
public class GdStatusWord5{
    // 0x1 开关机状态
    // 0x2 测距状态
    // 0xc 激光频率
    // 0x10 激光有无
    // 0x20 测距有效

    protected long statusWord;

    public GdStatusWord5(byte[] statusWord) {
        this.statusWord = bytesToUnsignedShort(statusWord);
    }

    /**
     * 开关机状态 0关机1开机
     * **/
    public int getPowerOnStatus(){
        return (statusWord & 0x1) == 0x0 ? 0 : 1;
    }

    /**
     * 测距状态 0停止1发射
     * **/
    public int getRangingStatus(){
        return (statusWord & 0x2) == 0x0 ? 0 : 1;
    }

    /**
     * 激光频率 0 1Hz 1 5Hz 2 12.5Hz
     * **/
    public double getLaserFrequency(){
        switch ((int) (statusWord & 0xc)){
            case 0x4:
                return 5;
            case 0x8:
                return 12.5;
            case 0x0:
            default:
                return 1;
        }
    }

    /**
     * 激光有无 0无1有
     * **/
    public int getLaserExist(){
        return (statusWord & 0x10) == 0x0 ? 0 : 1;
    }

    /**
     * 测距有效 0无效1有效
     * **/
    public int getRangingEffective(){
        return (statusWord & 0x20) == 0x0 ? 0 : 1;
    }


}
