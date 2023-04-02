package com.example.edu_datastructure.service;

import com.example.edu_datastructure.pojo.QJudgment;
import com.example.edu_datastructure.vo.PageBean;

import java.util.List;

/**
 * @Author ljj
 * @Data 2023/3/23 19:49
 * @Version
 */
public interface QJudgmentService {
    PageBean<QJudgment> queryJudgment(Integer currentPage, Integer pageSize);

    QJudgment queryFillById(Integer questionId);

    int updateJudgmentById(QJudgment qJudgment, Integer questionId);

    int deleteQuestionById(Integer questionId);

    int addJudge(QJudgment qJudgment);

    List<Integer> queryByRandom(Integer judgeNumber);

    List<QJudgment> queryPaperByIdAndType(Integer paperId);
}
