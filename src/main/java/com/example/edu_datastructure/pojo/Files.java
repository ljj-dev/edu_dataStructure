package com.example.edu_datastructure.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author ljj
 * @Data 2023/3/15 9:31
 * @Version
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Files implements Serializable {

    private static final long serialVersionUID=1L;
    /**
     * 文件存储路径
     */
    private String filePath;
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 文件后缀名
     */
    private String fileSuffix;
    /**
     * 文件类型(1资料类型 0作业类型)
     */
    private Integer fileType;
    /**
     * 文件ID
     */
    private Integer fileId;

}
