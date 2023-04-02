package com.example.edu_datastructure.compile;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * @Author ljj
 * @Data 2023/3/6 20:16
 * 读写文件的操作
 */
public class FileUtil {
    /**
     * 读文件
     * @param filePath 读取的文件
     * @return 返回读取的内容
     */
    public static String readFile(String filePath) {
        StringBuilder result = new StringBuilder();
        try(FileReader fileReader = new FileReader(filePath)){
            while (true) {
                int ch = fileReader.read();
                if (ch == -1){
                    break;
                }
                result.append((char)ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
    /**
     * 写文件
     * @param filePath 要写入的文件
     * @param content 写入的内容
     */
    public static void writeFile(String filePath, String content) {
        try(FileWriter fileWriter = new FileWriter(filePath)){
            fileWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
