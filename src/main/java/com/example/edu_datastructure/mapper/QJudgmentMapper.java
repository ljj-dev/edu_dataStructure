package com.example.edu_datastructure.mapper;

import com.example.edu_datastructure.pojo.QJudgment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author ljj
 * @Data 2023/3/23 14:10
 * @Version
 */
@Repository
public interface QJudgmentMapper {
    //增加判断题
    int addJudgment(@Param("qJudgment") QJudgment qJudgment);

    //删除判断题
    int deleteJudgmentById(@Param("questionId") Integer questionId);

    //修改判断题
    int updateJudgmentById(@Param("qJudgment") QJudgment qJudgment, @Param("questionId") Integer questionId);

    //查所有判断题
    List<QJudgment> queryAllJudgment(@Param("begin")int begin, @Param("pageSize")int pageSize);

    //根据id查询判断题
    QJudgment queryJudgmentById(@Param("questionId") Integer questionId);

    int allJudgmentCount();

    List<Integer> queryByRandom(@Param("judgeNumber") Integer judgeNumber);

    List<QJudgment> queryPaperByIdAndType(@Param("paperId") Integer paperId);
}
