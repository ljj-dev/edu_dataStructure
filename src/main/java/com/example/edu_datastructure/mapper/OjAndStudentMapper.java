package com.example.edu_datastructure.mapper;

import com.example.edu_datastructure.pojo.OjAndStudent;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author ljj
 * @Data 2023/3/10 13:46
 * @Version
 */
@Repository
public interface OjAndStudentMapper {
    List<OjAndStudent> queryMyOjProblem(@Param("studentId") Integer studentId, @Param("begin")int begin, @Param("pageSize")int pageSize);

    int myOjProblemCount(@Param("studentId") Integer studentId);

    String  queryCodeLog(@Param("problemId") Integer problemId, @Param("studentId") Integer studentId);

    int myOjproblemExist(@Param("problemId") Integer problemId, @Param("studentId") Integer studentId);

    int updateCodeLog(@Param("problemId") Integer problemId, @Param("studentId") Integer studentId, @Param("status") Integer status, @Param("codeLog") String codeLog);

    int saveMyProblem(@Param("problemId") Integer problemId, @Param("studentId") Integer studentId, @Param("status") Integer status, @Param("codeLog") String codeLog);
}
