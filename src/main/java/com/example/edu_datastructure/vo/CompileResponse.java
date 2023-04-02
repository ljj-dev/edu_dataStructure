package com.example.edu_datastructure.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ljj
 * @Data 2023/3/8 12:47
 * @Version
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompileResponse {
    /**
     * 表示是否成功
     */
    private int ok;

    /**
     *失败原因信息
     */
    private String reason;

    private String stdout;
}
