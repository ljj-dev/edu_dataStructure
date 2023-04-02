package com.example.edu_datastructure.service.Imp;

import com.example.edu_datastructure.mapper.QMultipleMapper;
import com.example.edu_datastructure.pojo.QMultiple;
import com.example.edu_datastructure.service.QMultipleService;
import com.example.edu_datastructure.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ljj
 * @Data 2023/3/23 15:52
 * @Version
 */
@Service
public class QMultipleServiceImp implements QMultipleService {
    @Autowired
    private QMultipleMapper qMultipleMapper;

    @Override
    public PageBean<QMultiple> queryMultiple(Integer currentPage, Integer pageSize) {
        List<QMultiple> rows;
        int begin = (currentPage - 1) * pageSize;
        rows = qMultipleMapper.queryAllMultiple(begin, pageSize);
        int count = qMultipleMapper.allMultipleCount();
        PageBean<QMultiple> qMultiplePageBean = new PageBean<>();
        qMultiplePageBean.setRows(rows);
        qMultiplePageBean.setTotalCount(count);
        return qMultiplePageBean;
    }

    @Override
    public QMultiple queryMultipleById(Integer questionId) {
        QMultiple qMultiple = qMultipleMapper.queryMultipleById(questionId);
        return qMultiple;
    }

    @Override
    public int updateMultipleById(QMultiple qMultiple, Integer questionId) {
        return qMultipleMapper.updateMultipleById(qMultiple, questionId);
    }

    @Override
    public int deleteQuestionById(Integer questionId) {
        return qMultipleMapper.deleteMultipleById(questionId);
    }

    @Override
    public int addMultiple(QMultiple qMultiple) {
        return qMultipleMapper.addMultiple(qMultiple);
    }

    @Override
    public List<Integer> queryByRandom(Integer multipleNumber) {
        return qMultipleMapper.queryByRandom(multipleNumber);
    }

    @Override
    public List<QMultiple> queryPaperByIdAndType(Integer paperId) {
        return qMultipleMapper.queryPaperByIdAndType(paperId);
    }
}
