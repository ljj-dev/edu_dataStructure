package com.example.edu_datastructure.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ljj
 * @Data 2023/3/20 11:09
 * @Version
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResult {
    private String msg;     //是否成功的信息
    private String data;    //传输的数据封装到data属性
    private Integer code;   //设置封装数据码，表示哪个具体的操作与该操作是否成功
}
