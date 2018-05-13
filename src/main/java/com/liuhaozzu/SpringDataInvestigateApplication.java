package com.liuhaozzu;


import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement //开启注解事务支持
@EnableMethodCache(basePackages = "com.liuhaozzu.spring.data.investigation.service")
@EnableCreateCacheAnnotation
public class SpringDataInvestigateApplication {
    public static void main(String[] args) throws Exception {
        System.setProperty("spring.devtools.restart.enabled", "false");
        new SpringApplication(SpringDataInvestigateApplication.class).run(args);
    }
}
