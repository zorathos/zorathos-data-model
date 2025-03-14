package org.datacenter.model.physiological;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.datacenter.model.unstructured.UnstructuredFileBase;

/**
 * @author : [wangminan]
 * @description : 三维动捕 bvh文件格式接入
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MotionCapture extends UnstructuredFileBase {
}
