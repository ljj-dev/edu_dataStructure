package com.example.edu_datastructure.service.Imp;

import com.example.edu_datastructure.mapper.StudentSignMapper;
import com.example.edu_datastructure.pojo.StudentSign;
import com.example.edu_datastructure.service.StudentSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author ljj
 * @Data 2023/3/14 10:15
 * @Version
 */
@Service
public class StudentSignServiceImp implements StudentSignService {
    @Autowired
    private StudentSignMapper studentSignMapper;


    @Override
    public StudentSign querySignById(Integer studentId) {
        StudentSign studentSign = studentSignMapper.querySignById(studentId);
        return studentSign;
    }

    @Override
    public int insertNewSign(StudentSign studentSign) {
        return studentSignMapper.insertNewSign(studentSign);
    }

    @Override
    public void updateSignInfo(StudentSign studentSign) {
        studentSignMapper.updateSignInfo(studentSign);
    }
}
