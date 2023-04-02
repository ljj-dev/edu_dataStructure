package com.example.edu_datastructure.mapper;

import com.example.edu_datastructure.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author ljj
 * @Data 2023/2/10 11:38
 * @Version
 */
@Repository
public interface UserMapper {
    List<User> queryAllUser(@Param("userName") Integer userName, @Param("password") String password, @Param("identity") Integer identity);
}
