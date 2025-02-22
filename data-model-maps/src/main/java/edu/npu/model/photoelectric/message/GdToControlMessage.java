package edu.npu.model.photoelectric.message;

import com.uav.uavserver.domain.photoelectric.statusWord.GdStatusWord1;
import com.uav.uavserver.domain.photoelectric.statusWord.GdStatusWord2;
import com.uav.uavserver.domain.photoelectric.statusWord.GdStatusWord5;
import lombok.Getter;
import lombok.Setter;

import static com.uav.uavserver.util.PhotoElectronicByteUtil.bytesTo180Angle;
import static com.uav.uavserver.util.PhotoElectronicByteUtil.bytesToShort;
import static com.uav.uavserver.util.PhotoElectronicByteUtil.bytesToUnsignedShort;

/**
 * @author : [wangminan]
 * @description : GD到控制的报文
 */
public class GdToControlMessage {
    // GD到控制的定长报文 66字节
    @Getter
    @Setter
    private byte[] message;

    public GdToControlMessage(byte[] message) {
        this.message = message;
        this.messageIdentification = new byte[]{message[0], message[1]};
        this.messageLength = new byte[]{message[2], message[3]};
        this.messageFrameNumber = new byte[]{message[4], message[5]};
        this.statusWord1 = new byte[]{message[6], message[7]};
        this.statusWord2 = new byte[]{message[8], message[9]};
        this.reservedField1 = new byte[]{message[10], message[11], message[12], message[13]};
        this.statusWord5 = new byte[]{message[14], message[15]};
        this.reservedField2 = new byte[]{message[16], message[17], message[18], message[19], message[20], message[21], message[22], message[23], message[24], message[25]};
        this.questionNumber = new byte[]{message[26], message[27]};
        this.laserDistance = new byte[]{message[28], message[29]};
        this.gdAzimuth = new byte[]{message[30], message[31]};
        this.gdPitchAngle = new byte[]{message[32], message[33]};
        this.gyroAzimuthSpeed = new byte[]{message[34], message[35]};
        this.gyroPitchAngleSpeed = new byte[]{message[36], message[37]};
        this.azimuthTrackingError = new byte[]{message[38], message[39]};
        this.pitchTrackingError = new byte[]{message[40], message[41]};
        this.fieldOfViewAzimuth = new byte[]{message[42], message[43]};
        this.fieldOfViewPitchAngle = new byte[]{message[44], message[45]};
        this.directionAxisPosition = new byte[]{message[46], message[47]};
        this.pitchAxisPosition = new byte[]{message[48], message[49]};
        this.routeDistance = new byte[]{message[50], message[51]};
        this.routeAzimuthError = new byte[]{message[52], message[53]};
        this.routePitchError = new byte[]{message[54], message[55]};
        this.routeAzimuthSpeed = new byte[]{message[56], message[57]};
        this.routeAzimuthAcceleration = new byte[]{message[58], message[59]};
        this.routePitchSpeed = new byte[]{message[60], message[61]};
        this.routePitchAcceleration = new byte[]{message[62], message[63]};
        this.reservedBytes3 = message[64];
        this.checkCode = message[65];
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
    private final byte[] messageFrameNumber;

    private int getMessageFrameNumber() {
        return bytesToUnsignedShort(messageFrameNumber);
    }

    // 状态字1-6
    private final byte[] statusWord1;

    public GdStatusWord1 getStatusWord1() {
        return new GdStatusWord1(statusWord1);
    }


    private final byte[] statusWord2;

    public GdStatusWord2 getStatusWord2() {
        return new GdStatusWord2(statusWord2);
    }

    // 保留字段1 4字节
    @Getter
    private final byte[] reservedField1;

    private final byte[] statusWord5;

    public GdStatusWord5 getStatusWord5() {
        return new GdStatusWord5(statusWord5);
    }

    // 保留字段2 10字节
    @Getter
    private final byte[] reservedField2;

    // 题号
    private final byte[] questionNumber;

    public int getQuestionNumber() {
        return bytesToUnsignedShort(questionNumber);
    }

    // 激光距离
    private final byte[] laserDistance;

    public int getLaserDistance() {
        return bytesToUnsignedShort(laserDistance);
    }

    // GD方位角
    private final byte[] gdAzimuth;

    public double getGdAzimuth() {
        return bytesTo180Angle(gdAzimuth);
    }

    // GD俯仰角
    private final byte[] gdPitchAngle;

    public double getGdPitchAngle() {
        return bytesTo180Angle(gdPitchAngle);
    }

    // 陀螺仪方位角速度
    private final byte[] gyroAzimuthSpeed;

    public double getGyroAzimuthSpeed() {
        return bytesTo180Angle(gyroAzimuthSpeed);
    }

    // 陀螺仪俯仰角速度
    private final byte[] gyroPitchAngleSpeed;

    public double getGyroPitchAngleSpeed() {
        return bytesTo180Angle(gyroPitchAngleSpeed);
    }

    // 方位跟踪误差量
    private final byte[] azimuthTrackingError;

    public double getAzimuthTrackingError() {
        return bytesToShort(azimuthTrackingError) * 0.01;
    }

    // 俯仰跟踪误差量
    private final byte[] pitchTrackingError;

    public double getPitchTrackingError() {
        return bytesToShort(pitchTrackingError) * 0.01;
    }

    // 视场方位角
    private final byte[] fieldOfViewAzimuth;

    public double getFieldOfViewAzimuth() {
        return bytesTo180Angle(fieldOfViewAzimuth);
    }

    // 视场俯仰角
    private final byte[] fieldOfViewPitchAngle;

    public double getFieldOfViewPitchAngle() {
        return bytesTo180Angle(fieldOfViewPitchAngle);
    }

    // 方位轴位
    private final byte[] directionAxisPosition;

    public int getDirectionAxisPosition() {
        return bytesToShort(directionAxisPosition);
    }

    // 俯仰轴位
    private final byte[] pitchAxisPosition;

    public int getPitchAxisPosition() {
        return bytesToShort(pitchAxisPosition);
    }

    // 航路距离
    private final byte[] routeDistance;

    public int getRouteDistance() {
        return bytesToUnsignedShort(routeDistance);
    }

    // 航路方位误差
    private final byte[] routeAzimuthError;

    public double getRouteAzimuthError() {
        return bytesToShort(routeAzimuthError) * 0.01;
    }

    // 航路俯仰误差
    private final byte[] routePitchError;

    public double getRoutePitchError() {
        return bytesToShort(routePitchError) * 0.01;
    }

    // 航路方位速度
    private final byte[] routeAzimuthSpeed;

    public double getRouteAzimuthSpeed() {
        return bytesToShort(routeAzimuthSpeed) * 0.1;
    }

    // 航路方位加速度
    private final byte[] routeAzimuthAcceleration;

    public double getRouteAzimuthAcceleration() {
        return bytesToShort(routeAzimuthAcceleration) * 0.1;
    }

    // 航路俯仰速度
    private final byte[] routePitchSpeed;

    public double getRoutePitchSpeed() {
        return bytesToShort(routePitchSpeed) * 0.1;
    }

    // 航路俯仰加速度
    private final byte[] routePitchAcceleration;

    public double getRoutePitchAcceleration() {
        return bytesToShort(routePitchAcceleration) * 0.1;
    }

    // 备用
    @Getter
    private final byte reservedBytes3;

    // 校验码
    @Getter
    private final byte checkCode;
}
