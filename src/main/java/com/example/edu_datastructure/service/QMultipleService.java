package com.example.edu_datastructure.service;

import com.example.edu_datastructure.pojo.QMultiple;
import com.example.edu_datastructure.vo.PageBean;

import java.util.List;

/**
 * @Author ljj
 * @Data 2023/3/23 15:52
 * @Version
 */
public interface QMultipleService {

    PageBean<QMultiple> queryMultiple(Integer currentPage, Integer pageSize);

    QMultiple queryMultipleById(Integer questionId);

    int updateMultipleById(QMultiple qMultiple, Integer questionId);

    int deleteQuestionById(Integer questionId);

    int addMultiple(QMultiple qMultiple);

    List<Integer> queryByRandom(Integer multipleNumber);

    List<QMultiple> queryPaperByIdAndType(Integer paperId);
}
