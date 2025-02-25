package org.datacenter.model.aggregation;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author : [wangminan]
 */
public class ObjectMapperTest {
    public static void main(String[] args) {
        HeightDesc heightDesc = HeightDesc.builder()
                .heightType(HeightDesc.HeightType.MSL)
                .baseModel(HeightDesc.BaseModel.EGM2008)
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(heightDesc);
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
