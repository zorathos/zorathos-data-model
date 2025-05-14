package org.datacenter.model.aggregation.sensor;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

/**
 * @author wangminan
 * @description 遥测设备运营商信息
 */
@Data
@Builder
public class SensorOperatorInfo {

    /**
     * 如为国内企业，须使用统一社会信用代码
     * 如为国外企业，可采用邓白氏编码或其他国际企业唯一标识码，或SILAS专门分配的唯一标识码
     * 格式:18位以内文本字符
     * 默认值给西工大的统一社会信用代码
     */
    @Builder.Default
    private String entityID = "12100000435231705W";
    /**
     * 运营商名称
     */
    @Builder.Default
    private String entityName = "西北工业大学";
    /**
     * 运营商类型
     */
    @Builder.Default
    private EntityType entityType = EntityType.PublicInst;
    /**
     * 运营商电话 区号电话号码
     */
    private String phone;

    @Getter
    public enum EntityType {
        /**
         * 盈利法人
         */
        @JsonAlias("For-profitLegalPerson")
        ForProfit,
        /**
         * 事业单位
         */
        PublicInst,
        /**
         * 社会团体
         */
        SocialOrg,
        /**
         * 基金会
         */
        Foundation,
        /**
         * 社会服务机构
         */
        SocialServiceOrg,
        /**
         * 机关法人
         */
        GovLegalPerson,
        /**
         * 农村集体经济组织法人
         */
        RuralCollectiveEconomicOrgLegalPerson,
        /**
         * 城镇农村合作经济组织法人
         */
        UrbanAndRuralCoopEconomicOrgLegalPerson,
        /**
         * 基层群众性自治组织法人
         */
        @JsonAlias("Community-LevelSelf-GevOrgLegalPerson")
        CommunityLevelSelfGevOrgLegalPerson,
        /**
         * 国内无人机生产厂商
         */
        DomesticUAVManufacturer,
        /**
         * 其他
         */
        Other;

        public static EntityType fromString(String value) {
            for (EntityType entityType : EntityType.values()) {
                if (entityType.name().equalsIgnoreCase(value)) {
                    return entityType;
                }
            }
            return null;
        }
    }
}
