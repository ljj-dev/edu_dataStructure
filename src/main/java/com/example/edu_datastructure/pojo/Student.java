package com.example.edu_datastructure.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author ljj
 * @Data 2023/2/10 11:21
 * @Version
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer studentId;
    private String studentName;
    private String studentSex;
    private String studentGrade;
    private Integer classId;
    private List<OjProblem> ojProblemList;

}
