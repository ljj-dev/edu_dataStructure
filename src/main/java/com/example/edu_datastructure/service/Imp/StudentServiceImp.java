package com.example.edu_datastructure.service.Imp;

import com.example.edu_datastructure.mapper.StudentMapper;
import com.example.edu_datastructure.pojo.Student;
import com.example.edu_datastructure.service.StudentService;
import com.example.edu_datastructure.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ljj
 * @Data 2023/3/10 12:04
 * @Version
 */
@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public Student queryStudentById(Integer studentId) {
        Student student = studentMapper.queryStudentById(studentId);
        return student;
    }

    @Override
    public int updateMyInfo(Student student) {
        return studentMapper.updateMyInfo(student);
    }

    @Override
    public int updateMyClass(Integer studentId, Integer classId) {
        return studentMapper.updateMyClass(studentId, classId);
    }

    @Override
    public int countClassById(Integer classId) {
        return studentMapper.countClassById(classId);
    }

    @Override
    public List<Student> queryStudentByClassId(Integer classId) {
        List<Student> students = studentMapper.queryStudentByClassId(classId);
        return students;
    }

    @Override
    public PageBean<Student> queryAllStudent(Integer currentPage, Integer pageSize) {
        List<Student> rows;
        int begin = (currentPage - 1) * pageSize;
        rows = studentMapper.queryAllStudent(begin , pageSize);
        int count = studentMapper.allClassCount();
        PageBean<Student> studentPageBean = new PageBean<>();
        studentPageBean.setRows(rows);
        studentPageBean.setTotalCount(count);
        return studentPageBean;
    }

    @Override
    public int updateStudentById(Student infoForm, Integer studentId) {
        return studentMapper.updateStudentById(infoForm, studentId);
    }

    @Override
    public int deleteStudentById(Integer studentId) {
        return studentMapper.deleteStudentById(studentId);
    }
}
