package com.example.edu_datastructure.mapper;

import com.example.edu_datastructure.pojo.QMultiple;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author ljj
 * @Data 2023/3/23 12:24
 * @Version
 */
@Repository
public interface QMultipleMapper {
    //增加选择题
    int addMultiple(@Param("qMultiple") QMultiple qMultiple);

    //删除选择题
    int deleteMultipleById(@Param("questionId") Integer questionId);

    //修改选择题
    int updateMultipleById(@Param("qMultiple") QMultiple qMultiple, @Param("questionId") Integer questionId);

    //查所有选择题
    List<QMultiple> queryAllMultiple(@Param("begin")int begin, @Param("pageSize")int pageSize);

    //根据id查询选择题
    QMultiple queryMultipleById(@Param("questionId") Integer questionId);

    int allMultipleCount();

    List<Integer> queryByRandom(@Param("multipleNumber") Integer multipleNumber);

    List<QMultiple> queryPaperByIdAndType(@Param("paperId") Integer paperId);
}
