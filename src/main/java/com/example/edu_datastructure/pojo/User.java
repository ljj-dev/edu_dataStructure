package com.example.edu_datastructure.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ljj
 * @Data 2023/2/10 11:30
 * @Version
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userName;
    private String password;
    private Integer identity;
    private String keyCord;
}
