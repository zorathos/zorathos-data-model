package edu.npu.model.photoelectric.message;


import com.uav.uavserver.config.udpserver.LogPushUdpClientHandler;
import edu.npu.util.PhotoElectronicByteUtil;
import lombok.Getter;
import lombok.Setter;

import static edu.npu.util.PhotoElectronicByteUtil.angle180ToBytes;
import static edu.npu.util.PhotoElectronicByteUtil.angle360ToBytes;
import static edu.npu.util.PhotoElectronicByteUtil.bytesTo180Angle;
import static edu.npu.util.PhotoElectronicByteUtil.bytesTo360Angle;
import static edu.npu.util.PhotoElectronicByteUtil.bytesToShort;
import static edu.npu.util.PhotoElectronicByteUtil.bytesToUnsignedShort;
import static edu.npu.util.PhotoElectronicByteUtil.intToBytes;

/**
 * @author : [wangminan]
 * @description : 控制到光电的报文
 */
public class ControlToGdMessage {
    // 定长报文 86字节
    @Getter
    @Setter
    private byte[] message;

    public ControlToGdMessage(byte[] message) {
        this.message = message;
        this.messageIdentification = new byte[]{message[0], message[1]};
        this.messageLength = new byte[]{message[2], message[3]};
        this.messageFrameNumber = new byte[]{message[4], message[5]};
        this.controlWord1 = new byte[]{message[6], message[7]};
        this.controlWord2 = new byte[]{message[8], message[9]};
        this.controlWord3 = new byte[]{message[10], message[11]};
        this.controlWord4 = new byte[]{message[12], message[13]};
        this.controlWord5 = new byte[]{message[14], message[15]};
        this.controlWord6 = new byte[]{message[16], message[17]};
        this.controlWord7 = new byte[]{message[18], message[19]};
        this.controlWord8 = new byte[]{message[20], message[21]};
        this.controlWord9 = new byte[]{message[22], message[23]};
        this.controlWord10 = new byte[]{message[24], message[25]};
        this.reservedBytes1 = new byte[]{message[26], message[27]};
        this.targetDistance = new byte[]{message[28], message[29]};
        this.targetAzimuth = new byte[]{message[30], message[31]};
        this.targetElevation = new byte[]{message[32], message[33]};
        this.reservedBytes2 = new byte[]{message[34], message[35]};
        this.azimuthCorrection = new byte[]{message[36], message[37]};
        this.elevationCorrection = new byte[]{message[38], message[39]};
        this.headingAngle = new byte[]{message[40], message[41]};
        this.reservedBytes3 = new byte[]{message[42], message[43], message[44], message[45], message[46], message[47], message[48], message[49], message[50], message[51], message[52], message[53], message[54], message[55]};
        this.joystickAzimuth = new byte[]{message[56], message[57]};
        this.joystickElevation = new byte[]{message[58], message[59]};
        this.analogTargetDistance = new byte[]{message[60], message[61]};
        this.reservedBytes4 = new byte[]{message[62], message[63], message[64], message[65], message[66], message[67], message[68], message[69], message[70], message[71], message[72], message[73], message[74], message[75]};
        this.routeNumber = new byte[]{message[76], message[77]};
        this.reservedBytes5 = new byte[]{message[78], message[79], message[80], message[81], message[82], message[83], message[84]};
        this.checkSum = message[85];
    }

    public ControlToGdMessage() {
        // 报文标识0x520
        this.messageIdentification = PhotoElectronicByteUtil.intToBytes(0x0520);
        // 报文长度86(10进制)
        this.messageLength = PhotoElectronicByteUtil.intToBytes(86);
        // 报文帧号===
        if (LogPushUdpClientHandler.messageFrameNumberAuto == 2147483647){
            LogPushUdpClientHandler.messageFrameNumberAuto = 0;
        }
        this.messageFrameNumber = PhotoElectronicByteUtil.intToBytes(LogPushUdpClientHandler.messageFrameNumberAuto++);
        // 控制字1
        this.controlWord1 = intToBytes(0x0810);
        // 控制字2
        this.controlWord2 = intToBytes(0x0038);
        // 控制字3
        this.controlWord3 = intToBytes(0x0000);
        // 控制字4
        this.controlWord4 = intToBytes(0x00);
        // 控制字5
        this.controlWord5 = intToBytes(0x00);
        // 控制字6
        this.controlWord6 = intToBytes(0x00);
        // 控制字7
        this.controlWord7 = intToBytes(0x0000);
        // 控制字8
        this.controlWord8 = intToBytes(0x00);
        // 控制字9
        this.controlWord9 = intToBytes(0x00);
        // 控制字10
        this.controlWord10 = intToBytes(0x00);
        // 备用1
        this.reservedBytes1 = new byte[]{0,0};
        // 目标距离!!!（从雷达中获取）
        this.targetDistance = PhotoElectronicByteUtil.intToBytes(0);
        // 目标方位角!!!（从雷达中获取）
        this.targetAzimuth = PhotoElectronicByteUtil.intToBytes(0);
        // 目标俯仰角!!!（从雷达中获取）
        this.targetElevation = PhotoElectronicByteUtil.intToBytes(0);
        // 备用2
        this.reservedBytes2 = new byte[]{0,0};
        // 标定方位修正量
        this.azimuthCorrection = new byte[]{0,0};
        // 标定俯仰修正量
        this.elevationCorrection = new byte[]{0,0};
        // 航向角
        this.headingAngle = new byte[]{0,0};
        // 备用3-4-5-6-7-8-9
        this.reservedBytes3 = new byte[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        // 操纵杆方位量（一次传20，发送四次后发0）
        this.joystickAzimuth = PhotoElectronicByteUtil.intToBytes(0);
        // 操纵杆俯仰量（一次传20，发送四次后发0）
        this.joystickElevation = PhotoElectronicByteUtil.intToBytes(0);
        // 模拟目标距离
        this.analogTargetDistance = PhotoElectronicByteUtil.intToBytes(0);
        // 备用10-11-12-13-14-15-16-17
        this.reservedBytes4 = new byte[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        // 航路编号
        this.routeNumber = PhotoElectronicByteUtil.intToBytes(0x8);
        // 备用
        this.reservedBytes5 = new byte[]{0,0,0,0,0,0,0};
        setCheckSumAndRewriteContol();
    }

    // 报文标识 2字节
    private final byte[] messageIdentification;

    public int getMessageIdentification() {
        return bytesToUnsignedShort(messageIdentification);
    }

    // 报文长度 2字节
    private final byte[] messageLength;

    public int getMessageLength() {
        return bytesToUnsignedShort(messageLength);
    }

    // 报文帧号 2字节
    private byte[] messageFrameNumber;
    private int getMessageFrameNumber() {
        return bytesToUnsignedShort(messageFrameNumber);
    }

    // 控制字1-10 各2字节
    @Getter @Setter
    private byte[] controlWord1;
    @Getter @Setter
    private byte[] controlWord2;
    @Getter @Setter
    private byte[] controlWord3;
    @Getter @Setter
    private byte[] controlWord4;
    @Getter @Setter
    private byte[] controlWord5;
    @Getter @Setter
    private byte[] controlWord6;
    @Getter @Setter
    private byte[] controlWord7;
    @Getter
    private final byte[] controlWord8;
    @Getter
    private final byte[] controlWord9;
    @Getter
    private final byte[] controlWord10;

    // 保留字节 2字节
    @Getter
    private final byte[] reservedBytes1;

    // 目标距离 2字节
    private byte[] targetDistance;

    public int getTargetDistance() {
        return bytesToUnsignedShort(targetDistance);
    }

    public void setTargetDistance(int targetDistance) {
        this.targetDistance = intToBytes(targetDistance);
    }

    // 目标方位角 2字节
    private byte[] targetAzimuth;

    public double getTargetAzimuth() {
        return bytesTo180Angle(targetAzimuth);
    }

    public void setTargetAzimuth(double targetAzimuth) {
        this.targetAzimuth = angle180ToBytes(targetAzimuth);
    }

    // 目标俯仰角 2字节
    private byte[] targetElevation;

    public double getTargetElevation() {
        return bytesTo180Angle(targetElevation);
    }

    public void setTargetElevation(double targetElevation) {
        this.targetElevation = angle180ToBytes(targetElevation);
    }

    // 保留字节 2字节
    @Getter
    private final byte[] reservedBytes2;

    // 标定方位修正量 2字节
    private byte[] azimuthCorrection;

    public double getAzimuthCorrection() {
        return bytesTo180Angle(azimuthCorrection);
    }

    public void setAzimuthCorrection(double azimuthCorrection) {
        this.azimuthCorrection = angle180ToBytes(azimuthCorrection);
    }

    // 标定俯仰修正量 2字节
    private byte[] elevationCorrection;

    public double getElevationCorrection() {
        return bytesTo180Angle(elevationCorrection);
    }

    public void setElevationCorrection(double elevationCorrection) {
        this.elevationCorrection = angle180ToBytes(elevationCorrection);
    }

    // 航向角 2字节
    private byte[] headingAngle;

    public double getHeadingAngle() {
        return bytesTo360Angle(headingAngle);
    }

    public void setHeadingAngle(double headingAngle) {
        this.headingAngle = angle360ToBytes(headingAngle);
    }

    // 备用 14字节
    @Getter
    private final byte[] reservedBytes3;

    // 操纵杆方位量 2字节
    private byte[] joystickAzimuth;

    public int getJoystickAzimuth() {
        return bytesToShort(joystickAzimuth);
    }

    public void setJoystickAzimuth(int joystickAzimuth) {
        this.joystickAzimuth = intToBytes(joystickAzimuth);
    }

    // 操纵杆俯仰量 2字节
    private byte[] joystickElevation;

    public int getJoystickElevation() {
        return bytesToShort(joystickElevation);
    }

    public void setJoystickElevation(int joystickElevation) {
        this.joystickElevation = intToBytes(joystickElevation);
    }

    // 模拟目标距离 2字节
    private byte[] analogTargetDistance;

    public int getAnalogTargetDistance() {
        return bytesToUnsignedShort(analogTargetDistance);
    }

    public void setAnalogTargetDistance(int analogTargetDistance) {
        this.analogTargetDistance = intToBytes(analogTargetDistance);
    }

    // 备用 14字节
    @Getter
    private final byte[] reservedBytes4;

    // 航路编号 2字节
    private byte[] routeNumber;

    public int getRouteNumber() {
        return bytesToUnsignedShort(routeNumber);
    }

    public void setRouteNumber(int routeNumber) {
        this.routeNumber = intToBytes(routeNumber);
    }

    // 备用 7字节
    @Getter
    private final byte[] reservedBytes5;

    // 校验和 1字节 所有字节取异或
    @Getter
    private byte checkSum;

    public void setCheckSumAndRewriteContol() {
        // 报文帧号===
        if (LogPushUdpClientHandler.messageFrameNumberAuto == 2147483647){
            LogPushUdpClientHandler.messageFrameNumberAuto = 0;
        }
        this.messageFrameNumber = PhotoElectronicByteUtil.intToBytes(LogPushUdpClientHandler.messageFrameNumberAuto++);
        message = combineArrays(messageIdentification,messageLength,messageFrameNumber,controlWord1,controlWord2,controlWord3,controlWord4,
                controlWord5,controlWord6,controlWord7,controlWord8,controlWord9,controlWord10,reservedBytes1,targetDistance,targetAzimuth,
                targetElevation,reservedBytes2,azimuthCorrection,elevationCorrection,headingAngle,reservedBytes3,joystickAzimuth,
                joystickElevation,analogTargetDistance,reservedBytes4,routeNumber,reservedBytes5
        );
        // 校验(前面每两个字节异或，后面一个异或)
        // 取值进行异或比较
//        int checkSum = bytesToUnsignedShort(new byte[]{message[0], message[1]}) ^ bytesToUnsignedShort(new byte[]{message[2], message[3]})
//                ^ bytesToUnsignedShort(new byte[]{message[4], message[5]}) ^ bytesToUnsignedShort(new byte[]{message[6], message[7]})
//                ^ bytesToUnsignedShort(new byte[]{message[8], message[9]}) ^ bytesToUnsignedShort(new byte[]{message[10], message[11]})
//                ^ bytesToUnsignedShort(new byte[]{message[12], message[13]}) ^ bytesToUnsignedShort(new byte[]{message[14], message[15]})
//                ^ bytesToUnsignedShort(new byte[]{message[16], message[17]}) ^ bytesToUnsignedShort(new byte[]{message[18], message[19]})
//                ^ bytesToUnsignedShort(new byte[]{message[20], message[21]}) ^ bytesToUnsignedShort(new byte[]{message[22], message[23]})
//                ^ bytesToUnsignedShort(new byte[]{message[24], message[25]}) ^ bytesToUnsignedShort(new byte[]{message[26], message[27]})
//                ^ bytesToUnsignedShort(new byte[]{message[28], message[29]}) ^ bytesToUnsignedShort(new byte[]{message[30], message[31]})
//                ^ bytesToUnsignedShort(new byte[]{message[32], message[33]}) ^ bytesToUnsignedShort(new byte[]{message[34], message[35]})
//                ^ bytesToUnsignedShort(new byte[]{message[36], message[37]}) ^ bytesToUnsignedShort(new byte[]{message[38], message[39]})
//                ^ bytesToUnsignedShort(new byte[]{message[40], message[41]}) ^ bytesToUnsignedShort(new byte[]{message[42], message[43]})
//                ^ bytesToUnsignedShort(new byte[]{message[44], message[45]}) ^ bytesToUnsignedShort(new byte[]{message[46], message[47]})
//                ^ bytesToUnsignedShort(new byte[]{message[48], message[49]}) ^ bytesToUnsignedShort(new byte[]{message[50], message[51]})
//                ^ bytesToUnsignedShort(new byte[]{message[52], message[53]}) ^ bytesToUnsignedShort(new byte[]{message[54], message[55]})
//                ^ bytesToUnsignedShort(new byte[]{message[56], message[57]}) ^ bytesToUnsignedShort(new byte[]{message[58], message[59]})
//                ^ bytesToUnsignedShort(new byte[]{message[60], message[61]}) ^ bytesToUnsignedShort(new byte[]{message[62], message[63]})
//                ^ bytesToUnsignedShort(new byte[]{message[64], message[65]}) ^ bytesToUnsignedShort(new byte[]{message[66], message[67]})
//                ^ bytesToUnsignedShort(new byte[]{message[68], message[69]}) ^ bytesToUnsignedShort(new byte[]{message[70], message[71]})
//                ^ bytesToUnsignedShort(new byte[]{message[72], message[73]}) ^ bytesToUnsignedShort(new byte[]{message[74], message[75]})
//                ^ bytesToUnsignedShort(new byte[]{message[76], message[77]}) ^ bytesToUnsignedShort(new byte[]{message[78], message[79]})
//                ^ bytesToUnsignedShort(new byte[]{message[80], message[81]}) ^ bytesToUnsignedShort(new byte[]{message[82], message[83]});
////                ^ message[84]; 不要补位了，java位数不够
//        byte[] newArray = new byte[message.length + 2];
//        System.arraycopy(message, 0, newArray, 0, message.length);
//        byte[] bytes = intToBytes(this.checkSum);
//        newArray[84] = bytes[0];
//        newArray[85] = bytes[1];
//        message = combineArrays(message,bytes);
        int checkSum = 0;
        for (int i = 0; i < message.length; i++) {
            checkSum = message[i] ^ checkSum;
        }
        byte[] newMessage = new byte[message.length + 1];    // 新数组
        System.arraycopy(message, 0, newMessage, 0, message.length);    // 复制原数组到新数组
        newMessage[newMessage.length - 1] = new Byte(String.valueOf(checkSum));    // 添加新元素到新数组的最后位置
        message = newMessage;
        this.checkSum = message[85];
    }

    private static byte[] combineArrays(byte[]... a) {
        int massLength = 0;
        for (byte[] b : a) {
            massLength += b.length;
        }
        byte[] c = new byte[massLength];
        byte[] d;
        int index = 0;
        for (byte[] anA : a) {
            d = anA;
            System.arraycopy(d, 0, c, 0 + index, d.length);
            index += d.length;
        }
        return c;
    }
}
