package com.example.edu_datastructure.mapper;

import com.example.edu_datastructure.pojo.Section;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author ljj
 * @Data 2023/2/25 18:10
 * @Version
 */
@Repository
public interface SectionMapper {
    List<Section> querySectionById(@Param("chapterId") Integer chapterId);

    int addSection(@Param("sectionInfo") Section sectionInfo);
}
