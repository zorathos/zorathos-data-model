package org.datacenter.model.real;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : [wangminan]
 * @description : 资产表配置
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssetTableConfig {
    private AssetTableModel assetModel;
    private List<AssetTableProperty> propertyList;
}
