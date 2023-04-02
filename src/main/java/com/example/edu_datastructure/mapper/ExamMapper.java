package com.example.edu_datastructure.mapper;

import com.example.edu_datastructure.pojo.Exam;
import com.example.edu_datastructure.pojo.ExamIssue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author ljj
 * @Data 2023/3/29 18:09
 * @Version
 */
@Repository
public interface ExamMapper {
    List<Exam> queryExam(@Param("begin") int begin, @Param("pageSize") int pageSize);

    int allExamCount();

    int addExam(@Param("examInfo") Exam examInfo);

    Exam queryExamById(@Param("examId") Integer examId);

    int updateExamById(@Param("examId") Integer examId, @Param("updateExamFrom") Exam updateExamFrom);

    int deleteExamById(@Param("examId") Integer examId);

    int issueExamById(@Param("classId") Integer classId, @Param("examId") Integer examId);

    List<ExamIssue> queryIssueExam(@Param("begin") int begin, @Param("pageSize") int pageSize);

    int allIssueExamCount();

    int deleteIssueExamById(@Param("examId") Integer examId, @Param("classId") Integer classId);
}
