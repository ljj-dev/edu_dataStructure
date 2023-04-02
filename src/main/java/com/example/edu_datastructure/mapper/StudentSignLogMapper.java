package com.example.edu_datastructure.mapper;

import com.example.edu_datastructure.pojo.StudentSignLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Author ljj
 * @Data 2023/3/14 9:40
 * @Version
 */
@Repository
public interface StudentSignLogMapper {
    List<StudentSignLog> querySignLogById(@Param("studentId") Integer studentId);


    int insertSignById(@Param("doSignForm") StudentSignLog doSignForm);

    int checkSignById(@Param("checkSignTime") Date checkSignTime, @Param("studentId") Integer studentId);
}
