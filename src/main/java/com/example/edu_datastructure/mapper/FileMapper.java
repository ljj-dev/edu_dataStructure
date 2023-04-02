package com.example.edu_datastructure.mapper;

import com.example.edu_datastructure.pojo.Files;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author ljj
 * @Data 2023/3/15 10:09
 * @Version
 */

@Repository
public interface FileMapper {
    /**
     * 将数据信息插入到数据库
     * @param files
     */
    void insertFile(Files files);

    /**
     * 根据id获取文件
     * @param id
     * @return
     */
    Files selectFileById(String id);

    List<Files> queryAllData(Integer begin, Integer pageSize);

    int allDataCount();
}
