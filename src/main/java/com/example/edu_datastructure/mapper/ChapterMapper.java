package com.example.edu_datastructure.mapper;

import com.example.edu_datastructure.pojo.Chapter;
import com.example.edu_datastructure.pojo.Section;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author ljj
 * @Data 2023/2/25 18:03
 * @Version
 */
@Repository
public interface ChapterMapper {
    List<Chapter> queryAllSection();

    List<Character> queryAllChapter(@Param("begin")int begin, @Param("pageSize")int pageSize);

    int allChapterCount();

    int deleteChapterById(@Param("chapterId") Integer chapterId);

    int addChapter(@Param("addChapterInfo")Chapter addChapterInfo);

    int deleteByIds(@Param("selectedIds") int[] selectedIds);
}
