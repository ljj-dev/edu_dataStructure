package com.example.edu_datastructure.mapper;

import com.example.edu_datastructure.pojo.QFill;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author ljj
 * @Data 2023/3/23 14:02
 * @Version
 */
@Repository
public interface QFillMapper {
    //增加填空题
    int addFill(@Param("qFill") QFill qFill);

    //删除填空题
    int deleteFillById(@Param("questionId") Integer questionId);

    //修改填空题
    int updateFillById(@Param("qFill") QFill qFill, @Param("questionId") Integer questionId);

    //查所有填空题
    List<QFill> queryAllFill(@Param("begin")int begin, @Param("pageSize")int pageSize);

    //根据id查询填空题
    QFill queryFillById(@Param("questionId") Integer questionId);

    int allFillCount();

    List<Integer> queryByRandom(@Param("fillNumber") Integer fillNumber);

    List<QFill> queryPaperByIdAndType(@Param("paperId") Integer paperId);
}
