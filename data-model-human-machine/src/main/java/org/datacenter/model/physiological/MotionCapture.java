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
    private float hipsQx;

    /**
     * Hips_qy
     */
    private float hipsQy;

    /**
     * Hips_qz
     */
    private float hipsQz;

    /**
     * Hips_px
     */
    private float hipsPx;

    /**
     * Hips_py
     */
    private float hipsPy;

    /**
     * Hips_pz
     */
    private float hipsPz;

    /**
     * Hips_Timestamp
     */
    private long hipsTimestamp;

    /**
     * JointTag_Spine_qx
     */
    private float jointTagSpineQx;

    /**
     * JointTag_Spine_qy
     */
    private float jointTagSpineQy;

    /**
     * JointTag_Spine_qz
     */
    private float jointTagSpineQz;

    /**
     * JointTag_Spine_px
     */
    private float jointTagSpinePx;

    /**
     * JointTag_Spine_py
     */
    private float jointTagSpinePy;

    /**
     * JointTag_Spine_pz
     */
    private float jointTagSpinePz;

    /**
     * JointTag_Spine_Timestamp
     */
    private long jointTagSpineTimestamp;

    /**
     * JointTag_Spine1_qx
     */
    private float jointTagSpine1Qx;

    /**
     * JointTag_Spine1_qy
     */
    private float jointTagSpine1Qy;

    /**
     * JointTag_Spine1_qz
     */
    private float jointTagSpine1Qz;

    /**
     * JointTag_Spine1_px
     */
    private float jointTagSpine1Px;

    /**
     * JointTag_Spine1_py
     */
    private float jointTagSpine1Py;

    /**
     * JointTag_Spine1_pz
     */
    private float jointTagSpine1Pz;

    /**
     * JointTag_Spine1_Timestamp
     */
    private long jointTagSpine1Timestamp;

    /**
     * JointTag_Spine2_qx
     */
    private float jointTagSpine2Qx;

    /**
     * JointTag_Spine2_qy
     */
    private float jointTagSpine2Qy;

    /**
     * JointTag_Spine2_qz
     */
    private float jointTagSpine2Qz;

    /**
     * JointTag_Spine2_px
     */
    private float jointTagSpine2Px;

    /**
     * JointTag_Spine2_py
     */
    private float jointTagSpine2Py;

    /**
     * JointTag_Spine2_pz
     */
    private float jointTagSpine2Pz;

    /**
     * JointTag_Spine2_Timestamp
     */
    private long jointTagSpine2Timestamp;

    /**
     * JointTag_Neck_qx
     */
    private float jointTagNeckQx;

    /**
     * JointTag_Neck_qy
     */
    private float jointTagNeckQy;

    /**
     * JointTag_Neck_qz
     */
    private float jointTagNeckQz;

    /**
     * JointTag_Neck_px
     */
    private float jointTagNeckPx;

    /**
     * JointTag_Neck_py
     */
    private float jointTagNeckPy;

    /**
     * JointTag_Neck_pz
     */
    private float jointTagNeckPz;

    /**
     * JointTag_Neck_Timestamp
     */
    private long jointTagNeckTimestamp;

    /**
     * JointTag_Neck1_qx
     */
    private float jointTagNeck1Qx;

    /**
     * JointTag_Neck1_qy
     */
    private float jointTagNeck1Qy;

    /**
     * JointTag_Neck1_qz
     */
    private float jointTagNeck1Qz;

    /**
     * JointTag_Neck1_px
     */
    private float jointTagNeck1Px;

    /**
     * JointTag_Neck1_py
     */
    private float jointTagNeck1Py;

    /**
     * JointTag_Neck1_pz
     */
    private float jointTagNeck1Pz;

    /**
     * JointTag_Neck1_Timestamp
     */
    private long jointTagNeck1Timestamp;

    /**
     * JointTag_Head_qx
     */
    private float jointTagHeadQx;

    /**
     * JointTag_Head_qy
     */
    private float jointTagHeadQy;

    /**
     * JointTag_Head_qz
     */
    private float jointTagHeadQz;

    /**
     * JointTag_Head_px
     */
    private float jointTagHeadPx;

    /**
     * JointTag_Head_py
     */
    private float jointTagHeadPy;

    /**
     * JointTag_Head_pz
     */
    private float jointTagHeadPz;

    /**
     * JointTag_Head_Timestamp
     */
    private long jointTagHeadTimestamp;

    /**
     * JointTag_RightShoulder_qx
     */
    private float jointTagRightShoulderQx;

    /**
     * JointTag_RightShoulder_qy
     */
    private float jointTagRightShoulderQy;

    /**
     * JointTag_RightShoulder_qz
     */
    private float jointTagRightShoulderQz;

    /**
     * JointTag_RightShoulder_px
     */
    private float jointTagRightShoulderPx;

    /**
     * JointTag_RightShoulder_py
     */
    private float jointTagRightShoulderPy;

    /**
     * JointTag_RightShoulder_pz
     */
    private float jointTagRightShoulderPz;

    /**
     * JointTag_RightShoulder_Timestamp
     */
    private long jointTagRightShoulderTimestamp;

    /**
     * JointTag_RightArm_qx
     */
    private float jointTagRightArmQx;

    /**
     * JointTag_RightArm_qy
     */
    private float jointTagRightArmQy;

    /**
     * JointTag_RightArm_qz
     */
    private float jointTagRightArmQz;

    /**
     * JointTag_RightArm_px
     */
    private float jointTagRightArmPx;

    /**
     * JointTag_RightArm_py
     */
    private float jointTagRightArmPy;

    /**
     * JointTag_RightArm_pz
     */
    private float jointTagRightArmPz;

    /**
     * JointTag_RightArm_Timestamp
     */
    private long jointTagRightArmTimestamp;

    /**
     * JointTag_RightForeArm_qx
     */
    private float jointTagRightForeArmQx;

    /**
     * JointTag_RightForeArm_qy
     */
    private float jointTagRightForeArmQy;

    /**
     * JointTag_RightForeArm_qz
     */
    private float jointTagRightForeArmQz;

    /**
     * JointTag_RightForeArm_px
     */
    private float jointTagRightForeArmPx;

    /**
     * JointTag_RightForeArm_py
     */
    private float jointTagRightForeArmPy;

    /**
     * JointTag_RightForeArm_pz
     */
    private float jointTagRightForeArmPz;

    /**
     * JointTag_RightForeArm_Timestamp
     */
    private long jointTagRightForeArmTimestamp;

    /**
     * JointTag_RightHand_qx
     */
    private float jointTagRightHandQx;

    /**
     * JointTag_RightHand_qy
     */
    private float jointTagRightHandQy;

    /**
     * JointTag_RightHand_qz
     */
    private float jointTagRightHandQz;

    /**
     * JointTag_RightHand_px
     */
    private float jointTagRightHandPx;

    /**
     * JointTag_RightHand_py
     */
    private float jointTagRightHandPy;

    /**
     * JointTag_RightHand_pz
     */
    private float jointTagRightHandPz;

    /**
     * JointTag_RightHand_Timestamp
     */
    private long jointTagRightHandTimestamp;

    /**
     * JointTag_RightInHandIndex_qx
     */
    private float jointTagRightInHandIndexQx;

    /**
     * JointTag_RightInHandIndex_qy
     */
    private float jointTagRightInHandIndexQy;

    /**
     * JointTag_RightInHandIndex_qz
     */
    private float jointTagRightInHandIndexQz;

    /**
     * JointTag_RightInHandIndex_px
     */
    private float jointTagRightInHandIndexPx;

    /**
     * JointTag_RightInHandIndex_py
     */
    private float jointTagRightInHandIndexPy;

    /**
     * JointTag_RightInHandIndex_pz
     */
    private float jointTagRightInHandIndexPz;

    /**
     * JointTag_RightInHandIndex_Timestamp
     */
    private long jointTagRightInHandIndexTimestamp;

    /**
     * JointTag_RightInHandMiddle_qx
     */
    private float jointTagRightInHandMiddleQx;

    /**
     * JointTag_RightInHandMiddle_qy
     */
    private float jointTagRightInHandMiddleQy;

    /**
     * JointTag_RightInHandMiddle_qz
     */
    private float jointTagRightInHandMiddleQz;

    /**
     * JointTag_RightInHandMiddle_px
     */
    private float jointTagRightInHandMiddlePx;

    /**
     * JointTag_RightInHandMiddle_py
     */
    private float jointTagRightInHandMiddlePy;

    /**
     * JointTag_RightInHandMiddle_pz
     */
    private float jointTagRightInHandMiddlePz;

    /**
     * JointTag_RightInHandMiddle_Timestamp
     */
    private long jointTagRightInHandMiddleTimestamp;

    /**
     * JointTag_LeftShoulder_qx
     */
    private float jointTagLeftShoulderQx;

    /**
     * JointTag_LeftShoulder_qy
     */
    private float jointTagLeftShoulderQy;

    /**
     * JointTag_LeftShoulder_qz
     */
    private float jointTagLeftShoulderQz;

    /**
     * JointTag_LeftShoulder_px
     */
    private float jointTagLeftShoulderPx;

    /**
     * JointTag_LeftShoulder_py
     */
    private float jointTagLeftShoulderPy;

    /**
     * JointTag_LeftShoulder_pz
     */
    private float jointTagLeftShoulderPz;

    /**
     * JointTag_LeftShoulder_Timestamp
     */
    private long jointTagLeftShoulderTimestamp;

    /**
     * JointTag_LeftArm_qx
     */
    private float jointTagLeftArmQx;

    /**
     * JointTag_LeftArm_qy
     */
    private float jointTagLeftArmQy;

    /**
     * JointTag_LeftArm_qz
     */
    private float jointTagLeftArmQz;

    /**
     * JointTag_LeftArm_px
     */
    private float jointTagLeftArmPx;

    /**
     * JointTag_LeftArm_py
     */
    private float jointTagLeftArmPy;

    /**
     * JointTag_LeftArm_pz
     */
    private float jointTagLeftArmPz;

    /**
     * JointTag_LeftArm_Timestamp
     */
    private long jointTagLeftArmTimestamp;

    /**
     * JointTag_LeftForeArm_qx
     */
    private float jointTagLeftForeArmQx;

    /**
     * JointTag_LeftForeArm_qy
     */
    private float jointTagLeftForeArmQy;

    /**
     * JointTag_LeftForeArm_qz
     */
    private float jointTagLeftForeArmQz;

    /**
     * JointTag_LeftForeArm_px
     */
    private float jointTagLeftForeArmPx;

    /**
     * JointTag_LeftForeArm_py
     */
    private float jointTagLeftForeArmPy;

    /**
     * JointTag_LeftForeArm_pz
     */
    private float jointTagLeftForeArmPz;

    /**
     * JointTag_LeftForeArm_Timestamp
     */
    private long jointTagLeftForeArmTimestamp;

    /**
     * JointTag_LeftHand_qx
     */
    private float jointTagLeftHandQx;

    /**
     * JointTag_LeftHand_qy
     */
    private float jointTagLeftHandQy;

    /**
     * JointTag_LeftHand_qz
     */
    private float jointTagLeftHandQz;

    /**
     * JointTag_LeftHand_px
     */
    private float jointTagLeftHandPx;

    /**
     * JointTag_LeftHand_py
     */
    private float jointTagLeftHandPy;

    /**
     * JointTag_LeftHand_pz
     */
    private float jointTagLeftHandPz;

    /**
     * JointTag_LeftHand_Timestamp
     */
    private long jointTagLeftHandTimestamp;

    /**
     * JointTag_LeftInHandIndex_qx
     */
    private float jointTagLeftInHandIndexQx;

    /**
     * JointTag_LeftInHandIndex_qy
     */
    private float jointTagLeftInHandIndexQy;

    /**
     * JointTag_LeftInHandIndex_qz
     */
    private float jointTagLeftInHandIndexQz;

    /**
     * JointTag_LeftInHandIndex_px
     */
    private float jointTagLeftInHandIndexPx;

    /**
     * JointTag_LeftInHandIndex_py
     */
    private float jointTagLeftInHandIndexPy;

    /**
     * JointTag_LeftInHandIndex_pz
     */
    private float jointTagLeftInHandIndexPz;

    /**
     * JointTag_LeftInHandIndex_Timestamp
     */
    private long jointTagLeftInHandIndexTimestamp;

    /**
     * JointTag_LeftInHandMiddle_qx
     */
    private float jointTagLeftInHandMiddleQx;

    /**
     * JointTag_LeftInHandMiddle_qy
     */
    private float jointTagLeftInHandMiddleQy;

    /**
     * JointTag_LeftInHandMiddle_qz
     */
    private float jointTagLeftInHandMiddleQz;

    /**
     * JointTag_LeftInHandMiddle_px
     */
    private float jointTagLeftInHandMiddlePx;

    /**
     * JointTag_LeftInHandMiddle_py
     */
    private float jointTagLeftInHandMiddlePy;

    /**
     * JointTag_LeftInHandMiddle_pz
     */
    private float jointTagLeftInHandMiddlePz;

    /**
     * JointTag_LeftInHandMiddle_Timestamp
     */
    private long jointTagLeftInHandMiddleTimestamp;
}
