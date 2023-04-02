package com.example.edu_datastructure.service.Imp;

import com.example.edu_datastructure.mapper.ExamMapper;
import com.example.edu_datastructure.pojo.Exam;
import com.example.edu_datastructure.pojo.ExamIssue;
import com.example.edu_datastructure.service.ExamService;
import com.example.edu_datastructure.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ljj
 * @Data 2023/3/29 18:08
 * @Version
 */
@Service
public class ExamServiceImp implements ExamService {
    @Autowired
    private ExamMapper examMapper;

    @Override
    public PageBean<Exam> queryExam(Integer currentPage, Integer pageSize) {
        List<Exam> rows;
        int begin = (currentPage - 1) * pageSize;
        rows = examMapper.queryExam(begin, pageSize);
        int count = examMapper.allExamCount();
        PageBean<Exam> examPageBean = new PageBean<>();
        examPageBean.setRows(rows);
        examPageBean.setTotalCount(count);
        return examPageBean;
    }

    @Override
    public int addExam(Exam examInfo) {
        return examMapper.addExam(examInfo);
    }

    @Override
    public Exam queryExamById(Integer examId) {
        Exam exam = examMapper.queryExamById(examId);
        return exam;
    }

    @Override
    public int updateExamById(Integer examId, Exam updateExamFrom) {
        return examMapper.updateExamById(examId, updateExamFrom);
    }

    @Override
    public int deleteExamById(Integer examId) {
        return examMapper.deleteExamById(examId);
    }

    @Override
    public int issueExamById(Integer classId, Integer examId) {
        return examMapper.issueExamById(classId, examId);
    }

    @Override
    public PageBean<ExamIssue> queryIssueExam(Integer currentPage, Integer pageSize) {
        List<ExamIssue> rows;
        int begin = (currentPage - 1) * pageSize;
        rows = examMapper.queryIssueExam(begin, pageSize);
        int count = examMapper.allIssueExamCount();
        PageBean<ExamIssue> examIssuePageBean = new PageBean<>();
        examIssuePageBean.setRows(rows);
        examIssuePageBean.setTotalCount(count);
        return examIssuePageBean;
    }

    @Override
    public int deleteIssueExamById(Integer examId, Integer classId) {
        return examMapper.deleteIssueExamById(examId, classId);
    }
}
