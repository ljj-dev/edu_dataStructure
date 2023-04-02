package com.example.edu_datastructure.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author ljj
 * @Data 2023/3/13 20:38
 * 签到记录表
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentSignLog {
    private Integer studentId;

    //签到时间
    private Date signTime;

    //签到类型
    private String signType;

    //创建时间
    private Date createTime;
}
