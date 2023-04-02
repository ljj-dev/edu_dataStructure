package com.example.edu_datastructure.service.Imp;

import com.example.edu_datastructure.mapper.StudentSignLogMapper;
import com.example.edu_datastructure.pojo.StudentSignLog;
import com.example.edu_datastructure.service.StudentSignLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author ljj
 * @Data 2023/3/14 9:45
 * @Version
 */
@Service
public class StudentSignLogServiceImp implements StudentSignLogService {
    @Autowired
    private StudentSignLogMapper studentSignLogMapper;

    @Override
    public List<StudentSignLog> querySignLogById(Integer studentId) {
        List<StudentSignLog> studentSignLogs = studentSignLogMapper.querySignLogById(studentId);
        return studentSignLogs;
    }

    @Override
    public int insertSignById(StudentSignLog doSignForm) {
        return studentSignLogMapper.insertSignById(doSignForm);
    }

    @Override
    public int checkSignById(Date checkSignTime, Integer studentId) {
        return studentSignLogMapper.checkSignById(checkSignTime , studentId);
    }

}
