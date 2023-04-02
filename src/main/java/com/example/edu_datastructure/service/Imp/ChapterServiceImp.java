package com.example.edu_datastructure.service.Imp;

import com.example.edu_datastructure.mapper.ChapterMapper;
import com.example.edu_datastructure.mapper.SectionMapper;
import com.example.edu_datastructure.pojo.Chapter;
import com.example.edu_datastructure.pojo.Section;
import com.example.edu_datastructure.service.ChapterService;
import com.example.edu_datastructure.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ljj
 * @Data 2023/2/25 19:09
 * @Version
 */
@Service
public class ChapterServiceImp implements ChapterService {
    @Autowired
    private ChapterMapper chapterMapper;

    @Autowired
    private SectionMapper sectionMapper;

    @Override
    public List<Chapter> queryAllSection() {
        List<Chapter> chapters = chapterMapper.queryAllSection();
        return chapters;
    }

    @Override
    public List<Section> querySectionById(Integer chapterId) {
        List<Section> sections = sectionMapper.querySectionById(chapterId);
        return sections;
    }

    @Override
    public int addChapter(Chapter addChapterInfo) {
        return chapterMapper.addChapter(addChapterInfo);
    }

    @Override
    public int deleteByIds(int[] selectedIds) {
        return chapterMapper.deleteByIds(selectedIds);
    }

    @Override
    public int addSection(Section sectionInfo) {
        return sectionMapper.addSection(sectionInfo);
    }


    @Override
    public PageBean<Character> queryAllChapter(Integer currentPage, Integer pageSize) {
        List<Character> rows;
        int begin = (currentPage - 1) * pageSize;
        rows = chapterMapper.queryAllChapter(begin, pageSize);
        int count = chapterMapper.allChapterCount();
        PageBean<Character> characterPageBean = new PageBean<>();
        characterPageBean.setRows(rows);
        characterPageBean.setTotalCount(count);
        return characterPageBean;
    }

    @Override
    public int deleteChapterById(Integer chapterId) {
        return chapterMapper.deleteChapterById(chapterId);
    }


}
