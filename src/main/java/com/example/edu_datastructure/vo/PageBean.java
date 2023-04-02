package com.example.edu_datastructure.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author ljj
 * @Data 2023/3/7 19:50
 * @Version
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageBean<E> {
    //总记录数
    private int totalCount;

    //当前页数据
    private List<E> rows;

}