package com.example.edu_datastructure.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.net.InetAddress;
import java.util.UUID;


/**
 * @Author ljj
 * @Data 2023/3/20 11:05
 * 文件上传
 */
@Component
public class UploadFileUtil {
    /**
     * 项目端口
     */
//    @Value("${server.port}")
//    public String port;

    /**
     * 项目路径
     */
//    @Value("${server.servlet.context-path}")
//    public String contextPath;

    /**
     * 上传文件
     *
     * @param multipartFile 文件对象
     * @return
     */
    public String uploadFile(MultipartFile multipartFile) {
        try {
            if (multipartFile.isEmpty()) {
                return "null";
            }
            // 获取文件的名称
            String originalFilename = multipartFile.getOriginalFilename();
            // 文件后缀 例如：.png
            String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            // uuid 生成文件名
            String uuid = String.valueOf(UUID.randomUUID());
            // 新的文件名，使用uuid生成文件名
            String fileName = uuid + fileSuffix;

            // 根路径，在 resources/static/upload
            String basePath = ResourceUtils.getURL("classpath:").getPath() + "static/data/pdfs/";
            // 创建新的文件
            File fileExist = new File(basePath);
            // 文件夹不存在，则新建
            if (!fileExist.exists()) {
                fileExist.mkdirs();
            }
            // 获取文件对象
            File file = new File(basePath, originalFilename);
            // 完成文件的上传
            multipartFile.transferTo(file);
            // 返回绝对路径
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "failed";
    }

}
