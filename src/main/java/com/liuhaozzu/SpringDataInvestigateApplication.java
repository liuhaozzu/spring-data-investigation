package com.liuhaozzu;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement //开启注解事务支持
public class SpringDataInvestigateApplication {
    public static void main(String[] args) throws Exception {
        new SpringApplication(SpringDataInvestigateApplication.class).run(args);
    }
}
