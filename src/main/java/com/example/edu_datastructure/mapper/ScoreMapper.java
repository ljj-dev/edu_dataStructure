package com.example.edu_datastructure.mapper;

import com.example.edu_datastructure.pojo.ScoreManage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author ljj
 * @Data 2023/4/1 20:55
 * @Version
 */
@Repository
public interface ScoreMapper {

    int addScore(@Param("scoreManage") ScoreManage scoreManage);
}
