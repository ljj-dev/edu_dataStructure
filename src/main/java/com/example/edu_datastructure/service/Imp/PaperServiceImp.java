package com.example.edu_datastructure.service.Imp;

import com.example.edu_datastructure.mapper.PaperMapper;
import com.example.edu_datastructure.pojo.PaperManage;
import com.example.edu_datastructure.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author ljj
 * @Data 2023/3/30 21:27
 * @Version
 */
@Service
public class PaperServiceImp implements PaperService {
    @Autowired
    private PaperMapper paperMapper;

    @Override
    public int add(PaperManage paperManage) {
        return paperMapper.add(paperManage);
    }
}
