package com.example.edu_datastructure.vo;

import lombok.Data;

/**
 * @Author ljj
 * @Data 2023/3/6 18:55
 * 这个类是放的运行后的结果.
 * 首先有一个状态码, 表示当前的运行的状态.
 * 有一个reason. 表示出错的信息.
 * 有一个stdout 表示程序得到的标准输出的结果
 * 有一个stderr, 表示待续得到的标准错误的结果
 */
@Data
public class Answer {
    // error 为状态码.
    // 0 编译通过
    // 1 表示编译出错
    // 2 表示运行出错
    // 3 表示其他错误
    private int error;

    // reason 为出错的提示信息.
    // error=1, reason 就是错误信息
    // error=2, reason 就是异常信息
    private String reason;

    // 运行程序得到的标准输出的结果
    private String stdout;

    // 运行程序得到的标准错误的结果
    private String stderr;


}