package com.example.edu_datastructure.controller;

import com.example.edu_datastructure.compile.HttpBodyHandlerUtils;
import com.example.edu_datastructure.compile.TaskUtil;
import com.example.edu_datastructure.pojo.*;
import com.example.edu_datastructure.service.*;
import com.example.edu_datastructure.utils.Code;
import com.example.edu_datastructure.utils.ResultData;
import com.example.edu_datastructure.utils.checkAllotSiginUtil;
import com.example.edu_datastructure.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.Class;
import java.util.Date;
import java.util.List;

/**
 * @Author ljj
 * @Data 2023/2/10 17:19
 * @Version
 */
@Controller
@RequestMapping("student")
public class StudentController {
    private static int status = 0;
    @Autowired
    private ChapterService chapterService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private OjProblemService ojProblemService;

    @Autowired
    private ClassService classService;

    @Autowired
    private StudentSignLogService studentSignLogService;

    @Autowired
    private StudentSignService studentSignService;

    @Autowired
    private FileService fileService;

    @RequestMapping({"{url}.html", "{url}"})
    public String student(@PathVariable("url") String url) {
        System.out.println(url);
        return "student/" + url;
    }

    @RequestMapping("prepare/{url}.html")
    public String prepare(@PathVariable("url") String url) {
        System.out.println(url);
        return "student/prepare/" + url;
    }

    @RequestMapping("/logout")
    @ResponseBody
    public String loginOut(HttpSession session) {
        session.invalidate();
        return "success";
    }

    @RequestMapping("/queryStudentById")
    @ResponseBody
    public ResultData queryStudentById(HttpSession session) {
        Student student = (Student) session.getAttribute("student");
        Integer studentId = student.getStudentId();
        Student studentInfo = studentService.queryStudentById(studentId);
        Integer code = studentInfo != null ? Code.QUERY_OK : Code.QUERY_ERR;
        String msg = studentInfo != null ? "" : "数据查询失败，请重试!";
        return new ResultData(studentInfo, code, msg);
    }

    @RequestMapping("/queryAllCourse")
    @ResponseBody
    public ResultData queryAllCourse() {
        List<Chapter> chapters = chapterService.queryAllSection();
        System.out.println("chapters:" + chapters);
        Integer code = chapters != null ? Code.QUERY_OK : Code.QUERY_ERR;
        String msg = chapters != null ? "" : "数据查询失败，请重试!";
        return new ResultData(chapters, code, msg);
    }


    @RequestMapping("queryAllData")
    @ResponseBody
    public ResultData queryAllData(Integer currentPage, Integer pageSize) {
        PageBean<Files> filesPageBean = fileService.queryAllData(currentPage, pageSize);
        Integer code = filesPageBean != null ? Code.QUERY_OK : Code.QUERY_ERR;
        String msg = filesPageBean != null ? "" : "数据查询失败，请重试!";
        return new ResultData(filesPageBean, code, msg);
    }


    @RequestMapping("/queryAllProblem")
    @ResponseBody
    public ResultData queryAllProblem(Integer currentPage, Integer pageSize) {
        PageBean<OjProblem> ojProblemPageBean = ojProblemService.queryAllOjProblem(currentPage, pageSize);
        Integer code = ojProblemPageBean != null ? Code.QUERY_OK : Code.QUERY_ERR;
        String msg = ojProblemPageBean != null ? "" : "数据查询失败，请重试!";
        return new ResultData(ojProblemPageBean, code, msg);
    }

    @RequestMapping("/queryMyProblem")
    @ResponseBody
    public ResultData queryMyProblem(HttpSession session, Integer currentPage, Integer pageSize) {
        Student student = (Student) session.getAttribute("student");
        Integer studentId = student.getStudentId();
        PageBean<OjAndStudent> ojProblemPageBean = ojProblemService.queryMyOjProblem(studentId, currentPage, pageSize);
        Integer code = ojProblemPageBean != null ? Code.QUERY_OK : Code.QUERY_ERR;
        String msg = ojProblemPageBean != null ? "" : "数据查询失败，请重试!";
        return new ResultData(ojProblemPageBean, code, msg);
    }

    @RequestMapping("queryProblemById")
    @ResponseBody
    public ResultData queryProblemById(Integer id, Boolean status, HttpSession session) {
        System.out.println("problemId:" + id);
        System.out.println("status:" + status);
        Student student = (Student) session.getAttribute("student");
        Integer studentId = student.getStudentId();
        OjProblem ojProblem = ojProblemService.queryProblemById(id);
        if (status) {
            String codeLog = ojProblemService.queryCodeLog(id, studentId);
            System.out.println("codeLog" + codeLog);
            if (codeLog != null) {
                ojProblem.setTemplateCode(codeLog);
            }
        }
        Integer code = ojProblem != null ? Code.QUERY_OK : Code.QUERY_ERR;
        String msg = ojProblem != null ? "" : "数据查询失败，请重试!";
        return new ResultData(ojProblem, code, msg);
    }

    @RequestMapping("querySignById")
    @ResponseBody
    public ResultData querySignById(HttpSession session) {
        Student student = (Student) session.getAttribute("student");
        Integer studentId = student.getStudentId();
        StudentSign studentSign = new StudentSign();
        List<StudentSignLog> studentSignLogs = studentSignLogService.querySignLogById(studentId);
        StudentSign studentSign1 = studentSignService.querySignById(studentId);

        if (studentSignLogs.size() < 1 && studentSign1 == null) {
            //该学生没有签到过，初始化该学生签到表中的记录
            studentSign.setStudentId(studentId);
            studentSign.setSignNums(3);
            studentSign.setCumulativeDays(0);
            studentSign.setRunningDays(0);
            int i = studentSignService.insertNewSign(studentSign);
            if (i <= 0) {
                Integer code = Code.ADD_ERR;
                String msg = "数据初始化失败，请重试!";
                return new ResultData(studentSign, code, msg);
            }
        }
        StudentSign studentSign2 = studentSignService.querySignById(studentId);
        Integer code = studentSign2 != null ? Code.QUERY_OK : Code.QUERY_ERR;
        String msg = studentSign2 != null ? "" : "数据查询失败，请重试!";
        return new ResultData(studentSign2, code, msg);
    }

    @RequestMapping("querySignLogById")
    @ResponseBody
    public ResultData querySignLogById(HttpSession session) {
        Student student = (Student) session.getAttribute("student");
        Integer studentId = student.getStudentId();
        List<StudentSignLog> studentSignLogs = studentSignLogService.querySignLogById(studentId);
        Integer code = studentSignLogs != null ? Code.QUERY_OK : Code.QUERY_ERR;
        String msg = studentSignLogs != null ? "" : "数据查询失败，请重试!";
        return new ResultData(studentSignLogs, code, msg);
    }

    @RequestMapping("sign")
    @ResponseBody
    public String sign(@RequestBody StudentSignLog doSignForm, HttpSession session) throws Exception {
        Student student = (Student) session.getAttribute("student");
        Integer studentId = student.getStudentId();

        StudentSign studentSign = studentSignService.querySignById(studentId);
        Date lastSign = studentSign.getLastSign();

        Date date = new Date();
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        doSignForm.setSignTime(date1);
        doSignForm.setCreateTime(date1);
        doSignForm.setStudentId(studentId);
        if (lastSign != null) {
            int i = checkAllotSiginUtil.checkAllotSigin(lastSign);
            if (i == 1) {
                //已经签到
                return "false";
            } else if (i == 2) {
                //未签到但处于断续签到状态
                int count = studentSignLogService.checkSignById(date1, studentId);
                if (count < 1) {
                    int j = studentSignLogService.insertSignById(doSignForm);
                    if (j > 0) {
                        studentSign.setStudentId(studentId);
                        studentSign.setRunningDays(0);
                        studentSign.setCumulativeDays(studentSign.getCumulativeDays() + 1);
                        studentSign.setLastSign(date1);
                        studentSignService.updateSignInfo(studentSign);
                        return "success";
                    }
                }
            } else {
                //代表未签到且处于连续签到状态
                int count = studentSignLogService.checkSignById(date1, studentId);
                if (count < 1) {
                    int j = studentSignLogService.insertSignById(doSignForm);
                    if (j > 0) {
                        studentSign.setStudentId(studentId);
                        studentSign.setRunningDays(studentSign.getRunningDays() + 1);
                        studentSign.setCumulativeDays(studentSign.getCumulativeDays() + 1);
                        studentSign.setLastSign(date1);
                        studentSignService.updateSignInfo(studentSign);
                        return "success";
                    }
                }
            }
        } else {
            int count = studentSignLogService.checkSignById(date1, studentId);
            if (count < 1) {
                int j = studentSignLogService.insertSignById(doSignForm);
                if (j > 0) {
                    studentSign.setStudentId(studentId);
                    studentSign.setRunningDays(studentSign.getRunningDays() + 1);
                    studentSign.setCumulativeDays(studentSign.getCumulativeDays() + 1);
                    studentSign.setLastSign(date1);
                    studentSignService.updateSignInfo(studentSign);
                    return "success";
                }
            }
        }
        return "false";
    }

    @RequestMapping("updateMyInfo")
    @ResponseBody
    public String updateMyInfo(@RequestBody Student infoForm) {
        System.out.println("infoForm:" + infoForm);
        int i = studentService.updateMyInfo(infoForm);
        if (i > 0) {
            return "success";
        } else {
            return "false";
        }
    }


    @RequestMapping("exitMyClass")
    @ResponseBody
    public String exitMyClass(@RequestBody com.example.edu_datastructure.pojo.Class selectClass, HttpSession session) {
        Integer classId = selectClass.getClassId();
        System.out.println("classId:" + classId);
        Student student = (Student) session.getAttribute("student");
        Integer studentId = student.getStudentId();
        Integer classId1 = student.getClassId();
        int i = studentService.updateMyClass(studentId, classId);
        if (i > 0) {
            int updateNumber = classService.updateNumber(classId1);
            if (updateNumber > 0) {
                return "success";
            }
        }
        return "false";
    }

    @RequestMapping("joinMyClass")
    @ResponseBody
    public String joinMyClass(@RequestBody com.example.edu_datastructure.pojo.Class selectClass, HttpSession session) {
        Integer classId = selectClass.getClassId();
        System.out.println("classId:" + classId);
        Student student = (Student) session.getAttribute("student");
        Integer studentId = student.getStudentId();
        int i = studentService.updateMyClass(studentId, classId);
        if (i > 0) {
            int updateNumber = classService.updateNumber(classId);
            if (updateNumber > 0) {
                return "success";
            }
        }
        return "false";
    }

    @RequestMapping("queryAllClass")
    @ResponseBody
    public ResultData queryAllClass() {
        List<Class> classes = classService.queryAllClass();
        Integer code = classes != null ? Code.QUERY_OK : Code.QUERY_ERR;
        String msg = classes != null ? "" : "数据查询失败，请重试!";
        return new ResultData(classes, code, msg);
    }

    @RequestMapping("saveMyAnswer")
    @ResponseBody
    public String saveMyAnswer(HttpServletRequest request, HttpSession session) {
        //1.读取 请求 的 body 的所有数据
        String httpBody = HttpBodyHandlerUtils.readBody(request);
        //2.按照API约定的格式来解析json数据，得到CompileRequest对象
        CompileRequest compileRequest = HttpBodyHandlerUtils.stringToPojo(httpBody, CompileRequest.class);

        Integer problemId = compileRequest.getId();
        String saveCode = compileRequest.getCode();

        Student student = (Student) session.getAttribute("student");
        Integer studentId = student.getStudentId();

        int i = ojProblemService.myOjproblemExist(problemId, studentId);
        if (i > 0) {
            //该数据存在,则修改数据
            System.out.println("status:" + status);
            int updateCodeLog = ojProblemService.updateCodeLog(problemId, studentId, status, saveCode);
            if (updateCodeLog > 0) {
                return "success";
            } else {
                return "false";
            }

        } else {
            //该数据不存在,则插入数据
            System.out.println("status:" + status);
            int saveMyProblem = ojProblemService.saveMyProblem(problemId, studentId, status, saveCode);
            if (saveMyProblem > 0) {
                return "success";
            } else {
                return "false";
            }

        }
    }

    @RequestMapping("doProblem")
    @ResponseBody
    public void compileAndRun(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //1.读取 请求 的 body 的所有数据
        String body = HttpBodyHandlerUtils.readBody(req);
        System.out.println("user_compile: \n" + body);

        if (!HttpBodyHandlerUtils.isCompileComplete(body)) {
            CompileResponse compileResponse = new CompileResponse();
            compileResponse.setOk(0);
            compileResponse.setReason("编译错误:您提交的代码无法完成编译");
            String jsonString = HttpBodyHandlerUtils.pojoToString(compileResponse);
            resp.setContentType("application/json; charset=utf-8");
            resp.getWriter().write(jsonString);
        } else {
            //2.按照API约定的格式来解析json数据，得到CompileRequest对象
            CompileRequest compileRequest = HttpBodyHandlerUtils.stringToPojo(body, CompileRequest.class);

            //3.按照 id 从数据库中读取出对应的测试用例代码

            OjProblem problem = ojProblemService.queryProblemById(compileRequest.getId());

            //得到该题目的测试代码
            String testCode = problem.getTestCode();

            //得到该题目的用户输入的代码
            String requestCode = compileRequest.getCode();

            //4.把用户输入的代码和测试用例进行组装，组装成一个完整的可以运行编译的代码
            String finalCode = mergeCode(requestCode, testCode);
            System.out.println("compile_and_run_code: \n" + finalCode);


            //5.创建task对象对刚才拼装的代码进行编译运行
            Question question = new Question();
            question.setCode(finalCode);
            TaskUtil task = new TaskUtil();
            Answer answer = null;
            try {
                answer = task.compileAndRun(question);
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }

            //6.把运行结果构造成响应数据写回给客户端
            CompileResponse compileResponse = new CompileResponse();
            assert answer != null;
            String stdout = answer.getStdout();
            System.out.println("stdout:" + stdout);
            String t = "T";
            boolean x = t.equals(stdout);
            System.out.println("x:" + x);
            if (x) {
                status = 1;
            } else {
                status = 0;
            }
            System.out.println("status:" + status);
            compileResponse.setOk(answer.getError());
            compileResponse.setReason(answer.getReason());
            compileResponse.setStdout(stdout);
            String jsonString = HttpBodyHandlerUtils.pojoToString(compileResponse);
            resp.setContentType("application/json; charset=utf-8");
            resp.getWriter().write(jsonString);
        }
    }


    /**
     * 把testCode中的main方法内容嵌入到requestCode中
     *
     * @param requestCode 用户的代码
     * @param testCode    测试用例代码
     * @return
     */
    private String mergeCode(String requestCode, String testCode) {
        //合并之前考虑清楚这两部分的代码都是什么样的
        //1.先找到requestCode中最后一个 }
        //2.把requestCode中最后一个 } 删除之后，再把testCode内容拼接上
        //3.拼接完之后再补一个 }
        int pos = requestCode.lastIndexOf('}');
        if (pos == -1) {
            return null;
        }

        return requestCode.substring(0, pos) + testCode + "\n}";
    }


}


