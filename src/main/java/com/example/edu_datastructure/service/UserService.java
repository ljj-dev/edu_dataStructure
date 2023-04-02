package com.example.edu_datastructure.service;

import com.example.edu_datastructure.pojo.User;

/**
 * @Author ljj
 * @Data 2023/2/10 11:32
 * @Version
 */
public interface UserService {
    User doLogin(Integer userName, String password, Integer identity);
}
