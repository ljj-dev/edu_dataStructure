package com.example.edu_datastructure.service.Imp;

import com.example.edu_datastructure.mapper.ScoreMapper;
import com.example.edu_datastructure.pojo.ScoreManage;
import com.example.edu_datastructure.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author ljj
 * @Data 2023/4/1 20:59
 * @Version
 */
@Service
public class ScoreServiceImp implements ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public int addScore(ScoreManage scoreManage) {
        return scoreMapper.addScore(scoreManage);
    }
}
