package edu.npu.util;

/**
 * @author : [wangminan]
 * @description : 光电位运算工具
 */
public class PhotoElectronicByteUtil {

    public static int bytesToUnsignedShort(byte[] bytes) {
        return (bytes[0] & 0xff) | ((bytes[1] & 0xff) << 8);
    }

    public static int bytesToShort(byte[] bytes) {
        return (bytes[0] & 0xff) | ((bytes[1]) << 8);
    }

    public static byte[] intToBytes(int value) {
        return new byte[]{(byte) (value & 0xff), (byte) ((value >> 8) & 0xff)};
    }

    public static double bytesTo180Angle(byte[] bytes) {
        // 确保输入的字节数组长度为2
        if (bytes.length != 2) {
            throw new IllegalArgumentException("Input byte array must have exactly 2 bytes.");
        }


        // 使用位运算合并两个字节为一个整数
        int highByte = bytes[1] & 0xFF; // 高字节，确保转为无符号
        int lowByte = bytes[0] & 0xFF;   // 低字节，确保转为无符号
        int normalizedValue = (highByte << 8) | lowByte; // 合并字节

        // 处理负值
//        if (normalizedValue > 32767) {
//            normalizedValue -= 65536; // 如果值大于32767，则为负数
//        }
        // 大于180减360，小于-180+360
        // 转换为角度
        return normalizedValue * (180.0 / 32768.0);
    }

    public static byte[] angle180ToBytes(double angle) {
        if (angle>180){
            angle = angle-360;
        } else if (angle<-180) {
            angle = angle+360;
        }


        // 角度转换为整数
        int normalizedValue = (int) (angle * (32768.0 / 180.0));
        // 处理负值
        if (normalizedValue < 0) {
            normalizedValue += 65536; // 如果值为负数，则加上65536
        }

        // 分离高低字节
        byte highByte = (byte) ((normalizedValue >> 8) & 0xFF);
        byte lowByte = (byte) (normalizedValue & 0xFF);

        // 返回字节数组
        return new byte[]{lowByte,highByte};
    }

    // 360度角是2^16
    public static double bytesTo360Angle(byte[] bytes) {
        // 确保输入的字节数组长度为2
        if (bytes.length != 2) {
            throw new IllegalArgumentException("Input byte array must have exactly 2 bytes.");
        }

        // 使用位运算合并两个字节为一个整数
        int highByte = bytes[1] & 0xFF; // 高字节，确保转为无符号
        int lowByte = bytes[0] & 0xFF;   // 低字节，确保转为无符号
        int normalizedValue = (highByte << 8) | lowByte; // 合并字节

        // 处理负值
        if (normalizedValue > 32767) {
            normalizedValue -= 65536; // 如果值大于32767，则为负数
        }

        // 转换为角度
        return normalizedValue * (360.0 / 65536.0);
    }

    public static byte[] angle360ToBytes(double angle) {
        if (angle>180){
            angle = angle-360;
        } else if (angle<-180) {
            angle = angle+360;
        }
        // 角度转换为整数
        int normalizedValue = (int) (angle * (65536.0 / 360.0));

        // 处理负值
        if (normalizedValue < 0) {
            normalizedValue += 65536; // 如果值为负数，则加上65536
        }

        // 分离高低字节
        byte highByte = (byte) ((normalizedValue >> 8) & 0xFF);
        byte lowByte = (byte) (normalizedValue & 0xFF);

        // 返回字节数组
        return new byte[]{lowByte,highByte};
    }


    public static void main(String[] args) {
        System.out.println(bytesToUnsignedShort(new byte[]{80,-120}));
    }
}
