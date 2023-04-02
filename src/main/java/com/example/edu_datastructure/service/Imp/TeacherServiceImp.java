package com.example.edu_datastructure.service.Imp;

import com.example.edu_datastructure.mapper.TeacherMapper;
import com.example.edu_datastructure.pojo.Teacher;
import com.example.edu_datastructure.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author ljj
 * @Data 2023/3/15 15:54
 * @Version
 */
@Service
public class TeacherServiceImp implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher queryStudentById(Integer teacherId) {
        Teacher teacher = teacherMapper.queryTeacherById(teacherId);
        return teacher;
    }
}
