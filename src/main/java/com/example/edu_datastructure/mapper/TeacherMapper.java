package com.example.edu_datastructure.mapper;

import com.example.edu_datastructure.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author ljj
 * @Data 2023/3/15 15:47
 * @Version
 */
@Repository
public interface TeacherMapper {
    Teacher queryTeacherById(@Param("teacherId") Integer teacherId);
}
