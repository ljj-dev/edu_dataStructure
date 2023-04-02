package com.example.edu_datastructure.service.Imp;

import com.example.edu_datastructure.mapper.UserMapper;
import com.example.edu_datastructure.pojo.User;
import com.example.edu_datastructure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ljj
 * @Data 2023/2/10 11:32
 * @Version
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User doLogin(Integer userName, String password, Integer identity) {
        List<User> users = userMapper.queryAllUser(userName, password, identity);
        if (users != null && users.size() > 0) {
            return users.get(0);
        }
        return null;
    }
}
