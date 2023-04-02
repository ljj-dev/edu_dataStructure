package com.example.edu_datastructure.controller;

import com.example.edu_datastructure.pojo.Student;
import com.example.edu_datastructure.pojo.Teacher;
import com.example.edu_datastructure.pojo.User;
import com.example.edu_datastructure.service.StudentService;
import com.example.edu_datastructure.service.TeacherService;
import com.example.edu_datastructure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author ljj
 * @Data 2023/2/10 14:50
 * @Version
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    //登录界面
    @RequestMapping({"{url}.html", "{url}"})
    public String login(@PathVariable("url") String url) {
        System.out.println(url);
        return url;
    }

    @RequestMapping("/doLogin")
    @ResponseBody
    public String doLogin(@RequestBody User loginFrom, Model model, HttpSession session) {
        Integer userName = loginFrom.getUserName();
        String password = loginFrom.getPassword();
        Integer identity = loginFrom.getIdentity();

        if (identity == null) {
            return "redirect:/login";
        } else {
            User user = userService.doLogin(userName, password, identity);
            System.out.println(user);
            if (user == null) {
                return "redirect:/login";
            } else {
                session.setAttribute("user", user);
                if (identity == 0) {
                    Student student = studentService.queryStudentById(userName);
                    session.setAttribute("student", student);
                    return "studentIndex";
                } else if (identity == 1) {
                    Teacher teacher = teacherService.queryStudentById(userName);
                    session.setAttribute("teacher", teacher);
                    return "teacherIndex";
                }
            }
        }
        return null;
    }

}
