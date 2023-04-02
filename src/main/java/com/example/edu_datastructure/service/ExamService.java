package com.example.edu_datastructure.service;

import com.example.edu_datastructure.pojo.Exam;
import com.example.edu_datastructure.pojo.ExamIssue;
import com.example.edu_datastructure.vo.PageBean;

/**
 * @Author ljj
 * @Data 2023/3/29 18:07
 * @Version
 */
public interface ExamService {
    PageBean<Exam> queryExam(Integer currentPage, Integer pageSize);

    int addExam(Exam examInfo);

    Exam queryExamById(Integer examId);

    int updateExamById(Integer examId, Exam updateExamFrom);

    int deleteExamById(Integer examId);

    int issueExamById(Integer classId, Integer examId);

    PageBean<ExamIssue> queryIssueExam(Integer currentPage, Integer pageSize);

    int deleteIssueExamById(Integer examId, Integer classId);
}
