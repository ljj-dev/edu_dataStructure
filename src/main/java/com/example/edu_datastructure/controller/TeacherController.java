package com.example.edu_datastructure.controller;

import com.example.edu_datastructure.pojo.Chapter;
import com.example.edu_datastructure.pojo.Section;
import com.example.edu_datastructure.pojo.Student;
import com.example.edu_datastructure.service.ChapterService;
import com.example.edu_datastructure.service.ClassService;
import com.example.edu_datastructure.service.StudentService;
import com.example.edu_datastructure.service.TeacherService;
import com.example.edu_datastructure.utils.Code;
import com.example.edu_datastructure.utils.ResponseResult;
import com.example.edu_datastructure.utils.ResultData;
import com.example.edu_datastructure.utils.UploadFileUtil;
import com.example.edu_datastructure.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author ljj
 * @Data 2023/3/15 15:34
 * @Version
 */
@Controller
@RequestMapping("teacher")
public class TeacherController {
    private static String fileUrlName = "";
    private static Integer temporaryStudentId = 0;


    @Autowired
    private TeacherService teacherService;

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private UploadFileUtil uploadFileUtil;

    @Autowired
    private ClassService classService;

    @Autowired
    private StudentService studentService;

    @RequestMapping({"{url}.html", "{url}"})
    public String teacher(@PathVariable("url") String url) {
        System.out.println(url);
        return "teacher/" + url;
    }

    @RequestMapping("/logout")
    public String loginOut(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @RequestMapping("queryAllChapter")
    @ResponseBody
    public ResultData queryAllChapter(Integer currentPage, Integer pageSize) {
        PageBean<Character> characterPageBean = chapterService.queryAllChapter(currentPage, pageSize);
        Integer code = characterPageBean != null ? Code.QUERY_OK : Code.QUERY_ERR;
        String msg = characterPageBean != null ? "" : "数据查询失败，请重试!";
        return new ResultData(characterPageBean, code, msg);
    }

    @RequestMapping("querySectionById")
    @ResponseBody
    public ResultData querySectionById(Integer chapterId) {
        List<Section> sections = chapterService.querySectionById(chapterId);
        Integer code = sections != null ? Code.QUERY_OK : Code.QUERY_ERR;
        String msg = sections != null ? "" : "数据查询失败，请重试!";
        System.out.println("sections:" + sections);
        return new ResultData(sections, code, msg);
    }

    @RequestMapping("addChapter")
    @ResponseBody
    public String addChapter(@RequestBody Chapter addChapterInfo) {
        int i = chapterService.addChapter(addChapterInfo);
        if (i > 0) {
            return "success";
        }
        return "false";
    }

    @RequestMapping("deleteChapterById")
    @ResponseBody
    public String deleteChapterById(Integer chapterId) {
        int i = chapterService.deleteChapterById(chapterId);
        if (i > 0) {
            return "success";
        }
        return "false";
    }

    @RequestMapping("deleteByIds")
    @ResponseBody
    public String deleteByIds(@RequestBody int[] selectedIds) {
        int i = chapterService.deleteByIds(selectedIds);
        if (i > 0) {
            return "success";
        }
        return "false";
    }

    @RequestMapping("addSection")
    @ResponseBody
    public String addSection(@RequestBody Section sectionInfo) {
        if (fileUrlName.equals("")){
            return "null";
        }
        sectionInfo.setSectionUrl(fileUrlName);
        int i = chapterService.addSection(sectionInfo);
        if (i > 0) {
            return "success";
        }
        return "false";
    }

    @RequestMapping("/uploadFile")
    @ResponseBody
    public String uploadFile(@RequestParam MultipartFile fileSection) {
        // 获取文件的名称
        String filename = fileSection.getOriginalFilename();

        fileUrlName = filename;
        return uploadFileUtil.uploadFile(fileSection);
    }

    @RequestMapping("queryAllClass")
    @ResponseBody
    public ResultData queryAllClass(Integer currentPage, Integer pageSize){
        PageBean<Class> classPageBean = classService.queryAllClass(currentPage, pageSize);
        Integer code = classPageBean != null ? Code.QUERY_OK : Code.QUERY_ERR;
        String msg = classPageBean != null ? "" : "数据查询失败，请重试!";
        return new ResultData(classPageBean, code, msg);
    }

    @RequestMapping("addClass")
    @ResponseBody
    public String addClass(@RequestBody Class addClassInfo) {
        int i = classService.addClass(addClassInfo);
        if (i > 0) {
            return "success";
        }
        return "false";
    }

    @RequestMapping("queryStudentByClassId")
    @ResponseBody
    public ResultData queryStudentByClassId(Integer classId){
        List<Student> students = studentService.queryStudentByClassId(classId);
        Integer code = students != null ? Code.QUERY_OK : Code.QUERY_ERR;
        String msg = students != null ? "" : "数据查询失败，请重试!";
        return new ResultData(students, code, msg);
    }

    @RequestMapping("deleteClassById")
    @ResponseBody
    public String deleteClassById(Integer classId) {
        int i = classService.deleteClassById(classId);
        if (i > 0) {
            return "success";
        }
        return "false";
    }

    @RequestMapping("deleteStudentToClassById")
    @ResponseBody
    public String deleteStudentToClassById(Integer studentId) {
        int i = studentService.updateMyClass(studentId, null);
        if (i > 0) {
            return "success";
        }
        return "false";
    }

    @RequestMapping("deleteByClassIds")
    @ResponseBody
    public String deleteByClassIds(@RequestBody int[] selectedIds) {
        int i = classService.deleteByClassIds(selectedIds);
        if (i > 0) {
            return "success";
        }
        return "false";
    }

    @RequestMapping("queryAllStudent")
    @ResponseBody
    public ResultData queryAllStudent(Integer currentPage, Integer pageSize){
        PageBean<Student> studentPageBean = studentService.queryAllStudent(currentPage, pageSize);
        Integer code = studentPageBean != null ? Code.QUERY_OK : Code.QUERY_ERR;
        String msg = studentPageBean != null ? "" : "数据查询失败，请重试!";
        return new ResultData(studentPageBean, code, msg);
    }

    @RequestMapping("queryStudentById")
    @ResponseBody
    public ResultData queryStudentById(Integer studentId){
        temporaryStudentId = studentId;
        Student studentInfo = studentService.queryStudentById(studentId);
        Integer code = studentInfo != null ? Code.QUERY_OK : Code.QUERY_ERR;
        String msg = studentInfo != null ? "" : "数据查询失败，请重试!";
        return new ResultData(studentInfo, code, msg);
    }

    @RequestMapping("updateStudentById")
    @ResponseBody
    public String updateStudentById(@RequestBody Student infoForm) {
        System.out.println("infoForm:" + infoForm);
        if (temporaryStudentId!=0){
            int i = studentService.updateStudentById(infoForm, temporaryStudentId);
            if (i > 0) {
                return "success";
            } else {
                return "false";
            }
        }else {
            return "false";
        }
    }

    @RequestMapping("deleteStudentById")
    @ResponseBody
    public String deleteStudentById(Integer studentId) {
        int i = studentService.deleteStudentById(studentId);
        if (i > 0) {
            return "success";
        }
        return "false";
    }

}
