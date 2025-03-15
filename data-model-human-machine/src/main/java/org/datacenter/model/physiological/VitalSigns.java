package org.datacenter.model.physiological;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.datacenter.model.unstructured.UnstructuredFileBase;

/**
 * @author : [wangminan]
 * @description : 心率呼吸血氧指标 二进制的dat文件
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class VitalSigns extends UnstructuredFileBase {
}
