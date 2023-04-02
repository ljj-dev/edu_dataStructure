package com.example.edu_datastructure.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ljj
 * @Data 2023/3/30 20:11
 * @Version
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RandomPaper {
    private Integer paperId;

    private Integer multipleNumber;

    private Integer fillNumber;

    private Integer judgeNumber;
}
