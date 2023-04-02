package com.example.edu_datastructure.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ljj
 * @Data 2023/3/23 10:17
 * 选择题
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QMultiple {
    private Integer questionId;
    private String question;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String answer;
    private String analysis;
    private Integer score;
    private Integer chapterId;
    private String difficultyLevel;
}
