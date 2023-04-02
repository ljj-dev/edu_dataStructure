package com.example.edu_datastructure.service;

import com.example.edu_datastructure.pojo.OjAndStudent;
import com.example.edu_datastructure.pojo.OjProblem;
import com.example.edu_datastructure.vo.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author ljj
 * @Data 2023/3/7 17:52
 * @Version
 */
public interface OjProblemService {
    PageBean<OjProblem> queryAllOjProblem(Integer currentPage, Integer pageSize);

    PageBean<OjAndStudent> queryMyOjProblem(Integer studentId, Integer currentPage, Integer pageSize);

    OjProblem queryProblemById(Integer problemId);

    String queryCodeLog(Integer problemId, Integer studentId);

    int myOjproblemExist(Integer problemId, Integer studentId);

    //修改codeLog
    int updateCodeLog(Integer problemId, Integer studentId, Integer status, String codeLog);

    //插入codeLog
    int saveMyProblem(Integer problemId, Integer studentId, Integer status, String codeLog);

}
