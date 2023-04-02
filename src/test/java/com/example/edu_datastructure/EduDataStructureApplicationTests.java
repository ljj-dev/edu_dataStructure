package com.example.edu_datastructure;

import cn.jianwoo.openai.chatgptapi.auth.OpenAiAuth;
import cn.jianwoo.openai.chatgptapi.completions.FastCompletion;
import cn.jianwoo.openai.chatgptapi.exception.ApiException;
import cn.jianwoo.openai.chatgptapi.service.PostApiService;
import cn.jianwoo.openai.chatgptapi.service.impl.ChatGptApiPost;
import com.example.edu_datastructure.pojo.Chapter;
import com.example.edu_datastructure.pojo.OjAndStudent;
import com.example.edu_datastructure.pojo.OjProblem;
import com.example.edu_datastructure.service.ChapterService;
import com.example.edu_datastructure.service.OjProblemService;
import com.example.edu_datastructure.utils.PdfUtil;
import com.example.edu_datastructure.vo.PageBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.List;

@SpringBootTest
class EduDataStructureApplicationTests {
    @Autowired
    ChapterService chapterService;

    @Autowired
    OjProblemService ojProblemService;

    @Test
    void contextLoads() {
//        List<Chapter> chapters = chapterService.queryAllSection();
//        System.out.println(chapters);

        Integer currentPage = 1;
        Integer pageSize = 2;
//        PageBean<OjProblem> ojProblemPageBean = ojProblemService.queryAllOjProblem(currentPage, pageSize);
        Integer studentId = 123456;
        PageBean<OjAndStudent> ojAndStudentPageBean = ojProblemService.queryMyOjProblem(studentId, currentPage, pageSize);
        System.out.println(ojAndStudentPageBean.getRows());
        System.out.println(ojAndStudentPageBean.getTotalCount());

    }


}
