package org.datacenter.model.real.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.datacenter.model.real.AssetTableConfig;

import java.util.List;

/**
 * @author : [wangminan]
 * @description : 数据资产表配置
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssetTableConfigResult {
    private Integer code;
    private String msg;
    private List<AssetTableConfig> result;
}
