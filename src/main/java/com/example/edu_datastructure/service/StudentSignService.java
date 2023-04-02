package com.example.edu_datastructure.service;

import com.example.edu_datastructure.pojo.StudentSign;
import org.apache.ibatis.annotations.Param;

/**
 * @Author ljj
 * @Data 2023/3/14 10:14
 * @Version
 */
public interface StudentSignService {
    StudentSign querySignById(Integer studentId);

    int insertNewSign(StudentSign studentSign);

    void updateSignInfo(StudentSign studentSign);
}
