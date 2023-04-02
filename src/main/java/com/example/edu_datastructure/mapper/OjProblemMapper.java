package com.example.edu_datastructure.mapper;

import com.example.edu_datastructure.pojo.OjAndStudent;
import com.example.edu_datastructure.pojo.OjProblem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author ljj
 * @Data 2023/3/7 17:37
 * @Version
 */
@Repository
public interface OjProblemMapper {
    List<OjProblem> queryAllOjProblem(@Param("begin")int begin, @Param("pageSize")int pageSize);

    int allOjProblemCount();

    OjProblem queryProblemById(@Param("problemId") Integer problemId);
}
