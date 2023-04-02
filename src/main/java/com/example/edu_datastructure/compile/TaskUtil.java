package com.example.edu_datastructure.compile;

import com.example.edu_datastructure.vo.Answer;
import com.example.edu_datastructure.vo.Question;

import java.io.File;
import java.io.IOException;

/**
 * @Author ljj
 * @Data 2023/3/6 20:29
 * Task 这个类表示一次运行编译的结果
 */

public class TaskUtil {
    // 约定临时文件所在的目录
    private final String WORK_DIR = "./tmp/";
    // 约定代码的类名
    private final String CLASS = "Solution";
    // 约定要编译的代码文件名
    private final String CODE = WORK_DIR + "Solution.java";
    // 约定存放编译错误信息的文件名
    private final String COMPILE_ERROR = WORK_DIR + "compile_error.txt";
    // 约定存放运行时的标准输出的文件名
    private final String STDOUT = WORK_DIR + "stdout.txt";
    // 约定存放运行时的标准错误的文件名
    private final String STDERR = WORK_DIR + "stderr.txt";

    /**
     * 编译 + 运行
     * @param question 要编译运行的 java 源代码
     * @return 编译运行的结果
     */
    public Answer compileAndRun(Question question) throws IOException, InterruptedException{
        Answer answer = new Answer();
        // 创建临时文件的目录
        File workDir = new File(WORK_DIR);
        if(!workDir.exists()){
            System.out.println("创建成功!");
            workDir.mkdirs();
        }
        // 1. 把 question 中的 code 写入到一个 Solution.java 文件中
        FileUtil.writeFile(CODE,question.getCode());
        // 2. 创建子进程, 调用 javac 进行编译. (这里需要 .java 文件)
        // 如果编译出错, 放入到 compileError.txt
        String compileCmd = String.format("javac -encoding utf8 %s -d %s",CODE,WORK_DIR);
        // 对于 javac 进程来说, 不关心他的标准输出.
        CommandUtil.run(compileCmd,null,COMPILE_ERROR);
        // 读取编译错误的信息.
        String compileError = FileUtil.readFile(COMPILE_ERROR);
        if (!"".equals(compileError)){
            // 编译错误
            // 返回 Answer 让 Answer中记录编译错误的信息.
            System.out.println("编译出错");
            answer.setError(1);
            answer.setReason(compileError);
            return answer;
        }
        // 3. 创建子进程, 调用 java 命令并执行
        // 运行程序时候, 获取 java 子进程的标准输出 和 标准错误
        String runCmd = String.format("java -classpath %s %s",WORK_DIR,CLASS);
        CommandUtil.run(runCmd,STDOUT,STDERR);
        String runError = FileUtil.readFile(STDERR);
        if (!"".equals(runError)) {
            System.out.println("运行出错!");
            answer.setError(2);
            answer.setReason(runError);
            return answer;
        }
        // 4. 父进程获取到刚才的编译执行的结果, 并打包成 Answer对象
        answer.setError(0);
        answer.setStdout(FileUtil.readFile(STDOUT));
        return answer;
        // 编译执行的结果, 就通过刚刚约定的这几个文件来获取即可

    }
}

