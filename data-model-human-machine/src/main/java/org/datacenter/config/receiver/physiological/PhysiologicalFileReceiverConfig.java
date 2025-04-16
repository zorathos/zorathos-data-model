package org.datacenter.config.receiver.physiological;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.datacenter.config.BaseReceiverAndAgentConfig;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhysiologicalFileReceiverConfig extends BaseReceiverAndAgentConfig {
    private String url;

    @Override
    public boolean validate() {
        return !url.isEmpty();
    }
}
