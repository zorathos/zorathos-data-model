package org.datacenter.model.physiological.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.datacenter.model.physiological.BasePhysiologicalInput;

import java.io.Serializable;

/**
 * @author : [wangminan]
 * @description : 肢体动作输入类
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class JointPosture extends BasePhysiologicalInput {

    /**
     * 关节名称 每帧插入19个节点数据，详见“三维动捕关节点字段说明”
     */
    @JsonAlias("joint_data")
    private JointName jointName;

    /**
     * 关节X向量 四元数旋转轴在x轴上的投影
     */
    @JsonAlias("qx")
    private Float qx;

    /**
     * 关节Y向量 四元数旋转轴在y轴上的投影
     */
    @JsonAlias("qy")
    private Float qy;

    /**
     * 关节Z向量 四元数旋转轴在z轴上的投影
     */
    @JsonAlias("qz")
    private Float qz;

    /**
     * 关节W向量 四元数旋转轴在w轴上的投影
     */
    @JsonAlias("qw")
    private Float qw;

    /**
     * 关节X坐标
     */
    @JsonAlias("px")
    private Float px;

    /**
     * 关节Y坐标
     */
    @JsonAlias("py")
    private Float py;

    /**
     * 关节Z坐标
     */
    @JsonAlias("pz")
    private Float pz;


    /**
     * 关节名称
     */
    @Getter
    public enum JointName implements Serializable {
        /**
         * 髋部
         */
        Hips,

        /**
         * 脊柱根节点
         */
        Spine,

        /**
         * 脊柱一节点
         */
        Spine1,

        /**
         * 脊柱二节点
         */
        Spine2,

        /**
         * 颈部根节点
         */
        Neck,

        /**
         * 颈部一节点
         */
        Neck1,

        /**
         * 头部节点
         */
        Head,

        /**
         * 右肩节点
         */
        RightShoulder,

        /**
         * 右上臂节点
         */
        RightArm,

        /**
         * 右前臂节点
         */
        RightForeArm,

        /**
         * 右手节点
         */
        RightHand,

        /**
         * 右手中指节点
         */
        RightInHandIndex,

        /**
         * 右手食指节点
         */
        RightInHandMiddle,

        /**
         * 左肩节点
         */
        LeftShoulder,

        /**
         * 左上臂节点
         */
        LeftArm,

        /**
         * 左前臂节点
         */
        LeftForeArm,

        /**
         * 左手节点
         */
        LeftHand,

        /**
         * 左手中指节点
         */
        LeftInHandIndex,

        /**
         * 左手食指节点
         */
        LeftInHandMiddle;

        public static JointName fromString(String name) {
            for (JointName jointName : JointName.values()) {
                if (jointName.name().equalsIgnoreCase(name)) {
                    return jointName;
                }
            }
            throw new IllegalArgumentException("No enum constant " + JointName.class.getCanonicalName() + "." + name);
        }
    }
}
