package com.example.edu_datastructure.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author ljj
 * @Data 2023/2/25 17:46
 * 课程类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chapter {
    private Integer chapterId;
    private String chapterName;
    private Integer sectionNum;
    private List<Section> sectionList;
}
