package org.datacenter.model.real;

import java.util.List;

/**
 * @author : [wangminan]
 * @description : 数据资产在Doris中存储的映射
 */
public class AssetBase {

    /**
     * bigint auto_id 主键
     */
    private Long autoId;

    /**
     * varchar(255) 批次号
     */
    private String batchId;

    /**
     * varchar(255) 架次号
     */
    private String sortieId;

    /**
     * code1 code2 ....
     */
    private List<String> codes;
}
