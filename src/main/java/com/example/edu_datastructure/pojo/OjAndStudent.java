package com.example.edu_datastructure.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ljj
 * @Data 2023/3/7 17:18
 * @Version
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OjAndStudent extends OjProblem{
//    private OjProblem ojProblem;
    private Student student;
    private String status;
    private String codeLog;
}
