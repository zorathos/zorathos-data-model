package org.datacenter.model.sorties.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.datacenter.model.sorties.Sorties;

import java.util.List;

/**
 * @author : [wangminan]
 * @description : 架次响应
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class SortiesResponse {
    private String code;
    private List<Sorties> data;
    private String message;
    private Boolean success;
}
