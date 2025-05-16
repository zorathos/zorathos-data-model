package org.datacenter.model.physiological.input;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.datacenter.model.physiological.BasePhysiologicalInput;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author : [wangminan]
 * @description : 肢体动作输入类
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(callSuper = true)
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

    public static void main(String[] args) throws JsonProcessingException {
        JointPosture posture = JointPosture.builder()
                .px(Float.parseFloat("0.1"))
                .py(Float.parseFloat("0.2"))
                .pz(Float.parseFloat("0.3"))
                .qx(Float.parseFloat("0.4"))
                .qy(Float.parseFloat("0.5"))
                .qz(Float.parseFloat("0.6"))
                .qw(Float.parseFloat("0.7"))
                .deviceId(1L)
                .jointName(JointName.Hips)
                .pilotId(1L)
                .importId(1L)
                .taskId(1L)
                .timestamp(LocalDateTime.parse("2025-05-15T12:00:00.000001"))
                .build();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(posture));

        String jointJson = """
                [{
                  "taskId" : 1,
                  "deviceId" : 1,
                  "pilotId" : 1,
                  "timestamp" : "2025-05-15 12:00:00.000001",
                  "jointName" : "Hips",
                  "qx" : 0.4,
                  "qy" : 0.5,
                  "qz" : 0.6,
                  "qw" : 0.7,
                  "px" : 0.1,
                  "py" : 0.2,
                  "pz" : 0.3
                },
                {
                  "taskId" : 1,
                  "deviceId" : 1,
                  "pilotId" : 1,
                  "timestamp" : "2025-05-15 12:00:00.000001",
                  "jointName" : "LeftHand",
                  "qx" : 0.4,
                  "qy" : 0.5,
                  "qz" : 0.6,
                  "qw" : 0.7,
                  "px" : 0.1,
                  "py" : 0.2,
                  "pz" : 0.3
                }]
                """;
        // 读一个List<JointPosture>对象
        List<JointPosture> jointPostures = mapper.readValue(jointJson,
                mapper.getTypeFactory().constructCollectionType(List.class, JointPosture.class));
        System.out.println(jointPostures);
    }
}
