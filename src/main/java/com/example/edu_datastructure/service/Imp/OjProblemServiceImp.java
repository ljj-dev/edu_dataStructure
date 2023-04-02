package com.example.edu_datastructure.service.Imp;

import com.example.edu_datastructure.mapper.OjAndStudentMapper;
import com.example.edu_datastructure.mapper.OjProblemMapper;
import com.example.edu_datastructure.pojo.OjAndStudent;
import com.example.edu_datastructure.pojo.OjProblem;
import com.example.edu_datastructure.service.OjProblemService;
import com.example.edu_datastructure.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ljj
 * @Data 2023/3/7 18:47
 * @Version
 */
@Service
public class OjProblemServiceImp implements OjProblemService {
    @Autowired
    private OjProblemMapper ojProblemMapper;

    @Autowired
    private OjAndStudentMapper ojAndStudentMapper;

    @Override
    public PageBean<OjProblem> queryAllOjProblem(Integer currentPage, Integer pageSize) {
        List<OjProblem> rows;
        int begin = (currentPage - 1) * pageSize;
        rows = ojProblemMapper.queryAllOjProblem(begin,pageSize);
        int count = ojProblemMapper.allOjProblemCount();

        PageBean<OjProblem> ojProblemPageBean = new PageBean<>();
        ojProblemPageBean.setRows(rows);
        ojProblemPageBean.setTotalCount(count);
        return ojProblemPageBean;
    }

    @Override
    public PageBean<OjAndStudent> queryMyOjProblem(Integer studentId, Integer currentPage, Integer pageSize) {
        List<OjAndStudent> rows;
        int begin = (currentPage - 1) * pageSize;
        rows = ojAndStudentMapper.queryMyOjProblem(studentId, begin, pageSize);
        int count = ojAndStudentMapper.myOjProblemCount(studentId);

        PageBean<OjAndStudent> ojProblemPageBean = new PageBean<>();
        ojProblemPageBean.setRows(rows);
        ojProblemPageBean.setTotalCount(count);
        return ojProblemPageBean;
    }

    @Override
    public OjProblem queryProblemById(Integer problemId) {
        OjProblem ojProblem = ojProblemMapper.queryProblemById(problemId);
        return ojProblem;
    }

    @Override
    public String queryCodeLog(Integer problemId, Integer studentId) {
        String ojAndStudent = ojAndStudentMapper.queryCodeLog(problemId, studentId);
        return ojAndStudent;
    }

    @Override
    public int myOjproblemExist(Integer problemId, Integer studentId) {
        return ojAndStudentMapper.myOjproblemExist(problemId, studentId);
    }

    @Override
    public int updateCodeLog(Integer problemId, Integer studentId, Integer status, String codeLog) {
        return ojAndStudentMapper.updateCodeLog(problemId, studentId, status,codeLog);
    }

    @Override
    public int saveMyProblem(Integer problemId, Integer studentId, Integer status, String codeLog) {
        return ojAndStudentMapper.saveMyProblem(problemId, studentId, status, codeLog);
    }
}
