package com.example.edu_datastructure.service;

import com.example.edu_datastructure.pojo.QFill;
import com.example.edu_datastructure.vo.PageBean;

import java.util.List;

/**
 * @Author ljj
 * @Data 2023/3/23 19:49
 * @Version
 */
public interface QFillService {
    PageBean<QFill> queryFill(Integer currentPage, Integer pageSize);

    QFill queryFillById(Integer questionId);

    int updateFillById(QFill qFill, Integer temporaryQuestionId);

    int deleteQuestionById(Integer questionId);

    int addFill(QFill qFill);

    List<Integer> queryByRandom(Integer fillNumber);

    List<QFill> queryPaperByIdAndType(Integer paperId);
}
