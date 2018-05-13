package com.liuhaozzu.spring.data.investigation.service;

import com.google.gson.Gson;
import com.liuhaozzu.spring.data.investigation.config.validation.ValidationService;
import com.liuhaozzu.spring.data.investigation.entity.Customer;
import com.liuhaozzu.spring.data.investigation.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/5/1 0001.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdateCustomerTest {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private ValidationService validationService;

    @Test
    public void testUpdateItemNum() {
        Customer customer1 = new Customer().setCreateTime(System.currentTimeMillis()).setMobile("adfadfadf");
        customer1.setFirstName("aaaaaaaa");
        try {
            validationService.validate(customer1);
            customerRepo.save(customer1);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getCause().getLocalizedMessage());
            System.out.println(new Gson().toJson(e));
        }

        Customer customer2 = new Customer().setCreateTime(System.currentTimeMillis()).setMobile("adfadfadf");
        customer2.setId(666L);
        customer2.setFirstName("aaaaaaaa");
        customerRepo.save(customer2);
        customer2.setId(2L);
        customer2.setMobile("aaaaaaaa");
        customerRepo.save(customer2);

        customer2.setMobile("bbbbbbbbbb");
        customer2.setFirstName("aaaaaaaa");
        customerRepo.save(customer2);

        Customer customer3 = customerRepo.findOne(2L);
        customer3.setFirstName("123456789");
        customerRepo.save(customer3.setMobile("cccccccccc"));
    }
    @Test
    @Transactional
    public void testUpdateItemNumWithException() {
        customerRepo.save(new Customer().setCreateTime(System.currentTimeMillis()).setFirstName("aaa").setMobile("adfadfadf"));
        /*customerRepo.save(new Customer().setCreateTime(System.currentTimeMillis()).setFirstName("aaa").setMobile("adfadfadf"));
        customerRepo.save(new Customer().setCreateTime(System.currentTimeMillis()).setFirstName("aaabbbccc").setMobile("adfadfadf"));
        customerRepo.save(new Customer().setCreateTime(System.currentTimeMillis()).setMobile("adfadfadf"));
        customerRepo.save(new Customer().setCreateTime(System.currentTimeMillis()).setFirstName("aaa").setMobile("adfadfadf"));
        customerRepo.save(new Customer().setCreateTime(System.currentTimeMillis()).setFirstName("aaa").setMobile("adfadfadf"));
        String abc = new String("abc");
        abc.indexOf("a");*/
    }
    @Test
    public void testNull(){
        String a=null;
        System.out.println(a + "abc");
        System.out.println("abc"+a);
        System.out.println("abc "+a);
        //System.out.println("abc".concat(a));
    }
}
