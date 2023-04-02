package com.example.edu_datastructure.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ljj
 * @Data 2023/2/10 17:40
 * 表现层与前端数据传输数据协议
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultData<T> {
    private T data;    //传输的数据封装到data属性
    private Integer code;   //设置封装数据码，表示哪个具体的操作与该操作是否成功
    private String msg;     //查询是否成功的信息

    public ResultData(T data, Integer code) {
        this.data = data;
        this.code = code;
    }
}
