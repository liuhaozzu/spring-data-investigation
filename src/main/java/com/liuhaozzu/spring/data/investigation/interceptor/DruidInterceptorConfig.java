package com.liuhaozzu.spring.data.investigation.interceptor;

import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/5/1 0001.
 */
@Aspect
@Configuration
public class DruidInterceptorConfig {
    @Bean
    public DruidStatInterceptor druidStatInterceptor() {
        DruidStatInterceptor interceptor=new com.alibaba.druid.support.spring.stat.DruidStatInterceptor();
        return interceptor;
    }

    @Bean
    public JdkRegexpMethodPointcut jdkRegexpMethodPointcut() {
        JdkRegexpMethodPointcut pointcut=new JdkRegexpMethodPointcut();
        pointcut.setPatterns("com.liuhaozzu.spring.data.investigation.repository.*");
        return pointcut;
    }

    @Bean
    public Advisor druidStatAdvisor() {
        return new DefaultPointcutAdvisor(jdkRegexpMethodPointcut(), druidStatInterceptor());
    }

}