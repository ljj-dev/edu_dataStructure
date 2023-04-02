package com.example.edu_datastructure.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ljj
 * @Data 2023/3/8 12:45
 * @Version
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompileRequest {
    /**
     * 表示题目id
     */
    private int id;

    /**
     * 表示用户提交的代码
     */
    private String code;
}
