package com.example.edu_datastructure.service;

import com.example.edu_datastructure.pojo.Chapter;
import com.example.edu_datastructure.pojo.OjProblem;
import com.example.edu_datastructure.pojo.Section;
import com.example.edu_datastructure.vo.PageBean;

import java.util.List;

/**
 * @Author ljj
 * @Data 2023/2/25 19:09
 * @Version
 */
public interface ChapterService {
    List<Chapter> queryAllSection();

    PageBean<Character> queryAllChapter(Integer currentPage, Integer pageSize);

    int deleteChapterById(Integer chapterId);

    List<Section> querySectionById(Integer chapterId);

    int addChapter(Chapter addChapterInfo);

    int deleteByIds(int[] selectedIds);

    int addSection(Section sectionInfo);

}
