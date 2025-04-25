package org.datacenter.model.physiological.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.datacenter.model.physiological.PhysiologicalInputBase;

/**
 * @author wangminan
 * @description 心理量表数据输入实体，继承 {@link PhysiologicalInputBase}。包含量表种类、打分方式及分项得分等字段。
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PsychologicalScaleInput extends PhysiologicalInputBase {
    /**
     * 原名: YJQD_scale_type
     * 量表种类，JSON 格式
     */
    private String scaleType;

    /**
     * 原名: YJQD_scale_score
     * 量表打分方式，JSON 格式
     */
    private String scaleScore;

    /**
     * 原名: YJQD_scale_sub_scores
     * 分项得分，JSON 格式
     */
    private String scaleSubScores;
}
