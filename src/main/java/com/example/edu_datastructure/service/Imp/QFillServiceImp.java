package com.example.edu_datastructure.service.Imp;

import com.example.edu_datastructure.mapper.QFillMapper;
import com.example.edu_datastructure.pojo.QFill;
import com.example.edu_datastructure.service.QFillService;
import com.example.edu_datastructure.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ljj
 * @Data 2023/3/23 19:51
 * @Version
 */
@Service
public class QFillServiceImp implements QFillService {
    @Autowired
    private QFillMapper qFillMapper;
    @Override
    public PageBean<QFill> queryFill(Integer currentPage, Integer pageSize) {
        List<QFill> rows;
        int begin = (currentPage - 1) * pageSize;
        rows = qFillMapper.queryAllFill(begin, pageSize);
        int count = qFillMapper.allFillCount();
        PageBean<QFill> qFillPageBean = new PageBean<>();
        qFillPageBean.setRows(rows);
        qFillPageBean.setTotalCount(count);
        return qFillPageBean;
    }

    @Override
    public QFill queryFillById(Integer questionId) {
        QFill qFill = qFillMapper.queryFillById(questionId);
        return qFill;
    }

    @Override
    public int updateFillById(QFill qFill, Integer questionId) {
        return qFillMapper.updateFillById(qFill, questionId);
    }

    @Override
    public int deleteQuestionById(Integer questionId) {
        return qFillMapper.deleteFillById(questionId);
    }

    @Override
    public int addFill(QFill qFill) {
        return qFillMapper.addFill(qFill);
    }

    @Override
    public List<Integer> queryByRandom(Integer fillNumber) {
        return qFillMapper.queryByRandom(fillNumber);
    }

    @Override
    public List<QFill> queryPaperByIdAndType(Integer paperId) {
        return qFillMapper.queryPaperByIdAndType(paperId);
    }
}
