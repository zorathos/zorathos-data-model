package org.datacenter.model.physiological;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author : [wangminan]
 * @description : 三维动捕
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MotionCapture {
    /**
     * 我们自己加的主键 auto_increment bigint
     */
    private Long id;

    /**
     * 架次号 关联
     */
    private String sortieNumber;

    /**
     * 采集用传感器Id
     */
    private String sensorId;

    /**
     * 采样时间
     */
    private LocalDateTime sampleTimestamp;

    /**
     * Hips_qx
     */
    private Float hipsQx;

    /**
     * Hips_qy
     */
    private Float hipsQy;

    /**
     * Hips_qz
     */
    private Float hipsQz;

    /**
     * Hips_px
     */
    private Float hipsPx;

    /**
     * Hips_py
     */
    private Float hipsPy;

    /**
     * Hips_pz
     */
    private Float hipsPz;

    /**
     * Hips_Timestamp
     */
    private LocalDateTime hipsTimestamp;

    /**
     * JointTag_Spine_qx
     */
    private Float jointTagSpineQx;

    /**
     * JointTag_Spine_qy
     */
    private Float jointTagSpineQy;

    /**
     * JointTag_Spine_qz
     */
    private Float jointTagSpineQz;

    /**
     * JointTag_Spine_px
     */
    private Float jointTagSpinePx;

    /**
     * JointTag_Spine_py
     */
    private Float jointTagSpinePy;

    /**
     * JointTag_Spine_pz
     */
    private Float jointTagSpinePz;

    /**
     * JointTag_Spine_Timestamp
     */
    private LocalDateTime jointTagSpineTimestamp;

    /**
     * JointTag_Spine1_qx
     */
    private Float jointTagSpine1Qx;

    /**
     * JointTag_Spine1_qy
     */
    private Float jointTagSpine1Qy;

    /**
     * JointTag_Spine1_qz
     */
    private Float jointTagSpine1Qz;

    /**
     * JointTag_Spine1_px
     */
    private Float jointTagSpine1Px;

    /**
     * JointTag_Spine1_py
     */
    private Float jointTagSpine1Py;

    /**
     * JointTag_Spine1_pz
     */
    private Float jointTagSpine1Pz;

    /**
     * JointTag_Spine1_Timestamp
     */
    private LocalDateTime jointTagSpine1Timestamp;

    /**
     * JointTag_Spine2_qx
     */
    private Float jointTagSpine2Qx;

    /**
     * JointTag_Spine2_qy
     */
    private Float jointTagSpine2Qy;

    /**
     * JointTag_Spine2_qz
     */
    private Float jointTagSpine2Qz;

    /**
     * JointTag_Spine2_px
     */
    private Float jointTagSpine2Px;

    /**
     * JointTag_Spine2_py
     */
    private Float jointTagSpine2Py;

    /**
     * JointTag_Spine2_pz
     */
    private Float jointTagSpine2Pz;

    /**
     * JointTag_Spine2_Timestamp
     */
    private LocalDateTime jointTagSpine2Timestamp;

    /**
     * JointTag_Neck_qx
     */
    private Float jointTagNeckQx;

    /**
     * JointTag_Neck_qy
     */
    private Float jointTagNeckQy;

    /**
     * JointTag_Neck_qz
     */
    private Float jointTagNeckQz;

    /**
     * JointTag_Neck_px
     */
    private Float jointTagNeckPx;

    /**
     * JointTag_Neck_py
     */
    private Float jointTagNeckPy;

    /**
     * JointTag_Neck_pz
     */
    private Float jointTagNeckPz;

    /**
     * JointTag_Neck_Timestamp
     */
    private LocalDateTime jointTagNeckTimestamp;

    /**
     * JointTag_Neck1_qx
     */
    private Float jointTagNeck1Qx;

    /**
     * JointTag_Neck1_qy
     */
    private Float jointTagNeck1Qy;

    /**
     * JointTag_Neck1_qz
     */
    private Float jointTagNeck1Qz;

    /**
     * JointTag_Neck1_px
     */
    private Float jointTagNeck1Px;

    /**
     * JointTag_Neck1_py
     */
    private Float jointTagNeck1Py;

    /**
     * JointTag_Neck1_pz
     */
    private Float jointTagNeck1Pz;

    /**
     * JointTag_Neck1_Timestamp
     */
    private LocalDateTime jointTagNeck1Timestamp;

    /**
     * JointTag_Head_qx
     */
    private Float jointTagHeadQx;

    /**
     * JointTag_Head_qy
     */
    private Float jointTagHeadQy;

    /**
     * JointTag_Head_qz
     */
    private Float jointTagHeadQz;

    /**
     * JointTag_Head_px
     */
    private Float jointTagHeadPx;

    /**
     * JointTag_Head_py
     */
    private Float jointTagHeadPy;

    /**
     * JointTag_Head_pz
     */
    private Float jointTagHeadPz;

    /**
     * JointTag_Head_Timestamp
     */
    private LocalDateTime jointTagHeadTimestamp;

    /**
     * JointTag_RightShoulder_qx
     */
    private Float jointTagRightShoulderQx;

    /**
     * JointTag_RightShoulder_qy
     */
    private Float jointTagRightShoulderQy;

    /**
     * JointTag_RightShoulder_qz
     */
    private Float jointTagRightShoulderQz;

    /**
     * JointTag_RightShoulder_px
     */
    private Float jointTagRightShoulderPx;

    /**
     * JointTag_RightShoulder_py
     */
    private Float jointTagRightShoulderPy;

    /**
     * JointTag_RightShoulder_pz
     */
    private Float jointTagRightShoulderPz;

    /**
     * JointTag_RightShoulder_Timestamp
     */
    private LocalDateTime jointTagRightShoulderTimestamp;

    /**
     * JointTag_RightArm_qx
     */
    private Float jointTagRightArmQx;

    /**
     * JointTag_RightArm_qy
     */
    private Float jointTagRightArmQy;

    /**
     * JointTag_RightArm_qz
     */
    private Float jointTagRightArmQz;

    /**
     * JointTag_RightArm_px
     */
    private Float jointTagRightArmPx;

    /**
     * JointTag_RightArm_py
     */
    private Float jointTagRightArmPy;

    /**
     * JointTag_RightArm_pz
     */
    private Float jointTagRightArmPz;

    /**
     * JointTag_RightArm_Timestamp
     */
    private LocalDateTime jointTagRightArmTimestamp;

    /**
     * JointTag_RightForeArm_qx
     */
    private Float jointTagRightForeArmQx;

    /**
     * JointTag_RightForeArm_qy
     */
    private Float jointTagRightForeArmQy;

    /**
     * JointTag_RightForeArm_qz
     */
    private Float jointTagRightForeArmQz;

    /**
     * JointTag_RightForeArm_px
     */
    private Float jointTagRightForeArmPx;

    /**
     * JointTag_RightForeArm_py
     */
    private Float jointTagRightForeArmPy;

    /**
     * JointTag_RightForeArm_pz
     */
    private Float jointTagRightForeArmPz;

    /**
     * JointTag_RightForeArm_Timestamp
     */
    private LocalDateTime jointTagRightForeArmTimestamp;

    /**
     * JointTag_RightHand_qx
     */
    private Float jointTagRightHandQx;

    /**
     * JointTag_RightHand_qy
     */
    private Float jointTagRightHandQy;

    /**
     * JointTag_RightHand_qz
     */
    private Float jointTagRightHandQz;

    /**
     * JointTag_RightHand_px
     */
    private Float jointTagRightHandPx;

    /**
     * JointTag_RightHand_py
     */
    private Float jointTagRightHandPy;

    /**
     * JointTag_RightHand_pz
     */
    private Float jointTagRightHandPz;

    /**
     * JointTag_RightHand_Timestamp
     */
    private LocalDateTime jointTagRightHandTimestamp;

    /**
     * JointTag_RightInHandIndex_qx
     */
    private Float jointTagRightInHandIndexQx;

    /**
     * JointTag_RightInHandIndex_qy
     */
    private Float jointTagRightInHandIndexQy;

    /**
     * JointTag_RightInHandIndex_qz
     */
    private Float jointTagRightInHandIndexQz;

    /**
     * JointTag_RightInHandIndex_px
     */
    private Float jointTagRightInHandIndexPx;

    /**
     * JointTag_RightInHandIndex_py
     */
    private Float jointTagRightInHandIndexPy;

    /**
     * JointTag_RightInHandIndex_pz
     */
    private Float jointTagRightInHandIndexPz;

    /**
     * JointTag_RightInHandIndex_Timestamp
     */
    private LocalDateTime jointTagRightInHandIndexTimestamp;

    /**
     * JointTag_RightInHandMiddle_qx
     */
    private Float jointTagRightInHandMiddleQx;

    /**
     * JointTag_RightInHandMiddle_qy
     */
    private Float jointTagRightInHandMiddleQy;

    /**
     * JointTag_RightInHandMiddle_qz
     */
    private Float jointTagRightInHandMiddleQz;

    /**
     * JointTag_RightInHandMiddle_px
     */
    private Float jointTagRightInHandMiddlePx;

    /**
     * JointTag_RightInHandMiddle_py
     */
    private Float jointTagRightInHandMiddlePy;

    /**
     * JointTag_RightInHandMiddle_pz
     */
    private Float jointTagRightInHandMiddlePz;

    /**
     * JointTag_RightInHandMiddle_Timestamp
     */
    private LocalDateTime jointTagRightInHandMiddleTimestamp;

    /**
     * JointTag_LeftShoulder_qx
     */
    private Float jointTagLeftShoulderQx;

    /**
     * JointTag_LeftShoulder_qy
     */
    private Float jointTagLeftShoulderQy;

    /**
     * JointTag_LeftShoulder_qz
     */
    private Float jointTagLeftShoulderQz;

    /**
     * JointTag_LeftShoulder_px
     */
    private Float jointTagLeftShoulderPx;

    /**
     * JointTag_LeftShoulder_py
     */
    private Float jointTagLeftShoulderPy;

    /**
     * JointTag_LeftShoulder_pz
     */
    private Float jointTagLeftShoulderPz;

    /**
     * JointTag_LeftShoulder_Timestamp
     */
    private LocalDateTime jointTagLeftShoulderTimestamp;

    /**
     * JointTag_LeftArm_qx
     */
    private Float jointTagLeftArmQx;

    /**
     * JointTag_LeftArm_qy
     */
    private Float jointTagLeftArmQy;

    /**
     * JointTag_LeftArm_qz
     */
    private Float jointTagLeftArmQz;

    /**
     * JointTag_LeftArm_px
     */
    private Float jointTagLeftArmPx;

    /**
     * JointTag_LeftArm_py
     */
    private Float jointTagLeftArmPy;

    /**
     * JointTag_LeftArm_pz
     */
    private Float jointTagLeftArmPz;

    /**
     * JointTag_LeftArm_Timestamp
     */
    private LocalDateTime jointTagLeftArmTimestamp;

    /**
     * JointTag_LeftForeArm_qx
     */
    private Float jointTagLeftForeArmQx;

    /**
     * JointTag_LeftForeArm_qy
     */
    private Float jointTagLeftForeArmQy;

    /**
     * JointTag_LeftForeArm_qz
     */
    private Float jointTagLeftForeArmQz;

    /**
     * JointTag_LeftForeArm_px
     */
    private Float jointTagLeftForeArmPx;

    /**
     * JointTag_LeftForeArm_py
     */
    private Float jointTagLeftForeArmPy;

    /**
     * JointTag_LeftForeArm_pz
     */
    private Float jointTagLeftForeArmPz;

    /**
     * JointTag_LeftForeArm_Timestamp
     */
    private LocalDateTime jointTagLeftForeArmTimestamp;

    /**
     * JointTag_LeftHand_qx
     */
    private Float jointTagLeftHandQx;

    /**
     * JointTag_LeftHand_qy
     */
    private Float jointTagLeftHandQy;

    /**
     * JointTag_LeftHand_qz
     */
    private Float jointTagLeftHandQz;

    /**
     * JointTag_LeftHand_px
     */
    private Float jointTagLeftHandPx;

    /**
     * JointTag_LeftHand_py
     */
    private Float jointTagLeftHandPy;

    /**
     * JointTag_LeftHand_pz
     */
    private Float jointTagLeftHandPz;

    /**
     * JointTag_LeftHand_Timestamp
     */
    private LocalDateTime jointTagLeftHandTimestamp;

    /**
     * JointTag_LeftInHandIndex_qx
     */
    private Float jointTagLeftInHandIndexQx;

    /**
     * JointTag_LeftInHandIndex_qy
     */
    private Float jointTagLeftInHandIndexQy;

    /**
     * JointTag_LeftInHandIndex_qz
     */
    private Float jointTagLeftInHandIndexQz;

    /**
     * JointTag_LeftInHandIndex_px
     */
    private Float jointTagLeftInHandIndexPx;

    /**
     * JointTag_LeftInHandIndex_py
     */
    private Float jointTagLeftInHandIndexPy;

    /**
     * JointTag_LeftInHandIndex_pz
     */
    private Float jointTagLeftInHandIndexPz;

    /**
     * JointTag_LeftInHandIndex_Timestamp
     */
    private LocalDateTime jointTagLeftInHandIndexTimestamp;

    /**
     * JointTag_LeftInHandMiddle_qx
     */
    private Float jointTagLeftInHandMiddleQx;

    /**
     * JointTag_LeftInHandMiddle_qy
     */
    private Float jointTagLeftInHandMiddleQy;

    /**
     * JointTag_LeftInHandMiddle_qz
     */
    private Float jointTagLeftInHandMiddleQz;

    /**
     * JointTag_LeftInHandMiddle_px
     */
    private Float jointTagLeftInHandMiddlePx;

    /**
     * JointTag_LeftInHandMiddle_py
     */
    private Float jointTagLeftInHandMiddlePy;

    /**
     * JointTag_LeftInHandMiddle_pz
     */
    private Float jointTagLeftInHandMiddlePz;

    /**
     * JointTag_LeftInHandMiddle_Timestamp
     */
    private LocalDateTime jointTagLeftInHandMiddleTimestamp;
}
