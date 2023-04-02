package com.example.edu_datastructure.service.Imp;

import com.example.edu_datastructure.mapper.QJudgmentMapper;
import com.example.edu_datastructure.pojo.QJudgment;
import com.example.edu_datastructure.service.QJudgmentService;
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
public class QJudgmentServiceImp implements QJudgmentService {
    @Autowired
    private QJudgmentMapper qJudgmentMapper;
    @Override
    public PageBean<QJudgment> queryJudgment(Integer currentPage, Integer pageSize) {
        List<QJudgment> rows;
        int begin = (currentPage - 1) * pageSize;
        rows = qJudgmentMapper.queryAllJudgment(begin, pageSize);
        int count = qJudgmentMapper.allJudgmentCount();
        PageBean<QJudgment> qJudgmentPageBean = new PageBean<>();
        qJudgmentPageBean.setRows(rows);
        qJudgmentPageBean.setTotalCount(count);
        return qJudgmentPageBean;
    }

    @Override
    public QJudgment queryFillById(Integer questionId) {
        QJudgment qJudgment = qJudgmentMapper.queryJudgmentById(questionId);
        return qJudgment;
    }

    @Override
    public int updateJudgmentById(QJudgment qJudgment, Integer questionId) {
        return qJudgmentMapper.updateJudgmentById(qJudgment, questionId);
    }

    @Override
    public int deleteQuestionById(Integer questionId) {
        return qJudgmentMapper.deleteJudgmentById(questionId);
    }

    @Override
    public int addJudge(QJudgment qJudgment) {
        return qJudgmentMapper.addJudgment(qJudgment);
    }

    @Override
    public List<Integer> queryByRandom(Integer judgeNumber) {
        return qJudgmentMapper.queryByRandom(judgeNumber);
    }

    @Override
    public List<QJudgment> queryPaperByIdAndType(Integer paperId) {
        return qJudgmentMapper.queryPaperByIdAndType(paperId);
    }
}
