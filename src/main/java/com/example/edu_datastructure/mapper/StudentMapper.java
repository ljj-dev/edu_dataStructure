package com.example.edu_datastructure.mapper;

import com.example.edu_datastructure.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author ljj
 * @Data 2023/3/7 17:20
 * @Version
 */
@Repository
public interface StudentMapper {
    Student queryStudentById(@Param("studentId") Integer studentId);

    int updateMyInfo(@Param("student") Student student);

    int updateMyClass(@Param("studentId") Integer studentId, @Param("classId") Integer classId);

    int countClassById(@Param("classId") Integer classId);

    List<Student> queryStudentByClassId(@Param("classId") Integer classId);

    List<Student> queryAllStudent(@Param("begin")int begin, @Param("pageSize")int pageSize);

    int allClassCount();

    int updateStudentById(@Param("infoForm") Student infoForm, @Param("studentId") Integer studentId);

    int deleteStudentById(@Param("studentId") Integer studentId);
}
