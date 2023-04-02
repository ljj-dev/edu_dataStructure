package com.example.edu_datastructure.service;

import com.example.edu_datastructure.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

/**
 * @Author ljj
 * @Data 2023/3/15 15:54
 * @Version
 */
public interface TeacherService {
    Teacher queryStudentById(Integer teacherId);
}
