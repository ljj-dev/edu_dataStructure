package com.example.edu_datastructure.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ljj
 * @Data 2023/2/25 17:53
 * @Version
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Section {
    private Integer sectionId;
    private String sectionUrl;
    private String sectionName;
    private Integer chapterId;
}
