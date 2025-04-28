package org.datacenter.model.physiological.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.datacenter.model.physiological.PhysiologicalInputBase;

/**
 * @author wangminan
 * @description 脑痒
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HboInput extends PhysiologicalInputBase {
    private Integer deviceId;

    /**
     * 原名: HBO
     * 脑氧饱和度
     */
    @JsonProperty("HBO")
    private Integer hbo;
}
