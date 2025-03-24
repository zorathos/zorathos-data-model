package org.datacenter.model.sorties.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.datacenter.model.sorties.SortiesBatch;

import java.util.List;

/**
 * @author : [wangminan]
 * @description : 响应体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SortiesBatchResponse {
    private String code;
    private String message;
    private boolean success;
    private List<SortiesBatch> data;
}
