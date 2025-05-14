package org.datacenter.config.receiver.physiological;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.datacenter.config.receiver.BaseReceiverConfig;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhysiologicalFileReceiverConfig extends BaseReceiverConfig {
    /**
     * 接入ID
     */
    private Long importId;
    private String url;

    @Override
    public boolean validate() {
        return !url.isEmpty();
    }
}
