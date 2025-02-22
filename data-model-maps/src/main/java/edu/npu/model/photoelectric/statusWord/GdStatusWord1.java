package edu.npu.model.photoelectric.statusWord;

import static com.uav.uavserver.util.PhotoElectronicByteUtil.bytesToUnsignedShort;

/**
 * @author : [wangminan]
 * @description : Gd状态字1 系统及伺服状态
 */
public class GdStatusWord1{
    // 0x00f0 伺服状态
    // 0x0001 工作状态
    // 0x000e 检查状态
    // 0x100 归零好
    // 0x200 跟踪好
    // 0x400 调弦到位
    // 0x800 记忆跟踪
    // 0x3000 工作方式
    // 0xc000 开机状态

    protected long statusWord;

    public GdStatusWord1(byte[] statusWord) {
        this.statusWord = bytesToUnsignedShort(statusWord);
    }

    /**
     * 工作状态 0战斗1检查
     * **/
    public int getWorkStatus(){
        return (statusWord & 0x0001) == 0x0 ? 0 : 1;
    }
    /**
     * 检查状态 0无效1状态检查2备用3备用4标定检查
     * **/
    public int getInspectStatus(){
        switch ((int) (statusWord & 0x000e)){
            case 0x2:
                return 1;
            case 0x4:
                return 2;
            case 0x6:
                return 3;
            case 0x8:
                return 4;
            case 0x0:
            default:
                return 0;
        }
    }

    /**
     * 伺服状态 0无效 1停托架/稳瞄 2停大地 3归零/航路 4目指A 5目指B 6跟踪
     * **/
    public int getServoStatus(){
        switch ((int) (statusWord & 0x00f0)){
            case 0x10:
                return 1;
            case 0x20:
                return 2;
            case 0x30:
                return 3;
            case 0x40:
                return 4;
            case 0x50:
                return 5;
            case 0x60:
                return 6;
            case 0x0:
            default:
                return 0;
        }
    }

    /**
     * 工作方式 0自动1人工
     * **/
    public int getWorkWay(){
        return (statusWord & 0x3000) == 0x0 ? 0 : 1;
    }

    /**
     * 开机状态 0关机好 1正在开机 2开机好 3正在关机
     * **/
    public int getPowerOnStatus(){
        switch ((int) (statusWord & 0xc000)){
            case 0x4000:
                return 1;
            case 0x8000:
                return 2;
            case 0xc000:
                return 3;
            case 0x0:
            default:
                return 0;
        }
    }

    /**
     * 是否归零好 0否1是
     * **/
    public int getReturnZeroStatus(){

        return (statusWord & 0x100) == 0x100 ? 1 : 0;
    }
}
