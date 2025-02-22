package io.github.wangminan.model.photoelectric.statusWord;

import static edu.npu.util.PhotoElectronicByteUtil.bytesToUnsignedShort;

/**
 * @author : [wangminan]
 * @description : Gd状态字2 视频跟踪器状态
 */
public class GdStatusWord2{

    // 0x3 跟踪状态
    // 0x4 校轴状态
    // 0x8 跟踪通道
    // 0x30 跟踪算法
    // 0x40 目标极性
    // 0x80 目标类型
    // 0x100 海天线有无
    // 0x800 字符显示

    protected long statusWord;

    public GdStatusWord2(byte[] statusWord) {
        this.statusWord = bytesToUnsignedShort(statusWord);
    }

    /**
     * 跟踪状态 0目标丢失 1捕获好 2记忆跟踪
     * **/
    public int getTrackStatus(){
        switch ((int) (statusWord & 0x3)){
            case 0x1:
                return 1;
            case 0x2:
                return 2;
            case 0x0:
            default:
                return 0;
        }
    }

    /**
     * 校轴状态 0关1开
     * **/
    public int getAlignAxisStatus(){
        return (statusWord & 0x4) == 0x0 ? 0 : 1;
    }

    /**
     * 跟踪通道 0电视1红外
     * **/
    public int getTrackChannel(){
        return (statusWord & 0x8) == 0x0 ? 0 : 1;
    }
    /**
     * 跟踪算法 0质心1相关
     * **/
    public int getTrackAlgorithm(){
        return (statusWord & 0x30) == 0x0 ? 0 : 1;
    }
    /**
     * 目标极性 0白目标1黑目标
     * **/
    public int getTargetPolarity(){
        return (statusWord & 0x40) == 0x0 ? 0 : 1;
    }
    /**
     * 目标类型 0对海1对空
     * **/
    public int getTargetType(){
        return (statusWord & 0x80) == 0x0 ? 0 : 1;
    }
    /**
     * 海天线有无 0无1有
     * **/
    public int getSeaAntenna(){
        return (statusWord & 0x100) == 0x0 ? 0 : 1;
    }
    /**
     * 字符显示 0全显示1全消隐
     * **/
    public int getCharIsShow(){
        return (statusWord & 0x800) == 0x0 ? 0 : 1;
    }

}
