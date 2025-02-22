package io.github.wangminan.model.photoelectric.controlWord;

import lombok.Getter;

/**
 * @author : [wangminan]
 * @description : [一句话描述该类的功能]
 */
public class GdControlWord3 extends AbstractControlWord{

    public GdControlWord3() {
        super();
        for (int i = 0; i < 16; i++) {
            controlWord[i] = 0;
        }
    }

    public GdControlWord3(byte[] controlWord) {
        // 两字节控制字 转换到16位数组
        super();
        for (int i = 0; i < 16; i++) {
            this.controlWord[i] = (controlWord[0] >> i) & 0x01;
        }
    }

    // 跟踪通道 电视/红外
    public void setTrackChannel_TV() {
        controlWord[15] = 0;
    }

    public void setTrackChannel_IR() {
        controlWord[15] = 1;
    }

    public TrackChannel getTrackChannel() {
        return controlWord[15] == 0 ? TrackChannel.TV : TrackChannel.IR;
    }

    public void setTrackChannel(TrackChannel trackChannel) {
        controlWord[15] = trackChannel.getValue();
    }

    // 工作模式 待机/捕获
    public void setWorkMode_Standby() {
        controlWord[14] = 0;
    }

    public void setWorkMode_Capture() {
        controlWord[14] = 1;
    }

    public WorkMode getWorkMode() {
        return controlWord[14] == 0 ? WorkMode.STANDBY : WorkMode.CAPTURE;
    }

    public void setWorkMode(WorkMode workMode) {
        controlWord[14] = workMode.getValue();
    }

    // 跟踪目标极性选择 白/黑
    public void setTrackTargetPolarity_White() {
        controlWord[13] = 0;
    }

    public void setTrackTargetPolarity_Black() {
        controlWord[13] = 1;
    }

    public TrackTargetPolarity getTrackTargetPolarity() {
        return controlWord[13] == 0 ? TrackTargetPolarity.WHITE : TrackTargetPolarity.BLACK;
    }

    public void setTrackTargetPolarity(TrackTargetPolarity trackTargetPolarity) {
        controlWord[13] = trackTargetPolarity.getValue();
    }

    // 跟踪模式 备用 对空
    public void setTrackMode_Spare() {
        controlWord[10] = 0;
    }

    public void setTrackMode_Air() {
        controlWord[10] = 1;
    }

    public void setTrackMode(TrackMode trackMode) {
        controlWord[10] = trackMode.getValue();
    }

    public TrackMode getTrackMode() {
        return controlWord[10] == 0 ? TrackMode.Spare : TrackMode.AIR;
    }

    // 跟踪算法 质心/相关
    public void setTrackAlgorithm_Centroid() {
        controlWord[8] = 0;
        controlWord[9] = 0;
    }

    public void setTrackAlgorithm_Correlation() {
        controlWord[8] = 0;
        controlWord[9] = 1;
    }

    public TrackAlgorithm getTrackAlgorithm() {
        if (controlWord[8] == 0 && controlWord[9] == 0) {
            return TrackAlgorithm.CENTROID;
        } else if (controlWord[8] == 0 && controlWord[9] == 1) {
            return TrackAlgorithm.CORRELATION;
        } else {
            return null;
        }
    }

    public void setTrackAlgorithm(TrackAlgorithm trackAlgorithm) {
        controlWord[8] = trackAlgorithm.getValue()[0];
        controlWord[9] = trackAlgorithm.getValue()[1];
    }

    // 校轴命令 不动 上下左右1线 保存十字线 恢复默认
    public void setAlignmentCommand_Still() {
        controlWord[5] = 0;
        controlWord[6] = 0;
        controlWord[7] = 0;
    }

    public void setAlignmentCommand_Left() {
        controlWord[5] = 0;
        controlWord[6] = 0;
        controlWord[7] = 1;
    }

    public void setAlignmentCommand_Right() {
        controlWord[5] = 0;
        controlWord[6] = 1;
        controlWord[7] = 0;
    }

    public void setAlignmentCommand_Up() {
        controlWord[5] = 0;
        controlWord[6] = 1;
        controlWord[7] = 1;
    }

    public void setAlignmentCommand_Down() {
        controlWord[5] = 1;
        controlWord[6] = 0;
        controlWord[7] = 0;
    }

    public void setAlignmentCommand_SaveCross() {
        controlWord[5] = 1;
        controlWord[6] = 0;
        controlWord[7] = 1;
    }

    public void setAlignmentCommand_RecoverDefault() {
        controlWord[5] = 1;
        controlWord[6] = 1;
        controlWord[7] = 0;
    }

    public void setAlignmentCommand(AlignmentCommand alignmentCommand) {
        controlWord[5] = alignmentCommand.getValue()[0];
        controlWord[6] = alignmentCommand.getValue()[1];
        controlWord[7] = alignmentCommand.getValue()[2];
    }

    public AlignmentCommand getAlignmentCommand() {
        return controlWord[5] == 0 && controlWord[6] == 0 && controlWord[7] == 0 ? AlignmentCommand.STILL :
                controlWord[5] == 0 && controlWord[6] == 0 && controlWord[7] == 1 ? AlignmentCommand.LEFT :
                controlWord[5] == 0 && controlWord[6] == 1 && controlWord[7] == 0 ? AlignmentCommand.RIGHT :
                controlWord[5] == 0 && controlWord[6] == 1 && controlWord[7] == 1 ? AlignmentCommand.UP :
                controlWord[5] == 1 && controlWord[6] == 0 && controlWord[7] == 0 ? AlignmentCommand.DOWN :
                controlWord[5] == 1 && controlWord[6] == 0 && controlWord[7] == 1 ? AlignmentCommand.SAVE_CROSS :
                controlWord[5] == 1 && controlWord[6] == 1 && controlWord[7] == 0 ? AlignmentCommand.RECOVER_DEFAULT : null;
    }

    // 校轴 开关
    public void setAlignmentSwitch_ON() {
        controlWord[4] = 1;
    }

    public void setAlignmentSwitch_OFF() {
        controlWord[4] = 0;
    }

    public AlignmentSwitch getAlignmentSwitch() {
        return controlWord[4] == 1 ? AlignmentSwitch.ON : AlignmentSwitch.OFF;
    }

    public void setAlignmentSwitch(AlignmentSwitch alignmentSwitch) {
        controlWord[4] = alignmentSwitch.getValue();
    }

    // 海天线
    public void setSeaAntenna_ON() {
        controlWord[2] = 1;
    }

    public void setSeaAntenna_OFF() {
        controlWord[2] = 0;
    }

    public SeaAntenna getSeaAntenna() {
        return controlWord[2] == 1 ? SeaAntenna.ON : SeaAntenna.OFF;
    }

    public void setSeaAntenna(SeaAntenna seaAntenna) {
        controlWord[2] = seaAntenna.getValue();
    }

    // 跟踪器字符显示 全显示0/全隐藏1
    public void setTrackerCharacterDisplay_All() {
        controlWord[0] = 0;
    }

    public void setTrackerCharacterDisplay_None() {
        controlWord[0] = 1;
    }

    public TrackerCharacterDisplay getTrackerCharacterDisplay() {
        return controlWord[0] == 0 ? TrackerCharacterDisplay.ALL : TrackerCharacterDisplay.NONE;
    }

    public void setTrackerCharacterDisplay(TrackerCharacterDisplay trackerCharacterDisplay) {
        controlWord[0] = trackerCharacterDisplay.getValue();
    }


    @Getter
    public enum TrackChannel{
        TV(0), IR(1);

        private final int value;

        TrackChannel(int value) {
            this.value = value;
        }
    }

    @Getter
    public enum WorkMode{
        STANDBY(0), CAPTURE(1);

        private final int value;

        WorkMode(int value) {
            this.value = value;
        }
    }

    @Getter
    public enum TrackTargetPolarity{
        WHITE(0), BLACK(1);

        private final int value;

        TrackTargetPolarity(int value) {
            this.value = value;
        }
    }

    @Getter
    public enum TrackMode{
        Spare(0), AIR(1);

        private final int value;

        TrackMode(int value) {
            this.value = value;
        }
    }

    @Getter
    public enum TrackAlgorithm{
        CENTROID(0, 0), CORRELATION(0,1);

        private final int[] value;

        TrackAlgorithm(int... value) {
            this.value = value;
        }
    }

    @Getter
    public enum AlignmentCommand{
        STILL(new int[]{0, 0, 0}),
        LEFT(new int[]{0, 0, 1}),
        RIGHT(new int[]{0, 1, 0}),
        UP(new int[]{0, 1, 1}),
        DOWN(new int[]{1, 0, 0}),
        SAVE_CROSS(new int[]{1, 0, 1}),
        RECOVER_DEFAULT(new int[]{1, 1, 0});

        private final int[] value;

        AlignmentCommand(int[] value) {
            this.value = value;
        }
    }

    @Getter
    public enum AlignmentSwitch{
        ON(1), OFF(0);

        private final int value;

        AlignmentSwitch(int value) {
            this.value = value;
        }
    }

    @Getter
    public enum SeaAntenna{
        ON(1), OFF(0);

        private final int value;

        SeaAntenna(int value) {
            this.value = value;
        }
    }

    @Getter
    public enum TrackerCharacterDisplay{
        ALL(0), NONE(1);

        private final int value;

        TrackerCharacterDisplay(int value) {
            this.value = value;
        }
    }
}
