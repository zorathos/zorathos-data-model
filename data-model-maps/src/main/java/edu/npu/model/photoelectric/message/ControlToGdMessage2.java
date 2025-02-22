package io.github.wangminan.model.photoelectric.message;

import edu.npu.util.PhotoElectronicByteUtil;
import lombok.Getter;
import lombok.Setter;

import static edu.npu.util.PhotoElectronicByteUtil.angle180ToBytes;
import static edu.npu.util.PhotoElectronicByteUtil.bytesTo180Angle;
import static edu.npu.util.PhotoElectronicByteUtil.bytesToUnsignedShort;
import static edu.npu.util.PhotoElectronicByteUtil.intToBytes;

/**
 * @author : [wangminan]
 * @description : 控制到光电的报文（备选）
 */
public class ControlToGdMessage2 {
    // 定长报文 35字节
    @Getter
    @Setter
    private byte[] message;

    private static int udpClientMessageFrameNumberAuto;


    public ControlToGdMessage2() {
        // 报文标识0x1150
        this.messageIdentification = intToBytes(0x1150);
        // 报文长度35
        this.messageLength = intToBytes(35);
        // 报文帧号
        if (udpClientMessageFrameNumberAuto == 2147483647) {
            udpClientMessageFrameNumberAuto = 0;
        }
        this.messageFrameNumber = intToBytes(udpClientMessageFrameNumberAuto++);
        // 控制字1
        this.controlWord1 = intToBytes(0);
        // 批号：0
        this.batchNum = new byte[]{0, 0};
        // 目标方位角!!!（从雷达中获取）
        this.targetAzimuth = PhotoElectronicByteUtil.intToBytes(0);
        // 目标俯仰角!!!（从雷达中获取）
        this.targetElevation = PhotoElectronicByteUtil.intToBytes(0);
        // 目标距离!!!（从雷达中获取）
        this.targetDistance = PhotoElectronicByteUtil.intToBytes(0);
        // 备用1
        this.reservedBytes1 = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
    @Getter
    @Setter
    private byte[] controlWord1;

    // 批号 2字节
    @Getter
    private final byte[] batchNum;

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

    // 目标距离 2字节
    private byte[] targetDistance;

    public int getTargetDistance() {
        return bytesToUnsignedShort(targetDistance);
    }

    public void setTargetDistance(int targetDistance) {
        this.targetDistance = intToBytes(targetDistance);
    }

    // 保留字节 2字节
    @Getter
    private final byte[] reservedBytes1;

    // 校验和 1字节 所有字节取异或
    @Getter
    private byte checkSum;

    public void setCheckSumAndRewriteContol() {
        // 报文帧号
        if (udpClientMessageFrameNumberAuto == 2147483647) {
            udpClientMessageFrameNumberAuto = 0;
        }
        this.messageFrameNumber = intToBytes(udpClientMessageFrameNumberAuto++);
        message = combineArrays(messageIdentification, messageLength, messageFrameNumber, controlWord1, batchNum,
                targetAzimuth, targetElevation, targetDistance, reservedBytes1
        );
        // 校验(前面每两个字节异或，后面一个异或)
        // 取值进行异或比较
        int checkSum = 0;
        for (byte b : message) {
            checkSum = b ^ checkSum;
        }
        byte[] newMessage = new byte[message.length + 1];    // 新数组
        System.arraycopy(message, 0, newMessage, 0, message.length);    // 复制原数组到新数组
        newMessage[newMessage.length - 1] = Byte.parseByte(String.valueOf(checkSum));    // 添加新元素到新数组的最后位置
        message = newMessage;
        this.checkSum = message[34];
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
            System.arraycopy(d, 0, c, index, d.length);
            index += d.length;
        }
        return c;
    }
}
