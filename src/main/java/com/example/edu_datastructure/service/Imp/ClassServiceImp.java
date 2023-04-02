package com.example.edu_datastructure.service.Imp;

import com.example.edu_datastructure.mapper.ClassMapper;
import com.example.edu_datastructure.service.ClassService;
import com.example.edu_datastructure.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ljj
 * @Data 2023/3/12 16:19
 * @Version
 */
@Service
public class ClassServiceImp implements ClassService {
    @Autowired
    private ClassMapper classMapper;


    @Override
    public List<Class> queryAllClass() {
        List<Class> classes = classMapper.queryAllClass();
        return classes;
    }

    @Override
    public PageBean<Class> queryAllClass(Integer currentPage, Integer pageSize) {
        List<Class> rows;
        int begin = (currentPage - 1) * pageSize;
        rows = classMapper.queryAllClassPage(begin , pageSize);
        int count = classMapper.allClassCount();
        PageBean<Class> classPageBean = new PageBean<>();
        classPageBean.setRows(rows);
        classPageBean.setTotalCount(count);
        return classPageBean;
    }

    @Override
    public int updateNumber(Integer classId) {
        return classMapper.updateNumber(classId);
    }

    @Override
    public int deleteClassById(Integer classId) {
        return classMapper.deleteClassById(classId);
    }

    @Override
    public int addClass(Class addClassInfo) {
        return classMapper.addClass(addClassInfo);
    }

    @Override
    public int deleteByClassIds(int[] selectedIds) {
        return classMapper.deleteByClassIds(selectedIds);
    }
}
