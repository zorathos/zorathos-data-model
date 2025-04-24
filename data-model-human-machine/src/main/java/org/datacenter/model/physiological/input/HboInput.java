package org.datacenter.model.physiological.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author wangminan
 * @description 脑痒
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HboInput extends PhysiologicalInputBase{
    private Integer hbo;
}
