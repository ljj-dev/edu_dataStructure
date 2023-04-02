package com.example.edu_datastructure.service;

import com.example.edu_datastructure.pojo.Student;
import com.example.edu_datastructure.vo.PageBean;

import java.util.List;

/**
 * @Author ljj
 * @Data 2023/3/10 12:04
 * @Version
 */
public interface StudentService {
    Student queryStudentById(Integer studentId);
    int updateMyInfo(Student student);

    int updateMyClass(Integer studentId, Integer classId);

    int countClassById(Integer classId);

    List<Student> queryStudentByClassId(Integer classId);

    PageBean<Student> queryAllStudent(Integer currentPage, Integer pageSize);

    int updateStudentById(Student infoForm, Integer studentId);

    int deleteStudentById(Integer studentId);
}
