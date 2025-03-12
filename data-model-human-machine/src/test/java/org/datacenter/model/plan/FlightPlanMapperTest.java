package org.datacenter.model.plan;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

/**
 * @author : [wangminan]
 * @description : 测试XML Mapper
 */
public class FlightPlanMapperTest {
    public static void main(String[] args) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        File file = new File("d:\\0_大学\\2024.9\\实验室\\数据中台\\数据模型\\0_业务和武器_定\\3.10-数据模型\\4_人员档案及飞行计划\\飞行计划样例数据.xml");

        // 解析XML文件
        FlightPlanRoot root = xmlMapper.readValue(file, FlightPlanRoot.class);

        System.out.println(root);
    }
}
