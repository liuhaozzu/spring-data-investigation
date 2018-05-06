package com.liuhaozzu.spring.data.investigation.config.validation;

import org.hibernate.validator.HibernateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Created by Administrator on 2018/5/6 0006.
 */
@Configuration
public class ValidationService {


    @Bean
    @ConditionalOnProperty(name = "validation.enabled", havingValue = "true")
    public Validator validator() {
        Validator validator = Validation.byProvider(HibernateValidator.class)
                .configure()
                .failFast(true)
                .buildValidatorFactory()
                .getValidator();
        System.err.println("validator:"+validator);
        System.err.println("validator:"+System.identityHashCode(validator));
        return validator;
    }


    public <T> void validate(T obj) {
        System.err.println(System.identityHashCode(validator()));
        Set<ConstraintViolation<T>> constraintViolations = validator().validate(obj);
        if (!constraintViolations.isEmpty()) {
            ConstraintViolation result = constraintViolations.iterator().next();
            System.out.println(result);
            System.out.println(result.getMessage());
        }
    }
}
