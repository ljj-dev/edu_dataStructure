package com.example.edu_datastructure.mapper;

import com.example.edu_datastructure.pojo.PaperManage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author ljj
 * @Data 2023/3/30 21:29
 * @Version
 */
@Repository
public interface PaperMapper {
    int add(@Param("paperManage") PaperManage paperManage);
}
