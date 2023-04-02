package com.example.edu_datastructure.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author ljj
 * @Data 2023/3/7 11:11
 * @Version
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OjProblem {
    private Integer problemId;

    private String title;

    private String level;

    private String description;

    private String templateCode;

    private String testCode;
    private List<Student> students;
}
