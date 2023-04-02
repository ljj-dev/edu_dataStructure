package com.example.edu_datastructure.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ljj
 * @Data 2023/4/1 20:24
 * @Version
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreManage {
    private Integer scoreId;
    private Integer examId;
    private Integer studentId;
    private Integer usualScore;
    private Integer finalScore;
    private Integer score;
    private String answerDate;
}
