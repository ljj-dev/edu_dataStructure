package com.example.edu_datastructure.controller;

import com.example.edu_datastructure.pojo.QFill;
import com.example.edu_datastructure.pojo.QJudgment;
import com.example.edu_datastructure.pojo.QMultiple;
import com.example.edu_datastructure.service.QFillService;
import com.example.edu_datastructure.service.QJudgmentService;
import com.example.edu_datastructure.service.QMultipleService;
import com.example.edu_datastructure.utils.Code;
import com.example.edu_datastructure.utils.ResultData;
import com.example.edu_datastructure.vo.PageBean;
import com.example.edu_datastructure.vo.TopicStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author ljj
 * @Data 2023/3/23 15:49
 * @Version
 */
@Controller
@RequestMapping("question")
public class QuestionController {
    private static Integer temporaryQuestionId = 0;
    @Autowired
    private QMultipleService qMultipleService;

    @Autowired
    private QFillService qFillService;

    @Autowired
    private QJudgmentService qJudgmentService;


    @RequestMapping("queryQuestion")
    @ResponseBody
    public ResultData queryQuestion(Integer questionType, Integer currentPage, Integer pageSize) {
        System.out.println("questionType:" + questionType);
        if (questionType == 1) {
            //查询所有选择题
            PageBean<QMultiple> qMultiplePageBean = qMultipleService.queryMultiple(currentPage, pageSize);
            Integer code = qMultiplePageBean != null ? Code.QUERY_OK : Code.QUERY_ERR;
            String msg = qMultiplePageBean != null ? "" : "数据查询失败，请重试!";
            return new ResultData(qMultiplePageBean, code, msg);
        }

        if (questionType == 2) {
            //查询所有填空题
            PageBean<QFill> qFillPageBean = qFillService.queryFill(currentPage, pageSize);
            Integer code = qFillPageBean != null ? Code.QUERY_OK : Code.QUERY_ERR;
            String msg = qFillPageBean != null ? "" : "数据查询失败，请重试!";
            return new ResultData(qFillPageBean, code, msg);
        }

        if (questionType == 3) {
            //查询所有判断题
            PageBean<QJudgment> qJudgmentPageBean = qJudgmentService.queryJudgment(currentPage, pageSize);
            Integer code = qJudgmentPageBean != null ? Code.QUERY_OK : Code.QUERY_ERR;
            String msg = qJudgmentPageBean != null ? "" : "数据查询失败，请重试!";
            return new ResultData(qJudgmentPageBean, code, msg);
        }
        return new ResultData(null, 0000, "数据查询失败，请重试!");
    }

    @RequestMapping("queryQuestionById")
    @ResponseBody
    public ResultData queryQuestionById(Integer questionType, Integer questionId) {
        temporaryQuestionId = questionId;
        if (questionType == 1) {
            QMultiple qMultiple = qMultipleService.queryMultipleById(questionId);
            Integer code = qMultiple != null ? Code.QUERY_OK : Code.QUERY_ERR;
            String msg = qMultiple != null ? "" : "数据查询失败，请重试!";
            return new ResultData(qMultiple, code, msg);
        }
        if (questionType == 2) {
            QFill qFill = qFillService.queryFillById(questionId);
            Integer code = qFill != null ? Code.QUERY_OK : Code.QUERY_ERR;
            String msg = qFill != null ? "" : "数据查询失败，请重试!";
            return new ResultData(qFill, code, msg);
        }
        if (questionType == 3) {
            QJudgment qJudgment = qJudgmentService.queryFillById(questionId);
            Integer code = qJudgment != null ? Code.QUERY_OK : Code.QUERY_ERR;
            String msg = qJudgment != null ? "" : "数据查询失败，请重试!";
            return new ResultData(qJudgment, code, msg);
        }
        return new ResultData(null, 0000, "数据查询失败，请重试!");
    }

    @RequestMapping("updateQuestionById")
    @ResponseBody
    public String updateQuestionById(@RequestBody TopicStructure topicStructure, Integer questionType) {
        if (questionType == 1) {
            QMultiple qMultiple = new QMultiple(topicStructure.getQuestionId(), topicStructure.getQuestion(), topicStructure.getAnswerA(), topicStructure.getAnswerB(), topicStructure.getAnswerC(), topicStructure.getAnswerD(), topicStructure.getAnswer(), topicStructure.getAnalysis(), topicStructure.getScore(), topicStructure.getChapterId(), topicStructure.getDifficultyLevel());
            int i = qMultipleService.updateMultipleById(qMultiple, temporaryQuestionId);
            if (i > 0) {
                return "success";
            } else {
                return "false";
            }
        }
        if (questionType == 2) {
            QFill qFill = new QFill(topicStructure.getQuestionId(), topicStructure.getQuestion(), topicStructure.getAnswer(), topicStructure.getAnalysis(), topicStructure.getScore(), topicStructure.getChapterId(), topicStructure.getDifficultyLevel());
            int i = qFillService.updateFillById(qFill, temporaryQuestionId);
            if (i > 0) {
                return "success";
            } else {
                return "false";
            }
        }
        if (questionType == 3) {
            QJudgment qJudgment = new QJudgment(topicStructure.getQuestionId(), topicStructure.getQuestion(), topicStructure.getAnswer(), topicStructure.getAnalysis(), topicStructure.getScore(), topicStructure.getChapterId(), topicStructure.getDifficultyLevel());
            int i = qJudgmentService.updateJudgmentById(qJudgment, temporaryQuestionId);
            if (i > 0) {
                return "success";
            } else {
                return "false";
            }
        }
        return "false";
    }

    @RequestMapping("deleteQuestionById")
    @ResponseBody
    public String deleteQuestionById(Integer questionType, Integer questionId) {
        if (questionType == 1) {
            int i = qMultipleService.deleteQuestionById(questionId);
            if (i > 0) {
                return "success";
            } else {
                return "false";
            }
        }
        if (questionType == 2) {
            int i = qFillService.deleteQuestionById(questionId);
            if (i > 0) {
                return "success";
            } else {
                return "false";
            }
        }
        if (questionType == 3) {
            int i = qJudgmentService.deleteQuestionById(questionId);
            if (i > 0) {
                return "success";
            } else {
                return "false";
            }
        }
        return "false";
    }

    @RequestMapping("addMultiple")
    @ResponseBody
    public String addMultiple(@RequestBody QMultiple postMultiple) {
        int i = qMultipleService.addMultiple(postMultiple);
        if (i > 0) {
            return "success";
        } else {
            return "false";
        }
    }

    @RequestMapping("addFill")
    @ResponseBody
    public String addFill(@RequestBody QFill postFill) {
        int i = qFillService.addFill(postFill);
        if (i > 0) {
            return "success";
        } else {
            return "false";
        }
    }

    @RequestMapping("addJudge")
    @ResponseBody
    public String addJudge(@RequestBody QJudgment postJudge) {
        int i = qJudgmentService.addJudge(postJudge);
        if (i > 0) {
            return "success";
        } else {
            return "false";
        }
    }

}
