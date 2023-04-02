//package com.example.edu_datastructure.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * @Author ljj
// * @Data 2023/3/8 19:49
// * @Version
// */
//@Configuration
//public class LoginConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //注册TestInterceptor拦截器
//        InterceptorRegistration registration = registry.addInterceptor(new UserLoginInterceptor());
//        registration.addPathPatterns("/**"); //所有路径都被拦截
//
//        registration.excludePathPatterns(    //添加不拦截路径
//                "/login",                    //登录路径
//                "/",
//                "/doLogin",                    //登录路径
//                "/**/*.html",                //html静态资源
//                "/**/*.js",                  //js静态资源
//                "/**/*.css"                  //css静态资源
//        );
//    }
//
//
//
//
//
//}
