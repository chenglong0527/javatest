package com.cskaoyan.config;

import com.cskaoyan.exception.AccountHandlerExceptionResolver;
import com.cskaoyan.exception.ParameterException;
import com.cskaoyan.interceptor.AccountInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@EnableWebMvc
@ComponentScan("com.cskaoyan.controller")
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AccountInterceptor()).addPathPatterns("/account/**");
    }
    @Bean
    public AccountHandlerExceptionResolver handlerExceptionResolver(){
        return new AccountHandlerExceptionResolver();
    }
}
