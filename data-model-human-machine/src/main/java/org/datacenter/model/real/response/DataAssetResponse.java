package org.datacenter.model.real.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.datacenter.model.real.AssetSummary;

import java.util.List;

/**
 * @author : [wangminan]
 * @description : 数据资产响应体
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataAssetResponse {
    private Integer code;
    private String msg;
    private List<AssetSummary> result;
}
