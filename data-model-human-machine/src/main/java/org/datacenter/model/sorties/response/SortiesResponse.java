package org.datacenter.model.sorties.response;

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
public class SortiesResponse {
    private String code;
    private List<Sorties> data;
}
