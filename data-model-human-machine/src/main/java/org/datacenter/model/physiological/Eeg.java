package org.datacenter.model.physiological;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.datacenter.model.unstructured.UnstructuredFileBase;

/**
 * @author : [wangminan]
 * @description : 脑电数据 以bdf形式接入
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Eeg extends UnstructuredFileBase {
}
