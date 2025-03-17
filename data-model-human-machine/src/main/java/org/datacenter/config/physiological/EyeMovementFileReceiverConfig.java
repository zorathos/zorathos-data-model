package org.datacenter.config.physiological;

import lombok.*;
import org.datacenter.config.BaseReceiverConfig;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EyeMovementFileReceiverConfig  extends BaseReceiverConfig {
    private String url;
}
