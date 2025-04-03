package org.datacenter.model.sorties.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class SortiesBatchResponse {
    private String code;
    private String message;
    private boolean success;
    private List<SortiesBatch> data;
}
