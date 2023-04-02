package com.example.edu_datastructure.controller;

import com.example.edu_datastructure.pojo.*;
import com.example.edu_datastructure.pojo.Class;
import com.example.edu_datastructure.service.*;
import com.example.edu_datastructure.utils.Code;
import com.example.edu_datastructure.utils.ResultData;
import com.example.edu_datastructure.vo.PageBean;
import com.example.edu_datastructure.vo.RandomPaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ljj
 * @Data 2023/3/29 18:05
 * @Version
 */
@Controller
@RequestMapping("exam")
public class ExamController {

    @Autowired
    private ExamService examService;

    @Autowired
    private PaperService paperService;

    @Autowired
    private QMultipleService qMultipleService;

    @Autowired
    private QFillService qFillService;

    @Autowired
    private QJudgmentService qJudgmentService;

    @Autowired
    private ScoreService scoreService;

    @RequestMapping("queryExam")
    @ResponseBody
    public ResultData queryExam(Integer currentPage, Integer pageSize) {
        PageBean<Exam> examPageBean = examService.queryExam(currentPage, pageSize);
        Integer code = examPageBean != null ? Code.QUERY_OK : Code.QUERY_ERR;
        String msg = examPageBean != null ? "" : "数据查询失败，请重试!";
        return new ResultData(examPageBean, code, msg);
    }

    @RequestMapping("queryIssueExam")
    @ResponseBody
    public ResultData queryIssueExam(Integer currentPage, Integer pageSize) {
        PageBean<ExamIssue> examIssuePageBean = examService.queryIssueExam(currentPage, pageSize);
        Integer code = examIssuePageBean != null ? Code.QUERY_OK : Code.QUERY_ERR;
        String msg = examIssuePageBean != null ? "" : "数据查询失败，请重试!";
        return new ResultData(examIssuePageBean, code, msg);
    }

    @RequestMapping("queryExamById")
    @ResponseBody
    public ResultData queryExamById(Integer examId) {
        Exam examInfo = examService.queryExamById(examId);
        Integer code = examInfo != null ? Code.QUERY_OK : Code.QUERY_ERR;
        String msg = examInfo != null ? "" : "数据查询失败，请重试!";
        return new ResultData(examInfo, code, msg);
    }

    @RequestMapping("addExam")
    @ResponseBody
    public String addExam(@RequestBody Exam addExamInfo) {
        if (addExamInfo != null) {
            int i = examService.addExam(addExamInfo);
            if (i > 0) {
                return "success";
            } else {
                return "false";
            }
        } else {
            return "false";
        }
    }

    @RequestMapping("updateExamById")
    @ResponseBody
    public String updateExamById(@RequestBody Exam updateExamFrom, Integer examId) {

        int i = examService.updateExamById(examId, updateExamFrom);
        if (i > 0) {
            return "success";
        } else {
            return "false";
        }
    }

    @RequestMapping("deleteExamById")
    @ResponseBody
    public String deleteExamById(Integer examId) {
        int i = examService.deleteExamById(examId);
        if (i > 0) {
            return "success";
        } else {
            return "false";
        }
    }

    //发布考试
    @RequestMapping("issueExamById")
    @ResponseBody
    public String issueExamById(@RequestBody Class selectClass, Integer examId) {
        Integer classId = selectClass.getClassId();
        int i = examService.issueExamById(classId, examId);
        if (i > 0) {
            return "success";
        } else {
            return "false";
        }
    }

    //删除发布的考试
    @RequestMapping("deleteIssueExamById")
    @ResponseBody
    public String deleteIssueExamById(Integer examId, Integer classId) {
        int i = examService.deleteIssueExamById(examId, classId);
        if (i > 0) {
            return "success";
        } else {
            return "false";
        }
    }

    //生成试卷
    @RequestMapping("addPaperExamById")
    @ResponseBody
    public String addPaperExamById(@RequestBody RandomPaper randomPaper) {
        Integer multipleNumber = randomPaper.getMultipleNumber();
        Integer fillNumber = randomPaper.getFillNumber();
        Integer judgeNumber = randomPaper.getJudgeNumber();
        Integer paperId = randomPaper.getPaperId();
//        System.out.println("paperId:" + paperId);
//        System.out.println("multipleNumber:" + multipleNumber);
//        System.out.println("fillNumber:" + fillNumber);
//        System.out.println("judgeNumber:" + judgeNumber);

        // 选择题数据库获取
        List<Integer> multipleIds = qMultipleService.queryByRandom(multipleNumber);
        if (multipleIds == null) {
            return "false";
        }
        for (Integer questionId : multipleIds) {
            PaperManage paperManage = new PaperManage(paperId, questionId, 1);
            int index = paperService.add(paperManage);
            if (index == 0) {
                return "false";
            }
        }

        // 填空题数据库获取
        List<Integer> fillIds = qFillService.queryByRandom(fillNumber);
        if (fillIds == null) {
            return "false";
        }
        for (Integer questionId : fillIds) {
            PaperManage paperManage = new PaperManage(paperId, questionId, 3);
            int index = paperService.add(paperManage);
            if (index == 0) {
                return "false";
            }
        }

        // 判断数据库获取
        List<Integer> judgeIds = qJudgmentService.queryByRandom(judgeNumber);
        if (judgeIds == null) {
            return "false";
        }
        for (Integer questionId : judgeIds) {
            PaperManage paperManage = new PaperManage(paperId, questionId, 2);
            int index = paperService.add(paperManage);
            if (index == 0) {
                return "false";
            }
        }

        return "success";
    }

    @RequestMapping("queryPaperById")
    @ResponseBody
    public Map<Integer, List<?>> queryPaperById(Integer paperId) {
        List<QMultiple> multiQuestionRes = qMultipleService.queryPaperByIdAndType(paperId);   //选择题题库 1
        List<QFill> fillQuestionsRes = qFillService.queryPaperByIdAndType(paperId);     //填空题题库 3
        List<QJudgment> judgeQuestionRes = qJudgmentService.queryPaperByIdAndType(paperId);   //判断题题库 2
        Map<Integer, List<?>> map = new HashMap<>();
        map.put(1, multiQuestionRes);
        map.put(2, fillQuestionsRes);
        map.put(3, judgeQuestionRes);
        return map;
    }

    @RequestMapping("addScore")
    @ResponseBody
    public String addScore(@RequestBody ScoreManage scoreManage, HttpSession session) {
        Student student = (Student) session.getAttribute("student");
        Integer studentId = student.getStudentId();
        scoreManage.setStudentId(studentId);
        int i = scoreService.addScore(scoreManage);
        if (i > 0) {
            return "success";
        } else {
            return "false";
        }
    }
}
