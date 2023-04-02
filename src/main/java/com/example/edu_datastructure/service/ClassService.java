package com.example.edu_datastructure.service;


import com.example.edu_datastructure.vo.PageBean;

import java.util.List;

/**
 * @Author ljj
 * @Data 2023/3/12 16:18
 * @Version
 */

public interface ClassService {
    List<Class> queryAllClass();

    PageBean<Class> queryAllClass(Integer currentPage, Integer pageSize);

    int updateNumber(Integer classId);

    int deleteClassById(Integer classId);

    int addClass(Class addClassInfo);

    int deleteByClassIds(int[] selectedIds);
}
