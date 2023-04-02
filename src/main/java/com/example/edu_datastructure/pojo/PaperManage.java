package com.example.edu_datastructure.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ljj
 * @Data 2023/3/30 21:15
 * @Version
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaperManage {
    private Integer paperId;
    private Integer questionId;
    private Integer questionType;
}