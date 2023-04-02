package com.example.edu_datastructure.service;

import com.example.edu_datastructure.pojo.Files;
import com.example.edu_datastructure.pojo.OjProblem;
import com.example.edu_datastructure.utils.ResultData;
import com.example.edu_datastructure.vo.PageBean;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @Author ljj
 * @Data 2023/3/15 9:54
 * @Version
 */
public interface FileService {
    /**
     * 文件上传接口
     * @param file
     * @return
     */
    ResultData upLoadFiles(MultipartFile file);

    /**
     * 根据id获取文件
     * @param id
     * @return
     */
    Files getFileById(String id);

    /**
     * 根据id获取数据流
     * @param files
     * @return
     */
    InputStream getFileInputStream(Files files);

    PageBean<Files> queryAllData(Integer currentPage, Integer pageSize);
}
