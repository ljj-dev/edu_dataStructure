package com.example.edu_datastructure;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.edu_datastructure.mapper")
public class EduDataStructureApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduDataStructureApplication.class, args);
    }

}
