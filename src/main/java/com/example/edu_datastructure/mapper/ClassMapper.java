package com.example.edu_datastructure.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author ljj
 * @Data 2023/3/12 16:21
 * @Version
 */
@Repository
public interface ClassMapper {
    List<Class> queryAllClass();

    int updateNumber(@Param("classId") Integer classId);

    int allClassCount();

    List<Class> queryAllClassPage(@Param("begin")int begin, @Param("pageSize")int pageSize);

    int deleteClassById(@Param("classId") Integer classId);

    int addClass(@Param("addClassInfo") Class addClassInfo);

    int deleteByClassIds(@Param("selectedIds") int[] selectedIds);
}
