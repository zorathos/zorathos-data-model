package org.datacenter.model.physiological;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.datacenter.model.unstructured.UnstructuredFileBase;

/**
 * @author : [wangminan]
 * @description : 脑电数据 以bdf形式接入
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Eeg extends UnstructuredFileBase {
}
