package com.example.edu_datastructure.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author ljj
 * @Data 2023/3/13 20:34
 * 签到表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentSign {
    private Integer studentId;

    //累计签到天数
    private Integer cumulativeDays;

    //连续签到天数
    private Integer runningDays;

    //上一次签到时间
    private Date lastSign;

    //可补签次数
    private Integer signNums;

}
