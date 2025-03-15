package org.datacenter.model.unstructured;

import lombok.Data;

/**
 * @author : [wangminan]
 * @description : 非结构化数据 抽象类
 */
@Data
public abstract class UnstructuredFileBase {

    /**
     * 文件名
     */
    protected String fileName;

    /**
     * 文件URL
     */
    protected String filePath;
}
