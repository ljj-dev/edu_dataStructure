package com.example.edu_datastructure.mapper;

import com.example.edu_datastructure.pojo.StudentSign;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author ljj
 * @Data 2023/3/14 10:07
 * @Version
 */
@Repository
public interface StudentSignMapper {
    StudentSign querySignById(@Param("studentId") Integer studentId);

    int insertNewSign(@Param("studentSign") StudentSign studentSign);

    void updateSignInfo(@Param("studentSign") StudentSign studentSign);
}
