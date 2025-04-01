package org.datacenter.config.physiological;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.datacenter.config.BaseReceiverConfig;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhysiologicalFileReceiverConfig extends BaseReceiverConfig {
    private String url;

    @Override
    public boolean validate() {
        return !url.isEmpty();
    }
}
