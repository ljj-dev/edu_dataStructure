package com.example.edu_datastructure.service;

import com.example.edu_datastructure.pojo.StudentSignLog;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Author ljj
 * @Data 2023/3/14 9:45
 * @Version
 */
public interface StudentSignLogService {
    List<StudentSignLog> querySignLogById(Integer studentId);


    int insertSignById(StudentSignLog doSignForm);

    int checkSignById(Date checkSignTime, Integer studentId);
}
