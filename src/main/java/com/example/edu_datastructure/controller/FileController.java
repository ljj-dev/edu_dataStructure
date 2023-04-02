package com.example.edu_datastructure.controller;

import com.example.edu_datastructure.pojo.Files;
import com.example.edu_datastructure.pojo.myEnum.ResponseCode;
import com.example.edu_datastructure.service.FileService;
import com.example.edu_datastructure.utils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @Author ljj
 * @Data 2023/3/15 15:11
 * @Version
 */
@Controller
@RequestMapping("/fileApi")
public class FileController {
    @Autowired
    private FileService fileService;
    //文件上传接口
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public ResultData upLoadFiles(MultipartFile multipartFile){
        //如果文件为空，直接返回错误信息
        if (multipartFile.isEmpty()){
            return new ResultData(null,ResponseCode.FILE_EMPTY.getCode(),ResponseCode.FILE_EMPTY.getMsg());
        }
        //否则调用service上传文件
        return fileService.upLoadFiles(multipartFile);
    }

    @RequestMapping(value = "/download/{id}",method = RequestMethod.GET)
    public void downloadFiles(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){
        OutputStream outputStream=null;
        InputStream inputStream=null;
        //先根据id查到文件信息
        Files files = fileService.getFileById(id);
        String fileName = files.getFileName();
        //通过文件信息将文件转化为inputStream
        inputStream=fileService.getFileInputStream(files);
        //下载文件需要设置的header
        response.setHeader("Content-Disposition", "attachment;filename=" +  new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
        // 获取输出流
        try {
            outputStream = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //不要忘记关闭流
            try {
                if (inputStream!=null){
                    inputStream.close();
                }
                if (outputStream!=null){
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
