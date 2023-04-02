package com.example.edu_datastructure.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author ljj
 * @Data 2023/3/29 14:30
 * @Version
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exam {
    private Integer examId;
    //考试描述
    private String description;
    //试卷编号
    private Integer paperId;
    //考试日期
    private String examDate;
    //考试时长
    private Integer totalTime;
    //年级
    private String grade;
    //学期
    private String term;
    //专业
    private String major;
    //学院
    private String institute;
    //总分
    private Integer totalScore;
    //考试类型
    private String type;
    //考生须知
    private String tips;
}
